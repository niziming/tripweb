package cn.zm.common.base;

import cn.zm.common.enums.ResEnum;
import lombok.Data;

/** 功能描述: <br>
 * <统一返回类>
 *
 * @author 十渊
 * @date 2021/10/27 17:27
 * @return
 */
@Data
public class ResResult<T> {

    private Integer code;
    private String msg;
    private T data;

    private ResResult(){
    }

    private ResResult(ResEnum resEnum, T data){
        this.code = resEnum.getCode();
        this.msg = resEnum.getMsg();
        this.data = data;
    }

    private ResResult(Integer code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public static <T> ResResult<T> fail(T data){
        return new ResResult<>(ResEnum.FAIL, data);

    }

    public static <T> ResResult<T> succ(T data){
        return new ResResult<>(ResEnum.SUCCESS, data);
    }
    public static <T> ResResult<T> succ(){
        return new ResResult<>(ResEnum.SUCCESS, null);
    }
}
