package com.example.zwc.pojo;

import java.util.Date;
import javax.persistence.*;

@Table(name = "t_menlei")
public class TMenLei {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 学科门类
     */
    private String xuekemenlei;

    /**
     * 专业类
     */
    private String zhuanyelei;

    /**
     * 专业名称
     */
    private String zhuanyemingcheng;

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
     * 获取学科门类
     *
     * @return xuekemenlei - 学科门类
     */
    public String getXuekemenlei() {
        return xuekemenlei;
    }

    /**
     * 设置学科门类
     *
     * @param xuekemenlei 学科门类
     */
    public void setXuekemenlei(String xuekemenlei) {
        this.xuekemenlei = xuekemenlei == null ? null : xuekemenlei.trim();
    }

    /**
     * 获取专业类
     *
     * @return zhuanyelei - 专业类
     */
    public String getZhuanyelei() {
        return zhuanyelei;
    }

    /**
     * 设置专业类
     *
     * @param zhuanyelei 专业类
     */
    public void setZhuanyelei(String zhuanyelei) {
        this.zhuanyelei = zhuanyelei == null ? null : zhuanyelei.trim();
    }

    /**
     * 获取专业名称
     *
     * @return zhuanyemingcheng - 专业名称
     */
    public String getZhuanyemingcheng() {
        return zhuanyemingcheng;
    }

    /**
     * 设置专业名称
     *
     * @param zhuanyemingcheng 专业名称
     */
    public void setZhuanyemingcheng(String zhuanyemingcheng) {
        this.zhuanyemingcheng = zhuanyemingcheng == null ? null : zhuanyemingcheng.trim();
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