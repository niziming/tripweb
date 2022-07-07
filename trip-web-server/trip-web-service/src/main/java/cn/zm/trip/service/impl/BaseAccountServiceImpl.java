package cn.zm.trip.service.impl;

import cn.zm.mybatis.utils.ConvertUtil;
import cn.zm.trip.entity.BaseAccount;
import cn.zm.trip.entity.dto.BaseAccountDTO;
import cn.zm.trip.entity.vo.BaseAccountVO;
import cn.zm.trip.mapper.BaseAccountMapper;
import cn.zm.trip.service.IBaseAccountService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;


@Service
@Transactional(rollbackFor = Exception.class)
public class BaseAccountServiceImpl extends ServiceImpl<BaseAccountMapper, BaseAccount> implements IBaseAccountService {
    @Override
    public IPage<BaseAccountVO> selectByPage(IPage<BaseAccount> page, BaseAccountDTO base_account) {
        IPage<BaseAccount> base_accountPage = baseMapper.selectPage(page, new QueryWrapper<>(base_account.convert()));
        return ConvertUtil.buildPage(base_accountPage);
    }
}
