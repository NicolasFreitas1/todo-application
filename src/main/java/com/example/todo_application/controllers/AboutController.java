package com.example.todo_application.controllers;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;import java.util.HashMap;
import java.util.Map;


@RestController
@RequestMapping("/sobre")
public class AboutController {
    @GetMapping()
    public Map<String, String> getSobre() {
        Map<String, String> sobreInfo = new HashMap<>();
        sobreInfo.put("estudante", "Nicolas Andrade de Freitas");
        sobreInfo.put("projeto", "Lista de tarefas");
        return sobreInfo;
    }
}
