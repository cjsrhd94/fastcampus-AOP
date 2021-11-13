package com.fastcampus.biz.board;

import java.util.List;
import java.util.Map;

public interface BoardService {
    // �� ���
    void insertBoard(BoardVO vo);

    // �� ����
    void updateBoard(BoardVO vo);

    // �� ����
    void deleteBoard(BoardVO vo);

//    // �� �� ��ȸ
//    Map<String, Object> getBoard(BoardVO vo);
//
//    // �� ��� �˻�
//    List<Map<String, Object>> getBoardList(BoardVO vo);

    // �� �� ��ȸ
    BoardVO getBoard(BoardVO vo);

    // �� ��� �˻�
    List<BoardVO> getBoardList(BoardVO vo);
}
