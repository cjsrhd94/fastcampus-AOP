package com.fastcampus.biz.board;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

// 2. DAO(Data Access Object) Ŭ���� : �������� DB ������ ����ϴ� Ŭ����
//@Repository
public class BoardDAOSpring implements BoardDAO {

	@Autowired
	private JdbcTemplate spring;

	// BOARD ���� SQL ��ɾ��
	private final String BOARD_INSERT = "insert into board(seq, title, writer, content) " +
                                        "values (?, ?, ?, ?)";
	private final String BOARD_UPDATE = "update board set title = ?, content = ? where seq = ?";
	private final String BOARD_UPDATE_CNT = "update board set cnt = cnt + 1 where seq = ?";
	private final String BOARD_DELETE = "delete board where seq = ?";
	private final String BOARD_GET    = "select * from board where seq = ?";
	private final String BOARD_LIST   = "select * from board order by seq desc";

	// BOARD ���� CRUD(Create(INSERT), Read(SELECT), Update, Delete) �޼ҵ� ����
	// �� ���
	@Override
	public void insertBoard(BoardVO vo) {
		System.out.println("===> SPRING ������� insertBoard() ��� ó��");
		spring.update(BOARD_INSERT, vo.getSeq(), vo.getTitle(), vo.getWriter(), vo.getContent());
	}
	
	// �� ����
	@Override
	public void updateBoard(BoardVO vo) {
		System.out.println("===> SPRING ������� updateBoard() ��� ó��");
		spring.update(BOARD_UPDATE, vo.getTitle(), vo.getContent(), vo.getSeq());
	}
	
	// �� ����
	@Override
	public void deleteBoard(BoardVO vo) {
		System.out.println("===> SPRING ������� deleteBoard() ��� ó��");
		spring.update(BOARD_DELETE, vo.getSeq());
	}
	
	// �� �� ��ȸ
	@Override
	public BoardVO getBoard(BoardVO vo) {
		System.out.println("===> SPRING ������� getBoard() ��� ó��");
		Object[] params = {vo.getSeq()};
		return spring.queryForObject(BOARD_GET, params, new BoardRowMapper());
	}
	
	// �� ��� �˻�
	@Override
	public List<BoardVO> getBoardList(BoardVO vo) {
		System.out.println("===> SPRING ������� getBoardList() ��� ó��");
		// ����� ��ȸ�� ���� query() �޼ҵ带 ����Ѵ�.
		// ù ��° ���ڴ� SQL, �� ��° ���ڴ� �˻��� ResultSet�� ������ RowMapper ��ü
		return spring.query(BOARD_LIST, new BoardRowMapper());
	}

}















