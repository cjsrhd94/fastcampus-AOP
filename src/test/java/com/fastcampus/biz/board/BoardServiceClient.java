package com.fastcampus.biz.board;

import org.springframework.context.support.GenericXmlApplicationContext;

import java.util.List;

public class BoardServiceClient {
    public static void main(String[] args) {
        // 1. 스프링 컨테이너를 구동한다.
        GenericXmlApplicationContext container
                = new GenericXmlApplicationContext("business-layer.xml");

        // 2. 테스트 객체를 Lookup한다.
        BoardService boardService = (BoardService) container.getBean("boardService");

        // 3. 객체를 테스트한다.
        BoardVO vo = new BoardVO();
        vo.setTitle("IoC 테스트");
        vo.setWriter("테스터2");
        vo.setContent("테스트중입니다!");
        boardService.insertBoard(vo);

        List<BoardVO> boardList = boardService.getBoardList(vo);
        for (BoardVO board : boardList){
            System.out.println("---> " + board.toString());
        }

        // 4. 컨테이너를 종료한다.
        container.close();

    }
}
