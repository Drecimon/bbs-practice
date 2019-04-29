package cn.ljlin233.introduce.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Member
 */
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Member {

    private Integer id;
    private Integer memberId;
    private String memberType;
    private String memberName;
    private Integer departmentId;
    
}