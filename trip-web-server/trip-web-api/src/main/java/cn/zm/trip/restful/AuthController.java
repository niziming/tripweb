package cn.zm.trip.restful;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("auth")
@Api(tags = "权限认证")
public class AuthController {
  // @GetMapping("/login")
  // @ApiOperation(value = "下载文件")
}
