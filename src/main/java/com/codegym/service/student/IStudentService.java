package com.codegym.service.student;

import com.codegym.model.Student;
import com.codegym.service.IGeneralService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IStudentService extends IGeneralService<Student> {
    Page<Student> findAll(Pageable pageable);
}
