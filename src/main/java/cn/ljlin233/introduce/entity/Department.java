package cn.ljlin233.introduce.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Department
 */
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Department {

    private Integer id;
    private String name;
    private String description;
}