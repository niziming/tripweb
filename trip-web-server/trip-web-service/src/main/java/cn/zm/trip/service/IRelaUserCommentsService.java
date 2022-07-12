package cn.zm.trip.service;

import cn.zm.trip.entity.RelaUserComments;
import cn.zm.trip.entity.dto.RelaUserCommentsDTO;
import cn.zm.trip.entity.vo.RelaUserCommentsVO;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

public interface IRelaUserCommentsService extends IService<RelaUserComments> {
    /**
    * 分页查询
    *
    * @param page   分页信息
    * @param RelaUserComments 关联用户评论表入参
    * @return 分页结果
    */
    IPage<RelaUserCommentsVO> selectByPage(IPage<RelaUserComments> page, RelaUserCommentsDTO RelaUserComments);
}
