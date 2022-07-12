package cn.zm.trip.entity.dto;

import cn.zm.trip.entity.ViewScenicSpotCommentsUser;
import com.baomidou.mybatisplus.annotation.TableName;
import cn.zm.mybatis.utils.ObjectConvert;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@TableName("view_scenic_spot_comments_user")
@ApiModel(value="ViewScenicSpotCommentsUserDTO对象", description="VIEW")
public class ViewScenicSpotCommentsUserDTO extends ObjectConvert<ViewScenicSpotCommentsUser>{
    @ApiModelProperty(value = "名称")
    private String name;
    @ApiModelProperty(value = "头像")
    private String avatar;
    @ApiModelProperty(value = "电话号码")
    private String phone;
    @ApiModelProperty(value = "简介")
    private String intro;
    @ApiModelProperty(value = "父评论id")
    private Long parentId;
    @ApiModelProperty(value = "内容")
    private String content;
}

