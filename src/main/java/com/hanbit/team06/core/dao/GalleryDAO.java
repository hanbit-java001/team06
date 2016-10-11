package com.hanbit.team06.core.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hanbit.team06.core.vo.GalleryVO;
import com.hanbit.team06.core.vo.MemberVO;

@Repository
public class GalleryDAO {

	@Autowired
	private SqlSession sqlSession;

	public ArrayList<GalleryVO> selectPhotoList(GalleryVO gallery) {

		return null;
	}

	public int countPhoto() {
		return sqlSession.selectOne("gallery.countPhoto");
	}

	public int insertPhoto(GalleryVO gallery) {
		return sqlSession.insert("gallery.insertPhoto", gallery);
	}

	public GalleryVO selectPhoto(int photoId) {
		Map param = new HashMap();
		param.put("photoId", photoId);

		return sqlSession.selectOne("gallery.selectPhotoId", param);
	}

	public int updatePhoto(GalleryVO gallery) {
		return sqlSession.update("gallery.updatePhoto", gallery);
	}

	public int selectNextPhotoId() {
		return sqlSession.selectOne("gallery.selectNextPhotoId");
	}
}
