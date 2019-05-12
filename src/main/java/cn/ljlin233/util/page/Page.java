package cn.ljlin233.util.page;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import lombok.Getter;
import lombok.Setter;

/**
 * Page 对分页的基本数据进行一个简单的封装
 */
@Setter
@Getter
public class Page<T> {

   private int pageNo = 1; // 页码，默认是第一页
   private int pageSize = 10; // 每页显示的记录数，默认是15
   private int totalNum;// 总记录数
   private List<T> results;// 对应的当前页记录
   private Map<String, Object> params = new HashMap<String, Object>();// 其他的参数我们把它分装成一个Map对象

   @Override
   public String toString() {
      return "Page [pageNo=" + pageNo + ", pageSize=" + pageSize + ", params=" + params + ", results=" + results
            + ", totalNum=" + totalNum + "]";
   }

}
