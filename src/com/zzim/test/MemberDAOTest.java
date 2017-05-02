package com.zzim.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.zzim.dao.MemberDAO;
import com.zzim.dto.Member;

public class MemberDAOTest {

	@Test
	public void test() {
		MemberDAO md = new MemberDAO();
		Member member = new Member("sjy", "0000", "손주영", "여", "1990-06-29");
		assertEquals(md.setMember(member), true);
	}

}
