package lv.dnk89.personalfinance.mvc;

import javax.servlet.http.HttpServletRequest;

public interface MVCHelper {

    String getFullLink(HttpServletRequest request, String link);
}
