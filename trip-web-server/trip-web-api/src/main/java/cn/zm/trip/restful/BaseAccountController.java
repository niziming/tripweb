package cn.zm.trip.restful;

import cn.zm.common.base.ResResult;
import cn.zm.mybatis.base.BaseController;
import cn.zm.trip.entity.dto.BaseAccountDTO;
import cn.zm.trip.entity.vo.BaseAccountVO;
import cn.zm.trip.service.IBaseAccountService;
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
 * 基础账户表
 * @author 十渊
 * @since 2022-07-07
 */
@RequestMapping("baseAccount")
@RestController
@Api(tags = "基础账户表")
public class BaseAccountController extends BaseController {

    @Resource
    private IBaseAccountService baseAccountService;

    @GetMapping
    @ApiOperation("基础账户表page查询")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "page", value = "当前页数", defaultValue = "1"),
        @ApiImplicitParam(name = "size", value = "每页个数", defaultValue = "10"),
        @ApiImplicitParam(name = "orderByColumn", value = "排序字段"),
        @ApiImplicitParam(name = "isDesc", value = "是否降序")
    })
    public ResResult<IPage<BaseAccountVO>> getByPage(@Validated BaseAccountDTO baseAccount) {
        // TODO 分页查询
        IPage<BaseAccountVO> page = baseAccountService.selectByPage(getPage(), baseAccount);
        return ResResult.succ(page);
    }

    // @PostMapping("list")
    // @ApiOperation("基础账户表list查询")
    // @ApiImplicitParams({
    //     @ApiImplicitParam(name = "orderByColumn", value = "排序字段"),
    //     @ApiImplicitParam(name = "isDesc", value = "是否降序")
    // })
    // public ResResult<List<BaseAccountVO>> list(@Validated @RequestBody BaseAccountDTO baseAccount) {
    //     // TODO 分页查询
    //     IPage<BaseAccountVO> page = baseAccountService.list(getPage(), baseAccount);
    //     return ResResult.succ(page);
    // }

    @GetMapping("{id}")
    @ApiOperation("基础账户表查询(id)")
    public ResResult<BaseAccountVO> get(@PathVariable String id) {
        // TODO 查询
        boolean aNull = Objects.isNull(baseAccountService.getById(id));
        return ResResult.succ(aNull ? null : baseAccountService.getById(id).convert());
    }

    @PostMapping
    @ApiOperation("基础账户表新增")
    public ResResult add(@RequestBody @Validated BaseAccountDTO baseAccount) {
        // TODO 新增
        baseAccountService.save(baseAccount.convert());
        return ResResult.succ("新增成功");
    }

    @DeleteMapping("{id}")
    @ApiOperation("基础账户表删除")
    public ResResult del(@PathVariable String id) {
        // TODO 删除
        baseAccountService.removeById(id);
        return ResResult.succ("删除成功");
    }

    @PutMapping
    @ApiOperation("基础账户表修改")
    public ResResult update(@RequestBody @Validated BaseAccountDTO baseAccount) {
        // TODO 修改
        baseAccountService.updateById(baseAccount.convert());
        return ResResult.succ("修改成功");
    }
}
