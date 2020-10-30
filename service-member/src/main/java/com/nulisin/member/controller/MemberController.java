package com.nulisin.member.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nulisin.member.request.MemberRequest;
import com.nulisin.member.response.MemberResponse;
import com.nulisin.member.service.impl.MemberServiceImpl;

@RestController
@RequestMapping("/member")
public class MemberController {

	@Autowired
	private MemberServiceImpl memberService;
	
	@PostMapping("/create")
	public MemberResponse createMember(@RequestBody MemberRequest request) {
		return memberService.createMember(request);
	}
	@GetMapping("/{phone}") //path variable
	public MemberResponse getMember(@PathVariable String phone) {
		return memberService.getMember(phone);
	}
	
	@PutMapping("/{phone}")
	public MemberResponse updateMember(@PathVariable String phone, @RequestBody MemberRequest request) {
		return memberService.updateMember(phone, request);
	}
	@DeleteMapping("/{phone}")
	public MemberResponse deleteMember(@PathVariable String phone) {
		return memberService.deleteMember(phone);
	}
}
