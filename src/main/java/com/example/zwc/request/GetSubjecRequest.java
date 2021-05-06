package com.example.zwc.request;

import lombok.Data;

import javax.persistence.Column;

/**
 * 要写注释呀
 */
@Data
public class GetSubjecRequest {

    /**
     * 学校名称

     */
    private String schoolName;
    /**
     * 课程名称

     */
    private String subjectName;


}
