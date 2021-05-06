package com.example.zwc.pojo;

import lombok.Data;

import java.util.Date;
import javax.persistence.*;
@Data
@Table(name = "t_subject_support")
public class TSubjectSupport {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String content;

    private String subejct;

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
     * @return content
     */
    public String getContent() {
        return content;
    }

    /**
     * @param content
     */
    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    /**
     * @return subejct
     */
    public String getSubejct() {
        return subejct;
    }

    /**
     * @param subejct
     */
    public void setSubejct(String subejct) {
        this.subejct = subejct == null ? null : subejct.trim();
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