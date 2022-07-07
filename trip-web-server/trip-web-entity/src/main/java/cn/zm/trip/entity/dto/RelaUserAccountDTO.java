package cn.zm.trip.entity.dto;

import cn.zm.trip.entity.RelaUserAccount;
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
@TableName("rela_user_account")
@ApiModel(value="RelaUserAccountDTO对象", description="关联表用户与账户")
public class RelaUserAccountDTO extends ObjectConvert<RelaUserAccount>{
    @ApiModelProperty(value = "ID")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    @ApiModelProperty(value = "用户id")
    private Long userId;
    @ApiModelProperty(value = "账户id")
    private Long accountId;
}

