package com.backend.service.teacher;


import com.backend.model.Member;
import com.backend.model.Teach;

import java.util.List;

public interface TeacherService {

    Teach makeClass(String memberId, String name);

    String deleteStudent(String studentId, Long classId);

    String addStudent(String studentId, Long classId);

    List<String> getAllStudent(Long classId);
}
