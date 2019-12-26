package com.hy.crm.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hy.crm.entity.Reply;
import com.hy.crm.mapper.ForumMapper;
import com.hy.crm.mapper.ReplyMapper;
import com.hy.crm.service.IReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * <p>
 * 帖子回复表 服务实现类
 * </p>
 *
 * @author wangsq
 * @since 2019-12-04
 */
@Service
public class ReplyServiceImpl extends ServiceImpl<ReplyMapper, Reply> implements IReplyService {
    @Autowired
    private ReplyMapper replyMapper;
    @Autowired
    private ForumMapper forumMapper;

    /**
     * 添加回复修改回复数量和最后回复时间
     * @param reply
     */
    public void addreply(Reply reply){
        Date date = new Date();
       reply.setReply_time(date);
       //拿到登陆姓名
        reply.setReply_name("张三");
        replyMapper.insert(reply);
        forumMapper.reply(reply.getFid());
    }
}
