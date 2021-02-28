package xyz.microloong.resumetemplate.bean;

import lombok.*;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class Edu {

    private int id;

    private int userId;

    private String start;

    private String end;

    private String school;

    private String study;

    private String description;

    private Edu next;

    public Edu(int userId, String start, String end, String school, String study, String description) {
        this.userId = userId;
        this.start = start;
        this.end = end;
        this.school = school;
        this.study = study;
        this.description = description;
    }
}
