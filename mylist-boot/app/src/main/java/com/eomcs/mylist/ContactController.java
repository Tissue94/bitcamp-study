package com.eomcs.mylist;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController 
public class ContactController {

  Contact[] contacts = new Contact[5]; // 길이 5인 배열 contacts를 생성
  int size = 0; //int 변수 size를 선언과 초기화

  @RequestMapping("/contact/list")  //list 객체 타입, 새로운 배열 arr생성, 초기화.(배열의 크기는 size의 크기와 같다)
  public Object list() {
    Contact[] arr = new Contact[size]; 
    for (int i = 0; i < size; i++) {  //arr의 배열 크기는 size크기만큼 커진다. 배열 contacts의 값을 배열 arr에 저장한다
      arr[i] = contacts[i]; 
    }
    return arr;   //arr배열의 값을 리턴
  }


  @RequestMapping("/contact/add")
  public Object add(Contact contact) {
    System.out.println(contact); //contact.tostring에서 .tostring은 생략가능
    if (size == contacts.length) { 
      contacts = grow(); 
    }
    contacts[size++] = contact;
    return size;
  }

  @RequestMapping("/contact/get")
  public Object get(String email) {
    int index = indexOf(email);
    if (index == -1) {
      return "";
    }

    return contacts[index];
  }

  @RequestMapping("/contact/update")
  public Object update(Contact contact) {
    int index = indexOf(contact.email);
    if (index == -1) {
      return 0;
    }

    contacts[index] = contact;
    return 1;
  }


  @RequestMapping("/contact/delete")
  public Object delete(String email) {
    int index = indexOf(email);
    if (index == -1) {
      return 0;
    }


    remove(index);  
    return 1;
    // 메서드 이름으로 코드의 의미를 짐작할 수 있다. 이것이 메서드로 분리하는 이유이다.
  }

  // 기능: 
  // - 입력 받은 파라미터 값을 가지고 CSV 형식으로 문자열을 만들어 준다.
  //
  // 기능:
  // - 이메일로 연락처 정보를 찾는다.
  // - 찾은 연락처의 배열 인덱스를 리턴한다.
  //

  int indexOf(String email) {
    for (int i = 0; i < size; i++) {
      Contact contact = contacts[i];
      if (contact.email.equals(email)) { 
        return i;
      }
    }
    return -1;
  }


  Contact remove(int index) {
    Contact old = contacts[index];
    for (int i = index + 1; i < size; i++) {
      contacts[i - 1] = contacts[i];
    }
    size--;
    return old;
  }



  Contact[] grow() {
    Contact[] arr = new Contact[newLength()];
    copy(contacts, arr);
    return arr;
  }
  // 기능:
  // - 주어진 배열에 대해 50% 증가시킨 새 배열의 길이를 알려준다.
  //
  int newLength() {
    return contacts.length + (contacts.length >> 1);
  }

  // 기능: 
  // - 배열을 복사한다.
  // 
  void copy(Contact[] source, Contact[] target) {
    // 개발자가 잘못 사용할 것을 대비해서 다음 코드를 추가한다.
    // 즉 target 배열이 source 배열 보다 작을 경우 target 배열 크기만큼만 복사한다.
    int length = source.length;
    if (target.length < source.length) {
      length = target.length;
    }
    for (int i = 0; i < length; i++) {
      target[i] = source[i];
    }
  } 
}



