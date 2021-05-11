package com.training.bookstore.controller;

import com.google.gson.Gson;
import com.training.bookstore.BackendClient;
import com.training.bookstore.client.StorageFilesClient;
import com.training.bookstore.controller.model.CaruselFrontend;
import com.training.bookstore.controller.model.CaruselFrontendSimple;
import com.training.bookstore.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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


    @GetMapping("")
    public String getIndex(Model model) throws IOException {
        List<Book> all = backendClient.findAll();

//        String read = filesClient.read("carousel/front-page.txt");
//        CaruselFrontend carusel = getPropertiesConfigUsingProperties(read);

//        String read = filesClient.read("carousel/front-page.json");
//        CaruselFrontendSimple carusel = getPropertiesConfigUsingJson(read);

        String read = filesClient.read("carousel/front-page-full.json");
        CaruselFrontend carusel = getPropertiesFullConfigUsingJson(read);

        System.out.println(read);

        model.addAttribute("caruselConfig", carusel);
        model.addAttribute("bojan", "Model bojan");
        model.addAttribute("books", all);
        return "index";
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
