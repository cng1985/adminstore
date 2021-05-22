package com.nbsaas.adminstore.oa.data.entity;

import com.haoxuer.discover.data.annotations.ColType;
import com.haoxuer.discover.data.annotations.FormFieldAnnotation;
import com.haoxuer.discover.data.entity.AbstractEntity;
import com.haoxuer.discover.user.data.entity.UserEntity;
import com.nbsaas.codemake.annotation.*;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;


@PermissionClass
@CreateByUser
@Data
@FormAnnotation(title = "工作日志管理", model = "工作日志", menu = "1,57,58")
@Entity
@Table(name = "bs_oa_work_logger")
public class WorkLogger extends UserEntity {


    @SearchItem(label = "标题",name = "title")
    @FormField(title = "标题", sortNum = "2",width = "260",grid = true, col = 22,required = true)
    private String title;

    @FormField(title = "工作时间", sortNum = "2",width = "160",grid = true, col = 22,type = InputType.date)
    private Date recordDate;

    @FormField(title = "具体内容", sortNum = "2", col = 22,type = InputType.richText)
    private String note;
}
