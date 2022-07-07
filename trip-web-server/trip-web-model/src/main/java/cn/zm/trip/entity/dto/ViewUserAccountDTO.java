package cn.zm.trip.entity.dto;

import cn.zm.trip.entity.ViewUserAccount;
import com.baomidou.mybatisplus.annotation.TableName;
import cn.zm.mybatis.utils.ObjectConvert;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@TableName("view_user_account")
@ApiModel(value="ViewUserAccountDTO对象", description="VIEW")
public class ViewUserAccountDTO extends ObjectConvert<ViewUserAccount>{
    @ApiModelProperty(value = "ID")
    private Long id;
    @ApiModelProperty(value = "名称")
    private String name;
    @ApiModelProperty(value = "头像")
    private String avatar;
    @ApiModelProperty(value = "电话号码")
    private Integer phone;
    @ApiModelProperty(value = "简介")
    private String intro;
    @ApiModelProperty(value = "账户")
    private String username;
    @ApiModelProperty(value = "密码")
    private String password;
}

