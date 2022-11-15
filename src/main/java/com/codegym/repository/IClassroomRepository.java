package com.codegym.repository;

import com.codegym.model.Classroom;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IClassroomRepository extends PagingAndSortingRepository<Classroom, Long> {
}
