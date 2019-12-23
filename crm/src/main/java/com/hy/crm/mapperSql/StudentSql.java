package com.hy.crm.mapperSql;

import com.github.pagehelper.util.StringUtil;
import com.hy.crm.entity.Business;

public class StudentSql {

    //查询我的商机动态sql
    public String MyBusAll(Business business, String id) {
        StringBuffer sql = new StringBuffer("select * from business where userid='"+id+"'");
        if (null != business) {
            if (null != business.getSyzt() && !"".equals(business.getSyzt())) {
                sql.append(" and b.Syzt like '%" + business.getSyzt() + "%'");
            } else if (null != business.getBname() && !"".equals(business.getBname())) {
                sql.append(" and b.bname like '%" + business.getBname() + "%'");
            } else if (null != business.getPredictsum() && !"".equals(business.getPredictsum())) {
                sql.append(" and b.predictsum like '%" + business.getPredictsum() + "%'");
            } else if (null != business.getFzr() && !"".equals(business.getFzr())) {
                sql.append(" and b.fzr like '%" + business.getFzr() + "%'");
            }/* else if (null != business.getBdeptid() && !"".equals(business.getBdeptid())) {
                sql.append(" and b.bdeptid like '%" + business.getBdeptid() + "%'");
            } else if (null != business.getBsettlementdate() && !"".equals(business.getBsettlementdate())) {
                sql.append(" and b.bsettlementdate like '%" + business.getBsettlementdate() + "%'");
            }*/
        }
        return sql.toString();

    }

    /*
     * 所有商机
     * */
    public String select(String bname, String syzt, Integer predictsum, String fzr, String sjssbm, String date) {
        StringBuffer sql = new StringBuffer("select * from business b left join data a on a.typeid = b.syzt where  1=1 ");
        if (bname != null && !"".equals(bname)) {
            sql.append(" and  bname like '%" + bname + "%'");
        }
        if (syzt != null && !"".equals(syzt)) {
            sql.append(" and syzt like '%" + syzt + "%'");
        }
        if (fzr != null && !"".equals(fzr)) {
            sql.append(" and fzr like '%" + fzr + "%'");
        }
        if (sjssbm != null && !"".equals(sjssbm)) {
            sql.append(" and sjssbm like '%" + sjssbm + "%'");
        }
        if (predictsum != null && !"".equals(predictsum)) {
            sql.append(" and predictsum ="+predictsum+" ");
        }
       /* if (!StringUtil.isEmpty(date)) {
            sql.append(" and date=#{date}");
        }*/
        return sql.toString();
    }

    public String query(String value, String type) {
        StringBuffer sql = new StringBuffer("select * from clien where 1=1 ");
       /* if (null != type && "uname".equals(type)){
            sql.append(" and uname like '%"+value+"%'");
        }
        if (null != type && "spell".equals(type)){
            sql.append(" and spell like '%"+value+"%'");
        }
        if (null != type && "khly".equals(type)){
            sql.append(" and khly like '%"+value+"%'");
        }*/
        if (null != value && type != null&&!"".equals(value)&&!"".equals(type)) {
            sql.append(" and " + type + " like '%" + value + "%'");
        }
        /*if (null != typeid) {
            sql.append(" and typeid like '%" + typeid + "%'");
        }*/
        System.out.println(sql.toString());
        return sql.toString();
    }
    public String querynoe( String typeid) {
        StringBuffer sql = new StringBuffer("select * from clien where 1=1 ");
        if (null != typeid) {
            sql.append(" and typeid like '%" + typeid + "%'");
        }
        System.out.println(sql.toString());
        return sql.toString();
    }
    /*public String update(Student student){
        StringBuffer sql = new StringBuffer("update student set");
        if(!StringUtil.isEmpty(student.getStuname())){
            sql.append(" stuname=#{stuname},");
        }
        if (!StringUtil.isEmpty(student.getSex())){
            sql.append(" sex=#{sex} ");
        }
        if(student.getSid() !=null && !"".equals(student.getSid())){
            sql.append(" where sid=#{sid}");
        }
        return sql.toString();
    }*/
}
