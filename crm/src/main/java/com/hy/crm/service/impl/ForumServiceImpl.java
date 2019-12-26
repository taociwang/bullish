package com.hy.crm.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hy.crm.entity.Forum;
import com.hy.crm.entity.Reply;
import com.hy.crm.mapper.ForumMapper;
import com.hy.crm.service.IForumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 论坛表 服务实现类
 * </p>
 *
 * @author wangsq
 * @since 2019-12-04
 */
@Service
public class ForumServiceImpl extends ServiceImpl<ForumMapper, Forum> implements IForumService {

    @Autowired
    private ForumMapper forumMapper;


    /*模糊查询论坛*/
    public List<Forum> queryAllCust(Forum forum, String kinds, String text){
        return forumMapper.queryAllCust(kinds,forum,text);
    }

    public Forum theid(Integer fid){
        return forumMapper.theid(fid);
    }

    /**
     * 发帖子
     */
    public List<Reply> theid1(Integer fid){
        return forumMapper.theid1(fid);
    }

    /**
     * 修改点击量
     */
    public void click(Integer fid){
        forumMapper.click(fid);
    }

    /**
     * 修改回复量
     */
    public void reply(String fid){
        forumMapper.reply(fid);
    }
}
