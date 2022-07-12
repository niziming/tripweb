package cn.zm.trip.entity.vo;

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
@TableName("base_scenic_spot")
@ApiModel(value="BaseScenicSpotVO对象", description="基础景点")
public class BaseScenicSpotVO {
    @ApiModelProperty(value = "ID")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    @ApiModelProperty(value = "景点信息标题")
    private String title;
    @ApiModelProperty(value = "景点发布作者ID")
    private Long author;
    @ApiModelProperty(value = "景点发布作者姓名")
    private String authorName;
    @ApiModelProperty(value = "景点类型")
    private String type;
    @ApiModelProperty(value = "景点缩略图")
    private String avatar;
    @ApiModelProperty(value = "景点联系电话")
    private String phone;
    @ApiModelProperty(value = "景点级别")
    private String level;
    @ApiModelProperty(value = "景点门票")
    private Double price;
    @ApiModelProperty(value = "景点位置")
    private String location;
    @ApiModelProperty(value = "景点邮政编码")
    private String zip;
    @ApiModelProperty(value = "景点开放时间")
    private String opentime;
    @ApiModelProperty(value = "景点信息发布时间")
    @TableField("creatTime")
    private LocalDateTime creatTime;
    @ApiModelProperty(value = "景点描述内容")
    private String content;
}

