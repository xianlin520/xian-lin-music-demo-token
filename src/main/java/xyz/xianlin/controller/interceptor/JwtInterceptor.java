package xyz.xianlin.controller.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import xyz.xianlin.controller.Code;
import xyz.xianlin.exception.BusinessException;
import xyz.xianlin.util.JwtUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;
@Component // 设置为Spring的组件
public class JwtInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //如果不是映射到方法直接通过
        if (!(handler instanceof HandlerMethod)) {
            return true;
        }
        
        //从 http 请求头中取出 token
        String token = request.getHeader("Authorization");
//        System.out.println("此处测试是否拿到了token：" + token);
        
        if (token == null) {
//            throw new RuntimeException("无 token ，请重新登陆");
            throw new BusinessException(Code.BUSINESS_ERR ,"无 token ，请重新登陆");
        }
        if (JwtUtil.checkSign(token)) {
            return true;
        }else {
            throw new BusinessException(Code.BUSINESS_ERR ,"token 验证失败");
        }
//        return true;
    }
}


