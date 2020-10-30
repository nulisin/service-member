package com.nulisin.member.service;

import com.nulisin.member.request.MemberRequest;
import com.nulisin.member.response.MemberResponse;

public interface MemberService {

	MemberResponse createMember(MemberRequest request);
	MemberResponse getMember(String phone);
	MemberResponse updateMember(String phone, MemberRequest request);
	MemberResponse deleteMember(String phone);
}
