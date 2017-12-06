package lv.dnk89.personalfinance.mvc.models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HomeModel {

    private String pageTitle;
    private String menuTitle;
    private List<MainMenuItem> menuItems = new ArrayList<>();

    public String getMenuTitle() {
        return menuTitle;
    }

    public void setMenuTitle(String menuTitle) {
        this.menuTitle = menuTitle;
    }

    public void addMenuItem(String text, String link) {
        menuItems.add(new MainMenuItem(text, link));
    }

    public List<MainMenuItem> getMenuItems() {
        return Collections.unmodifiableList(menuItems);
    }

    public String getPageTitle() {
        return pageTitle;
    }

    public void setPageTitle(String pageTitle) {
        this.pageTitle = pageTitle;
    }
}
