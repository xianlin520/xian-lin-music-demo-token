package xyz.xianlin.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import xyz.xianlin.domain.UserData;

@Mapper // 使用工厂创建代理对象, 继承BaseMapper
public interface UserDao extends BaseMapper<UserData> {
   /* // 根据QQ号查询用户信息- 用于核实此QQ号是否已经注册
    @Select("select * from user_data where userQQ = #{userQQ}")
    UserData selectByUserQQ(String userQQ);
    
    //根据QQ号和密码查询用户信息- 用于登录
    @Select("select * from user_data where userQQ = #{userQQ} and userPassword = #{userPassword}")
    UserData selectByUserQQAndUserPassword(UserData userData);
    
    // 插入用户信息 - 用于注册
    @Insert("insert into user_data (userQQ, userName, userPassword) VALUES (#{userQQ}, #{userName}, #{userPassword})")
    boolean insertUser(UserData userData);*/
}
