package com.fastcampus.biz.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDAOSpring userDAO;

    @Override
    public void insertUser(UserVO vo) {
    }

    @Override
    public void updateUser(UserVO vo) {
    }

    @Override
    public void deleteUser(UserVO vo) {
    }

    @Override
    public UserVO getUser(UserVO vo) {
        return userDAO.getUser(vo);
    }

    @Override
    public List<UserVO> getUserList(UserVO vo) {
        return null;
    }
}
