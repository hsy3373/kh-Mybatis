package com.kh.mybatis.common.template;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
// mybatis의 예전이름이 ibatis임


public class Template {
	
	/*
	 * 기존 JDBC
	 * 1. getConnection() : driver.properties 파일을 읽어들여서 db와 접속된 Connection 객체를 생성해서 반환
	 * 2. close() : 전달받은 JDBC객체를 반납시키는 구문
	 * 3. commit()/rollback() : 트랜잭션 처리해주는 구문
	 * */

	//마이바티스 버전   (스프링으로 넘어가면 아래 코드들을 간단하게 설정하고 넘어가게 됨)
	public static SqlSession getSqlSession() {
	
		// mybatis-config.xml을 읽어들여서 해당 db와 접속된 SqlSession객체를 생성해서 반환
		
		SqlSession sqlSession = null;
		
		// sqlSession객체를 얻어오기 위해서는 SqlSessionFactory객체가 필요
		// SqlSessionFactory객체를 생성하기 위해서는 SqlSessionFactoryBuilder객체가 필요함
		
		String resource = "/mybatis-config.xml"; //  /는 최상위 폴더(classes)를 뜻함
		
		try {
			InputStream stream = Resources.getResourceAsStream(resource);// 자원으로부터 통로를 얻어냄
			
			// 1단계 SqlSessionFactoryBuilder 객체 생성
//			SqlSessionFactoryBuilder ssfb = new SqlSessionFactoryBuilder();
			
			// 2단계 mybatis-config파일을 읽어들여서 SqlSessionFactory 객체 생성
//			SqlSessionFactory ssf = ssfb.build(stream);
			
			// 3단계 SqlSession객체 생성 및 트랜잭션 처리를 자동/수동으로 할지 매개변수를 통해 구분(false:수동, true:자동)
//			sqlSession = ssf.openSession(false); //false : 자동커밋을 막아주는 변수
			
			sqlSession = new SqlSessionFactoryBuilder().build(stream).openSession(false);
			
		} catch (IOException e) {
			e.printStackTrace();
		}  
		
		return sqlSession;
	}
	
}
