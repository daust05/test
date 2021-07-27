package com.backend.service.teacher;

import com.backend.model.Classroom;
import com.backend.model.Member;
import com.backend.model.Take;
import com.backend.model.Teach;
import com.backend.repository.TeachRepository;
import com.backend.repository.classroom.ClassroomRepository;
import com.backend.repository.take.TakeRepository;
import com.backend.service.classroom.ClassroomService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TeacherServiceImpl implements TeacherService{

    private final TeachRepository teachRepository;
    private final TakeRepository takeRepository;
    private final ClassroomRepository classroomRepository;


    @Override
    public Teach makeClass(String memberId, String name) {
        Classroom classroom = new Classroom();
        classroom.setCourseName(name);
        classroomRepository.save(classroom);
        Long classId = classroom.getClassId();

        Teach teach = new Teach(classId, memberId);
        teachRepository.save(teach);
        return teach;
    }

    @Override
    public String deleteStudent(String studentId, Long classId) {
        Optional<Take> delInfo = takeRepository.getOne(studentId, classId);
        if(delInfo.isPresent()){
            takeRepository.delete(delInfo.get());
        }
        else
            System.out.println("no student");
        return studentId;
    }

    @Override
    public String addStudent(String studentId, Long classId) {
        return null;
    }

    @Override
    public List<String> getAllStudent(Long classId) {
        List<Take> teachList = takeRepository.getAllByClassId(classId);
        List<String> students = new ArrayList<>();
        for(Take take: teachList){
            students.add(take.getStudentId());
        }
        return students;
    }
}
