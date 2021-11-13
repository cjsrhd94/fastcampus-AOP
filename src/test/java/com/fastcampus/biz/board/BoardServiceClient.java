package com.fastcampus.biz.board;

import org.springframework.context.support.GenericXmlApplicationContext;

import java.util.List;
import java.util.Map;

public class BoardServiceClient {
    public static void main(String[] args) {
        // 1. ������ �����̳ʸ� �����Ѵ�.
        GenericXmlApplicationContext container
                = new GenericXmlApplicationContext("business-layer.xml");

        // 2. �׽�Ʈ ��ü�� Lookup�Ѵ�.
        BoardService boardService = (BoardService) container.getBean("boardService");

        // 3. ��ü�� �׽�Ʈ�Ѵ�.
        BoardVO vo = new BoardVO();
        vo.setSeq(10);
        vo.setTitle("IoC �׽�Ʈ");
        vo.setWriter("�׽���2");
        vo.setContent("�׽�Ʈ���Դϴ�!");
        boardService.insertBoard(vo);

        vo.setSeq(3);
        BoardVO board = boardService.getBoard(vo);
        System.out.println("�� ��ȸ ��� : " + board.toString());

        List<BoardVO> boardList = boardService.getBoardList(vo);
        for (BoardVO boards : boardList){
            System.out.println("---> " + boards.toString());
        }

        // 4. �����̳ʸ� �����Ѵ�.
        container.close();

    }
}
