package com.javaex.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.PersonVo;

@Repository
public class PhonebookDao {

	@Autowired
	private SqlSession sqlSession;

	//추가
	public int personInsert(PersonVo personVo) {
		System.out.println("PhonebookDao.personInsert()");

		return sqlSession.insert("phonebook.insert", personVo);
	}

	
	//리스트
	public List<PersonVo> personSelect() {
		System.out.println("PhonebookDao.personSelect()");

		List<PersonVo> pList = sqlSession.selectList("phonebook.select");
		return pList;

	}
	// 삭제
	public int personDelete(int no) {
		System.out.println("PhonebookDao.personDelete()");

		int count = sqlSession.delete("phonebook.delete", no);
		System.out.println(no);
		
		return count;
	}
	
	// 수정폼
	public PersonVo personSelectOne(int no) {
		System.out.println("PhonebookDao.personSelectOne");
		
		PersonVo personVo=sqlSession.selectOne("phonebook.selectOne",no);
		System.out.println(personVo);
		
		return personVo;
	}
	
	// 수정
	public int personUpdate(PersonVo personVo) {
		System.out.println("PhonebookDao.personUpdate");
		
		int count=sqlSession.update("phonebook.update", personVo);
		
		return count;
	}
}
