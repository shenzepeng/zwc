package com.example.zwc.pojo;

import java.util.Date;
import javax.persistence.*;

@Table(name = "t_menlei")
public class TMenLei {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * ѧ������
     */
    private String xuekemenlei;

    /**
     * רҵ��
     */
    private String zhuanyelei;

    /**
     * רҵ����
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
     * ��ȡѧ������
     *
     * @return xuekemenlei - ѧ������
     */
    public String getXuekemenlei() {
        return xuekemenlei;
    }

    /**
     * ����ѧ������
     *
     * @param xuekemenlei ѧ������
     */
    public void setXuekemenlei(String xuekemenlei) {
        this.xuekemenlei = xuekemenlei == null ? null : xuekemenlei.trim();
    }

    /**
     * ��ȡרҵ��
     *
     * @return zhuanyelei - רҵ��
     */
    public String getZhuanyelei() {
        return zhuanyelei;
    }

    /**
     * ����רҵ��
     *
     * @param zhuanyelei רҵ��
     */
    public void setZhuanyelei(String zhuanyelei) {
        this.zhuanyelei = zhuanyelei == null ? null : zhuanyelei.trim();
    }

    /**
     * ��ȡרҵ����
     *
     * @return zhuanyemingcheng - רҵ����
     */
    public String getZhuanyemingcheng() {
        return zhuanyemingcheng;
    }

    /**
     * ����רҵ����
     *
     * @param zhuanyemingcheng רҵ����
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