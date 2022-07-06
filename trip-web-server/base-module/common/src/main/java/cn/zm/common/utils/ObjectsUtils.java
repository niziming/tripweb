package cn.zm.common.utils;

import cn.zm.common.base.Child;
import cn.zm.common.base.TestObje;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

/** 功能描述: <br>
 * <类 工具类>
 *
 * @author 十渊
 * @date 2021/11/4 9:15
 * @return
 */
public class ObjectsUtils {

  /** 功能描述: <br>
   * <源数组是否匹配所有目标>
   *
   * @param target
   * @param sources
   *
   * @author 十渊
   * @date 2021/11/4 9:07
   * @return boolean
   */
  public static boolean allMatch(Object target, Object ...sources) {
    return Arrays.stream(sources).allMatch(p -> p.equals(target));
  }

  /** 功能描述: <br>
   * <源数组中是否任意匹配目标>
   *
   * @param target
   * @param sources
   *
   * @author 十渊
   * @date 2021/11/4 9:08
   * @return boolean
   */
  public static boolean anyMatch(Object target, Object ...sources) {
    return Arrays.stream(sources).anyMatch(p -> p.equals(target));
  }

  /** 功能描述: <br>
   * <list 转 tree 根据 parent id>
   *
   * @param t pid
   * @param list 数组
   * @param rootId 根节点
   *
   * @author 十渊
   * @date 2021/11/5 16:41
   * @return java.util.List<T>
   */
  public static <E, T extends Child> List<T> list2Tree(Function<T,E> t, List<T> list, E rootId) {
    Map<E, List<T>> treeMap = list.stream().collect(Collectors.groupingBy(t));
    list.forEach(i -> i.setChild(treeMap.get(i.getId())));
    return treeMap.get(rootId);
  }

  /** 功能描述: <br>
   * <list 转 tree 根据 parent id>
   *
   * @param pid pid
   * @param list 数组
   * @param rootId 根节点
   *
   * @author 十渊
   * @date 2021/11/5 16:41
   * @return java.util.List<T>
   */
  public static <E, T> List<T> list2Tree(Function<T,E> pid, Function<T,E> id, Consumer<T> c, List<T> list, E rootId) {
    Map<E, List<T>> treeMap = list.stream().collect(Collectors.groupingBy(pid));
    // list.forEach(i -> i.setChild(treeMap.get(id)));
    return treeMap.get(rootId);
  }

  public static void main(String[] args) {

    TestObje build = TestObje.builder().build();
    TestObje build1 = TestObje.builder().build();
    ArrayList<TestObje> testObjes = new ArrayList<>();

    build.setId("1");
    build.setPid("0");
    build.setName("parent");

    testObjes.add(build);
    build1.setId("2");
    build1.setPid("1");
    build1.setName("child");
    testObjes.add(build1);
    List<TestObje> testObjes1 = list2Tree(t -> t.getPid(), testObjes, "0");
    System.out.println("testObjes1 = " + testObjes1);
  }
}