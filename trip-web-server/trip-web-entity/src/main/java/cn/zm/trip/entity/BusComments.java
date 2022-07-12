package cn.zm.trip.entity;

import cn.zm.mybatis.utils.ObjectConvert;
import cn.zm.trip.entity.vo.BusCommentsVO;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@TableName("bus_comments")
@ApiModel(value="BusComments对象", description="业务评论表")
public class BusComments extends ObjectConvert<BusCommentsVO> {
    @ApiModelProperty(value = "ID")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    @ApiModelProperty(value = "父评论id")
    private Long parentId;
    @ApiModelProperty(value = "内容")
    private String content;
    @ApiModelProperty(value = "点赞")
    private Integer like;
    @ApiModelProperty(value = "评论时间")
    @TableField("createTime")
    private LocalDateTime createTime;
}

