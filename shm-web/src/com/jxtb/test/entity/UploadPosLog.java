package com.jxtb.test.entity;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 17-8-4
 * Time: 下午1:57
 *  用户上传持仓日志表
 *  表 ： KM_UPLOAD_POS_LOG
 */
public class UploadPosLog {
    private String l_id; //guid
    private String upload_group;     //上传群组ID(保险公司：葡保 MIG 鼎睿 复保 永安【SELECT * FROM SYSROLE WHERE ROLETYPE = '402881ea0b8bf8e3010b8bfd2885000b' AND ISDELETE = 0】)
    private Date version_date;    //版本日期
    private String author;    //上传人
    private String dt_status; //0:正常 1:删除
    private Date ent_time;//上传时间
    private Date upd_time;//更新时间

    private String group1;//资产类别

    public String getL_id() {
        return l_id;
    }

    public void setL_id(String l_id) {
        this.l_id = l_id;
    }

    public String getUpload_group() {
        return upload_group;
    }

    public void setUpload_group(String upload_group) {
        this.upload_group = upload_group;
    }

    public Date getVersion_date() {
        return version_date;
    }

    public void setVersion_date(Date version_date) {
        this.version_date = version_date;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDt_status() {
        return dt_status;
    }

    public void setDt_status(String dt_status) {
        this.dt_status = dt_status;
    }

    public Date getEnt_time() {
        return ent_time;
    }

    public void setEnt_time(Date ent_time) {
        this.ent_time = ent_time;
    }

    public Date getUpd_time() {
        return upd_time;
    }

    public void setUpd_time(Date upd_time) {
        this.upd_time = upd_time;
    }

    public String getGroup1() {
        return group1;
    }

    public void setGroup1(String group1) {
        this.group1 = group1;
    }
}
