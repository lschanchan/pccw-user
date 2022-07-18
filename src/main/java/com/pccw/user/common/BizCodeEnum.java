package com.pccw.user.common;

/**
 *
 **/
public enum BizCodeEnum {
	/**
	 * 统一业务编码
	 */
	SUCCESS(0, "成功"),
	UN_KNOWN(-99, "系统异常"),
	BIZ_ERROR(-100, "业务异常"),


	ILLEGAL_PARAM(11, "参数错误"),


	;
	private final Integer code;
	private final String name;

	BizCodeEnum(Integer code, String name) {
		this.code = code;
		this.name = name;
	}

	public Integer getCode() {
		return code;
	}

	public String getName() {
		return name;
	}
}
