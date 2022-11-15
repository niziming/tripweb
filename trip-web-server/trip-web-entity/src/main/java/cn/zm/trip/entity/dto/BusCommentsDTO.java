package cn.zm.trip.entity.dto;

import cn.zm.trip.entity.BusComments;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import cn.zm.mybatis.utils.ObjectConvert;
import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@TableName("bus_comments")
@ApiModel(value="BusCommentsDTO对象", description="业务评论表")
public class BusCommentsDTO extends ObjectConvert<BusComments>{
    @ApiModelProperty(value = "ID")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    @ApiModelProperty(value = "父评论id")
    private Long parentId;
    @ApiModelProperty(value = "内容")
    private String content;
    @ApiModelProperty(value = "点赞")
    private Integer up;
    @ApiModelProperty(value = "评论时间")
    @TableField("createTime")
    private LocalDateTime createTime;
}

