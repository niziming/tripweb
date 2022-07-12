package cn.zm.trip.service;

import cn.zm.trip.entity.BusComments;
import cn.zm.trip.entity.dto.BusCommentsDTO;
import cn.zm.trip.entity.vo.BusCommentsVO;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

public interface IBusCommentsService extends IService<BusComments> {
    /**
    * 分页查询
    *
    * @param page   分页信息
    * @param BusComments 业务评论表入参
    * @return 分页结果
    */
    IPage<BusCommentsVO> selectByPage(IPage<BusComments> page, BusCommentsDTO BusComments);
}
