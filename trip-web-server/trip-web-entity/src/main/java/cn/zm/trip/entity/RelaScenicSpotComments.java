package cn.zm.trip.entity;

import cn.zm.trip.entity.vo.RelaScenicSpotCommentsVO;
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
@TableName("rela_scenic_spot_comments")
@ApiModel(value="RelaScenicSpotComments对象", description="关联景区评论关联表")
public class RelaScenicSpotComments extends ObjectConvert<RelaScenicSpotCommentsVO>{
    @ApiModelProperty(value = "ID")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    @ApiModelProperty(value = "景点id")
    private Long scenicSpotId;
    @ApiModelProperty(value = "评论id")
    private Long commentsId;
}

