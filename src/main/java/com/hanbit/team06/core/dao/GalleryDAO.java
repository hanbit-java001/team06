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

	public int countPhotos() {
		return sqlSession.selectOne("gallery.countPhotos");
	}

	public int insertPhoto(GalleryVO gallery) {
		return sqlSession.insert("gallery.insertPhoto", gallery);
	}

	public int deletePhoto(int photoId) {
		return sqlSession.delete("gallery.deletePhoto", photoId);
	}

	public int updatePhoto(GalleryVO gallery) {
		return sqlSession.update("gallery.updatePhoto", gallery);
	}

	public GalleryVO selectFile(String photoName) {
		return sqlSession.selectOne("gallery.selectPhoto", photoName);
	}

	public GalleryVO selectPhoto(int photoId) {
		Map param = new HashMap();
		param.put("photoId", photoId);

		return sqlSession.selectOne("gallery.selectPhoto", param);
	}

	public int selectPhotoId(String photoName) {
		return sqlSession.selectOne("gallery.selectPhotoId", photoName);
	}

	public String selectPhotoName(int photoId) {
		return sqlSession.selectOne("gallery.selectPhotoName");
	}

	public int selectNextPhotoId() {
		return sqlSession.selectOne("gallery.selectNextPhotoId");
	}
}
