package cn.zm.common.utils;


import cn.zm.common.base.ServiceException;
import cn.zm.common.enums.ResEnum;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * 断言工具类
 */
public class AssertUtil {

    public  static void assertNonNull(Object obj, ResEnum resEnum){
        if(obj == null ){
            throw new ServiceException(resEnum);
        }
        if(obj instanceof List){
            List list = (List) obj;
            if(list == null || list.size() == 0 ){
                throw new ServiceException(resEnum);
            }
        }
    }
    /**
     * Title: assertNull </br>
     * Description:  断言对象为空，如果不为空抛出异常  </br>
     * @author 周扬
     * @date 2021/9/7 9:17
     * @param obj  断言对象
     * @param resEnum  异常编码
     */
    public  static void assertNull(Object obj, ResEnum resEnum){
        if(obj == null ){
           return;
        }
        if(obj instanceof List){
            List list = (List) obj;
            if(list != null && list.size() > 0  ){
                throw new ServiceException(resEnum);
            }
        }

    }

    /**
     * Title: assertNotEmpty </br>
     * Description:  断言数组不为空，如果为空抛出异常  </br>
     *
     * @param list          断言数组
     * @param resEnum 异常编码
     * @author 十渊Jermaine
     * @date 2021/12/2 9:17
     */
    public static <T> void assertNotEmpty(List<T> list, ResEnum resEnum) {
        if (Objects.nonNull(list) && 0 < list.size()) {
            return;
        }
        if (list.isEmpty()) {
            throw new ServiceException(resEnum);
        }
    }
    /**
     * Title: assertNotEmpty </br>
     * Description:  断言数组为空，如果不为空抛出异常  </br>
     *
     * @param list          断言数组
     * @param resEnum 异常编码
     * @author 十渊Jermaine
     * @date 2021/12/2 9:17
     */
    public static <T> void assertEmpty(List<T> list, ResEnum resEnum) {
        if ( list.isEmpty() || (0 == list.size())) {
            return;
        }
        if (0 < list.size()) {
            throw new ServiceException(resEnum);
        }
    }

    /**
     * Title: assertTrue <br>
     * Description: 断言为真，为空抛出异常<br>
     *
     * @param flag           断言对象    </br>
     * @param resEnum 异常编码   </br>
     * @author 十渊Jermaine   </br>
     * @date 2022年5月12日   </br>
     */
    public static void assertTrue(Boolean flag, ResEnum resEnum) {
        if (!flag) {
            throw new ServiceException(resEnum);
        }
    }

    /**
     * Title: assertAllTrue <br>
     * Description: 断言全部为真，为空抛出异常<br>
     *
     * @param flag           断言对象    </br>
     * @param resEnum 异常编码   </br>
     * @author 十渊Jermaine   </br>
     * @date 2022年5月12日   </br>
     */
    public static void assertAllTrue( ResEnum resEnum, Boolean ...flag) {
        if (Objects.isNull(flag) || flag.length == 0 || Arrays.stream(flag).anyMatch(f -> f.equals(false)))
            throw new ServiceException(resEnum);

    }

    /**
     * Title: assertAllFalse <br>
     * Description: 断言全部为假，为空抛出异常<br>
     *
     * @param flag           断言对象    </br>
     * @param resEnum 异常编码   </br>
     * @author 十渊Jermaine   </br>
     * @date 2022年5月12日   </br>
     */
    public static void assertAllFalse( ResEnum resEnum, Boolean ...flag) {
        if (Objects.isNull(flag) || flag.length == 0 || Arrays.stream(flag).anyMatch(f -> f.equals(true)))
            throw new ServiceException(resEnum);

    }

    /**
     * Title: assertFalse <br>
     * Description: 断言为假，为空抛出异常<br>
     *
     * @param flag           断言对象    </br>
     * @param resEnum 异常编码   </br>
     * @author 十渊Jermaine   </br>
     * @date 2022年5月12日   </br>
     */
    public static void assertFalse(Boolean flag, ResEnum resEnum) {
        if (flag) {
            throw new ServiceException(resEnum);
        }
    }

}
