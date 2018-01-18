package com.liotw.springboot.mybatis.core;

/**
 * 项目常量
 * @author jiangjialiang on 2017/12/25
 * @version 1.0.0
 */
public final class ProjectConstant {
    /** 项目基础包名称，根据项目修改 */
    public static final String BASE_PACKAGE = "com.liotw.springboot.mybatis";
    /** Domain所在包 */
    public static final String DOMAIN_PACKAGE = BASE_PACKAGE + ".domain";
    /** Mapper所在包 */
    public static final String MAPPER_PACKAGE = BASE_PACKAGE + ".mapper";
    /** Service所在包 */
    public static final String SERVICE_PACKAGE = BASE_PACKAGE + ".service";
    /** ServiceImpl所在包 */
    public static final String SERVICE_IMPL_PACKAGE = SERVICE_PACKAGE + ".impl";
    /** DTO所在包 */
    public static final String DTO_PACKAGE = BASE_PACKAGE + ".dto";
    /** Controller所在包 */
    public static final String CONTROLLER_PACKAGE = BASE_PACKAGE + ".web";
    /** Mapper插件基础接口的完全限定名 */
    public static final String MAPPER_INTERFACE_REFERENCE = BASE_PACKAGE + ".core.Mapper";
}
