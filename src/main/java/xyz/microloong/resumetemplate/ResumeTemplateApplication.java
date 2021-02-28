package xyz.microloong.resumetemplate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan("xyz.microloong.resumetemplate.servlet")
public class ResumeTemplateApplication {

    public static void main(String[] args) {
        SpringApplication.run(ResumeTemplateApplication.class, args);
    }

}
