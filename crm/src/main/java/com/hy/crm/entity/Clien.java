package com.hy.crm.entity;

import java.io.Serializable;

/**
 * <p>
 * 客户表
 * </p>
 *
 * @author wangsq
 * @since 2019-12-04
 */
public class Clien implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer cid;

    /**
     * 客户名
     */
    private String uname;

    /**
     * 联系人
     */
    private String lxr;

    /**
     * 部门
     */
    private String bm;

    /**
     * 电话
     */
    private Integer phone;

    /**
     * 所属行业
     */
    private String sshy;

    /**
     * 省
     */
    private String sheng;

    /**
     * 市
     */
    private String shi;

    /**
     * 区
     */
    private String qu;

    /**
     * 地址
     */
    private String site;

    /**
     * 邮箱
     */
    private String mailbox;

    /**
     * 邮政编码
     */
    private String yzbm;

    /**
     * 注册资本
     */
    private Integer zczb;

    /**
     * 法人代表
     */
    private String frdb;

    /**
     * 部门
     */
    private String part;

    /**
     * 办公电话
     */
    private Integer bgdh;

    private String cz;

    /**
     * 附加说明
     */
    private String shuoming;

    /**
     * 银行账户
     */
    private Integer yhzh;

    /**
     * 开户名称
     */
    private String khmc;

    /**
     * 开户银行
     */
    private String khyh;

    /**
     * 用户地址
     */
    private String yhdz;

    /**
     * 税号
     */
    private Integer shuihao;

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }
    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }
    public String getLxr() {
        return lxr;
    }

    public void setLxr(String lxr) {
        this.lxr = lxr;
    }
    public String getBm() {
        return bm;
    }

    public void setBm(String bm) {
        this.bm = bm;
    }
    public Integer getPhone() {
        return phone;
    }

    public void setPhone(Integer phone) {
        this.phone = phone;
    }
    public String getSshy() {
        return sshy;
    }

    public void setSshy(String sshy) {
        this.sshy = sshy;
    }
    public String getSheng() {
        return sheng;
    }

    public void setSheng(String sheng) {
        this.sheng = sheng;
    }
    public String getShi() {
        return shi;
    }

    public void setShi(String shi) {
        this.shi = shi;
    }
    public String getQu() {
        return qu;
    }

    public void setQu(String qu) {
        this.qu = qu;
    }
    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }
    public String getMailbox() {
        return mailbox;
    }

    public void setMailbox(String mailbox) {
        this.mailbox = mailbox;
    }
    public String getYzbm() {
        return yzbm;
    }

    public void setYzbm(String yzbm) {
        this.yzbm = yzbm;
    }
    public Integer getZczb() {
        return zczb;
    }

    public void setZczb(Integer zczb) {
        this.zczb = zczb;
    }
    public String getFrdb() {
        return frdb;
    }

    public void setFrdb(String frdb) {
        this.frdb = frdb;
    }
    public String getPart() {
        return part;
    }

    public void setPart(String part) {
        this.part = part;
    }
    public Integer getBgdh() {
        return bgdh;
    }

    public void setBgdh(Integer bgdh) {
        this.bgdh = bgdh;
    }
    public String getCz() {
        return cz;
    }

    public void setCz(String cz) {
        this.cz = cz;
    }
    public String getShuoming() {
        return shuoming;
    }

    public void setShuoming(String shuoming) {
        this.shuoming = shuoming;
    }
    public Integer getYhzh() {
        return yhzh;
    }

    public void setYhzh(Integer yhzh) {
        this.yhzh = yhzh;
    }
    public String getKhmc() {
        return khmc;
    }

    public void setKhmc(String khmc) {
        this.khmc = khmc;
    }
    public String getKhyh() {
        return khyh;
    }

    public void setKhyh(String khyh) {
        this.khyh = khyh;
    }
    public String getYhdz() {
        return yhdz;
    }

    public void setYhdz(String yhdz) {
        this.yhdz = yhdz;
    }
    public Integer getShuihao() {
        return shuihao;
    }

    public void setShuihao(Integer shuihao) {
        this.shuihao = shuihao;
    }

    @Override
    public String toString() {
        return "Clien{" +
        "cid=" + cid +
        ", uname=" + uname +
        ", lxr=" + lxr +
        ", bm=" + bm +
        ", phone=" + phone +
        ", sshy=" + sshy +
        ", sheng=" + sheng +
        ", shi=" + shi +
        ", qu=" + qu +
        ", site=" + site +
        ", mailbox=" + mailbox +
        ", yzbm=" + yzbm +
        ", zczb=" + zczb +
        ", frdb=" + frdb +
        ", part=" + part +
        ", bgdh=" + bgdh +
        ", cz=" + cz +
        ", shuoming=" + shuoming +
        ", yhzh=" + yhzh +
        ", khmc=" + khmc +
        ", khyh=" + khyh +
        ", yhdz=" + yhdz +
        ", shuihao=" + shuihao +
        "}";
    }
}
