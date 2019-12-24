package com.hy.crm.mapper.sql;

import com.github.pagehelper.util.StringUtil;
import com.hy.crm.entity.Documentary;
import com.hy.crm.entity.User;

public class DocSql {
    /**
     * 这是查询所有跟单的 SQL语句
     * @param documentary
     * @return
     */
    public String SQLqueryAll(Documentary documentary,String kinds){
        StringBuffer sql = new StringBuffer("select * from documentary where 1= 1 ");
        /*if(!"-1".equals(kinds)){
            if(null !=documentary){
                if(StringUtil.isNotEmpty(documentary.getClassify())){
                    if(kinds.equals("date")){
                        sql.append(" and date = '"+documentary.getClassify()+"'");
                    }else if(kinds.equals("classify")){
                        sql.append(" and documentary_theme like '%"+documentary.getClassify()+"%'");
                    }

                }
            }
        }*/



        return sql.toString();
    }

    /**
     * 这是查询我的跟单的SQL
     * @param documentary
     * @param kinds
     * @return
     */
       public String queryMy(Documentary documentary, String kinds, User user){
        StringBuffer sql = new StringBuffer("select * from documentary where dpeople = '"+user.getUsername()+"' ");
        if(!"-1".equals(kinds)){
            if(null !=documentary){
                if(StringUtil.isNotEmpty(documentary.getClassify())){
                    if(kinds.equals("date")){
                        sql.append(" and date = '"+documentary.getClassify()+"'");
                    }else if(kinds.equals("classify")){
                        sql.append(" and classify like '%"+documentary.getClassify()+"%'");
                    }

                }
            }
        }
        return sql.toString();
    }
}
