package cn.zm.mybatis.base;

import cn.hutool.core.convert.Convert;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Objects;
import java.util.Optional;

/** 功能描述: <br>
 * <基础controller>
 *
 * @author 十渊
 * @date 2021/10/12 13:28
 * @return
 */
@Slf4j
public class  BaseController {
    private final static String PAGE = "page";

    private final static String SIZE = "size";

    private final static String ORDER_BY_COLUMN = "orderByColumn";

    private final static String IS_DESC = "isDesc";

    /**
     * 分页查询
     *
     * @return 分页对象
     */
    protected <T> IPage<T> getPage() {
        HttpServletRequest request = getRequest();
        log.debug("当前页数: [{}], 每页数量: [{}], 排序字段: [{}], 是否降序: [{}]",
                request.getParameter(PAGE),
                request.getParameter(SIZE),
                request.getParameter(ORDER_BY_COLUMN),
                request.getParameter(IS_DESC));
        Integer page = Convert.toInt(request.getParameter(PAGE)) == null ? 1 : Convert.toInt(request.getParameter(PAGE));
        Integer size = Convert.toInt(request.getParameter(SIZE)) == null ? 10 : Convert.toInt(request.getParameter(SIZE));
        String orderByColumn = Convert.toStr(request.getParameter(ORDER_BY_COLUMN));
        Boolean isDesc = Convert.toBool(request.getParameter(IS_DESC));

        Page<T> iPage = new Page<>(page, size);
        if (StringUtils.isNotBlank(orderByColumn)) {
            OrderItem orderItem = Objects.isNull(isDesc) ?
              OrderItem.asc(orderByColumn) :
              isDesc ? OrderItem.desc(orderByColumn) :
                OrderItem.asc(orderByColumn);
            iPage.addOrder(orderItem);
        }
        return iPage;
    }

    private ServletRequestAttributes getAttributes() {
        RequestAttributes attributes = RequestContextHolder.getRequestAttributes();
        return (ServletRequestAttributes) attributes;
    }

    private HttpServletRequest getRequest() {
        return getAttributes().getRequest();
    }

}
