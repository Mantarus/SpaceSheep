package com.ottepel_hack.controllers;

import com.ottepel_hack.managers.SolutionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.script.ScriptException;

/**
 * Created by iistomin on 17/03/17.
 */
@RestController
public class MainController {

    @Autowired
    SolutionManager solutionManager;

    @RequestMapping("/")
    public Object sayHello(@RequestParam("param") String param) {
        return "Hello!";
    }

    @RequestMapping(value = "/testSolution", method = RequestMethod.GET)
    public Response testSolution() {
        try {
            return new Response(true, solutionManager.testSolution("fun1('hello')"));
        } catch (ScriptException e) {
            return new Response(false, e.getMessage());
        }
    }

}
