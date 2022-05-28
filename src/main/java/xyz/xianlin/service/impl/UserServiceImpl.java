package xyz.xianlin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.xianlin.dao.UserDao;
import xyz.xianlin.domain.UserData;
import xyz.xianlin.service.UserService;

import java.util.List;

@Service // 标识为 Spring Bean
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;
    
    @Override
    public UserData selectByUserQQ(String userQQ) {
//        return userDao.selectByUserQQ(userQQ);
        QueryWrapper<UserData> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_qq", userQQ);
        List<UserData> userData = userDao.selectList(queryWrapper);
        if (userData.size() == 0) return null;
        UserData user = userData.get(0);
        return new UserData(user.getId(), user.getUserQQ(), user.getUserName());
//        return userData.get(0);
    }
    
    
    @Override
    public UserData selectByUserQQAndUserPassword(UserData userData) {
//        return userDao.selectByUserQQAndUserPassword(userData);
        QueryWrapper<UserData> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_qq", userData.getUserQQ());
        queryWrapper.eq("user_password", userData.getUserPassword());
        List<UserData> userData1 = userDao.selectList(queryWrapper);
        if (userData1.size() == 0) return null;
        return userData1.get(0);
    }
    
    @Override
    public void insertUser(UserData userData) {
//        boolean b = userDao.insertUser(userData);
        userDao.insert(userData);
    }
}
