package com.training.bookstore.model.resources;

public class Shop {
    private Lang lang;
    private Theme theme;

    public Lang getLang() {
        return lang;
    }

    public void setLang(Lang lang) {
        this.lang = lang;
    }

    public Theme getTheme() {
        return theme;
    }

    public void setTheme(Theme theme) {
        this.theme = theme;
    }

    public String getShopCode () {
        return String.format("%s%s", theme.name(), lang.name()).toLowerCase();
    }
}
