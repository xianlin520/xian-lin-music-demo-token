package xyz.xianlin;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import xyz.xianlin.util.MailClient;

@SpringBootTest
public class MailTests {
    
    @Autowired
    private MailClient mailClient;
    
    @Test
    public void testTextMail() {
        mailClient.sendMail("2683971783@qq.com","测试邮件","Welcome!!!");
    }
}

