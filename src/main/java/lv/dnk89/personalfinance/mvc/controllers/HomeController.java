package lv.dnk89.personalfinance.mvc.controllers;

import lv.dnk89.personalfinance.mvc.MVCController;
import lv.dnk89.personalfinance.mvc.MVCHelper;
import lv.dnk89.personalfinance.mvc.MVCModel;
import lv.dnk89.personalfinance.mvc.models.HomeModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Component
public class HomeController implements MVCController {

    private static final String HOME_VIEW = "/home.jsp";
    private static final String HOME_TITLE = "Home";

    @Autowired
    private MVCHelper helper;

    @Override
    public MVCModel processGet(HttpServletRequest request) {
        HomeModel model = new HomeModel();
        model.setPageTitle(HOME_TITLE);
        model.setMenuTitle("Main menu:");
        model.addMenuItem("Add transaction", helper.getFullLink(request,"add"));
        model.addMenuItem("Remove transaction", helper.getFullLink(request, "remove"));
        model.addMenuItem("List transactions", helper.getFullLink(request, "list"));
        return new MVCModel(model, HOME_VIEW);
    }

    @Override
    public MVCModel processPost(HttpServletRequest request) {
        return null;
    }
}
