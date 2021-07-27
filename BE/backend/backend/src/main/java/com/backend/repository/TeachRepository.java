package com.backend.repository;

import com.backend.model.Member;
import com.backend.model.Teach;

import java.util.List;
import java.util.Optional;

public interface TeachRepository {

    Teach save(Teach teach);

    Optional<Teach> findOneByMember(Member member);

    List<Teach> findAllByMemberId(String memberId);

    List<Teach> findAllByClassId(Long classId);

    void clearRepository();
}
