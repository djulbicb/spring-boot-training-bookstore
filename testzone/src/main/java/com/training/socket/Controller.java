package com.training.socket;

public class Controller {
    public String respond(String requestCommand) {
        switch (requestCommand) {
            case "/" :
                return "This is home page\n\r";
            case "/bojan" :
                return "Hello Bojan. :) You rule";
            case "/html" :
                return "HTTP/1.0 200 OK\r\n" + "Content-Type: text/html\r\n\r\n" + "<h1>This is sime title</h1><p>This is some paragraph</p>";
            case "/json" :
                return "HTTP/1.0 200 OK\r\n" + "Content-Type: application/json\r\n\r\n" + "{\"name\":\"Bojan rules\"}";
            default:
                return "I dont know what that is";
        }
    }
}