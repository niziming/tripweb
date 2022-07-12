package cn.zm.trip.restful;

import cn.zm.common.base.ResResult;
import cn.zm.mybatis.base.BaseController;
import cn.zm.mybatis.utils.ConvertUtil;
import cn.zm.trip.entity.ViewUserAccount;
import cn.zm.trip.entity.dto.ViewUserAccountDTO;
import cn.zm.trip.entity.vo.ViewUserAccountVO;
import cn.zm.trip.service.IViewUserAccountService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
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
 * @since 2022-07-07
 */
@RequestMapping("viewUserAccount")
@RestController
@Api(tags = "视图-用户及账户信息")
public class ViewUserAccountController extends BaseController {

    @Resource
    private IViewUserAccountService viewUserAccountService;

    @GetMapping
    @ApiOperation("用户及账户信息page查询")
    // @ApiImplicitParams({
    //     @ApiImplicitParam(name = "page", value = "当前页数", defaultValue = "1"),
    //     @ApiImplicitParam(name = "size", value = "每页个数", defaultValue = "10"),
    //     @ApiImplicitParam(name = "orderByColumn", value = "排序字段"),
    //     @ApiImplicitParam(name = "isDesc", value = "是否降序")
    // })
    public ResResult<IPage<ViewUserAccountVO>> getByPage(@Validated ViewUserAccountDTO viewUserAccount) {
        // TODO 分页查询
        IPage<ViewUserAccountVO> page = viewUserAccountService.selectByPage(getPage(), viewUserAccount);
        return ResResult.succ(page);
    }

    @PostMapping("list")
    @ApiOperation("用户及账户信息list查询")
    public ResResult<List<ViewUserAccountVO>> list(@Validated @RequestBody ViewUserAccountDTO viewUserAccount) {
        // TODO list查询
        List<ViewUserAccount> dos = viewUserAccountService.list(new QueryWrapper<>(viewUserAccount.convert()));
        List<ViewUserAccountVO> vos = ConvertUtil.list(dos);
        return ResResult.succ(vos);
    }

    @GetMapping("{id}")
    @ApiOperation("用户及账户信息查询(id)")
    public ResResult<ViewUserAccountVO> get(@PathVariable String id) {
        // TODO 查询
        boolean aNull = Objects.isNull(viewUserAccountService.getById(id));
        return ResResult.succ(aNull ? null : viewUserAccountService.getById(id).convert());
    }


}
