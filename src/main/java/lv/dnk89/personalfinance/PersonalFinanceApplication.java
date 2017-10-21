package lv.dnk89.personalfinance;

import lv.dnk89.personalfinance.businesslogic.FinanceTransactionAddService;
import lv.dnk89.personalfinance.businesslogic.FinanceTransactionListService;
import lv.dnk89.personalfinance.businesslogic.FinanceTransactionRemoveService;
import lv.dnk89.personalfinance.businesslogic.FinanceTransactionTotalSumService;
import lv.dnk89.personalfinance.businesslogic.impl.FinanceTransactionAddServiceImpl;
import lv.dnk89.personalfinance.businesslogic.impl.FinanceTransactionListServiceImpl;
import lv.dnk89.personalfinance.businesslogic.impl.FinanceTransactionRemoveServiceImpl;
import lv.dnk89.personalfinance.businesslogic.impl.FinanceTransactionTotalSumServiceImpl;
import lv.dnk89.personalfinance.database.Database;
import lv.dnk89.personalfinance.database.InMemoryDatabase;
import lv.dnk89.personalfinance.ui.FinanceTransactionAddView;
import lv.dnk89.personalfinance.ui.FinanceTransactionListView;
import lv.dnk89.personalfinance.ui.FinanceTransactionRemoveView;
import lv.dnk89.personalfinance.ui.View;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class PersonalFinanceApplication {

    public static void main(String[] args) {
        // Use cases:
        // 1. Add transaction to list
        // 2. Remove transaction from list
        // 3. Print transactions list to console
        // 4. Exit

        Database database = new InMemoryDatabase();

        FinanceTransactionAddService financeTransactionAddService = new FinanceTransactionAddServiceImpl(database);
        FinanceTransactionRemoveService financeTransactionRemoveService = new FinanceTransactionRemoveServiceImpl(database);
        FinanceTransactionListService financeTransactionListService = new FinanceTransactionListServiceImpl(database);
        FinanceTransactionTotalSumService financeTransactionTotalSumService = new FinanceTransactionTotalSumServiceImpl();

        Map<Integer, View> views = new HashMap<>();
        views.put(1, new FinanceTransactionAddView(financeTransactionAddService));
        views.put(2, new FinanceTransactionRemoveView(financeTransactionRemoveService));
        views.put(3, new FinanceTransactionListView(financeTransactionListService, financeTransactionTotalSumService));

        while (true) {
            printProgramMenu();
            int menuItem = getFromUserMenuItemToExecute();
            if (menuItem == 4) {
                break;
            }

            View selectedView = views.get(menuItem);
            if (selectedView != null) {
                selectedView.execute();
            }
        }
    }

    private static int getFromUserMenuItemToExecute() {
        System.out.print("Please enter menu item number to execute:");
        Scanner sc = new Scanner(System.in);
        try {
            return Integer.parseInt(sc.nextLine());
        } catch (NumberFormatException e) {
            System.out.println(String.format("Something was wrong: %s", e.getMessage()));
            return -1;
        }
    }

    private static void printProgramMenu() {
        System.out.println();
        System.out.println("Program Menu:");
        System.out.println("1. Add transaction to list");
        System.out.println("2. Remove transaction from list");
        System.out.println("3. Print transaction list to console");
        System.out.println("4. Exit");
    }
}
