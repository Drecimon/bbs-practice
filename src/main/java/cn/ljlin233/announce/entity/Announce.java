package cn.ljlin233.announce.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Announce
 */
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Announce {

    private Integer id;
    private String title;
    private String content;
    private Integer upUserId;
    private String upUserNickname;
    private String upDate;
    private Integer visitCount;
    private String savePath;

}