package cn.zm.trip.service.impl;

import cn.zm.mybatis.utils.ConvertUtil;
import cn.zm.trip.entity.ViewScenicSpotCommentsUser;
import cn.zm.trip.entity.dto.ViewScenicSpotCommentsUserDTO;
import cn.zm.trip.entity.vo.ViewScenicSpotCommentsUserVO;
import cn.zm.trip.mapper.ViewScenicSpotCommentsUserMapper;
import cn.zm.trip.service.IViewScenicSpotCommentsUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;


@Service
@Transactional(rollbackFor = Exception.class)
public class ViewScenicSpotCommentsUserServiceImpl extends ServiceImpl<ViewScenicSpotCommentsUserMapper, ViewScenicSpotCommentsUser> implements IViewScenicSpotCommentsUserService {
    @Override
    public IPage<ViewScenicSpotCommentsUserVO> selectByPage(IPage<ViewScenicSpotCommentsUser> page, ViewScenicSpotCommentsUserDTO view_scenic_spot_comments_user) {
        IPage<ViewScenicSpotCommentsUser> view_scenic_spot_comments_userPage = baseMapper.selectPage(page, new QueryWrapper<>(view_scenic_spot_comments_user.convert()));
        return ConvertUtil.buildPage(view_scenic_spot_comments_userPage);
    }
}
