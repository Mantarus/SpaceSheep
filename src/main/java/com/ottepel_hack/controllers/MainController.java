package com.ottepel_hack.controllers;

import com.ottepel_hack.game.LevelManager;
import com.ottepel_hack.managers.SolutionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
            return new Response(true, solutionManager.testSolution("for (i = 0; i < 10; i++) { moveLeft(); }"));
        } catch (ScriptException e) {
            return new Response(false, e.getMessage());
        }
    }

    @RequestMapping(value = "/script", method = RequestMethod.POST)
    public Response executeScript(@RequestBody String script) {
        try {
            return new Response(true, solutionManager.testSolution(script));
        } catch (ScriptException e) {
            return new Response(false, e.getMessage());
        }
    }

    @RequestMapping("/getlevel")
    public Response getLevel() {
        LevelManager.getNewLevel();
        return new Response(null);
    }

}
