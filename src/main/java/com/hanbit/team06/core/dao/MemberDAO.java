package com.hanbit.team06.core.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hanbit.team06.core.vo.MemberVO;

@Repository
public class MemberDAO {

	private static final Logger LOGGER = LoggerFactory.getLogger(MemberDAO.class);

	@Autowired
	private SqlSession sqlSession;

	public int countMember(String memberEmail) {
		return sqlSession.selectOne("member.countMember", memberEmail);
	}

	public int insertMember(MemberVO member) {
		return sqlSession.insert("member.insertMember", member);
	}

	public int insertNaverMember(MemberVO member) {
		return sqlSession.insert("member.insertNaverMember", member);
	}

	public MemberVO selectMember(String memberEmail) {
		Map param = new HashMap();
		param.put("memberEmail", memberEmail);

		return sqlSession.selectOne("member.selectMember", param);
	}

	public MemberVO selectMember(int memberId) {
		Map param = new HashMap();
		param.put("memberId", memberId);

		return sqlSession.selectOne("member.selectMember", param);
	}

	public MemberVO selectNaverMember(String memberEmail) {
		Map param = new HashMap();
		param.put("memberEmail", memberEmail);

		return sqlSession.selectOne("member.selectNaverMember", param);
	}

	public int selectMemberId(String memberEmail) {
		return sqlSession.selectOne("member.selectMemberId", memberEmail);
	}

	public String selectPassword(int memberId) {
		return sqlSession.selectOne("member.selectPassword", memberId);
	}

	public int updateMember(MemberVO member) {
		return sqlSession.update("member.updateMember", member);
	}

	public int selectNextMemberId() {
		return sqlSession.selectOne("member.selectNextMemberId");
	}

	public List<MemberVO> selectMembers(int page) {
		List<MemberVO> members = sqlSession.selectList("member.selectMembers", page);

		return members;
	}

	public int countMembers() {
		return sqlSession.selectOne("member.countMembers");
	}

}
