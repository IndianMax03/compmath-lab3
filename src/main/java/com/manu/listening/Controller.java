package com.manu.listening;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.manu.model.EquationData;
import com.manu.services.EquationService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@org.springframework.stereotype.Controller
public class Controller {

    EquationService equationService = new EquationService();

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @PostMapping("equations/solveNormal")
    @ResponseBody
    public ObjectNode solveNormal(@RequestBody EquationData data) {
        return equationService.analyze(data);
    }

}
