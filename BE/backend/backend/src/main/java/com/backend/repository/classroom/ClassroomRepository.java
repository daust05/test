package com.backend.repository.classroom;

import com.backend.model.Classroom;

import java.util.List;
import java.util.Optional;

public interface ClassroomRepository {

    Classroom save(Classroom classroom);

    Optional<Classroom> findById(Long classId);

    List<Classroom> findAll();

    String getClassNameById(Long id);
}
