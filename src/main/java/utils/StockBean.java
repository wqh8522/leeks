package utils;

import java.util.Objects;

public class StockBean {
    private String code;
    private String name;
    private String now;
    private String change;//涨跌
    private String changePercent;
    private String time;

    public StockBean() {
    }

    public StockBean(String code) {
        this.code = code;
        this.name = "--";
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNow() {
        return now;
    }

    public void setNow(String now) {
        this.now = now;
    }

    public String getChange() {
        return change;
    }

    public void setChange(String change) {
        this.change = change;
    }

    public String getChangePercent() {
        return changePercent;
    }

    public void setChangePercent(String changePercent) {
        this.changePercent = changePercent;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StockBean bean = (StockBean) o;
        return Objects.equals(code, bean.code);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code);
    }
}
