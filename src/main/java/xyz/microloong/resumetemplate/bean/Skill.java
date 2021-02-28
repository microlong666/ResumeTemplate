package xyz.microloong.resumetemplate.bean;

import lombok.*;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class Skill {

    private int id;

    private int userId;

    private String keyWords;

    public Skill(int userId, String keywords) {
        this.userId = userId;
        this.keyWords = keywords;
    }
}
