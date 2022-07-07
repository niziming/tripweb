package cn.zm.common.enums;

/** 功能描述: <br>
 * <统一枚举>
 *
 * @author 十渊
 * @date 2021/10/27 17:28
 * @return
 */
public enum ResEnum {
	// 请求错误
	FAIL(1000, "请求错误"),
	CHECK_FAIL(1001, "验证失败"),
	BUSINESS_FAIL(1002, "网络异常"),
	INVALID_PARAMS(1003, "请求参数错误"),
	DATA_EXCEPTION(1004, "数据异常"),
	SUCCESS(2000, "操作成功"),
	SERVER_ERR(5000, "服务异常")
	;

	private int		code;
	private String	msg;
	private Object	data;

	ResEnum(int code) {
		this.code = code;
	}

	ResEnum(int code, String msg) {
		this.code = code;
		this.msg = msg;
	}

	public String getMsg() {
		return msg;
	}

	public int getCode() {
		return code;
	}
}
