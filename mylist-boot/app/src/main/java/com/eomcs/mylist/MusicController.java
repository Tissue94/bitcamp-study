package com.eomcs.mylist;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MusicController {

  String[] musics = new String[5];

  int size = 0;

  @RequestMapping("/my1/list")
  public Object list() {
    String[] arr = new String[size]; // 배열에 저장된 값만 복사할 새 배열을 만든다
    for (int i = 0; i < size; i++) {
      arr[i] = musics[i]; // 전체 배열에서 값이 들어 있는 항목만 복사한다.
    }
    return arr; // 복사한 배열 항목들을 담고 있는 새 배열을 리턴한다.
  }

  @RequestMapping("/my1/add")
  public Object add(String artist, String name, String album, String released) {
    String music = artist + "," +name + "," + album + "," + released;
    musics[size++] = music;
    return size;
  }

  @RequestMapping("my1/get")
  public Object get(String name) {
    for (int i = 0; i < size; i++) {
      if (musics[i].split(",")[1].equals(name)) { //
        return musics[i];
      }
    }
    return "";
  }

  @RequestMapping("/my1/update") 
  public Object update(String artist, String name, String album, String released) {
    String music = artist + "," +name + "," + album + "," + released;
    for (int i = 0; i < size; i++) {
      if (musics[i].split(",")[1].equals(name)) { //
        musics[i] = music;
        return 1;
      }
    }
    return 0;
  }

  @RequestMapping("my1/delete")
  public Object delete(String name) {
    for (int i = 0; i < size; i++) {
      if (musics[i].split(",")[1].equals(name)) { //

        //현재 위치에 다음 항목에서 배열 끝까지 반복하며 앞으로 값을 당겨온다.
        for (int j = i + 1; j < size; j++) {
          musics[j - 1] = musics[j];
        }
        size--;
        return 1;
      }
    }
    return 0;
  }



}
