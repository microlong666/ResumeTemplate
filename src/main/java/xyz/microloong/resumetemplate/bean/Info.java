package xyz.microloong.resumetemplate.bean;

import lombok.*;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class Info {

    private User user;

    private Edu edu;

    private Skill skill;

    private Work work;

    private Specialty specialty;

}
