package cn.ljlin233.announce.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Scope
 */
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Scope {

    private Integer id;
    private Integer announceId;
    private Integer departmentId;
    
}