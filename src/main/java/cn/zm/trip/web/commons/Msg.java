package cn.zm.trip.web.commons;

public class Msg {
	private String msg;
	private int status;
	private static final int STATUS_SUCCESS = 200;
	private static final int STATUS_FAIL = 500;

	public Msg(String msg) {
		this.msg = msg;
	}

	private Msg(int status,String msg) {
		this.status = status;
		this.msg = msg;
	}

	private Msg(int status) {
		this.status = status;
	}

	public Msg() {
	}

	public static Msg success(String msg){
		return new Msg(STATUS_SUCCESS,msg);
	}

	public static Msg success(){
		return new Msg(STATUS_SUCCESS);
	}

	public static Msg fail(String msg){
		return new Msg(STATUS_FAIL,msg);
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return msg;
	}
}
