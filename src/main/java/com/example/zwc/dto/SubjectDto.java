package com.example.zwc.dto;

import lombok.Data;

import javax.persistence.Column;

/**
 * 要写注释呀
 */
@Data
public class SubjectDto {
    private Long id;

    /**
     * 学校名称

     */

    private String schoolName;

    /**
     * 学校内容

     */

    private String schoolContent;

    /**
     * 课程名称

     */

    private String subjectName;

    /**
     * 课程内容

     */

    private String subjectContent;
}
