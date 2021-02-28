package xyz.microloong.resumetemplate.bean;

import lombok.*;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class Work {

    private int id;

    private int userId;

    private String start;

    private String end;

    private String company;

    private String job;

    private String description;

    private Work next;

    public Work(int userId, String start, String end, String company, String job, String description) {
        this.userId = userId;
        this.start = start;
        this.end = end;
        this.company = company;
        this.job = job;
        this.description = description;
    }
}
