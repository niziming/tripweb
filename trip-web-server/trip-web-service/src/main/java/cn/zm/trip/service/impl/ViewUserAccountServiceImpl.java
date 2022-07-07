package cn.zm.trip.service.impl;

import cn.zm.mybatis.utils.ConvertUtil;
import cn.zm.trip.entity.BaseAccount;
import cn.zm.trip.entity.BaseUser;
import cn.zm.trip.entity.RelaUserAccount;
import cn.zm.trip.entity.ViewUserAccount;
import cn.zm.trip.entity.dto.ViewUserAccountDTO;
import cn.zm.trip.entity.vo.ViewUserAccountVO;
import cn.zm.trip.service.IBaseAccountService;
import cn.zm.trip.service.IBaseUserService;
import cn.zm.trip.service.IRelaUserAccountService;
import cn.zm.trip.service.IViewUserAccountService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import cn.zm.trip.mapper.ViewUserAccountMapper;

import javax.annotation.Resource;


@Service
@Transactional(rollbackFor = Exception.class)
public class ViewUserAccountServiceImpl extends ServiceImpl<ViewUserAccountMapper, ViewUserAccount> implements IViewUserAccountService {

    @Resource
    private IBaseUserService baseUserService;

    @Resource
    private IBaseAccountService baseAccountService;

    @Resource
    private IRelaUserAccountService relaUserAccountService;

    @Override
    public IPage<ViewUserAccountVO> selectByPage(IPage<ViewUserAccount> page, ViewUserAccountDTO view_user_account) {
        IPage<ViewUserAccount> view_user_accountPage = baseMapper.selectPage(page, new QueryWrapper<>(view_user_account.convert()));
        return ConvertUtil.buildPage(view_user_accountPage);
    }

    @Override
    public void register(ViewUserAccountDTO dto) {
        BaseUser bu = BaseUser.builder().build();
        BaseAccount ba = BaseAccount.builder().build();
        BeanUtils.copyProperties(dto, bu);
        BeanUtils.copyProperties(dto, ba);
        baseUserService.save(bu);
        baseAccountService.save(ba);
        relaUserAccountService.save(RelaUserAccount.builder()
            .userId(bu.getId())
            .accountId(ba.getId())
          .build());
    }
}
