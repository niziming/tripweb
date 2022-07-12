package cn.zm.trip.restful;

import cn.zm.common.base.ResResult;
import cn.zm.mybatis.base.BaseController;
import cn.zm.trip.entity.dto.ViewScenicSpotCommentsUserDTO;
import cn.zm.trip.entity.vo.ViewScenicSpotCommentsUserVO;
import cn.zm.trip.service.IViewScenicSpotCommentsUserService;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.core.metadata.IPage;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Api;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import java.util.Objects;
import java.util.List;

/**
 * VIEW
 * @author 十渊
 * @since 2022-07-12
 */
@RequestMapping("viewScenicSpotCommentsUser")
@RestController
@Api(tags = "视图-景点评论用户关联")
public class ViewScenicSpotCommentsUserController extends BaseController {

    @Resource
    private IViewScenicSpotCommentsUserService viewScenicSpotCommentsUserService;

    @GetMapping
    @ApiOperation("VIEWpage查询")
    // @ApiImplicitParams({
    //     @ApiImplicitParam(name = "page", value = "当前页数", defaultValue = "1"),
    //     @ApiImplicitParam(name = "size", value = "每页个数", defaultValue = "10"),
    //     @ApiImplicitParam(name = "orderByColumn", value = "排序字段"),
    //     @ApiImplicitParam(name = "isDesc", value = "是否降序")
    // })
    public ResResult<IPage<ViewScenicSpotCommentsUserVO>> getByPage(@Validated ViewScenicSpotCommentsUserDTO viewScenicSpotCommentsUser) {
        // TODO 分页查询
        IPage<ViewScenicSpotCommentsUserVO> page = viewScenicSpotCommentsUserService.selectByPage(getPage(), viewScenicSpotCommentsUser);
        return ResResult.succ(page);
    }


    @GetMapping("{id}")
    @ApiOperation("VIEW查询(id)")
    public ResResult<ViewScenicSpotCommentsUserVO> get(@PathVariable String id) {
        // TODO 查询
        boolean aNull = Objects.isNull(viewScenicSpotCommentsUserService.getById(id));
        return ResResult.succ(aNull ? null : viewScenicSpotCommentsUserService.getById(id).convert());
    }

}
