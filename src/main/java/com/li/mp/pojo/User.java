package com.li.mp.pojo;


import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * @ClassName User
 * @Description TODO
 * @Author LiYe
 * @Date 2024/3/26 10:41
 * @Version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @TableId(type = IdType.AUTO)
    private Long id;
    private String name;
    private Integer age;
    private String email;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    @TableField("isdeleted")
    @TableLogic
    private int deleted;
}
