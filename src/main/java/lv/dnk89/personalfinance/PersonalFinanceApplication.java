package lv.dnk89.personalfinance;

import lv.dnk89.personalfinance.configs.SpringAppConfig;
import lv.dnk89.personalfinance.ui.FinanceTransactionAddView;
import lv.dnk89.personalfinance.ui.FinanceTransactionListView;
import lv.dnk89.personalfinance.ui.FinanceTransactionRemoveView;
import lv.dnk89.personalfinance.ui.View;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

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

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringAppConfig.class);

        Map<Integer, View> views = new HashMap<>();
        views.put(1, applicationContext.getBean(FinanceTransactionAddView.class));
        views.put(2, applicationContext.getBean(FinanceTransactionRemoveView.class));
        views.put(3, applicationContext.getBean(FinanceTransactionListView.class));

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
