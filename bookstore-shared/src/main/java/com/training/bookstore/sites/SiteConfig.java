package com.training.bookstore.sites;

import com.training.bookstore.model.resources.Lang;
import com.training.bookstore.model.resources.Theme;

import java.util.List;

public class SiteConfig {
    private Lang lang;
    private Theme theme;
    private String code;
    private List<String> domains;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

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

    public List<String> getDomains() {
        return domains;
    }

    public void setDomains(List<String> domains) {
        this.domains = domains;
    }

    @Override
    public String toString() {
        return "SiteConfig{" +
                "lang=" + lang +
                ", theme=" + theme +
                ", code='" + code + '\'' +
                ", domains=" + domains +
                '}';
    }
}
