package lv.dnk89.personalfinance.mvc;

public class MVCModel {

    private Object data;
    private String view;

    public MVCModel(Object data, String view) {
        this.data = data;
        this.view = view;
    }

    public Object getData() {
        return data;
    }

    public String getView() {
        return view;
    }
}
