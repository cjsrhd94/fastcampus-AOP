package com.fastcampus.biz.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

// DAO(Data Access Object)
@Repository
public class UserDAOSpring implements UserService{

	@Autowired
	private JdbcTemplate spring;
	
	// BOARD ���� SQL ���ɾ��
	private final String USER_INSERT = "insert into users values (?, ?, ?, sysdate, ?)";
	private final String USER_UPDATE = "update users set role = ? where id = ?";
	private final String USER_DELETE = "delete users where id = ?";
	private final String USER_GET    = "select * from users where id = ? and password = ?";
	private final String USER_LIST   = "select * from users order by seq desc";
	
	// USERS ���� CRUD(Create(INSERT), Read(SELECT), Update, Delete) �޼ҵ� ����
	// ȸ�� ���
	@Override
	public void insertUser(UserVO vo) {
		System.out.println("===> SPRING ������� insertUser()��� ó��");
		spring.update(USER_INSERT, vo.getId(), vo.getPassword(), vo.getName(), vo.getRole());
	}
	
	// ȸ�� ����
	@Override
	public void updateUser(UserVO vo) {
		System.out.println("===> SPRING ������� updateUser()��� ó��");
		spring.update(USER_UPDATE, vo.getRole(), vo.getId());
	}
	
	// ȸ�� ����
	@Override
	public void deleteUser(UserVO vo) {
		System.out.println("===> SPRING ������� deleteUser()��� ó��");
		spring.update(USER_DELETE, vo.getId());
	}
	
	// ȸ�� �� ��ȸ
	@Override
	public UserVO getUser(UserVO vo) {
		System.out.println("===> SPRING ������� getUser()��� ó��");
		Object[] params = {vo.getId(), vo.getPassword()};
		return spring.queryForObject(USER_GET, params, new UserRowMapper());
	}
	
	// ȸ�� ��� ��ȸ
	@Override
	public List<UserVO> getUserList(UserVO vo) {
		System.out.println("===> SPRING ������� getUserList()��� ó��");
		return spring.query(USER_LIST, new UserRowMapper());
	}
}