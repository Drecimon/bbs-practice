package cn.ljlin233.introduce.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Award
 */
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Award {

    private Integer id;
    private String title;
    private String content;
    private Integer upUserId;
    private String nickname;
    private String datetime;
    private Integer visitCount;
    
}