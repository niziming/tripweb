package cn.zm.plus.web.service.impl;

import cn.zm.plus.web.entity.BusComments;
import cn.zm.plus.web.mapper.BusCommentsMapper;
import cn.zm.plus.web.service.IBusCommentsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.baomidou.mybatisplus.core.metadata.IPage;
import cn.zm.plus.web.entity.dto.BusCommentsDTO;
import cn.zm.plus.web.entity.vo.BusCommentsVO;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import cn.zm.plus.utils.ConvertUtil;


@Service
@Transactional(rollbackFor = Exception.class)
public class BusCommentsServiceImpl extends ServiceImpl<BusCommentsMapper, BusComments> implements IBusCommentsService {
    @Override
    public IPage<BusCommentsVO> selectByPage(IPage<BusComments> page, BusCommentsDTO bus_comments) {
        IPage<BusComments> bus_commentsPage = baseMapper.selectPage(page, new QueryWrapper<>(bus_comments.convert()));
        return ConvertUtil.buildPage(bus_commentsPage);
    }
}
