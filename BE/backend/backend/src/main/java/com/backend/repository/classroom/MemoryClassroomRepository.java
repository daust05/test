package com.backend.repository.classroom;

import com.backend.model.Classroom;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Component
public class MemoryClassroomRepository implements ClassroomRepository{

    private Map<Long, Classroom> store = new HashMap<>();
    private Long sequence = 0L;

    @Override
    public Classroom save(Classroom classroom) {
        classroom.setClassId(sequence++);
        store.put(classroom.getClassId(), classroom);
        return classroom;
    }

    @Override
    public Optional<Classroom> findById(Long classId) {
        return Optional.ofNullable(store.get(classId));
    }

    @Override
    public List<Classroom> findAll() {
        return store.values().stream().toList();
    }

    @Override
    public String getClassNameById(Long id) {
        return store.get(id).getCourseName();
    }
}
