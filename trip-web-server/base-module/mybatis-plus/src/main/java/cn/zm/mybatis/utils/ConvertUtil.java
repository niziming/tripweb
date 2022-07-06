package cn.zm.mybatis.utils;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class ConvertUtil {
    /**
     * 获取 vo 分页数据
     *
     * @param page do 分页数据
     * @return vo 分页数据
     */
    public static <T, E extends ObjectConvert> IPage<T> buildPage(IPage<E> page) {
        IPage<T> pageViews = new Page<>();
        BeanUtil.copyProperties(page, pageViews);
        pageViews.setRecords(page.getRecords()
               .stream()
               .map(e -> (T)e.convert())
               .collect(Collectors.toList()));
        return pageViews;
    }


    /** 功能描述: <br>
     * <批量转换VO>
     *
     * @param list
     *
     * @author 十渊
     * @date 2022/1/11 10:32
     * @return java.util.List<T>
     */
    public static <T, E extends ObjectConvert> List<T> list(List<E> list) {
        List<T> result = new ArrayList<>();
        if (Objects.nonNull(list) && !list.isEmpty()) {
            result = list.stream().map(e -> (T)e.convert()).collect(Collectors.toList());
        }
        return result;
    }
}
