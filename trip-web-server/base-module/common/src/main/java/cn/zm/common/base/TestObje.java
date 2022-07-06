package cn.zm.common.base;

import lombok.*;

@Data
@Builder
@AllArgsConstructor //全参构造函数
@NoArgsConstructor //空参构造函数
public class TestObje extends Child  {
  private String pid;
  private String name;

  @Override
  public String toString() {
    return "TestObje{" +
      "id='" + id + '\'' +
      ", child=" + child +
      ", pid='" + pid + '\'' +
      ", name='" + name + '\'' +
      '}';
  }
}
