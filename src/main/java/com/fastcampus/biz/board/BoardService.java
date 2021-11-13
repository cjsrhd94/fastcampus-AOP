package com.fastcampus.biz.board;

import java.util.List;
import java.util.Map;

public interface BoardService {
    // 글 등록
    void insertBoard(BoardVO vo);

    // 글 수정
    void updateBoard(BoardVO vo);

    // 글 삭제
    void deleteBoard(BoardVO vo);

    // 글 상세 조회
    Map<String, Object> getBoard(BoardVO vo);

    // 글 목록 검색
    List<Map<String, Object>> getBoardList(BoardVO vo);
}
