package com.hy.crm.service.impl;

import com.hy.crm.entity.Data;
import com.hy.crm.mapper.DataMapper;
import com.hy.crm.service.IDataService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 基本数据管理表 服务实现类
 * </p>
 *
 * @author wangsq
 * @since 2019-12-04
 */
@Service
public class DataServiceImpl extends ServiceImpl<DataMapper, Data> implements IDataService {

}
