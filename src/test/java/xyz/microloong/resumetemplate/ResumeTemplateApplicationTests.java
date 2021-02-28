package xyz.microloong.resumetemplate;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import xyz.microloong.resumetemplate.bean.User;
import xyz.microloong.resumetemplate.service.DbService;

@SpringBootTest
class ResumeTemplateApplicationTests {

    @Test
    public void userInsert() {
        User user = new User("1", 18, "1", "1", "1", "1", "1", "1", "1", "1", "1");
        DbService.insertUser(user);
    }

}
