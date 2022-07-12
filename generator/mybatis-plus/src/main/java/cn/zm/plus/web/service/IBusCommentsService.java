package cn.zm.plus.web.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import cn.zm.plus.web.entity.BusComments;
import com.baomidou.mybatisplus.extension.service.IService;
import cn.zm.plus.web.entity.dto.BusCommentsDTO;
import cn.zm.plus.web.entity.vo.BusCommentsVO;

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
