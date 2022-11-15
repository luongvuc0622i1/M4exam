package com.codegym.controller;

import com.codegym.model.Classroom;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/classroom")
public class ClassroomController {
    @GetMapping("")
    public ModelAndView showForm() {
        ModelAndView modelAndView = new ModelAndView("/classList");
        modelAndView.addObject("classroom", new Classroom());
        return modelAndView;
    }
}
