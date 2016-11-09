package com.hanbit.team06.core.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hanbit.team06.core.vo.GalleryVO;

@Repository
public class GalleryDAO {

	private static final Logger LOGGER = LoggerFactory.getLogger(MemberDAO.class);

	@Autowired
	private SqlSession sqlSession;

	public List<GalleryVO> selectPhotoList() {
		List<GalleryVO> photoList = sqlSession.selectList("gallery.selectPhotoList");
		return photoList;
	}

	public List<GalleryVO> selectPhotoFind(int hashtagId1) {
		List<GalleryVO> photoList = sqlSession.selectList("gallery.selectPhotoFind", hashtagId1);
		return photoList;
	}

	public int countPhotoList() {
		return sqlSession.selectOne("gallery.countPhotoList");
	}

	public int insertPhoto(GalleryVO gallery) {
		return sqlSession.insert("gallery.insertPhoto", gallery);
	}

	public int insertHash(String hash) {
		return sqlSession.insert("gallery.insertHashtag", hash);
	}

	public int deletePhoto(int photoId) {
		return sqlSession.delete("gallery.deletePhoto", photoId);
	}

	public int updatePhoto(GalleryVO gallery) {
		return sqlSession.update("gallery.updatePhoto", gallery);
	}

	public GalleryVO selectFile(String photoName) {
		return sqlSession.selectOne("gallery.selectFile", photoName);
	}

	public List<String> allHashList() {
		List<String> allHashtag = sqlSession.selectList("gallery.allHashList");
		return allHashtag;
	}

	public String selectHashtagS(String hash) {
		return sqlSession.selectOne("gallery.selectHashtagS", hash);
	}

	public Integer selectHashtagI(String hash) {
		return sqlSession.selectOne("gallery.selectHashtagI", hash);
	}

	public List<String> selectHashtagIS(List<Integer> hashIds) {
		List<String> HashWords = sqlSession.selectList("gallery.selectHashtagIS", hashIds);
		return HashWords;
	}

	public GalleryVO selectPhoto(int photoId) {
//		Map param = new HashMap();
//		param.put("photoId", photoId);

		return sqlSession.selectOne("gallery.selectPhoto", photoId);
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

	public int sumPhotoLike() {
		return sqlSession.selectOne("gallery.sumLike");
	}

	public int sumReadCount() {
		return sqlSession.selectOne("gallery.sumReadCount");
	}
}
