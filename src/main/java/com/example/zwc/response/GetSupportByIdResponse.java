package com.example.zwc.response;

import lombok.Data;

import javax.persistence.Column;
import java.util.Date;

/**
 * 要写注释呀
 */
@Data
public class GetSupportByIdResponse {
    private Long id;

    private String content;

    private String subject;

    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "update_time")
    private Date updateTime;
}
