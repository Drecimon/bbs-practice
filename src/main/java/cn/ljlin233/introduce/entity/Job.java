package cn.ljlin233.introduce.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Job
 */
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Job {

    public Integer id;
    public String title;
    public String content;
    public Integer upUserId;
    public String upNickname;
    public String upDate;
    public Integer visitCount;
    
}