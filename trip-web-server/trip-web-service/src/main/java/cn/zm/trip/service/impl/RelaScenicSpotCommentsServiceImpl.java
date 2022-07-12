package cn.zm.trip.service.impl;

import cn.zm.mybatis.utils.ConvertUtil;
import cn.zm.trip.entity.RelaScenicSpotComments;
import cn.zm.trip.entity.dto.RelaScenicSpotCommentsDTO;
import cn.zm.trip.entity.vo.RelaScenicSpotCommentsVO;
import cn.zm.trip.mapper.RelaScenicSpotCommentsMapper;
import cn.zm.trip.service.IRelaScenicSpotCommentsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

@Service
@Transactional(rollbackFor = Exception.class)
public class RelaScenicSpotCommentsServiceImpl extends ServiceImpl<RelaScenicSpotCommentsMapper, RelaScenicSpotComments> implements IRelaScenicSpotCommentsService {
    @Override
    public IPage<RelaScenicSpotCommentsVO> selectByPage(IPage<RelaScenicSpotComments> page, RelaScenicSpotCommentsDTO rela_scenic_spot_comments) {
        IPage<RelaScenicSpotComments> rela_scenic_spot_commentsPage = baseMapper.selectPage(page, new QueryWrapper<>(rela_scenic_spot_comments.convert()));
        return ConvertUtil.buildPage(rela_scenic_spot_commentsPage);
    }
}
