package com.hy.crm.sql;

import com.hy.crm.entity.Forum;

public class CustomerSQL {

    public String queryAllCust(String kinds, Forum forum , String text){
        StringBuffer sql = new StringBuffer("select * from forum  where 1=1 ");
        System.out.println(kinds+"------------------");
        System.out.println(text+"------------------");
        if(null!=kinds && !"-1".equals(kinds)){
            if(!"-1".equals(kinds)){
                if(kinds.equals("theme")){
                    sql.append(" and "+kinds+" like '%"+text+"%'");
                }else if(kinds.equals("theme_author")){
                    sql.append(" and "+kinds+" like '%"+text+"%'");
                }else if (kinds.equals("label")){
                    sql.append(" and "+kinds+" like '%"+text+"%'");
                }else if(kinds.equals("click")){
                    sql.append(" and "+kinds+" like '%"+text+"%'");
                }else if(kinds.equals("reply_time")){
                    sql.append(" and "+kinds+" like '%"+text+"%'");
                }
            }
        }

        return sql.toString();
    }
}
