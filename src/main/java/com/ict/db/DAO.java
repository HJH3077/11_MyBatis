package com.ict.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

public class DAO {
	// DB접속
	// config.xml로

	// MyBatis에서는 SqlSession 클래스를 이용해서
	// mapper.xml 파일의 태그들을 사용해서 sQL을 사용한다.
	private static SqlSession ss;

	private synchronized static SqlSession getSession() {
		if (ss == null) { // 맨 처음인 경우
			// ss = DBService.getFactory().openSession(); // select문
			// ss = DBService.getFactory().openSession(true); // autocommit();

			// 트랜젝션 처리를 위해서 수동 commit()을 하자
			ss = DBService.getFactory().openSession(false); // 수동commit();
		}
		return ss;
	}

	// list
	// MyBatis select문은 4가지로 구분된다.
	// 결과가 여러 개일 때 List<VO> => selectList() 메소드
	// 결과가 하나일 때 VO => selectOne() 메소드
	// 파라미터 값이 없을 때
	// 파라미터 값이 있을 때 (파라미터가 2개 이상이면 무조건 VO아니면 Map을 사용)
	public static List<VO> getSelectAll() {
		List<VO> list = new ArrayList<VO>();
		// getSession().sql명령과 같은 메소드 차지
		// list = getSession().selectList("mapper의 id"); // 파라미터가 없는 메소드
		// list = getSession().selectList("mapper의 id", 파라미터); // 파라미터가 없는 메소드
		list = getSession().selectList("list");
		return list;
	}

	public static int getInsert(VO vo) {
		int result = 0;
		// insert, update, delete는
		// getSession().insert("mapper의 id", 파라미터)
		result = getSession().insert("insert", vo); // 파라미터 사용 (근데 보통 파라미터 값을 안쓸리가 없음)

		// insert, update, delete는
		// openSession(false)를 했기 때문에 commit을 해야 DB에 반영된다.
		ss.commit();
		return result;
	}

	// 상세 보기
	public static VO getSelectOne(String idx) { // 파라미터가 있음
		VO vo = null;
		vo = getSession().selectOne("onelist", idx); // 파라미터가 있는거 사용
		return vo;
	}

	public static int getUpdate(VO vo) {
			int result = 0;
			result = getSession().update("update", vo);
			ss.commit();
			return result;
	}
	
	public static int getDelete(VO vo) {
		int result = 0;
		// getSession().delete("mapper의 id", 파라미터)
		// insert, update, delete는
		// openSession(false)를 했기 때문에 commit을 해야 DB에 반영된다.
		result = getSession().delete("delete", vo);
		ss.commit();
		return result;
	}
}
