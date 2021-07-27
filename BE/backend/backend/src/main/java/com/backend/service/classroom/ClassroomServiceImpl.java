package com.backend.service.classroom;

import com.backend.model.Classroom;
import com.backend.model.Teach;
import com.backend.repository.TeachRepository;
import com.backend.repository.classroom.ClassroomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ClassroomServiceImpl implements ClassroomService{

    private final TeachRepository teachRepository;
    private final ClassroomRepository classroomRepository;

    @Override
    public List<Classroom> findAllClassByMemberId(String Id) {
        return teachRepository.findAllByMemberId(Id).stream()
                .map(teach->classroomRepository.findById(teach.getClassId()).get())
                .collect(Collectors.toList());
    }

    @Override
    public String getClassNameById(Long id) {
        return classroomRepository.getClassNameById(id);
    }
}
