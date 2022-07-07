package cn.zm.trip.entity;

import cn.zm.trip.entity.vo.BaseUserVO;
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
@TableName("base_user")
@ApiModel(value="BaseUser对象", description="基础用户")
public class BaseUser extends ObjectConvert<BaseUserVO>{
    @ApiModelProperty(value = "ID")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    @ApiModelProperty(value = "名称")
    private String name;
    @ApiModelProperty(value = "头像")
    private String avatar;
    @ApiModelProperty(value = "简介")
    private String intro;
    @ApiModelProperty(value = "电话号码")
    private Integer phone;
}

