package com.ict.db;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

// config.xml을 읽어서 MyBatis가 DB에 접근하고 실행할 수 있도록 도와주는 클래스
// 자바에서 MyBatis를 사용하기 위해서는 SqlSession이라는 객체를 사용한다.
// SqlSession객체를 사용하기 위해서 SqlSessionFactory 클래스를 생성하는 역할을 한다.
public class DBService {
	static private SqlSessionFactory factory;
	
	// static 초기화 (객체를 생성할 필요가 없으므로 초기화 방법)
	static {
		try {
			factory = new SqlSessionFactoryBuilder().build(
					Resources.getResourceAsReader("com/ict/db/config.xml"));
		} catch (Exception e) {
		}
	}
	
	public static SqlSessionFactory getFactory( ) { // 외부에서 접근하기 위해 사용(보안적으로 static없이 직접 접근X)
		return factory; // DB접속 정보와 mapper정보를 가지고 있음
	}
}
