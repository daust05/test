package com.backend.service.student;

import com.backend.model.Classroom;
import com.backend.model.Take;
import com.backend.repository.classroom.ClassroomRepository;
import com.backend.repository.take.TakeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService{

    private final TakeRepository takeRepository;
    private final ClassroomRepository classroomRepository;

    @Override
    public Take joinClass(String studentId, Long classId) {
        Take info = new Take(studentId, classId);
        takeRepository.save(info);
        return info;
    }

    @Override
    public String deleteStudent(String studentId, Long classId) {
        Optional<Take> delInfo = takeRepository.getOne(studentId, classId);
        if(delInfo.isPresent()){
            takeRepository.delete(delInfo.get());
        }
        return studentId;
    }

    @Override
    public List<Classroom> getAllClass(String studentId) {
        return takeRepository.getAllByStudentId(studentId).stream()
                .map(take -> classroomRepository.findById(take.getClassId()).get())
                .collect(Collectors.toList());
    }
}
