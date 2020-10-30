package com.nulisin.member.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nulisin.member.model.Member;
import com.nulisin.member.model.Status;
import com.nulisin.member.repository.MemberRepository;
import com.nulisin.member.request.MemberRequest;
import com.nulisin.member.response.MemberResponse;
import com.nulisin.member.service.MemberService;

@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	private MemberRepository repo;

	@Override
	public MemberResponse createMember(MemberRequest request) {
		// TODO Auto-generated method stub
		// inisialisasi MemberResponse untuk dikembalikan / return nya
		MemberResponse response = new MemberResponse();
		// inisisalisasi Status
		Status status = new Status();
		// try catch untuk mencegah error program
		try {
			// cek dengan nomor telepon apakah member sudah terdaftar
			Member memberIsExist = repo.findByPhone(request.getPhone());
			if (memberIsExist != null) {
				status.setStatusCode("403");
				status.setStatusMessage("Forbidden, data found");
				response.setStatus(status);
				return response;
			}
			// jika memberisexist null
			Member member = new Member();
			member.setNama(request.getNama());
			member.setPhone(request.getPhone());
			member.setUmur(request.getUmur());
			repo.save(member); // untuk save member
			status.setStatusCode("201");
			status.setStatusMessage("created");
			response.setName(request.getNama());
			response.setStatus(status);
			return response;
		} catch (Exception e) {
			// TODO: handle exception
			status.setStatusMessage(e.getMessage());
			response.setStatus(status);
			return response;
		}
	}

	@Override
	public MemberResponse getMember(String phone) {
		// TODO Auto-generated method stub
		// inisialisasi member response
		MemberResponse response = new MemberResponse();
		Status status = new Status();
		// try catch
		try {
			Member member = repo.findByPhone(phone);
			if (member == null) {
				status.setStatusCode("204");
				status.setStatusMessage("no content, tidak ada data, silahkan registrasi");
				response.setStatus(status);
				return response;
			}
			status.setStatusCode("200");
			status.setStatusMessage("sukses");
			response.setName(member.getNama());
			response.setStatus(status);
			return response;
		} catch (Exception e) {
			// TODO: handle exception
			status.setStatusMessage(e.getMessage());
			response.setStatus(status);
			return response;
		}
	}

	@Override
	public MemberResponse updateMember(String phone, MemberRequest request) {
		// TODO Auto-generated method stub
		// inisialisasi member response
		MemberResponse response = new MemberResponse();
		Status status = new Status();
		// try catch
		try {
			Member member = repo.findByPhone(phone);
			if (member == null) {
				status.setStatusCode("204");
				status.setStatusMessage("no content, tidak ada data, silahkan registrasi");
				response.setStatus(status);
				return response;
			}
			//inisialisasi member update
			Member memberUpdate = new Member();
			memberUpdate.setId(member.getId()); //disamakan agar datanya tetap bukan bertambah
			memberUpdate.setNama(request.getNama());
			memberUpdate.setPhone(request.getPhone());
			memberUpdate.setUmur(request.getUmur());
			repo.save(memberUpdate);
			status.setStatusCode("200");
			status.setStatusMessage("sukses");
			response.setName(request.getNama());
			response.setStatus(status);
			return response;
		} catch (Exception e) {
			// TODO: handle exception
			status.setStatusMessage(e.getMessage());
			response.setStatus(status);
			return response;
		}
	}

	@Override
	public MemberResponse deleteMember(String phone) {
		// TODO Auto-generated method stub
		// inisialisasi member response
		MemberResponse response = new MemberResponse();
		Status status = new Status();
		// try catch
		try {
			Member member = repo.findByPhone(phone);
			if (member == null) {
				status.setStatusCode("204");
				status.setStatusMessage("no content, tidak ada data, silahkan registrasi");
				response.setStatus(status);
				return response;
			}
			status.setStatusCode("04");
			status.setStatusMessage("deleted");
			response.setName(member.getNama());
			response.setStatus(status);
			repo.delete(member);
			return response;
		} catch (Exception e) {
			// TODO: handle exception
			status.setStatusMessage(e.getMessage());
			response.setStatus(status);
			return response;
		}
	}

}
