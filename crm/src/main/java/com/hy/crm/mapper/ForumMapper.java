package com.hy.crm.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hy.crm.entity.Forum;
import com.hy.crm.entity.Reply;
import com.hy.crm.sql.CustomerSQL;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * <p>
 * 论坛表 Mapper 接口
 * </p>
 *
 * @author wangsq
 * @since 2019-12-04
 */
@Mapper
public interface ForumMapper extends BaseMapper<Forum> {

    /*模糊查询论坛*/
    @SelectProvider(type = CustomerSQL.class,method = "queryAllCust")
    List<Forum> queryAllCust(String kinds, Forum forum ,String text);

    @Results({
            @Result(column = "emp_id",property = "emp_id")
    })
    @Select("select * from forum where fid=#{value}")
    public Forum theid(Integer fid);

    @Results({
            @Result(column = "emp_id",property = "emp_id"),
            @Result(column = "post_time",property = "post_time")
    })
    @Select("select * from reply where fid=#{value}")
    public List<Reply> theid1(Integer fid);

    /**
     * 修改点击量+1
     * @param fid
     */
    @Update("update forum set click=click+1 where fid=#{fid}")
    public void click(Integer fid);

    /**
     * 修改回复量+1 ,最后回复时间
     * @param fid
     */
    @Update("update forum set reply=reply+1,reply_time=now() where fid=#{fid}")
    public void reply(String fid);

}
