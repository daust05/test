package com.backend.service.student;

import com.backend.model.Classroom;
import com.backend.model.Take;

import java.util.List;

public interface StudentService {

    Take joinClass(String studentId, Long classId);

    String deleteStudent(String studentId, Long classId);

    List<Classroom> getAllClass(String studentId);
}
