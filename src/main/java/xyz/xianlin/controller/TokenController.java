package xyz.xianlin.controller;


import jdk.nashorn.internal.runtime.logging.Logger;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import xyz.xianlin.util.JwtUtil;

@RestController // 标记为控制器
@CrossOrigin // 解决跨域问题
@RequestMapping("/token") // 指定请求路径
@Slf4j // 启用日志
public class TokenController {
    @GetMapping("/{token}")
    public Result selectByToken(@PathVariable String token) {
        if (JwtUtil.checkSign(token)) {
            log.info("LogBackTestInfo");
            return new Result(Code.GET_OK, null, "验证成功");
        }else {
            log.info("LogBackTestInfo");
            log.error("LogBackTestError");
            return new Result(Code.GET_ERR, null, "验证失败");
        }
    }
}

