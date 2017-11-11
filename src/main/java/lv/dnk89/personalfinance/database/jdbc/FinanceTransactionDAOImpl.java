package lv.dnk89.personalfinance.database.jdbc;

import lv.dnk89.personalfinance.database.DBException;
import lv.dnk89.personalfinance.database.FinanceTransactionDAO;
import lv.dnk89.personalfinance.domain.FinanceTransaction;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static lv.dnk89.personalfinance.domain.FinanceTransactionBuilder.createFinanceTransaction;

@Component
public class FinanceTransactionDAOImpl extends DAOImpl implements FinanceTransactionDAO {

    @Override
    public FinanceTransaction save(FinanceTransaction transaction) throws DBException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
        try {
            connection = getConnection();
            String sql = "insert into transactions(id, sum, description, date) values(default, ?, ?, ?)";
            preparedStatement = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            preparedStatement.setBigDecimal(1, transaction.getSum());
            preparedStatement.setString(2, transaction.getDescription());
            preparedStatement.setObject(3, transaction.getDate());
            preparedStatement.executeUpdate();
            rs = preparedStatement.getGeneratedKeys();
            if (rs.next()) {
                transaction.setId(rs.getLong(1));
            }
        } catch (Throwable e) {
            System.out.println("Exception while execute FinanceTransactionDAOImpl.save()");
            e.printStackTrace();
            throw new DBException(e);
        } finally {
            closeConnectionResources(connection, preparedStatement, rs);
        }
        return transaction;
    }

    @Override
    public Optional<FinanceTransaction> getById(Long id) throws DBException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
        try {
            connection = getConnection();
            String sql = "select * from transactions where id = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, id);
            rs = preparedStatement.executeQuery();

            FinanceTransaction transaction = null;
            if (rs.next()) {
                transaction = createFinanceTransaction()
                        .withId(rs.getLong("id"))
                        .withSum(rs.getBigDecimal("sum"))
                        .withDescription(rs.getString("description"))
                        .withDate(rs.getObject("date", LocalDate.class)).build();
            }
            return Optional.ofNullable(transaction);
        } catch (Throwable e) {
            System.out.println("Exception while execute FinanceTransactionDAOImpl.getById()");
            e.printStackTrace();
            throw new DBException(e);
        } finally {
            closeConnectionResources(connection, preparedStatement, rs);
        }
    }

    @Override
    public void delete(FinanceTransaction transaction) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = getConnection();
            String sql = "delete from transactions where id = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, transaction.getId());
            preparedStatement.executeUpdate();
        } catch (Throwable e) {
            System.out.println("Exception while execute FinanceTransactionDAOImpl.delete()");
            e.printStackTrace();
            throw new DBException(e);
        } finally {
            closeConnectionResources(connection, preparedStatement, null);
        }
    }

    @Override
    public List<FinanceTransaction> getAll() {
        List<FinanceTransaction> transactions = new ArrayList<>();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
        try {
            connection = getConnection();
            String sql = "select * from transactions";
            preparedStatement = connection.prepareStatement(sql);

            rs = preparedStatement.executeQuery();

            while (rs.next()) {
                FinanceTransaction transaction = createFinanceTransaction()
                        .withId(rs.getLong("id"))
                        .withSum(rs.getBigDecimal("sum"))
                        .withDescription(rs.getString("description"))
                        .withDate(rs.getObject("date", LocalDate.class)).build();
                transactions.add(transaction);
            }
        } catch (Throwable e) {
            System.out.println("Exception while execute FinanceTransactionDAOImpl.getById()");
            e.printStackTrace();
            throw new DBException(e);
        } finally {
            closeConnectionResources(connection, preparedStatement, rs);
        }
        return transactions;
    }
}
