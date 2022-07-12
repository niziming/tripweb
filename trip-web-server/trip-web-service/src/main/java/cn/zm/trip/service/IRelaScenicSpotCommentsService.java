package cn.zm.trip.service;

import cn.zm.trip.entity.RelaScenicSpotComments;
import cn.zm.trip.entity.dto.RelaScenicSpotCommentsDTO;
import cn.zm.trip.entity.vo.RelaScenicSpotCommentsVO;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

public interface IRelaScenicSpotCommentsService extends IService<RelaScenicSpotComments> {
    /**
    * 分页查询
    *
    * @param page   分页信息
    * @param RelaScenicSpotComments 关联景区评论关联表入参
    * @return 分页结果
    */
    IPage<RelaScenicSpotCommentsVO> selectByPage(IPage<RelaScenicSpotComments> page, RelaScenicSpotCommentsDTO RelaScenicSpotComments);
}
