package xyz.xianlin.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("user_data") // 设置数据库表名
public class UserData {
    @TableId(value="id" , type = IdType.AUTO) // 设置id策略为自增
    private Integer id;
    @TableField("user_qq") // 设置数据库表的字段名
    private String userQQ;
    private String userName;
    private String userPassword;
    
    public UserData(Integer id, String userQQ, String userName) {
        this.id = id;
        this.userQQ = userQQ;
        this.userName = userName;
    }
    
    public UserData(String userQq, String userName, String userPassword) {
        this.userQQ = userQq;
        this.userName = userName;
        this.userPassword = userPassword;
    }
    
    @Override
    public String toString() {
        return "UserData{" +
                "userQQ='" + userQQ + '\'' +
                ", userName='" + userName + '\'' +
                ", userPassword='" + userPassword + '\'' +
                '}';
    }
    
//    public Integer getId() {
//        return id;
//    }
//
//    public String getUserQQ() {
//        return userQQ;
//    }
//
//    public String getUserName() {
//        return userName;
//    }
//
//    public String getUserPassword() {
//        return userPassword;
//    }
    
}
