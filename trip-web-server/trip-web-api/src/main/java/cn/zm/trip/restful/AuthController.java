package cn.zm.trip.restful;

import cn.zm.common.base.ResResult;
import cn.zm.common.enums.ResEnum;
import cn.zm.common.utils.AssertUtil;
import cn.zm.trip.entity.ViewUserAccount;
import cn.zm.trip.entity.dto.ViewUserAccountDTO;
import cn.zm.trip.entity.vo.ViewUserAccountVO;
import cn.zm.trip.service.IViewUserAccountService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;


@Transactional(rollbackFor = Exception.class)
@RestController
@RequestMapping("auth")
@Api(tags = "权限认证")
public class AuthController {
  @Resource
  private IViewUserAccountService userAccountService;


  @PostMapping("/login")
  @ApiOperation("登陆")
  public ResResult<ViewUserAccountVO> login(@RequestBody ViewUserAccountDTO dto) {
    ViewUserAccount one = userAccountService.getOne(new QueryWrapper<>(dto.convert()));
    AssertUtil.assertNonNull(one, ResEnum.INVALID_PARAMS);
    return ResResult.succ(one.convert());
  }

  @PostMapping("/register")
  @ApiOperation("注册")
  public ResResult register(@RequestBody @Validated ViewUserAccountDTO dto) {
    userAccountService.register(dto);
    return ResResult.succ();
  }

}
