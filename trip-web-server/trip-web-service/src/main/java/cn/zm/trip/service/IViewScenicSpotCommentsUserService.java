package cn.zm.trip.service;

import cn.zm.trip.entity.ViewScenicSpotCommentsUser;
import cn.zm.trip.entity.dto.ViewScenicSpotCommentsUserDTO;
import cn.zm.trip.entity.vo.ViewScenicSpotCommentsUserVO;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

public interface IViewScenicSpotCommentsUserService extends IService<ViewScenicSpotCommentsUser> {
    /**
    * 分页查询
    *
    * @param page   分页信息
    * @param ViewScenicSpotCommentsUser VIEW入参
    * @return 分页结果
    */
    IPage<ViewScenicSpotCommentsUserVO> selectByPage(IPage<ViewScenicSpotCommentsUser> page, ViewScenicSpotCommentsUserDTO ViewScenicSpotCommentsUser);
}
