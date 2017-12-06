package lv.dnk89.personalfinance.mvc.controllers;

import lv.dnk89.personalfinance.mvc.MVCController;
import lv.dnk89.personalfinance.mvc.MVCModel;
import lv.dnk89.personalfinance.mvc.models.HomeModel;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Component
public class HomeController implements MVCController {

    public static final String HOME_VIEW = "/home.jsp";
    public static final String HOME_TITLE = "Home";

    @Override
    public MVCModel processGet(HttpServletRequest request) {
        HomeModel model = new HomeModel();
        model.setPageTitle(HOME_TITLE);
        model.setMenuTitle("Main menu:");
        model.addMenuItem("Add transaction", "/add");
        model.addMenuItem("Remove transaction", "/remove");
        model.addMenuItem("List transactions", "/list");
        return new MVCModel(model, HOME_VIEW);
    }

    @Override
    public MVCModel processPost(HttpServletRequest request) {
        return null;
    }
}
