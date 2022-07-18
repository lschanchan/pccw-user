package com.pccw.user.common;

/**
 *
 **/
public class ApiResponse<T> {

	private Integer errorcode;

	private String errmsg;

	private T data;

	public static <T> ApiResponse<T> buildSuccess() {
		return buildResponse(BizCodeEnum.SUCCESS);
	}

	public static <T> ApiResponse<T> buildSuccess(T t) {
		ApiResponse<T> response = buildResponse(BizCodeEnum.SUCCESS);
		response.setData(t);
		return response;
	}

	public static <T> ApiResponse<T> buildFail() {
		return buildResponse(BizCodeEnum.UN_KNOWN);
	}

	public static <T> ApiResponse<T> buildIllegalParam() {
		return buildResponse(BizCodeEnum.ILLEGAL_PARAM);
	}

	public static <T> ApiResponse<T> buildFail(String message) {
		return buildFail(BizCodeEnum.UN_KNOWN.getCode(), message);
	}

	public static <T> ApiResponse<T> buildFail(Integer code, String message) {
		ApiResponse<T> response = new ApiResponse<>();
		response.setErrorcode(code);
		response.setErrmsg(message);
		return response;
	}

	public static <T> ApiResponse<T> buildResponse(BizCodeEnum bizCodeEnum) {
		ApiResponse<T> response = new ApiResponse<>();
		response.setErrorcode(bizCodeEnum.getCode());
		response.setErrmsg(bizCodeEnum.getName());
		return response;
	}



	public boolean isSuccess() {
		return BizCodeEnum.SUCCESS.getCode().equals(errorcode);
	}

	public Integer getErrorcode() {
		return errorcode;
	}

	public void setErrorcode(Integer errorcode) {
		this.errorcode = errorcode;
	}

	public String getErrmsg() {
		return errmsg;
	}

	public void setErrmsg(String errmsg) {
		this.errmsg = errmsg;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

}
