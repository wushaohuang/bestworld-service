package com.starter.common.lang;

import lombok.Data;

import java.io.Serializable;

@Data
public class Response implements Serializable {

	// 状态码
	private int code;
	// 提示信息
	private String msg;
	// 查询到的结果数据
	private Object data;

	public static Response succ(Object data) {
		return succ(200, "操作成功", data);
	}

	public static Response succ(int code, String msg, Object data) {
		Response r = new Response();
		r.setCode(code);
		r.setMsg(msg);
		r.setData(data);
		return r;
	}

	public static Response fail(String msg) {
		return fail(400, msg, null);
	}

	public static Response fail(int code, String msg, Object data) {
		Response r = new Response();
		r.setCode(code);
		r.setMsg(msg);
		r.setData(data);
		return r;
	}

}
