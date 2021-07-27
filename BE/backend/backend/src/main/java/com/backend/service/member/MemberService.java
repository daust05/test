package com.backend.service.member;

import com.backend.model.Member;

import java.util.Optional;

public interface MemberService {

    String join(Member member);

    Optional<Member> findOne(String id);
}
