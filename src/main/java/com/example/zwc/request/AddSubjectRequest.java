package com.example.zwc.request;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * 要写注释呀
 */
@Data
public class AddSubjectRequest {


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
