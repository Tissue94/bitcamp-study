package com.eomcs.mylist.controller;

import java.sql.Date;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.eomcs.mylist.dao.BinaryBoardDao;
import com.eomcs.mylist.domain.Board;

@RestController 
public class BoardController {

  BinaryBoardDao boardDao = new BinaryBoardDao();

  @RequestMapping("/board/list")
  public Object list() {
    return boardDao.findAll(); 
  }

  @RequestMapping("/board/add")
  public Object add(Board board) throws Exception{
    board.setCreatedDate(new Date(System.currentTimeMillis()));
    boardDao.insert(board);
    return boardDao.countAll();
  }

  @RequestMapping("/board/get")
  public Object get(int index) throws Exception{
    Board board = boardDao.findByNo(index);
    if (board == null) {
      return "";
    }
    boardDao.increaseViewCount(index);
    return board;
  }

  @RequestMapping("/board/update")
  public Object update(int index, Board board) throws Exception{
    Board old = boardDao.findByNo(index);
    if (old == null) {
      return 0;
    }

    board.setViewCount(old.getViewCount());
    board.setCreatedDate(old.getCreatedDate());
    return boardDao.update(index, board);
  }

  @RequestMapping("/board/delete")
  public Object delete(int index) throws Exception{
    return boardDao.delete(index);
  }
}




