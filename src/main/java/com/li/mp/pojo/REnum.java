package com.li.mp.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

/**
 * @ClassName REnum
 * @Description TODO
 * @Author LiYe
 * @Date 2024/6/27 16:49
 * @Version 1.0
 */
@AllArgsConstructor
@Getter
public enum REnum {
    SUCCESS(200,"SUCCESS"),
    FAIL(500,"ERROR");


    private final Integer code;
    private final String desc;


}
