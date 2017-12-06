package lv.dnk89.personalfinance.mvc.models;

public class MainMenuItem {

    private String text;
    private String link;

    MainMenuItem(String text, String link) {
        this.text = text;
        this.link = link;
    }

    public String getText() {
        return text;
    }

    public String getLink() {
        return link;
    }
}
