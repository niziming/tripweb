package cn.zm.trip.service.impl;

import cn.zm.mybatis.utils.ConvertUtil;
import cn.zm.trip.entity.BusComments;
import cn.zm.trip.entity.dto.BusCommentsDTO;
import cn.zm.trip.entity.vo.BusCommentsVO;
import cn.zm.trip.mapper.BusCommentsMapper;
import cn.zm.trip.service.IBusCommentsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;


@Service
@Transactional(rollbackFor = Exception.class)
public class BusCommentsServiceImpl extends ServiceImpl<BusCommentsMapper, BusComments> implements IBusCommentsService {
    @Override
    public IPage<BusCommentsVO> selectByPage(IPage<BusComments> page, BusCommentsDTO bus_comments) {
        IPage<BusComments> bus_commentsPage = baseMapper.selectPage(page, new QueryWrapper<>(bus_comments.convert()));
        return ConvertUtil.buildPage(bus_commentsPage);
    }
}
