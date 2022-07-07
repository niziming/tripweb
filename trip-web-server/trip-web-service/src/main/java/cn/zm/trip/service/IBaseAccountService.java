package cn.zm.trip.service;

import cn.zm.trip.entity.BaseAccount;
import cn.zm.trip.entity.dto.BaseAccountDTO;
import cn.zm.trip.entity.vo.BaseAccountVO;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

public interface IBaseAccountService extends IService<BaseAccount> {
    /**
    * 分页查询
    *
    * @param page   分页信息
    * @param BaseAccount 基础账户表入参
    * @return 分页结果
    */
    IPage<BaseAccountVO> selectByPage(IPage<BaseAccount> page, BaseAccountDTO BaseAccount);
}
