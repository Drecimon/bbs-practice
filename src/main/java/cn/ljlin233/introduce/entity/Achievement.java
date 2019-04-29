package cn.ljlin233.introduce.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Achievement
 */
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Achievement {

    private Integer id;
    private String title;
    private String content;
    private Integer upUserId;
    private String upNickname;
    private String upDate;
    private Integer visitCount;

}