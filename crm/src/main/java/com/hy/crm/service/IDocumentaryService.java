package com.hy.crm.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hy.crm.entity.Documentary;
import com.hy.crm.entity.LayUI;
import com.hy.crm.entity.User;

/**
 * <p>
 * 跟单表 服务类
 * </p>
 *
 * @author wangsq
 * @since 2019-12-04
 */
public interface IDocumentaryService extends IService<Documentary> {
    public LayUI queryAll(Integer pageNum, Integer size, Documentary documentary, String kinds);
   // public void addDoc(Documentary documentary);
    public LayUI queryMy(Integer pageNum, Integer size,Documentary documentary,String kinds, User user);
}
