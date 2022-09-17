package xyz.xianlin.util;

import com.sun.xml.internal.messaging.saaj.packaging.mime.MessagingException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.mail.internet.MimeMessage;
@Slf4j // 启用日志
@Component
public class MailClient {
    
    @Autowired
    private JavaMailSender mailSender;
    
    // 发件人
    @Value("${spring.mail.username}")
    private String from;
    
    // to:收件人  subject:邮件标题  content:邮件内容
    public void sendMail(String to,String subject,String content) {
        try {
            MimeMessage message = mailSender.createMimeMessage();
            // 构建 MimeMessage 的内容
            MimeMessageHelper helper = new MimeMessageHelper(message);
            helper.setFrom(from);
            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(content, true); // true表示支持html文本
            mailSender.send(helper.getMimeMessage());
        } catch (Exception e) {
            log.error("发送邮件失败：" + e.getMessage());
        }
    }
}

