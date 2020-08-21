package com.ego.commons.pojo;

import lombok.*;

import java.util.List;

/**
 * 电商中的EasyUI数据表格统一返回结果类型
 */
@Data
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class EasyUIDatagrid {
    private long total;
    private List rows;
}
