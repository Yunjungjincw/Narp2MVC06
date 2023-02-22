package kr.bit.model;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

// JDBC - > myBatis, JPA
public class MemberDAO {
		
		private static SqlSessionFactory sqlSessionFactory;
		
		//초기화 블럭- 프로그램 실행시 딱 한번만 실행되는 코드영역
		static {
			try {
				String resource = "kr/bit/mybatis/config.xml";	//mybatis환경 설정파일
				InputStream inputStream = Resources.getResourceAsStream(resource);	//읽기
				sqlSessionFactory =  new SqlSessionFactoryBuilder().build(inputStream);
			}catch(Exception e) {
				e.printStackTrace();
			}
		} 
		
		//회원 전체 리스트 보기
		public List<MemberVO> memberList() {
			//Connection + Statment => sqlSession
			SqlSession session =sqlSessionFactory.openSession();
			List<MemberVO> list =session.selectList("memberList");
			session.close();
			return list;
		}
		
		//회원가입 기능
		
		public int memberInsert(MemberVO vo) {
			SqlSession session = sqlSessionFactory.openSession();
			int cnt =session.insert("memberInsert",vo);
			session.commit();
			session.close();
			return cnt;
		}
		
		//회원삭제 기능
		public int memberDelete(int num) {
			SqlSession session = sqlSessionFactory.openSession();
			int cnt =session.delete("memberDelete",num);
			session.commit();
			session.close();
			return cnt;
		}
		
		//회원 상세 보기
		public MemberVO memberContent(int num) {
			SqlSession session = sqlSessionFactory.openSession();
			MemberVO vo =session.selectOne("memberContent",num);
			session.close();
			return vo;
		}
		
		//회원 정보 수정
		public int memberUpdate(MemberVO vo) {
			SqlSession session = sqlSessionFactory.openSession();
			int cnt =session.update("memberUpdate", vo);
			session.commit();
			session.close();
			return cnt;
		}
		
		
		public String memberLogin(MemberVO vo) {
			SqlSession session = sqlSessionFactory.openSession();
			String user_name=session.selectOne("memberLogin", vo);
			session.close();
			return user_name;
		}
	}


















