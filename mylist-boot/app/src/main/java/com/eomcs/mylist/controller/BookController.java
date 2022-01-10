package com.eomcs.mylist.controller;

import java.io.FileWriter;
import java.io.IOException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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

    StringBuilder buf = new StringBuilder();

    int c;
    while ((c = in.read()) != -1) {

      if (c== '\n') { // 만약 읽은 문자가 줄바꿈 명령이라면, 지금까지 읽은 CSV 데이터를 분석하여 Contact객체에 담는다. 
        bookList.add(Book.valueOf(buf.toString())); 

        buf.setLength(0); // 다음 데이터를 읽기 위해 버퍼를 초기화 시킨다.

      } else { // 문자를 읽을 때 마다 버퍼에 임시 보관한다.
        buf.append((char) c);
      }
      //System.out.print((char) c);
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
  public Object save() throws IOException{
    FileWriter out = new FileWriter("books.csv"); // 따로 경로를 지정하지 않으면 프로젝트 폴더에 파일이 생성된다.

    Object[] arr = bookList.toArray();
    for (Object obj : arr) {
      Book book = (Book) obj;
      out.write(book.toCsvString() + "\n");
    }
    out.close();
    return arr.length;
  }
}





