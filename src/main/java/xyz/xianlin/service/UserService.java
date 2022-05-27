package xyz.xianlin.service;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import xyz.xianlin.domain.UserData;

public interface UserService {
    // 根据QQ号查询用户信息- 用于核实此QQ号是否已经注册
//    @Select("select * from user_data where userQQ = #{userQQ}")
    UserData selectByUserQQ(String userQQ);
    
    //根据QQ号和密码查询用户信息- 用于登录
//    @Select("select * from user_data where userQQ = #{userQQ} and userPassword = #{userPassword}")
    UserData selectByUserQQAndUserPassword(UserData UserData);
    
    // 插入用户信息 - 用于注册
//    @Insert("insert into user_data (userQQ, userName, userPassword) VALUES (#{userQQ}, #{userName}, #{userPassword})")
    void insertUser(UserData UserData);
    
}
