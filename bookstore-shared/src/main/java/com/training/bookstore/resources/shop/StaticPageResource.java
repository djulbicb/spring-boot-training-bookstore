package com.training.bookstore.resources.shop;

import com.training.bookstore.resources.Resource;

public class StaticPageResource extends Resource {
    @Override
    public Type getType() {
        return Type.SHOP;
    }

    @Override
    public String getName() {
        return "static-html-pages";
    }

    @Override
    public String getVersion() {
        return "v1";
    }

    @Override
    public String getPath() {
        return "static-html-pages.json";
    }
}
