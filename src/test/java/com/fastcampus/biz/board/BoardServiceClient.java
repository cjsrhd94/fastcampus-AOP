package com.fastcampus.biz.board;

import org.springframework.context.support.GenericXmlApplicationContext;

import java.util.List;
import java.util.Map;

public class BoardServiceClient {
    public static void main(String[] args) {
        // 1. 스프링 컨테이너를 구동한다.
        GenericXmlApplicationContext container
                = new GenericXmlApplicationContext("business-layer.xml");

        // 2. 테스트 객체를 Lookup한다.
        BoardService boardService = (BoardService) container.getBean("boardService");

        // 3. 객체를 테스트한다.
        BoardVO vo = new BoardVO();
        vo.setSeq(10);
        vo.setTitle("IoC 테스트");
        vo.setWriter("테스터2");
        vo.setContent("테스트중입니다!");
        boardService.insertBoard(vo);

        vo.setSeq(3);
        BoardVO board = boardService.getBoard(vo);
        System.out.println("상세 조회 결과 : " + board.toString());

        List<BoardVO> boardList = boardService.getBoardList(vo);
        for (BoardVO boards : boardList){
            System.out.println("---> " + boards.toString());
        }

        // 4. 컨테이너를 종료한다.
        container.close();

    }
}
