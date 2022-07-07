package cn.zm.trip.service.impl;

import cn.zm.mybatis.utils.ConvertUtil;
import cn.zm.trip.entity.ViewUserAccount;
import cn.zm.trip.entity.dto.ViewUserAccountDTO;
import cn.zm.trip.entity.vo.ViewUserAccountVO;
import cn.zm.trip.service.IViewUserAccountService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import cn.zm.trip.mapper.ViewUserAccountMapper;


@Service
@Transactional(rollbackFor = Exception.class)
public class ViewUserAccountServiceImpl extends ServiceImpl<ViewUserAccountMapper, ViewUserAccount> implements IViewUserAccountService {
    @Override
    public IPage<ViewUserAccountVO> selectByPage(IPage<ViewUserAccount> page, ViewUserAccountDTO view_user_account) {
        IPage<ViewUserAccount> view_user_accountPage = baseMapper.selectPage(page, new QueryWrapper<>(view_user_account.convert()));
        return ConvertUtil.buildPage(view_user_accountPage);
    }
}
