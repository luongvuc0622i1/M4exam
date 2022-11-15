package com.codegym.controller;

import com.codegym.model.Student;
import com.codegym.service.student.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Service
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private IStudentService studentService;

//    @Autowired
//    private IClassroomService classroomService;

    @GetMapping("")
    public ModelAndView showStudent(Pageable pageable) {
        ModelAndView modelAndView = new ModelAndView("student/list1");
        Iterable<Student> studentPage = studentService.findAll();
        modelAndView.addObject("students", studentPage);
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("/student/create");
        modelAndView.addObject("student", new Student());
        return modelAndView;
    }

    @PostMapping("/create")
    public ModelAndView saveStudent(@ModelAttribute("student") Student student) {
        ModelAndView modelAndView = new ModelAndView("/student/create");
        studentService.save(student);
        modelAndView.addObject("student", student);
        modelAndView.addObject("message", "Student created");
        return modelAndView;
    }

    @GetMapping("/edit/{id}")
    public ModelAndView showEditForm(@PathVariable("id") Long id) {
        Optional<Student> student = studentService.findById(id);
        if (!student.isPresent()) {
            return new ModelAndView("/error-404");
        } else {
            return new ModelAndView("/student/edit", "blog", student.get());
        }
    }

    @PostMapping("/edit")
    public ModelAndView editStudent(@ModelAttribute Student student) {
        ModelAndView modelAndView = new ModelAndView("/student/edit");
        studentService.save(student);
        modelAndView.addObject("student", student);
        modelAndView.addObject("message", "Student edited successfully");
        return modelAndView;
    }

    @GetMapping("/delete/{id}")
    public ModelAndView showDeleteForm(@PathVariable("id") Long id) {
        Optional<Student> student = studentService.findById(id);
        if (!student.isPresent()) {
            return new ModelAndView("/error-404");
        } else {
            return new ModelAndView("/student/delete", "student", student.get());
        }
    }

    @PostMapping("/delete")
    public String deleteStudent(@ModelAttribute("student") Student student) {
        studentService.remove(student.getId());
        return "redirect:/student";
    }
}