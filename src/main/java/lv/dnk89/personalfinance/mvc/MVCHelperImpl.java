package lv.dnk89.personalfinance.mvc;

import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Component
public class MVCHelperImpl implements MVCHelper {
    @Override
    public String getFullLink(HttpServletRequest request, String link) {
        return String.format("%s/%s", request.getContextPath(), link);
    }
}
