package com.eomcs.mylist.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.eomcs.io.FileWriter2;
import com.eomcs.mylist.domain.Book;
import com.eomcs.util.ArrayList;

@RestController 
// controller와 Restcontroller의 차이
// controller 에는 일반 controller Restcontroller 있다
// 일반 controller 는 페이지 요청 
// 로그인이나 데이터 수정 (데이터를 가져오거나 뿌려줄 때 삭제할 때 등)은 Restcontroller

// 은행 에러
public class BookController {

  // Board 객체 목록을 저장할 메모리 준비
  // => Objec[] list = new Object[5];
  // => int size = 0;
  ArrayList bookList = new ArrayList();

  public BookController() throws Exception{
    System.out.println("BoookController() 호출됨!");

    com.eomcs.io.FileReader2 in = new com.eomcs.io.FileReader2("books.csv");

    String line;
    while ((line = in.readLine()).length() != 0) { // 빈줄을 리턴 받았으면 읽기를 종료한다.
      bookList.add(Book.valueOf(line));   // 파일에서 읽은 한 줄의 CSV 데이터로 객체를 만든 후 목록에 등록한다.
    }

    in.close();
  }

  @RequestMapping("/book/list")
  public Object list() {
    return bookList.toArray(); 
  }

  @RequestMapping("/book/add")
  public Object add(Book book) {

    bookList.add(book);
    return bookList.size();
  }


  @RequestMapping("/book/get")
  public Object get(int index) {
    if (index < 0 || index >= bookList.size()){
      return "";
    }

    return bookList.get(index);
  }

  @RequestMapping("/book/update")
  public Object update(int index, Book book) {
    if (index < 0 || index >= bookList.size()){
      return 0;
    }

    return bookList.set(index, book) == null ? 0 : 1;
  }

  @RequestMapping("/book/delete")
  public Object delete(int index) {
    if (index < 0 || index >= bookList.size()){
      return 0;
    }

    bookList.remove(index);
    return 1;
  }

  @RequestMapping("/book/save")
  public Object save() throws Exception{
    FileWriter2 out = new FileWriter2("books.csv"); // 따로 경로를 지정하지 않으면 프로젝트 폴더에 파일이 생성된다.

    Object[] arr = bookList.toArray();
    for (Object obj : arr) {
      Book book = (Book) obj;
      out.println(book.toCsvString());
    }
    out.close();
    return arr.length;
  }
}





