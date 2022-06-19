package xyz.xianlin;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
// 启用日志
@Slf4j
public class XianLinTokenDemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(XianLinTokenDemoApplication.class, args);
        log.info("===========================");
        log.info("SpringBoot项目启动成功");
        log.info("===========================");
    }
}
