package com.eomcs.oop.ex11.h.test;

public class LinkedList {
  Node head;
  Node tail;
  int size;

  public void add(Object value) {
    Node node = new Node(value);

    if (head == null) {
      tail = head = node; // head = node 이 먼저 실행 된 후 tail = head 실행
    } else {
      node.prev = tail;
      tail.next = node;
      tail = node;
    }
    size++;
  }

  public void add(int index, Object value) { // insert
    Node node = getNode(index);
    Node newNode = new Node(value);

    if(node.prev != null) {
      node.prev.next = newNode; // 앞 노드 뒤에 새 노드를 삽입

    }
    newNode.prev = node.prev; // 새 노드의 앞 노드 설정

    node.prev = newNode; // 현재 노드의 앞 노드를 새 노드로 설정
    newNode.next = node; // 새 노드의 다음 노드를 현재 노드로 설정

    if(node == head) { // 첫번째 노드라면 
      head = newNode; // 새 노드를 첫 번째 노드로 만든다.
    }

    size++;
  }

  public int size() {
    return size;
  }

  public Object get(int index) {
    Node node = getNode(index);

    return node.value;
  }

  public Object remove(int index) {

    Node node = getNode(index);

    if(size == 1) {
      head = tail = null;
    } else if ( node == head) {
      head = node.next;
    } else if (node == tail) {
      tail = node.prev;
    } else {
      node.prev.next = node.next;
      node.next.prev = node.prev;
    }

    // 삭제된 노드는 다른 노드를 참조하지 않도록 초기화시킨다.
    // => 삭제된 노드끼리 참조하는 경우 가비지가 되지 않는 문제가 발생한다.
    // => 삭제된 노드가 값 객체의 주소를 갖고 있으면 값 객체가 가비지가 되지 않는 문제가 발생한다.
    //
    node.prev = null;
    node.next = null;
    Object deleted = node.value;
    node.value = null;
    size--;
    return deleted; // 삭제되기 전의 값 리턴
  }

  public Object set(int index, Object value) {
    Node node = getNode(index);
    Object old = node.value;
    node.value = value;
    return old; // 변경되기 전의 값 리턴
  }

  private Node getNode(int index) {
    if (index < 0 || index >= size) {
      throw new IndexOutOfBoundsException();
    } 

    Node node = head;
    int count = 0;
    while (count < index) {
      node = node.next;
      count++;
    }

    return node;
  }

  public Iterator iterator() {

    // Anonymous Class활용 예 2
    // => 오직 한개의 인스턴스만 생성할 경우
    // => return 문, 할당문, 파라미터 전달하는 곳에 놓기
    //

    // 메서드가 한개짜리 인터페이스일때만 람다 가능

    //컬렉션의 값을 조회하는 일을 수행한다.
    //
    return new Iterator(){
      int cursor;

      @Override
      public boolean hasNext() {
        return cursor < LinkedList.this.size();
      }

      @Override
      public Object next() {
        return LinkedList.this.get(cursor++);
        //    int temp = cursor;
        //    cursor = cursor + 1;
        //    return list.get(temp);
      }
    }; // => new ListIterator(this)
  }

  // Static Nested Class 활용 예
  // => 특정 클래스 안에서만 사용되는 클래스일 때
  // => 바깥 클래스의 인스턴스 멤버를 사용하지 않을 때
  // 
  private static class Node {
    Node prev;
    Object value;
    Node next;

    public Node(Object value) {
      this.value = value;
    }

  }




}
