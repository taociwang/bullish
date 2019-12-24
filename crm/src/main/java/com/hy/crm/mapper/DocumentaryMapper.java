package com.hy.crm.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hy.crm.entity.Documentary;

/**
 * <p>
 * 跟单表 Mapper 接口
 * </p>
 *
 * @author wangsq
 * @since 2019-12-04
 */
public interface DocumentaryMapper extends BaseMapper<Documentary> {
   // @Select("select date,topic,dpeople,particular,accessory from documentary ")
   /* @SelectProvider(type = DocSql.class,method = "queryMy")
    public List<Documentary> queryMy(Documentary documentary, Page<Documentary> page, String kinds, User user);*/


}
