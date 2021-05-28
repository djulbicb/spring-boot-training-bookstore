package com.training.bookstore.config.context.spec;

import com.training.bookstore.model.site.Lang;
import com.training.bookstore.model.site.SiteInfo;
import com.training.bookstore.model.site.Theme;
import com.training.bookstore.sites.SiteConfig;

public class SiteSpec {
    private SiteInfo siteInfo;

    public SiteSpec(SiteConfig config) {
        this.siteInfo = new SiteInfo();
        siteInfo.setLang(config.getLang());
        siteInfo.setTheme(config.getTheme());
        siteInfo.setShopCode(config.getCode());
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
