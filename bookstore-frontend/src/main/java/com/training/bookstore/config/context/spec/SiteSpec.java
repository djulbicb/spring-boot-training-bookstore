package com.training.bookstore.config.context.spec;

import com.training.bookstore.model.site.Lang;
import com.training.bookstore.model.site.SiteInfo;
import com.training.bookstore.model.site.Theme;

public class SiteSpec {
    private SiteInfo siteInfo;

    public SiteSpec(Theme theme, Lang lang) {
        this.siteInfo = new SiteInfo();
        siteInfo.setLang(lang);
        siteInfo.setTheme(theme);
    }

    public SiteInfo getSiteInfo() {
        return siteInfo;
    }

    public void setSiteInfo(SiteInfo siteInfo) {
        this.siteInfo = siteInfo;
    }

    public Theme getTheme() {
        return siteInfo.getTheme();
    }

    public Lang getLang() {
        return siteInfo.getLang();
    }

    @Override
    public String toString() {
        return "SiteSpec{" +
                "theme=" + getTheme() +
                ", lang=" + getLang() +
                '}';
    }
}
