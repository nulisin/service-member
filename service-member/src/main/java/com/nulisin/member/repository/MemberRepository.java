package com.nulisin.member.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.nulisin.member.model.Member;

public interface MemberRepository extends MongoRepository<Member, String> {
	
	//membuat findmember by phone
	Member findByPhone(String phone);
}
