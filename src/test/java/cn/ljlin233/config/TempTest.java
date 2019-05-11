package cn.ljlin233.config;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.jdbc.SQL;

/**
 * TempTest
 */
public class TempTest {


    public String selectSQL(List<Integer> departmentIds) {

        return new SQL() {{

            SELECT("intro_apply");
            WHERE("department_id = #{departmentIds}");
            
        }}.toString();
    }

    
    public static void main(String[] args) {
        
        List<Integer> arrays = new ArrayList<>();
        arrays.add(1);
        arrays.add(2);
        arrays.add(3);

        TempTest t = new TempTest();
        String result = t.selectSQL(arrays);

        System.out.println(result);
    }



}