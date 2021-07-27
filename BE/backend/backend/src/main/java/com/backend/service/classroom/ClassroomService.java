package com.backend.service.classroom;

import com.backend.model.Classroom;

import java.util.List;

public interface ClassroomService {

    List<Classroom> findAllClassByMemberId(String Id);

    String getClassNameById(Long id);
}
