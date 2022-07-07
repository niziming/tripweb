package cn.zm.trip.service.impl;

import cn.zm.mybatis.utils.ConvertUtil;
import cn.zm.trip.entity.BaseUser;
import cn.zm.trip.entity.dto.BaseUserDTO;
import cn.zm.trip.entity.vo.BaseUserVO;
import cn.zm.trip.mapper.BaseUserMapper;
import cn.zm.trip.service.IBaseUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;


@Service
@Transactional(rollbackFor = Exception.class)
public class BaseUserServiceImpl extends ServiceImpl<BaseUserMapper, BaseUser> implements IBaseUserService {
    @Override
    public IPage<BaseUserVO> selectByPage(IPage<BaseUser> page, BaseUserDTO base_user) {
        IPage<BaseUser> base_userPage = baseMapper.selectPage(page, new QueryWrapper<>(base_user.convert()));
        return ConvertUtil.buildPage(base_userPage);
    }
}
