package cn.zm.trip.restful;

import cn.zm.common.base.ResResult;
import cn.zm.mybatis.base.BaseController;
import cn.zm.trip.entity.dto.BaseUserDTO;
import cn.zm.trip.entity.vo.BaseUserVO;
import cn.zm.trip.service.IBaseUserService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.web.bind.annotation.RestController;
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
 * 基础用户
 * @author 十渊
 * @since 2022-07-07
 */
@RequestMapping("baseUser")
@RestController
@Api(tags = "基础用户")
public class BaseUserController extends BaseController {

    @Resource
    private IBaseUserService baseUserService;

    @GetMapping
    @ApiOperation("基础用户page查询")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "page", value = "当前页数", defaultValue = "1"),
        @ApiImplicitParam(name = "size", value = "每页个数", defaultValue = "10"),
        @ApiImplicitParam(name = "orderByColumn", value = "排序字段"),
        @ApiImplicitParam(name = "isDesc", value = "是否降序")
    })
    public ResResult<IPage<BaseUserVO>> getByPage(@Validated BaseUserDTO baseUser) {
        // TODO 分页查询
        IPage<BaseUserVO> page = baseUserService.selectByPage(getPage(), baseUser);
        return ResResult.succ(page);
    }

    // @PostMapping("list")
    // @ApiOperation("基础用户list查询")
    // @ApiImplicitParams({
    //     @ApiImplicitParam(name = "orderByColumn", value = "排序字段"),
    //     @ApiImplicitParam(name = "isDesc", value = "是否降序")
    // })
    // public ResResult<List<BaseUserVO>> list(@Validated @RequestBody BaseUserDTO baseUser) {
    //     // TODO 分页查询
    //     IPage<BaseUserVO> page = baseUserService.list(getPage(), baseUser);
    //     return ResResult.succ(page);
    // }

    @GetMapping("{id}")
    @ApiOperation("基础用户查询(id)")
    public ResResult<BaseUserVO> get(@PathVariable String id) {
        // TODO 查询
        boolean aNull = Objects.isNull(baseUserService.getById(id));
        return ResResult.succ(aNull ? null : baseUserService.getById(id).convert());
    }

    @PostMapping
    @ApiOperation("基础用户新增")
    public ResResult add(@RequestBody @Validated BaseUserDTO baseUser) {
        // TODO 新增
        baseUserService.save(baseUser.convert());
        return ResResult.succ("新增成功");
    }

    @DeleteMapping("{id}")
    @ApiOperation("基础用户删除")
    public ResResult del(@PathVariable String id) {
        // TODO 删除
        baseUserService.removeById(id);
        return ResResult.succ("删除成功");
    }

    @PutMapping
    @ApiOperation("基础用户修改")
    public ResResult update(@RequestBody @Validated BaseUserDTO baseUser) {
        // TODO 修改
        baseUserService.updateById(baseUser.convert());
        return ResResult.succ("修改成功");
    }
}
