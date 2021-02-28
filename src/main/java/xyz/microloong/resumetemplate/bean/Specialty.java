package xyz.microloong.resumetemplate.bean;

import lombok.*;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class Specialty {

    private int id;

    private int userId;

    private String name;

    private String description;

    private Specialty next;

    public Specialty(int userId, String name, String description) {
        this.userId = userId;
        this.name = name;
        this.description = description;
    }
}
