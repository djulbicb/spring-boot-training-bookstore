package com.training.bookstore.controller;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.training.bookstore.BackendClient;
import com.training.bookstore.client.StorageFilesClient;
import com.training.bookstore.context.SiteSpec;
import com.training.bookstore.context.localeResolver.SubDomainLocaleResolver;
import com.training.bookstore.controller.model.CaruselFrontend;
import com.training.bookstore.controller.model.CaruselFrontendSimple;
import com.training.bookstore.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.StringReader;
import java.util.List;
import java.util.Properties;

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
//
//    @Autowired
//    StorageMinioClient minioClient;
    @Autowired
    SubDomainLocaleResolver resolver;

    @Autowired
    HttpServletRequest request;

    @RequestMapping( value = { "/tiles"}, method = RequestMethod.GET)
    public String tiles() {
        return"test";
    }

    @RequestMapping( value = { "/apachetiles"}, method = RequestMethod.GET)
    public String productsPage() {
        return "template-def";
    }

    @GetMapping("res")
    @ResponseBody
    public String testRes (SiteSpec handler) {
//        ShopResource resource = new ShopResource();
//        Shop shop = new Shop();
//        shop.setTheme(Theme.BLUE);
//        shop.setLang(Lang.EN);
//
//        Resource res = new Resource();
//        res.setCategory("news");
//        res.setName("news.json");
//        res.setType(Resource.Type.SHOP);
//
//        resource.setResource(res);
//        resource.setShop(shop);
//
//
//        filesClient.write(resource);

        System.out.println(handler);
        return "testing";
    }

    @GetMapping("")
    public String getIndex(Model model) throws IOException {
        List<Book> all = backendClient.findAll();

//        String read = filesClient.read("carousel/front-page.txt");
//        CaruselFrontend carusel = getPropertiesConfigUsingProperties(read);

//        String read = filesClient.read("carousel/front-page.json");
//        CaruselFrontendSimple carusel = getPropertiesConfigUsingJson(read);

//        String read = filesClient.read("carousel/front-page-full.json");
//        CaruselFrontend carusel = getPropertiesFullConfigUsingJson(read);

        String read = filesClient.read("carousel/front-page-full.json");
        CaruselFrontend carusel = getPropertiesFullConfigUsingJsonGeneric(read, CaruselFrontend.class);



        System.out.println(read);

        model.addAttribute("caruselConfig", carusel);
        model.addAttribute("bojan", "Model bojan");
        model.addAttribute("books", all);
        return "index";
    }

    private <T> T getPropertiesFullConfigUsingJsonGeneric(String jsonContent, Class<T> klass) {
        TypeToken type = TypeToken.get(klass);
        return gson.fromJson(jsonContent, type.getType());
    }

    private CaruselFrontend getPropertiesFullConfigUsingJson(String jsonContent) {
        return gson.fromJson(jsonContent, CaruselFrontend.class);
    }

    private CaruselFrontendSimple getPropertiesConfigUsingJson(String jsonContent) {
        return gson.fromJson(jsonContent, CaruselFrontendSimple.class);
    }


    private CaruselFrontendSimple getPropertiesConfigUsingProperties(String read) throws IOException {
        CaruselFrontendSimple carusel = new CaruselFrontendSimple();

        Properties p = new Properties();
        p.load(new StringReader(read));
        carusel.setNumberOfPics(Integer.parseInt(p.getProperty("numberOfPics")));
        carusel.setTitle(p.getProperty("title"));
        carusel.setSubtitle(p.getProperty("subtitle"));

        return carusel;
    }

    private CaruselFrontendSimple getPropertiesConfigiCustom(String read) {
        CaruselFrontendSimple carusel = new CaruselFrontendSimple();
        String[] rows = read.split("\\r?\\n");
        carusel.setNumberOfPics(Integer.parseInt(rows[0].split(":")[1]));
        carusel.setTitle(rows[1].split(":")[1]);
        carusel.setSubtitle(rows[2].split(":")[1]);
        return carusel;
    }

}
