package com.haoxuer.adminstore.structure.data.so;

import java.io.Serializable;
import com.haoxuer.discover.data.page.Filter;
import com.haoxuer.discover.data.page.Search;
import lombok.Data;

/**
* Created by imake on 2020年07月27日09:16:50.
*/
@Data
public class EmployeeSo implements Serializable {

    //姓名
     @Search(name = "name",operator = Filter.Operator.like)
     private String name;

    //电话
     @Search(name = "phone",operator = Filter.Operator.like)
     private String phone;



    private String sortField;

    private String sortMethod;

}
