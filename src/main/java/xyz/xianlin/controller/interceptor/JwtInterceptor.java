package xyz.xianlin.controller.interceptor;

import lombok.extern.slf4j.Slf4j;
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
@Slf4j // 启用日志
public class JwtInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //如果不是映射到方法直接通过
        if (!(handler instanceof HandlerMethod)) {
            return true;
        }
        
        //从 http 请求头中取出 token
        String token = request.getHeader("Authorization");
        
        // 获取访问者端口
        int port = request.getRemotePort();
        // 获取访问者IP
        String ipAddress = request.getRemoteAddr();
        // 获取访问者访问的路径
        String path = request.getRequestURI();
        // 获取访问者访问的方式
        String method = request.getMethod();
        if (token == null) {
            log.info("未携带token，访问被拒，访问路径[{}] 访问方式[{}], IP：{}, 端口：{}", path, method, ipAddress, port);
            throw new BusinessException(Code.BUSINESS_ERR ,"无 token ，请重新登陆");
        }
        if (JwtUtil.checkSign(token)) {
            log.info("Token验证成功，访问路径[{}] 访问方式[{}], IP：{}, 端口：{}", path, method, ipAddress, port);
            return true;
        }else {
            log.info("Token验证失败，访问被拒，访问路径[{}] 访问方式[{}], IP：{}, 端口：{}", path, method, ipAddress, port);
            throw new BusinessException(Code.BUSINESS_ERR ,"token 验证失败");
        }
//        return true;
    }
}


