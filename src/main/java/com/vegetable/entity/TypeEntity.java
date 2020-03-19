package com.vegetable.entity;

import java.io.Serializable;
import lombok.Data;

@Data
public class TypeEntity implements Serializable {
    /**
     * 一级类别编号
     */
    private Integer tId;

    /**
     * 名称
     */
    private String tName;

    /**
     * 备注
     */
    private String remark;

    private static final long serialVersionUID = 1L;
}

