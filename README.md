Spring Boot MyBatis ![alt tag](https://api.travis-ci.org/phishman3579/java-algorithms-implementation.svg?branch=master)
==============================

This is Spring Boot MyBatis development templates.

# Table of Contents
+ [springboot mybatis](#https://github.com/loveisontheway/springboot-mybatis#springboot-mybatis)
  - [procedure](https://github.com/loveisontheway/springboot-mybatis#procedure)
    1. [ProjectConstant](https://github.com/loveisontheway/springboot-mybatis#ProjectConstant)
    1. [CodeGenerator](https://github.com/loveisontheway/springboot-mybatis#CodeGenerator)
+ [Share](https://github.com/loveisontheway/springboot-mybatis#Share)

# springboot mybatis
MyBatis是持久层框架，基于Spring Boot的Mybatis，嵌入MyBatis Generator插件，该插件结合Freemarker+Swagger,实现了自动创建实体类、接口、接口实现类、数据传输类、SQL映射文件、Controller类、RESTful接口API文档。

## procedure

### ProjectConstant
`ProjectConstant`类是配置自动生成的包路径位置。

| name | description |
| :------ | :------ |
| domain | 实体类 |
| mapper | Mapper接口，相当于DAO |
| service | Service接口 |
| impl | ServiceImpl接口实现类，业务逻辑处理 |
| dto | 数据传输对象，domain扩展类 |
| web | 相当于controller层 |

```java
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
```

### CodeGenerator
`CodeGenerator`类是MyBatis Generator自动生成代码器，直接运行Main方法即可。
```java
public static void main(String[] args) {
    /**
     * 单表名
     * 元素1: 表名 [不可为空，与MySQL表名保持一致]
     * 元素2: 自定义名称 [""或null 表示直接引用'元素1']
     * 元素3: 类注释描述 [""或null 表示无注释]
     * 元素4: 主键数据类型 [不可为空，默认Integer]
     */
    String[][] arrNames = {{"md_administrative_region", "", "行政区划", "Integer"}};
    // 多表名
/*        String[][] arrNames = {
            {"md_administrative_region", "", "行政区划", "Integer"},
            {"sm_application", null, "应用中心", "String"},
            {"sm_application_module", null, "模块应用", "String"},
            {"sm_module_function", "SmModuleFunctionTest", "模块管理", "String"}
    };*/
    genCode(arrNames);
}
```

# Share
* WEB: https://www.helloweba.net/nav.html
* JAVA: http://ifeve.com/
