package com.ict.db;

public class MyBatis {
	/*
	 	개발자가 지정한 SQL, 저장프로시저 그리고 몇 가지 고급 매핑을 지원하는 퍼시스턴스 프레임워크이다.
	 	즉, 자바 SQL 프레임워크이다. (SQL Mappig Framework for Java)
	 	MyBatis 다운로드 후 압축해제하고 WEB-INF-lib안에 라이브러리(jar파일)를 넣어준다.
	 	
	 	5개의 파일이 필요하다 : DAO, VO, DBService, config.xml, mapper.xml
	 		- VO : DB 정보를 담는 객체 (해당 변수가 DB컬럼명과 같아야 한다.)
	 		- DAO : DB에 접근해서 검색, 삽입, 삭제, 수정을 할 수 있도록 지원하는 객체
	 		- DBServie : config.xml을 읽어서 MyBatis가 DB에 접근하고 실행할 수 있도록 도와주는 클래스
	 		- config.xml : DB에 접근할 수 있는 환경 설정과 실제 DB 처리를 해서 결과를 얻어내는 mapper.xml의
	 					   위치를 지정해주는 환경 설정 파일
	 		- mapper.xml : 실제 DB처리하고 결과를 얻어내는 역할을 하는 xml파일, 
	 					   DAO에서 mapper.xml을 호출해서 사용한다.
	 		
	 		* mapper.xml의 내용 :
	 		xml은 태그로 구성되어 있다. HTML태그를 사용하는 것이 아니라 자기만의 고유 태그를 만들어서 사용
	 		자기만의 고유태그에게 의미를 부여하기 위해서는 DTD라는 문서를 만들어야 하는데 MyBatis에서
	 		만든 DTD문서를 활용해서 고유 태그를 사용한다.
	 		고유태그에는 <select>, <update>, <delete>, <insert>태그 등이 있다.
	 		
	 			- id : DAO에서 mapper를 호출할 때 사용하는 이름
	 			- parameterType : 파라미터 타입을 작성하면 된다.
	 			- resultType : select문에 대한 결과 타입인데 90%이상 VO타입이다.
	 						   (네모형태인 표가 나오므로 90퍼는 VO, 하지만 집계함수는 숫자가 나오므로 예외가 존재)
	 			
	 			<select id="" resultType="" parameterType="">
	 				실제 sql 구문 작성 (PreparedStatement에서 사용하는 ? 대신 #{}를 사용하면 된다.)
	 			</select>
	 			
	 			insert, update, delete 태그는 id와 parameterType만 존재, resultType은 없다.(결과가 무조건 숫자라서) 
	 			<insert id="" parameterType="">
	 				실제 sql 구문 작성 (? 대신 #{})
	 			</insert>
	 			<update id="" parameterType="">
	 				실제 sql 구문 작성 (? 대신 #{})
	 			</insert>
	 			<delete id="" parameterType="">
	 				실제 sql 구문 작성 (? 대신 #{})
	 			</insert>
	 */
}
