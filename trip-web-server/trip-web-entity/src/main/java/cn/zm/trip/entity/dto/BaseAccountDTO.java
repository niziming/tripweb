package cn.zm.trip.entity.dto;

import cn.zm.trip.entity.BaseAccount;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import cn.zm.mybatis.utils.ObjectConvert;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@TableName("base_account")
@ApiModel(value="BaseAccountDTO对象", description="基础账户表")
public class BaseAccountDTO extends ObjectConvert<BaseAccount>{
    @ApiModelProperty(value = "账户标识")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    @ApiModelProperty(value = "账户")
    private String username;
    @ApiModelProperty(value = "密码")
    private String password;
}

