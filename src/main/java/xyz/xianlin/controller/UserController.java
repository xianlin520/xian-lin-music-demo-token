package xyz.xianlin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import xyz.xianlin.domain.UserData;
import xyz.xianlin.service.impl.UserServiceImpl;
import xyz.xianlin.util.JwtUtil;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestController // 标记为控制器
@CrossOrigin // 解决跨域问题
@RequestMapping("/users") // 指定请求路径
public class UserController {
    @Autowired // 注入UserService
    private UserServiceImpl userService;
    
    @GetMapping("/{userQQ}") // 指定请求方式为GET, 用于查询用户是否存在
    public Result selectByUserQQ(@PathVariable String userQQ) {
        UserData userData = userService.selectByUserQQ(userQQ);
        return new Result(userData != null ? Code.GET_OK : Code.GET_ERR, userData, "查询成功");
    }
    
    @PostMapping // 指定请求方式为POST, 用于查询用户密码是否正确
    @ResponseBody // 指定返回结果为JSON
    public Result selectByUserQQAndUserPassword(@RequestBody UserData userData, HttpServletRequest request) {
        UserData userDataRet = userService.selectByUserQQAndUserPassword(userData);
        if (userDataRet != null) {
            //假设数据库中查询到了该用户，这里测试先所及生成一个UUID，作为用户的id
            String userId = UUID.randomUUID().toString();
            //准备存放在IWT中的自定义数据
            Map<String, Object> info = new HashMap<>();
            info.put("userQQ", userDataRet.getUserQQ());
            //生成JWT字符串
            String token = JwtUtil.sign(userId, info);
            return new Result(Code.POST_OK, token, "登录成功"); // 正常返回
        }
        return new Result(Code.POST_ERR, null, "用户名或密码错误");
        
    }
    @PutMapping // 指定请求方式为PUT, 用于插入新用户
    public Result insertUser(@RequestBody UserData userData) {
        try {
            userService.insertUser(userData);
            return new Result(Code.PUT_OK, null, "数据插入成功");
        } catch (Exception e) {
            return new Result(Code.PUT_ERR, null, "数据插入失败, 数据库内已存在该用户");
        }
        
    }
}
