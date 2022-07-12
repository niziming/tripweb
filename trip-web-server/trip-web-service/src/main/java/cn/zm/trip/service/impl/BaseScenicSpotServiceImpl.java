package cn.zm.trip.service.impl;

import cn.zm.mybatis.utils.ConvertUtil;
import cn.zm.trip.entity.BaseScenicSpot;
import cn.zm.trip.entity.dto.BaseScenicSpotDTO;
import cn.zm.trip.entity.vo.BaseScenicSpotVO;
import cn.zm.trip.mapper.BaseScenicSpotMapper;
import cn.zm.trip.service.IBaseScenicSpotService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;


@Service
@Transactional(rollbackFor = Exception.class)
public class BaseScenicSpotServiceImpl extends ServiceImpl<BaseScenicSpotMapper, BaseScenicSpot> implements IBaseScenicSpotService {
    @Override
    public IPage<BaseScenicSpotVO> selectByPage(IPage<BaseScenicSpot> page, BaseScenicSpotDTO base_scenic_spot) {
        IPage<BaseScenicSpot> base_scenic_spotPage = baseMapper.selectPage(page, new QueryWrapper<>(base_scenic_spot.convert()));
        return ConvertUtil.buildPage(base_scenic_spotPage);
    }
}
