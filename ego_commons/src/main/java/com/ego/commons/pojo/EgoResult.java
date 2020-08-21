package com.ego.commons.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * EGO电商平台中的，通用返回结果类型
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EgoResult {
    private int status;

    public static EgoResult ok(){
        return new EgoResult(200);
    }

    public static EgoResult error(){
        return new EgoResult(500);
    }
}