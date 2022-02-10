package com.eomcs.net.ex12;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

@SuppressWarnings("rawtypes")
public class ChatServer {

  int port;

  ArrayList clientOutStreams = new ArrayList();

  public ChatServer(int port) {
    this.port = port;
  }


  public void service() {
    try (ServerSocket serverSocket = new ServerSocket(this.port)) {
      System.out.println("서버 실행 중...");
      while (true) {
        new RequestHandler(serverSocket.accept()).start();
      }
    } catch (Exception e) {
      System.out.println("서버 실행 오류! - " + e.getMessage());
    }

  }

  @SuppressWarnings("unchecked")
  public void sendMessage(String message) {
    ArrayList deleteStreams = new ArrayList();

    for (int i = 0; i < clientOutStreams.size(); i++) {
      DataOutputStream out = (DataOutputStream) clientOutStreams.get(i);
      try {out.writeUTF(message);
      } catch (Exception e) {
        System.out.println("전송 오류: " + message);
        deleteStreams.add(out); // 무효한 출력 스트림은 삭제 명단에 등록한다. 
        //(목록 중간을 함부로 삭제하면 안된다. ->삭제 명단 목록에 넣어놓고 밑에 for문에서 삭제 명단 목록을 삭제한다.)
      }
    }

    for (Object deleteStream : deleteStreams) { // 삭제명단에 등록된 출력 스트림을 제거한다.
      clientOutStreams.remove(deleteStream);
    }
  }

  class RequestHandler extends Thread {
    Socket socket;

    public  RequestHandler(Socket socket) {
      this.socket = socket;
    } 

    @SuppressWarnings("unchecked")
    @Override
    public void run() {
      try (Socket socket2 = socket;
          DataOutputStream out = new DataOutputStream(socket.getOutputStream());
          DataInputStream in = new DataInputStream(socket.getInputStream())){

        clientOutStreams.add(out);

        String nickname = in.readUTF();

        out.writeUTF(nickname + "님 환영합니다!");
        out.flush();

        while (true) {
          String message = in.readUTF();
          if (message.equals("\\quit")) {
            out.writeUTF("<![QUIT[]>"); // 연결을 끊겠다는 특별한 메세지 ( 스레드를 종료하겠다는 메세지)
            out.flush();
            clientOutStreams.remove(out); // 메세지 출력 목록에서 연결이 종료된 클라이언트를 제거한다.
            break;
          }
          sendMessage(String.format("[%s] : %s", nickname, message));
        }
      } catch (Exception e) {
        System.out.println("클라이언트와의 통신 오류! -" + e.getMessage());
      }
    }
  }

  public static void main(String[] args) {
    new ChatServer(8888).service();
  }
}
