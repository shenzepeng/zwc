package com.example.zwc.pojo;

import java.util.Date;
import javax.persistence.*;

@Table(name = "t_use")
public class TUse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "can_use")
    private String canUse;

    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "uptdate_time")
    private Date uptdateTime;

    private String app;

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
     * @return can_use
     */
    public String getCanUse() {
        return canUse;
    }

    /**
     * @param canUse
     */
    public void setCanUse(String canUse) {
        this.canUse = canUse == null ? null : canUse.trim();
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
     * @return uptdate_time
     */
    public Date getUptdateTime() {
        return uptdateTime;
    }

    /**
     * @param uptdateTime
     */
    public void setUptdateTime(Date uptdateTime) {
        this.uptdateTime = uptdateTime;
    }

    /**
     * @return app
     */
    public String getApp() {
        return app;
    }

    /**
     * @param app
     */
    public void setApp(String app) {
        this.app = app == null ? null : app.trim();
    }
}