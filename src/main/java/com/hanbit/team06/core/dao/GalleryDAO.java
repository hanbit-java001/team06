package com.hanbit.team06.core.dao;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hanbit.team06.core.vo.GalleryVO;

@Repository
public class GalleryDAO {

	@Autowired
	private SqlSession sqlSession;

	public ArrayList<GalleryVO> selectImageList(GalleryVO sqlparams) {

		return null;
	}

	public int addImage(GalleryVO image) {

		return 0;
	}
}
