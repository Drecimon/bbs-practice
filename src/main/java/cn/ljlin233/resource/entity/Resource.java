package cn.ljlin233.resource.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Resource
 */
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Resource {

    private Integer id;
    private String title;
    private String content;
    private String category;
    private Integer upUserId;
    private String upNickname;
    private String upDate;
    private Integer visitCount;
    private Integer downloadCount;
    private String url;
    
}