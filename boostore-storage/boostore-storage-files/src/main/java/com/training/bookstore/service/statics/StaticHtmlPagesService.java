package com.training.bookstore.service.statics;

import com.google.gson.Gson;
import com.pocketknife.io.FileWrite;
import com.training.bookstore.model.statics.StaticHtmlPage;
import com.training.bookstore.resources.shop.StaticPageResource;
import com.training.bookstore.service.FilesPathResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.resource.PathResourceResolver;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
public class StaticHtmlPagesService {

    private final Gson gson;

    @Autowired
    public StaticHtmlPagesService(Gson gson, FilesPathResolver filesPathResolver) throws IOException {
        this.gson = gson;

        System.out.println("ssss");
        String resourceGlobalPath = filesPathResolver.getResourceGlobalPath(new StaticPageResource());

        StaticPageResource resource = new StaticPageResource();

        List<StaticHtmlPage> pages = new ArrayList<>();
        pages.add(StaticHtmlPage.empty());
        pages.add(StaticHtmlPage.empty());
        pages.add(StaticHtmlPage.empty());
        FileWrite.write(resourceGlobalPath, gson.toJson(pages));


    }
}
