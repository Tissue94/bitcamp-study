package com.eomcs.mylist.dao;

import com.eomcs.mylist.domain.Book;

public interface BookDao {

  // 인터페이스는 객체의 메서드 호출 규칙을 정의하는 것이기 때문에
  // 메서드를 작성할 때 메서드 몸체(메서드 body)를 작성하지 말아야 한다.
  // 메서드 바디 없는 메서드를 "추상 메서드(abstract method)"라 부른다.

  // 인터페이스에서는 public 생략 가능
  int countAll();

  Object[] findAll();

  void insert(Book book) throws Exception;

  Book findByNo(int no);

  int update(int no, Book book) throws Exception;

  int delete(int no) throws Exception;
}