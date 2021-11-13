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
//        System.out.println("===> BoardServiceImpl ����");
//    }

//    public BoardServiceImpl(BoardDAO boardDAO) {
//        System.out.println("===> BoardServiceImpl ����");
//        this.boardDAO = boardDAO;
//    }

//    public void setBoardDAO(BoardDAO boardDAO) {
//        System.out.println("===> BoardServiceImpl ����");
//        this.boardDAO = boardDAO;
//    }

    @Override
    public void insertBoard(BoardVO vo) {
        // Ŭ���̾�Ʈ�� 0�� ���� ����Ϸ��� �ϴ� ���� ���ܸ� �߻���Ų��.
//        if(vo.getSeq() == 0){
//            throw new IllegalArgumentException("0�� ���� ����� ���� �����ϴ�.");
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
