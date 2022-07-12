package cn.zm.trip.restful;

import cn.zm.common.base.ResResult;
import cn.zm.mybatis.base.BaseController;
import cn.zm.trip.entity.dto.BaseScenicSpotDTO;
import cn.zm.trip.entity.vo.BaseScenicSpotVO;
import cn.zm.trip.service.IBaseScenicSpotService;
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
 * 基础景点
 * @author 十渊
 * @since 2022-07-12
 */
@RequestMapping("baseScenicSpot")
@RestController
@Api(tags = "基础景点")
public class BaseScenicSpotController extends BaseController {

    @Resource
    private IBaseScenicSpotService baseScenicSpotService;

    @GetMapping
    @ApiOperation("基础景点page查询")
    // @ApiImplicitParams({
    //     @ApiImplicitParam(name = "page", value = "当前页数", defaultValue = "1"),
    //     @ApiImplicitParam(name = "size", value = "每页个数", defaultValue = "10"),
    //     @ApiImplicitParam(name = "orderByColumn", value = "排序字段"),
    //     @ApiImplicitParam(name = "isDesc", value = "是否降序")
    // })
    public ResResult<IPage<BaseScenicSpotVO>> getByPage(@Validated BaseScenicSpotDTO baseScenicSpot) {
        // TODO 分页查询
        IPage<BaseScenicSpotVO> page = baseScenicSpotService.selectByPage(getPage(), baseScenicSpot);
        return ResResult.succ(page);
    }

    // @PostMapping("list")
    // @ApiOperation("基础景点list查询")
    // @ApiImplicitParams({
    //     @ApiImplicitParam(name = "orderByColumn", value = "排序字段"),
    //     @ApiImplicitParam(name = "isDesc", value = "是否降序")
    // })
    // public ResResult<List<BaseScenicSpotVO>> list(@Validated @RequestBody BaseScenicSpotDTO baseScenicSpot) {
    //     // TODO 分页查询
    //     IPage<BaseScenicSpotVO> page = baseScenicSpotService.list(getPage(), baseScenicSpot);
    //     return ResResult.succ(page);
    // }

    @GetMapping("{id}")
    @ApiOperation("基础景点查询(id)")
    public ResResult<BaseScenicSpotVO> get(@PathVariable String id) {
        // TODO 查询
        boolean aNull = Objects.isNull(baseScenicSpotService.getById(id));
        return ResResult.succ(aNull ? null : baseScenicSpotService.getById(id).convert());
    }

    @PostMapping
    @ApiOperation("基础景点新增")
    public ResResult add(@RequestBody @Validated BaseScenicSpotDTO baseScenicSpot) {
        // TODO 新增
        baseScenicSpotService.save(baseScenicSpot.convert());
        return ResResult.succ("新增成功");
    }

    @DeleteMapping("{id}")
    @ApiOperation("基础景点删除")
    public ResResult del(@PathVariable String id) {
        // TODO 删除
        baseScenicSpotService.removeById(id);
        return ResResult.succ("删除成功");
    }

    @PutMapping
    @ApiOperation("基础景点修改")
    public ResResult update(@RequestBody @Validated BaseScenicSpotDTO baseScenicSpot) {
        // TODO 修改
        baseScenicSpotService.updateById(baseScenicSpot.convert());
        return ResResult.succ("修改成功");
    }
}
