package controller;

import org.springframework.web.bind.annotation.GetMapping;

public class HomeController {
// http://localhost:8080/app/ GET
    @GetMapping("/")
public String getIndexPage(){
    return "index";}
}
