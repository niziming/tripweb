package cn.zm.trip.entity.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.validation.Valid;

@Data
@Accessors(chain = true)
@ApiModel(value="ScenicSpotCommentsDTO对象", description="业务-景区评论关联实体")
public class ScenicSpotCommentsDTO {
    @ApiModelProperty(value = "基础-景点")
    @Valid
    private BaseScenicSpotDTO scenicSpotDTO;

    @Valid
    @ApiModelProperty(value = "业务-评论")
    private BusCommentsDTO commentsDTO;
}

