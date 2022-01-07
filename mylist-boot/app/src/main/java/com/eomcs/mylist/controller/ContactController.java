package com.eomcs.mylist.controller;

import java.io.FileReader;
import java.io.FileWriter;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.eomcs.mylist.domain.Contact;
import com.eomcs.util.ArrayList;

@RestController 
public class ContactController {

  // Contact 객체 목록을 저장할 메모리 준비
  // => Objec[] list = new Object[5];
  // => int size = 0;
  ArrayList contactList = new ArrayList();

  public ContactController() throws Exception{
    System.out.println("ContactController() 호출됨!");

    FileReader in = new FileReader("contacts.csv");

    StringBuilder buf = new StringBuilder();

    int c;
    while ((c = in.read()) != -1) {

      if (c== '\n') { // 만약 읽은 문자가 줄바꿈 명령이라면, 지금까지 읽은 CSV 데이터를 분석하여 Contact객체에 담는다. 
        contactList.add(Contact.valueOf(buf.toString())); 

        buf.setLength(0); // 다음 데이터를 읽기 위해 버퍼를 초기화 시킨다.

      } else { // 문자를 읽을 때 마다 버퍼에 임시 보관한다.
        buf.append((char) c);
      }
      //System.out.print((char) c);
    }

    in.close();
  }

  @RequestMapping("/contact/list")
  public Object list() {
    return contactList.toArray(); 
  }

  @RequestMapping("/contact/add")
  public Object add(Contact contact) {
    //    System.out.println(contact);
    contactList.add(contact);
    return contactList.size();
  }


  @RequestMapping("/contact/get")
  public Object get(String email) {
    int index = indexOf(email);
    if (index == -1) {
      return "";
    }

    return contactList.get(index);
  }

  @RequestMapping("/contact/update")
  public Object update(Contact contact) {
    int index = indexOf(contact.getEmail());
    if (index == -1) {
      return 0;
    }

    return contactList.set(index, contact) == null ? 0 : 1;
  }

  @RequestMapping("/contact/delete")
  public Object delete(String email) {
    int index = indexOf(email);
    if (index == -1) {
      return 0;
    }

    contactList.remove(index);
    return 1;
  }

  @RequestMapping("/contact/save")
  public Object save() throws Exception{
    FileWriter out = new FileWriter("contacts.csv"); // 따로 경로를 지정하지 않으면 프로젝트 폴더에 파일이 생성된다.

    Object[] arr = contactList.toArray();
    for (Object obj : arr) {
      Contact contact = (Contact) obj;
      out.write(contact.toCsvString() + "\n");
    }
    out.close();
    return arr.length;
  }

  int indexOf(String email) {
    for (int i = 0; i < contactList.size(); i++) {
      Contact contact = (Contact)contactList.get(i);
      if (contact.getEmail().equals(email)) { 
        return i;
      }
    }
    return -1;
  }
}





