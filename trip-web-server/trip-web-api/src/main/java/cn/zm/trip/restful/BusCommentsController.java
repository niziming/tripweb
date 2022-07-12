package cn.zm.trip.restful;

import cn.zm.common.base.ResResult;
import cn.zm.mybatis.base.BaseController;
import cn.zm.trip.entity.dto.BusCommentsDTO;
import cn.zm.trip.entity.vo.BusCommentsVO;
import cn.zm.trip.service.IBusCommentsService;
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
 * 业务评论表
 * @author 十渊
 * @since 2022-07-12
 */
@RequestMapping("busComments")
@RestController
@Api(tags = "业务评论表")
public class BusCommentsController extends BaseController {

    @Resource
    private IBusCommentsService busCommentsService;

    @GetMapping
    @ApiOperation("业务评论表page查询")
    // @ApiImplicitParams({
    //     @ApiImplicitParam(name = "page", value = "当前页数", defaultValue = "1"),
    //     @ApiImplicitParam(name = "size", value = "每页个数", defaultValue = "10"),
    //     @ApiImplicitParam(name = "orderByColumn", value = "排序字段"),
    //     @ApiImplicitParam(name = "isDesc", value = "是否降序")
    // })
    public ResResult<IPage<BusCommentsVO>> getByPage(@Validated BusCommentsDTO busComments) {
        // TODO 分页查询
        IPage<BusCommentsVO> page = busCommentsService.selectByPage(getPage(), busComments);
        return ResResult.succ(page);
    }

    // @PostMapping("list")
    // @ApiOperation("业务评论表list查询")
    // @ApiImplicitParams({
    //     @ApiImplicitParam(name = "orderByColumn", value = "排序字段"),
    //     @ApiImplicitParam(name = "isDesc", value = "是否降序")
    // })
    // public ResResult<List<BusCommentsVO>> list(@Validated @RequestBody BusCommentsDTO busComments) {
    //     // TODO 分页查询
    //     IPage<BusCommentsVO> page = busCommentsService.list(getPage(), busComments);
    //     return ResResult.succ(page);
    // }

    @GetMapping("{id}")
    @ApiOperation("业务评论表查询(id)")
    public ResResult<BusCommentsVO> get(@PathVariable String id) {
        // TODO 查询
        boolean aNull = Objects.isNull(busCommentsService.getById(id));
        return ResResult.succ(aNull ? null : busCommentsService.getById(id).convert());
    }

    @PostMapping
    @ApiOperation("业务评论表新增")
    public ResResult add(@RequestBody @Validated BusCommentsDTO busComments) {
        // TODO 新增
        busCommentsService.save(busComments.convert());
        return ResResult.succ("新增成功");
    }

    @DeleteMapping("{id}")
    @ApiOperation("业务评论表删除")
    public ResResult del(@PathVariable String id) {
        // TODO 删除
        busCommentsService.removeById(id);
        return ResResult.succ("删除成功");
    }

    @PutMapping
    @ApiOperation("业务评论表修改")
    public ResResult update(@RequestBody @Validated BusCommentsDTO busComments) {
        // TODO 修改
        busCommentsService.updateById(busComments.convert());
        return ResResult.succ("修改成功");
    }
}
