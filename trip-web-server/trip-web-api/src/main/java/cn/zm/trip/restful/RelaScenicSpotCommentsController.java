package cn.zm.trip.restful;

import cn.zm.common.base.ResResult;
import cn.zm.mybatis.base.BaseController;
import cn.zm.trip.entity.dto.RelaScenicSpotCommentsDTO;
import cn.zm.trip.entity.vo.RelaScenicSpotCommentsVO;
import cn.zm.trip.service.IRelaScenicSpotCommentsService;
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
 * 关联景区评论关联表
 * @author 十渊
 * @since 2022-07-12
 */
@RequestMapping("relaScenicSpotComments")
@RestController
@Api(tags = "关联景区评论关联表")
public class RelaScenicSpotCommentsController extends BaseController {

    @Resource
    private IRelaScenicSpotCommentsService relaScenicSpotCommentsService;

    @GetMapping
    @ApiOperation("关联景区评论关联表page查询")
    public ResResult<IPage<RelaScenicSpotCommentsVO>> getByPage(@Validated RelaScenicSpotCommentsDTO relaScenicSpotComments) {
        // TODO 分页查询
        IPage<RelaScenicSpotCommentsVO> page = relaScenicSpotCommentsService.selectByPage(getPage(), relaScenicSpotComments);
        return ResResult.succ(page);
    }

    // @PostMapping("list")
    // @ApiOperation("关联景区评论关联表list查询")
    // @ApiImplicitParams({
    //     @ApiImplicitParam(name = "orderByColumn", value = "排序字段"),
    //     @ApiImplicitParam(name = "isDesc", value = "是否降序")
    // })
    // public ResResult<List<RelaScenicSpotCommentsVO>> list(@Validated @RequestBody RelaScenicSpotCommentsDTO relaScenicSpotComments) {
    //     // TODO 分页查询
    //     IPage<RelaScenicSpotCommentsVO> page = relaScenicSpotCommentsService.list(getPage(), relaScenicSpotComments);
    //     return ResResult.succ(page);
    // }

    @GetMapping("{id}")
    @ApiOperation("关联景区评论关联表查询(id)")
    public ResResult<RelaScenicSpotCommentsVO> get(@PathVariable String id) {
        // TODO 查询
        boolean aNull = Objects.isNull(relaScenicSpotCommentsService.getById(id));
        return ResResult.succ(aNull ? null : relaScenicSpotCommentsService.getById(id).convert());
    }

    @PostMapping
    @ApiOperation("关联景区评论关联表新增")
    public ResResult add(@RequestBody @Validated RelaScenicSpotCommentsDTO relaScenicSpotComments) {
        // TODO 新增
        relaScenicSpotCommentsService.save(relaScenicSpotComments.convert());
        return ResResult.succ("新增成功");
    }

    @DeleteMapping("{id}")
    @ApiOperation("关联景区评论关联表删除")
    public ResResult del(@PathVariable String id) {
        // TODO 删除
        relaScenicSpotCommentsService.removeById(id);
        return ResResult.succ("删除成功");
    }

    @PutMapping
    @ApiOperation("关联景区评论关联表修改")
    public ResResult update(@RequestBody @Validated RelaScenicSpotCommentsDTO relaScenicSpotComments) {
        // TODO 修改
        relaScenicSpotCommentsService.updateById(relaScenicSpotComments.convert());
        return ResResult.succ("修改成功");
    }
}
