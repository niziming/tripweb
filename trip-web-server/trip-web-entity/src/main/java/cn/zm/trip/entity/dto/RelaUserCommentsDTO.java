package cn.zm.trip.entity.dto;

import cn.zm.trip.entity.RelaUserComments;
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
@TableName("rela_user_comments")
@ApiModel(value="RelaUserCommentsDTO对象", description="关联用户评论表")
public class RelaUserCommentsDTO extends ObjectConvert<RelaUserComments>{
    @ApiModelProperty(value = "ID")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    @ApiModelProperty(value = "用户id")
    private Long userId;
    @ApiModelProperty(value = "评论id")
    private Long commentsId;
}

