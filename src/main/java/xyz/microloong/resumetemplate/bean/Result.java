package xyz.microloong.resumetemplate.bean;

import com.alibaba.fastjson.JSON;
import lombok.*;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class Result {

    private int status;

    private String msg;

    private Object data;

    public Result(int status, String msg) {
        this.status = status;
        this.msg = msg;
    }

    public String toJSON() {
        return JSON.toJSONString(this);
    }
}
