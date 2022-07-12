package cn.zm.trip.restful;

import cn.zm.common.base.ResResult;
import cn.zm.mybatis.base.BaseController;
import cn.zm.trip.entity.dto.RelaUserCommentsDTO;
import cn.zm.trip.entity.vo.RelaUserCommentsVO;
import cn.zm.trip.service.IRelaUserCommentsService;
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
 * 关联用户评论表
 * @author 十渊
 * @since 2022-07-12
 */
@RequestMapping("relaUserComments")
@RestController
@Api(tags = "关联用户评论表")
public class RelaUserCommentsController extends BaseController {

    @Resource
    private IRelaUserCommentsService relaUserCommentsService;

    @GetMapping
    @ApiOperation("关联用户评论表page查询")
    // @ApiImplicitParams({
    //     @ApiImplicitParam(name = "page", value = "当前页数", defaultValue = "1"),
    //     @ApiImplicitParam(name = "size", value = "每页个数", defaultValue = "10"),
    //     @ApiImplicitParam(name = "orderByColumn", value = "排序字段"),
    //     @ApiImplicitParam(name = "isDesc", value = "是否降序")
    // })
    public ResResult<IPage<RelaUserCommentsVO>> getByPage(@Validated RelaUserCommentsDTO relaUserComments) {
        // TODO 分页查询
        IPage<RelaUserCommentsVO> page = relaUserCommentsService.selectByPage(getPage(), relaUserComments);
        return ResResult.succ(page);
    }

    // @PostMapping("list")
    // @ApiOperation("关联用户评论表list查询")
    // @ApiImplicitParams({
    //     @ApiImplicitParam(name = "orderByColumn", value = "排序字段"),
    //     @ApiImplicitParam(name = "isDesc", value = "是否降序")
    // })
    // public ResResult<List<RelaUserCommentsVO>> list(@Validated @RequestBody RelaUserCommentsDTO relaUserComments) {
    //     // TODO 分页查询
    //     IPage<RelaUserCommentsVO> page = relaUserCommentsService.list(getPage(), relaUserComments);
    //     return ResResult.succ(page);
    // }

    @GetMapping("{id}")
    @ApiOperation("关联用户评论表查询(id)")
    public ResResult<RelaUserCommentsVO> get(@PathVariable String id) {
        // TODO 查询
        boolean aNull = Objects.isNull(relaUserCommentsService.getById(id));
        return ResResult.succ(aNull ? null : relaUserCommentsService.getById(id).convert());
    }

    @PostMapping
    @ApiOperation("关联用户评论表新增")
    public ResResult add(@RequestBody @Validated RelaUserCommentsDTO relaUserComments) {
        // TODO 新增
        relaUserCommentsService.save(relaUserComments.convert());
        return ResResult.succ("新增成功");
    }

    @DeleteMapping("{id}")
    @ApiOperation("关联用户评论表删除")
    public ResResult del(@PathVariable String id) {
        // TODO 删除
        relaUserCommentsService.removeById(id);
        return ResResult.succ("删除成功");
    }

    @PutMapping
    @ApiOperation("关联用户评论表修改")
    public ResResult update(@RequestBody @Validated RelaUserCommentsDTO relaUserComments) {
        // TODO 修改
        relaUserCommentsService.updateById(relaUserComments.convert());
        return ResResult.succ("修改成功");
    }
}
