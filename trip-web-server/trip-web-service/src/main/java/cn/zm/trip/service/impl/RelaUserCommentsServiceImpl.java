package cn.zm.trip.service.impl;

import cn.zm.mybatis.utils.ConvertUtil;
import cn.zm.trip.entity.RelaUserComments;
import cn.zm.trip.entity.dto.RelaUserCommentsDTO;
import cn.zm.trip.entity.vo.RelaUserCommentsVO;
import cn.zm.trip.mapper.RelaUserCommentsMapper;
import cn.zm.trip.service.IRelaUserCommentsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;


@Service
@Transactional(rollbackFor = Exception.class)
public class RelaUserCommentsServiceImpl extends ServiceImpl<RelaUserCommentsMapper, RelaUserComments> implements IRelaUserCommentsService {
    @Override
    public IPage<RelaUserCommentsVO> selectByPage(IPage<RelaUserComments> page, RelaUserCommentsDTO rela_user_comments) {
        IPage<RelaUserComments> rela_user_commentsPage = baseMapper.selectPage(page, new QueryWrapper<>(rela_user_comments.convert()));
        return ConvertUtil.buildPage(rela_user_commentsPage);
    }
}
