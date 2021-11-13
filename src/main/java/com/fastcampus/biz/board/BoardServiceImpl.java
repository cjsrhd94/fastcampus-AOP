package com.fastcampus.biz.board;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("boardService")
public class BoardServiceImpl implements BoardService{

    @Autowired
    private BoardDAO boardDAO;

//    public BoardServiceImpl() {
//        System.out.println("===> BoardServiceImpl 생성");
//    }

//    public BoardServiceImpl(BoardDAO boardDAO) {
//        System.out.println("===> BoardServiceImpl 생성");
//        this.boardDAO = boardDAO;
//    }

//    public void setBoardDAO(BoardDAO boardDAO) {
//        System.out.println("===> BoardServiceImpl 생성");
//        this.boardDAO = boardDAO;
//    }

    @Override
    public void insertBoard(BoardVO vo) {
        // 클라이언트가 0번 글을 등록하려고 하는 순간 예외를 발생시킨다.
//        if(vo.getSeq() == 0){
//            throw new IllegalArgumentException("0번 글을 등록할 수는 없습니다.");
//        }
        boardDAO.insertBoard(vo);
    }

    @Override
    public void updateBoard(BoardVO vo) {
        boardDAO.updateBoard(vo);
    }

    @Override
    public void deleteBoard(BoardVO vo) {
        boardDAO.deleteBoard(vo);
    }

    @Override
    public BoardVO getBoard(BoardVO vo) {
        return boardDAO.getBoard(vo);
    }

    @Override
    public List<BoardVO> getBoardList(BoardVO vo) {
        return boardDAO.getBoardList(vo);
    }
}
