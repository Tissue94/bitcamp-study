package com.eomcs.mylist;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ContactController {

  String[] contacts = new String[5];

  int size = 0;

  @RequestMapping("/contact/list")
  public Object list() {
    String[] arr = new String[size]; // 배열에 저장된 값만 복사할 새 배열을 만든다
    for (int i = 0; i < size; i++) {
      arr[i] = contacts[i]; // 전체 배열에서 값이 들어 있는 항목만 복사한다.
    }
    return arr; // 복사한 배열 항목들을 담고 있는 새 배열을 리턴한다.
  }

  @RequestMapping("/contact/add")
  public Object add(String name, String email, String tel, String company) {
    if (size == contacts.length) { 
      //기존 배열 대신 새 배열을 연락처 저장 배열로 사용한다.
      contacts = grow(); // 메서드 이름에서 해당 코드에 대한 설명을 짐작할 수 있다.
    }
    contacts[size++] = createCSV(name, email, tel, company);
    return size;
  }

  @RequestMapping("contact/get")
  public Object get(String email) {
    int index = indexOf(email);
    if (index == -1) {
      return "";
    } 
    return contacts[index];
  }

  @RequestMapping("/contact/update") 
  public Object update(String name, String email, String tel, String company) {
    int index = indexOf(email);
    if (index == -1) {
      return 0;
    }
    contacts[index] = createCSV(name, email, tel, company);
    return 1;
  }

  @RequestMapping("contact/delete")
  public Object delete(String email) {
    int index = indexOf(email); 
    if (index == -1) {
      return 0;
    }
    remove(index);//메서드 이름에서 해당 코드에 대한 의미를 짐작할 수 있다. 이것이 메서드를 분리하는 이유이다
    return 1;
  }

  //기능 : 입력 받은 파라미터 값을 가지고 CSV 형식으로 문자열을 만들어 준다.
  String createCSV(String name, String email, String tel, String company) {
    return name + "," + email + "," + tel + "," + company;
  }

  //기능 : 이메일로 연락처 정보를 찾는다. 찾은 연락처의 배열 인덱스를 리턴한다.
  int indexOf(String email) {
    for (int i = 0; i < size; i++) {
      if (contacts[i].split(",")[1].equals(email)) { //
        return i;
      }
    }
    return -1;
  }
  //기능 : 배열에서 지정한 항목을 삭제한다.

  String remove(int index) {
    String old = contacts[index];
    for (int i = index + 1; i < size; i++) {
      contacts[i - 1] = contacts[i];
    }
    size--;
    return old;
  }

  //기능 : 배열의 크기를 늘린다. 기존 배열의 값을 복사해온다.
  String[] grow() {
    // 배열이 꽉 찼다면, 기존배열보다 50% 큰 배열을 새로 만든다.
    String[] arr = new String[newLength()];
    copy(contacts, arr);
    return arr;
  }

  // 기능 : 주어진 배열에 대해 50% 증가시킨 새 배열의 길이를 알려준다.
  int newLength() {
    return contacts.length +(contacts.length >> 1);
  }

  // 기능 : 배열을 복사한다.
  void copy(String[] source, String[] target) {
    // 개발자가 잘못사용할 것을 대비해서 다음 코드를 추가한다. 
    // 즉 target 배열이 source 배열보다 작을 경우 target 배열 크기 만큼만 복사한다.
    int length = source.length;
    if (target.length < source.length) {
      length = target.length;
    }
    for (int i = 0; i < length; i++) {
      target[i] = source[i];
    }
  }

}
