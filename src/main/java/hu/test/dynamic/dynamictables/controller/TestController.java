package hu.test.dynamic.dynamictables.controller;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 * Created by kormo_000 on 2017.10.11..
 */
@RestController
@RequestMapping("/api")
public class TestController {

    EntityManager em;

    @GetMapping("/hello")
    public String hello() {
//        EntityManagerFactory emf =
        return "Hello";
    }

}
