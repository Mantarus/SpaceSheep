package com.ottepel_hack.controllers;

import com.ottepel_hack.game.LevelStateFactory;
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

    @Autowired
    LevelStateFactory levelStateFactory;

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

    @RequestMapping("/test")
    public Response test() {
//        Response response = new Response(null);
//        SolutionResponseBody body = new SolutionResponseBody();
//        response.setBody(body);
//        body.setLevelState(levelStateFactory.getSimpleLevel());
//        try {
//            body.setSequence(solutionManager.testSolution("for (i = 0; i < 5; i++) { moveLeft(); }"));
//            return response;
//        } catch (ScriptException e) {
//            return new Response(false, e.getMessage());
//        }
        Response response = new Response(null);
        try {
            response.setBody(solutionManager.testSolution(levelStateFactory.getSimpleLevel(), "for (i = 0; i < 5; i++) { moveLeft(); }"));
        } catch (ScriptException e) {
            return new Response(false, e.getMessage());
        }
        return response;
    }

}
