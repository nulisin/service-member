package com.nulisin.member.response;

import com.nulisin.member.model.Status;

public class MemberResponse {
	private String name;
	private Status status;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	
	
}
