package com.example.zwc.pojo;

import java.util.Date;
import javax.persistence.*;

@Table(name = "t_subject")
public class TSubject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 学校名称

     */
    @Column(name = "school_name")
    private String schoolName;

    /**
     * 学校内容

     */
    @Column(name = "school_content")
    private String schoolContent;

    /**
     * 课程名称

     */
    @Column(name = "subject_name")
    private String subjectName;

    /**
     * 课程内容

     */
    @Column(name = "subject_content")
    private String subjectContent;

    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "update_time")
    private Date updateTime;

    /**
     * @return id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取学校名称

     *
     * @return school_name - 学校名称

     */
    public String getSchoolName() {
        return schoolName;
    }

    /**
     * 设置学校名称

     *
     * @param schoolName 学校名称

     */
    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName == null ? null : schoolName.trim();
    }

    /**
     * 获取学校内容

     *
     * @return school_content - 学校内容

     */
    public String getSchoolContent() {
        return schoolContent;
    }

    /**
     * 设置学校内容

     *
     * @param schoolContent 学校内容

     */
    public void setSchoolContent(String schoolContent) {
        this.schoolContent = schoolContent == null ? null : schoolContent.trim();
    }

    /**
     * 获取课程名称

     *
     * @return subject_name - 课程名称

     */
    public String getSubjectName() {
        return subjectName;
    }

    /**
     * 设置课程名称

     *
     * @param subjectName 课程名称

     */
    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName == null ? null : subjectName.trim();
    }

    /**
     * 获取课程内容

     *
     * @return subject_content - 课程内容

     */
    public String getSubjectContent() {
        return subjectContent;
    }

    /**
     * 设置课程内容

     *
     * @param subjectContent 课程内容

     */
    public void setSubjectContent(String subjectContent) {
        this.subjectContent = subjectContent == null ? null : subjectContent.trim();
    }

    /**
     * @return create_time
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * @param createTime
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * @return update_time
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * @param updateTime
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}