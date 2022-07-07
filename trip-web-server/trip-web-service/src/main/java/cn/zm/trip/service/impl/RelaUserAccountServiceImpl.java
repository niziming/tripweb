package cn.zm.trip.service.impl;

import cn.zm.mybatis.utils.ConvertUtil;
import cn.zm.trip.entity.RelaUserAccount;
import cn.zm.trip.entity.dto.RelaUserAccountDTO;
import cn.zm.trip.entity.vo.RelaUserAccountVO;
import cn.zm.trip.mapper.RelaUserAccountMapper;
import cn.zm.trip.service.IRelaUserAccountService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

@Service
@Transactional(rollbackFor = Exception.class)
public class RelaUserAccountServiceImpl extends ServiceImpl<RelaUserAccountMapper, RelaUserAccount> implements IRelaUserAccountService {
    @Override
    public IPage<RelaUserAccountVO> selectByPage(IPage<RelaUserAccount> page, RelaUserAccountDTO rela_user_account) {
        IPage<RelaUserAccount> rela_user_accountPage = baseMapper.selectPage(page, new QueryWrapper<>(rela_user_account.convert()));
        return ConvertUtil.buildPage(rela_user_accountPage);
    }
}
