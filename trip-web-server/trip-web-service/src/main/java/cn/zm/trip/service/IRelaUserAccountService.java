package cn.zm.trip.service;

import cn.zm.trip.entity.RelaUserAccount;
import cn.zm.trip.entity.dto.RelaUserAccountDTO;
import cn.zm.trip.entity.vo.RelaUserAccountVO;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

public interface IRelaUserAccountService extends IService<RelaUserAccount> {
    /**
    * 分页查询
    *
    * @param page   分页信息
    * @param RelaUserAccount 关联表用户与账户入参
    * @return 分页结果
    */
    IPage<RelaUserAccountVO> selectByPage(IPage<RelaUserAccount> page, RelaUserAccountDTO RelaUserAccount);
}
