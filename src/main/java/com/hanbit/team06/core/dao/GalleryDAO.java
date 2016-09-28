package com.hanbit.team06.core.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hanbit.team06.core.vo.GalleryVO;

@Repository
public class GalleryDAO {

	@Autowired
	private SqlSession sqlSession;

	public String selectPassword(int memberId) {

		return null;
	}

	public int updateMember(GalleryVO imageList) {

		return 0;
	}
}
