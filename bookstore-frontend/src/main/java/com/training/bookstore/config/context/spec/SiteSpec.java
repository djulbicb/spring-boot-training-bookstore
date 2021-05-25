package com.training.bookstore.config.context.spec;

import com.training.bookstore.model.resources.Lang;
import com.training.bookstore.model.resources.Theme;

import javax.servlet.http.HttpServletRequest;

public class SiteSpec {
    private Theme theme;
    private Lang lang;

    public SiteSpec(HttpServletRequest request) {
        String serverName = request.getServerName();
        System.out.println("SiteSpec REQUEST SCOPE " + serverName);
    }

    public SiteSpec(Theme theme, Lang lang) {
        this.theme = theme;
        this.lang = lang;
    }

    public Theme getTheme() {
        return theme;
    }

    public Lang getLang() {
        return lang;
    }

    @Override
    public String toString() {
        return "SiteSpec{" +
                "theme=" + theme +
                ", lang=" + lang +
                '}';
    }
}
