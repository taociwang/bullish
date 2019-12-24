package com.hy.crm.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hy.crm.entity.Data;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 基本数据管理表 Mapper 接口
 * </p>
 *
 * @author wangsq
 * @since 2019-12-04
 */
@Mapper
public interface DataMapper extends BaseMapper<Data> {


}
