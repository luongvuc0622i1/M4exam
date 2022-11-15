package com.codegym.controller;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Service
public class StudentController {
//    @GetMapping("")
//    public ModelAndView showStudent(Pageable pageable) {
//        ModelAndView modelAndView = new ModelAndView("/student/list");
//        Page<Blog> blogs;
//        if (q.isPresent()) {
//            blogs = blogService.findAllByDescriptionContaining(q.get(), pageable);
//        } else {
//            blogs = blogService.findAll(pageable);
//        }
//        modelAndView.addObject("blogs", blogs);
//        return modelAndView;
//    }
}
