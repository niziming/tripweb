package cn.zm.trip.service;

import cn.zm.trip.entity.ViewUserAccount;
import cn.zm.trip.entity.dto.ViewUserAccountDTO;
import cn.zm.trip.entity.vo.ViewUserAccountVO;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

public interface IViewUserAccountService extends IService<ViewUserAccount> {
    /**
    * 分页查询
    *
    * @param page   分页信息
    * @param ViewUserAccount VIEW入参
    * @return 分页结果
    */
    IPage<ViewUserAccountVO> selectByPage(IPage<ViewUserAccount> page, ViewUserAccountDTO ViewUserAccount);
}
