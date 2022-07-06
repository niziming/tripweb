package cn.zm.common.base;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "基础条件依赖", description = "基础条件依赖")
public class BaseEntity {
  @ApiModelProperty(value = "页数")
  private String page;
  @ApiModelProperty(value="长度")
  private String size;
  @ApiModelProperty(value="排序资源")
  private String orderByColumn;
  @ApiModelProperty(value="正倒序")
  private boolean isDesc;
}
