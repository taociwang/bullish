package com.hy.crm.entity;

import java.io.Serializable;

/**
 * <p>
 * 商机表
 * </p>
 *
 * @author wangsq
 * @since 2019-12-04
 */
public class Business implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer bid;

    /**
     * 商业名
     */
    private String bname;

    /**
     * 客户名字
     */
    private String kname;

    /**
     * 所属行业
     */
    private String bsshy;

    /**
     * 省
     */
    private String psheng;

    /**
     * 市
     */
    private String pshi;

    /**
     * 区
     */
    private String pqu;

    /**
     * 地址
     */
    private String bsite;

    /**
     * 预计金额
     */
    private Integer predictsum;

    /**
     * lxr
     */
    private String blxr;

    /**
     * 参与人
     */
    private String cyr;

    /**
     * 负责人
     */
    private String fzr;

    /**
     * 关注人
     */
    private String gzr;

    /**
     * 业务需求
     */
    private String ywxq;

    /**
     * 商业状态
     */
    private String syzt;

    /**
     * 相关附件
     */
    private String xgfj;

    /**
     * 商机所属部门
     */
    private String sjssbm;

    public Integer getBid() {
        return bid;
    }

    public void setBid(Integer bid) {
        this.bid = bid;
    }
    public String getBname() {
        return bname;
    }

    public void setBname(String bname) {
        this.bname = bname;
    }
    public String getKname() {
        return kname;
    }

    public void setKname(String kname) {
        this.kname = kname;
    }
    public String getBsshy() {
        return bsshy;
    }

    public void setBsshy(String bsshy) {
        this.bsshy = bsshy;
    }
    public String getPsheng() {
        return psheng;
    }

    public void setPsheng(String psheng) {
        this.psheng = psheng;
    }
    public String getPshi() {
        return pshi;
    }

    public void setPshi(String pshi) {
        this.pshi = pshi;
    }
    public String getPqu() {
        return pqu;
    }

    public void setPqu(String pqu) {
        this.pqu = pqu;
    }
    public String getBsite() {
        return bsite;
    }

    public void setBsite(String bsite) {
        this.bsite = bsite;
    }
    public Integer getPredictsum() {
        return predictsum;
    }

    public void setPredictsum(Integer predictsum) {
        this.predictsum = predictsum;
    }
    public String getBlxr() {
        return blxr;
    }

    public void setBlxr(String blxr) {
        this.blxr = blxr;
    }
    public String getCyr() {
        return cyr;
    }

    public void setCyr(String cyr) {
        this.cyr = cyr;
    }
    public String getFzr() {
        return fzr;
    }

    public void setFzr(String fzr) {
        this.fzr = fzr;
    }
    public String getGzr() {
        return gzr;
    }

    public void setGzr(String gzr) {
        this.gzr = gzr;
    }
    public String getYwxq() {
        return ywxq;
    }

    public void setYwxq(String ywxq) {
        this.ywxq = ywxq;
    }
    public String getSyzt() {
        return syzt;
    }

    public void setSyzt(String syzt) {
        this.syzt = syzt;
    }
    public String getXgfj() {
        return xgfj;
    }

    public void setXgfj(String xgfj) {
        this.xgfj = xgfj;
    }
    public String getSjssbm() {
        return sjssbm;
    }

    public void setSjssbm(String sjssbm) {
        this.sjssbm = sjssbm;
    }

    @Override
    public String toString() {
        return "Business{" +
        "bid=" + bid +
        ", bname=" + bname +
        ", kname=" + kname +
        ", bsshy=" + bsshy +
        ", psheng=" + psheng +
        ", pshi=" + pshi +
        ", pqu=" + pqu +
        ", bsite=" + bsite +
        ", predictsum=" + predictsum +
        ", blxr=" + blxr +
        ", cyr=" + cyr +
        ", fzr=" + fzr +
        ", gzr=" + gzr +
        ", ywxq=" + ywxq +
        ", syzt=" + syzt +
        ", xgfj=" + xgfj +
        ", sjssbm=" + sjssbm +
        "}";
    }
}
