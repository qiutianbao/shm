package com.jxtb.test.entity;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 17-8-4
 * Time: 下午2:00
 *  *  股票上传持仓信息
 *  表 ： KM_UPLOAD_STOCK_POS
 */
public class UploadStockPos {
    private String l_id; //guid
    private String upload_group;   //上传群组ID(保险公司：葡保 MIG 鼎睿 复保 永安【SELECT * FROM SYSROLE WHERE ROLETYPE = '402881ea0b8bf8e3010b8bfd2885000b' AND ISDELETE = 0】)
    private String bond_code;   //债券代码
    private String bond_name;   //债券名称
    private String code_type;   //代码类型:ISIN,TICKER,BLBGID,CUISP,CINS,FIGI,SEDO
    private String code_orig;   //未转换代码
    private String d_line;   //截止日期
    private Integer sum_count;  //持股总数
    private Integer total_value;  //总市值
    private Integer last_price;   //收盘价
    private String cur_type;   //币种
    private String ent_time;//记录进表时间
    private String upd_time;//记录修改时间
    private String upload_log_id;   //外键关联KM_UPLOAD_POS_LOG的L_ID ,对应UploadPosLog实体类

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

    public String getBond_code() {
        return bond_code;
    }

    public void setBond_code(String bond_code) {
        this.bond_code = bond_code;
    }

    public String getBond_name() {
        return bond_name;
    }

    public void setBond_name(String bond_name) {
        this.bond_name = bond_name;
    }

    public String getCode_type() {
        return code_type;
    }

    public void setCode_type(String code_type) {
        this.code_type = code_type;
    }

    public String getCode_orig() {
        return code_orig;
    }

    public void setCode_orig(String code_orig) {
        this.code_orig = code_orig;
    }

    public String getD_line() {
        return d_line;
    }

    public void setD_line(String d_line) {
        this.d_line = d_line;
    }

    public Integer getSum_count() {
        return sum_count;
    }

    public void setSum_count(Integer sum_count) {
        this.sum_count = sum_count;
    }

    public Integer getTotal_value() {
        return total_value;
    }

    public void setTotal_value(Integer total_value) {
        this.total_value = total_value;
    }

    public Integer getLast_price() {
        return last_price;
    }

    public void setLast_price(Integer last_price) {
        this.last_price = last_price;
    }

    public String getCur_type() {
        return cur_type;
    }

    public void setCur_type(String cur_type) {
        this.cur_type = cur_type;
    }

    public String getEnt_time() {
        return ent_time;
    }

    public void setEnt_time(String ent_time) {
        this.ent_time = ent_time;
    }

    public String getUpd_time() {
        return upd_time;
    }

    public void setUpd_time(String upd_time) {
        this.upd_time = upd_time;
    }

    public String getUpload_log_id() {
        return upload_log_id;
    }

    public void setUpload_log_id(String upload_log_id) {
        this.upload_log_id = upload_log_id;
    }

}