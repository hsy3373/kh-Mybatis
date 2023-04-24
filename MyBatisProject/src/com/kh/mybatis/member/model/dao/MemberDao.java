package com.kh.mybatis.member.model.dao;

import org.apache.ibatis.session.SqlSession;

import com.kh.mybatis.member.model.vo.Member;

public class MemberDao {

	
	
	public Member loginMember(SqlSession sqlSession,  Member m) {
		
		//조회해오는 메소드 selectOne : 조회해올 데이터가 1개일때 사용, 조회된 데이터가 없다면 null값을 반환
		// 첫번째 매개변수 = sql문, 두번째 매개변수 sql문실행시 넣을 파라미터
		return sqlSession.selectOne( "memberMapper.loginMember" , m);
		//insert 문을 실행할때는 insert. 으로 시작하면 됨
	}
	
	
	public int insertMember(SqlSession sqlSession, Member m) {
		
		return sqlSession.insert( "memberMapper.insertMember" , m);
		
	}
}
