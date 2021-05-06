package com.example.zwc.dto;

import lombok.Data;

import javax.persistence.Column;
import java.util.Date;

/**
 * 要写注释呀
 */
@Data
public class SupportDto {
    private Long id;

    private String content;

    private String subejct;


    private Date createTime;


    private Date updateTime;
}
