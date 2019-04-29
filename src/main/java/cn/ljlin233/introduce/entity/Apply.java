package cn.ljlin233.introduce.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Apply
 */
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Apply {

    private Integer id;
    private Integer userId;
    private Integer departmentId;
    private String applyStatus;
    
}