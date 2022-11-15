package com.codegym.service.classroom;

import com.codegym.model.Classroom;
import com.codegym.repository.IClassroomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClassroomService implements IClassroomService {
    @Autowired
    private IClassroomRepository classroomRepository;

    @Override
    public Iterable<Classroom> findAll() {
        return classroomRepository.findAll();
    }

    @Override
    public Optional<Classroom> findById(Long id) {
        return classroomRepository.findById(id);
    }

    @Override
    public void save(Classroom model) {
        classroomRepository.save(model);
    }

    @Override
    public void remove(Long id) {
        classroomRepository.deleteById(id);
    }
}
