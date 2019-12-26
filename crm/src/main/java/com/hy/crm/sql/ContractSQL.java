package com.hy.crm.sql;

import com.hy.crm.entity.Contract;

public class ContractSQL {

    public String queryAllContract(String type, Contract contract , String text,String state,String contract_date){
        StringBuffer sql = new StringBuffer("select * from contract  where 1=1 ");
        if(null!=type && !"-1".equals(type)){
            if(!"-1".equals(type)){
                if(type.equals("contract_name")){
                    sql.append(" and "+type+" like '%"+text+"%'");
                }else if(type.equals("contract_number")){
                    sql.append(" and "+type+" like '%"+text+"%'");
                }else if (type.equals("contract_money")){
                    sql.append(" and "+type+" like '%"+text+"%'");
                }else if(type.equals("contract_date")){
                    sql.append(" and "+type+" like '%"+text+"%'");
                }
            }
        }
        if(state != null && !state.equals("")){
            sql.append(" and state='"+state+"'");
        }else if(contract_date != null && !contract_date.equals("")){
            sql.append(" and contract_date='"+contract_date+"'");
        }
        return sql.toString();
    }

    public String queryAllContract1(String type, Contract contract , String text,String contract_date){
        StringBuffer sql = new StringBuffer("select * from contract  where 1=1 ");
        if(contract_date != null && !contract_date.equals("")){
            sql.append(" and "+contract_date);
        }
        return sql.toString();
    }
}
