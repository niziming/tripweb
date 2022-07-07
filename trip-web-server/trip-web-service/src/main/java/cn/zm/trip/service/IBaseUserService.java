package cn.zm.trip.service;

import cn.zm.trip.entity.BaseUser;
import cn.zm.trip.entity.dto.BaseUserDTO;
import cn.zm.trip.entity.vo.BaseUserVO;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

public interface IBaseUserService extends IService<BaseUser> {
    /**
    * 分页查询
    *
    * @param page   分页信息
    * @param BaseUser 基础用户入参
    * @return 分页结果
    */
    IPage<BaseUserVO> selectByPage(IPage<BaseUser> page, BaseUserDTO BaseUser);
}
