package com.training.bookstore.controller;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.training.bookstore.BackendClient;
import com.training.bookstore.client.StorageFilesClient;
import com.training.bookstore.config.context.spec.SiteSpec;
import com.training.bookstore.model.resources.impl.home.HomePageConfig;
import com.training.bookstore.model.book.Book;
import com.training.bookstore.model.resources.Resource;
import com.training.bookstore.model.resources.ResourceNames;
import com.training.bookstore.model.resources.impl.home.HomePageFooterConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/")
public class
FrontendController {

    @Autowired
    BackendClient backendClient;

    @Autowired
    StorageFilesClient filesClient;

    @Autowired
    Gson gson;

    @ResponseBody
    @GetMapping("/sss")
    public String sss(SiteSpec siteSpec, Model model) {
        Resource[] resources = filesClient.readShopResource();
        return Arrays.toString(resources);
    }


    @RequestMapping( value = { "/tiles"}, method = RequestMethod.GET)
    public ModelAndView tiles(SiteSpec siteSpec, Model model) {
        model.addAttribute("siteSpec", siteSpec);

        return new ModelAndView("main"); // main.blue
    }

    @GetMapping("/product")
    public ModelAndView showProduct (SiteSpec siteSpec, Model model) {
        model.addAttribute("siteSpec", siteSpec);

        return new ModelAndView("product");
    }


    @GetMapping("")
    public ModelAndView getIndex(SiteSpec siteSpec, Model model) throws IOException {
        HomePageConfig carusel = filesClient.getResourceByNameAndShop(ResourceNames.HOME_PAGE, siteSpec.getSiteInfo().getShopCode(), HomePageConfig.class);
        HomePageFooterConfig footer = filesClient.getResourceByNameAndShop(ResourceNames.HOME_FOOTER, siteSpec.getSiteInfo().getShopCode(), HomePageFooterConfig.class);

        model.addAttribute("siteSpec", siteSpec);
        model.addAttribute("carusel", carusel);
        model.addAttribute("footer", footer);
        model.addAttribute("books", backendClient.findAll());
        return  new ModelAndView("home");
    }

    private <T> T getPropertiesFullConfigUsingJsonGeneric(String jsonContent, Class<T> klass) {
        TypeToken type = TypeToken.get(klass);
        return gson.fromJson(jsonContent, type.getType());
    }
}
