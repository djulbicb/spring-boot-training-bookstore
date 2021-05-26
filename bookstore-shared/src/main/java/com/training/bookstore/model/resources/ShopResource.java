package com.training.bookstore.model.resources;

import com.training.bookstore.model.site.SiteInfo;

public class ShopResource {
    private Resource resource;
    private SiteInfo siteInfo;

    public Resource getResource() {
        return resource;
    }

    public void setResource(Resource resource) {
        this.resource = resource;
    }

    public SiteInfo getShop() {
        return siteInfo;
    }

    public void setShop(SiteInfo siteInfo) {
        this.siteInfo = siteInfo;
    }
}
