package com.estsoft.bookmall.daotest;

import java.util.List;

import com.estsoft.bookmall.dao.MemberDao;
import com.estsoft.bookmall.vo.MemberVo;

public class MemberDaoTest {

	public static void main(String[] args) {
		// insert test
		insertTest();
		// getList test
		getListTest();
	}

	public static void getListTest() {
		List<MemberVo> list = new MemberDao().getList();
		for (MemberVo memberVo : list) {
			System.out.println(memberVo);
		}
	}

	public static void insertTest() {
		MemberVo memberVo = new MemberVo();
		MemberDao memberDao = new MemberDao();

		memberVo.setMemberId(1L);
		memberVo.setMemberName("Eclair Tartar");
		memberVo.setEmail("eclairsh@gmail.com");
		memberVo.setPassword("chocolatteCream");
		memberVo.setPhone("+82 10-9340-2345");
		memberDao.insert(memberVo);

		memberVo.setMemberId(1L);
		memberVo.setMemberName("Jellybean Soysauce");
		memberVo.setEmail("spinachBean@gmail.com");
		memberVo.setPassword("terrible");
		memberVo.setPhone("+82 10-3564-5648");
		memberDao.insert(memberVo);

		memberVo.setMemberId(1L);
		memberVo.setMemberName("TurkishDelight Garlic");
		memberVo.setEmail("TKDelight@gmail.com");
		memberVo.setPassword("EdwordNarnia");
		memberVo.setPhone("+82 10-7826-1589");
		memberDao.insert(memberVo);
	}

}
