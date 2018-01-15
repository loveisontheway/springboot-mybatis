package com.liotw.springboot.mybatis.constants;

public class Constant {

	/**
	 * @Fields MODULE_FUNCTION_TYPE_MENU : 1：菜单类型
	 */
	public static final char MODULE_FUNCTION_TYPE_MENU = '1';
	
	/**
	 * @Fields MODULE_FUNCTION_TYPE_COMPONENT : 2：组件
	 */
	public static final char MODULE_FUNCTION_TYPE_COMPONENT = '2';
	
	/**
	 * @Fields MODULE_FUNCTION_TYPE_PAGE : 3：页面
	 */
	public static final char MODULE_FUNCTION_TYPE_PAGE = '3';
	/**
	 * @Fields MODULE_FUNCTION_TYPE_PAGE : 4：页面
	 */
	public static final char MODULE_FUNCTION_TYPE_BUTTON = '4';

	
	/**
	 * @Fields RESULT_CODE_SUCCESS : 返回码成功
	 */
	public static final int RESULT_CODE_SUCCESS = 1;
	
	/**
	 * @Fields RESULT_CODE_FAILURE : 返回码失败
	 */
	public static final int RESULT_CODE_FAILURE = 0;
	/**
	 * @Fields RESULT_CODE_EXCEPTION : 请求抛出异常
	 */
	public static final int RESULT_CODE_EXCEPTION = 1002; 
	
	/**
	 * @Fields RESULT_CODE_NOT_LOGIN : 未登陆状态
	 */
	public static final int RESULT_CODE_NOT_LOGIN = 1003; 
	
	/**
	 * @Fields RESULT_CODE_NO_EXISTS : 查询结果为空
	 */
	public static final int RESULT_CODE_NO_EXISTS = 1004; 
	
	/**
	 * @Fields RESULT_CODE_NOT_AUTHORIZED : 无操作权限
	 */
	public static final int RESULT_CODE_NOT_AUTHORIZED = 1005; 

	/**
	 * @Fields RESULT_CODE_USER_OR_PASSWORD_ERROR : 返回码 用户名或密码错误
	 */
	public static final int RESULT_CODE_USER_OR_PASSWORD_ERROR = 1006; 
	
	//
	/**
	 * @Fields RESULT_CODE_MAX_PASSWORD_ERROR_COUNT : 返回码 密码错误次数达到上限
	 */
	public static final int RESULT_CODE_MAX_PASSWORD_ERROR_COUNT = 1007;
	
	/**
	 * @Fields RESULT_CODE_ILLEGAL_REQUEST : 非法请求返回码 未登录 或跳过登陆的请求
	 */
	public static final int  RESULT_CODE_ILLEGAL_REQUEST = 1008;
	
	/**
	 * @Fields RESULT_CODE_PARAMS_EMPTY : 返回码 必填参数为空
	 */
	public static final int  RESULT_CODE_PARAMS_EMPTY = 1009;
	
	/**
	 * @Fields RESULT_MSG_SUCCESS : 返回消息 成功
	 */
	public static final String RESULT_MSG_SUCCESS = "Success";
	
	/**
	 * @Fields RESULT_MSG_FAILURE : 返回消息 失败
	 */
	public static final String RESULT_MSG_FAILURE = "Failure";	
	
	/**
	 * @Fields RESULT_MSG_USER_OR_PASSWORD_ERROR : 返回消息  用户名或密码错误
	 */
	public static final String RESULT_MSG_USER_OR_PASSWORD_ERROR = "username or password Invalid"; 
	
	/**
	 * @Fields RESULT_MSG_MAX_PASSWORD_ERROR_COUNT : 返回消息 密码错误次数达到上限
	 */
	public static final String RESULT_MSG_MAX_PASSWORD_ERROR_COUNT = "upper limit for password error";
	
	/**
	 * @Fields RESULT_MSG_ILLEGAL_REQUEST : 非法请求返回码 未登录 或跳过登陆的请求
	 */
	public static final String  RESULT_MSG_ILLEGAL_REQUEST = "Illegal request";
     
	/**
	 * @Fields RESULT_MSG_EXCEPTION : 返回消息 请求抛出异常
	 */
	public static final String RESULT_MSG_EXCEPTION = "request exception";
	
	/**
	 * @Fields RESULT_MSG_PARAMS_EMPTY : 返回消息 必填参数为空
	 */
	public static final String  RESULT_MSG_PARAMS_EMPTY = "the input parameter is null";
	
	
	/**
	 * @Fields MODULE_STATUS_ENABLE : 模块状态：1 激活
	 */
	public static final int MODULE_STATUS_ENABLE = 1;
	
	/**
	 * @Fields MODULE_STATUS_DISABLE :模块状态：0 禁用
	 */
	public static final int MODULE_STATUS_DISABLE = 0;

	/**
	 * 一级菜单的父ID缺省值
	 */
	public static final String ROOT_MENU_PID = "0";
}
