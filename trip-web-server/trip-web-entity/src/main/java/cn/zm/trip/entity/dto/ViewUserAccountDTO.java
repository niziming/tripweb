package cn.zm.trip.entity.dto;

import cn.zm.common.utils.AppRegexpConstants;
import cn.zm.trip.entity.ViewUserAccount;
import com.baomidou.mybatisplus.annotation.TableName;
import cn.zm.mybatis.utils.ObjectConvert;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Pattern;

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

    @Pattern(regexp = AppRegexpConstants.MOBILE_PHONE, message = "电话号码格式错误")
    @NotBlank(message = "电话号码不可为空")
    @ApiModelProperty(value = "电话号码")
    private String phone;

    @ApiModelProperty(value = "简介")
    private String intro;

    @Length(min = 6, max = 12, message = "账户长度6-12")
    @ApiModelProperty(value = "账户")
    private String username;

    @Length(min = 6, max = 20, message = "密码长度6-12")
    @ApiModelProperty(value = "密码")
    private String password;
}

