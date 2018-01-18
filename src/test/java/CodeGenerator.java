import com.google.common.base.CaseFormat;
import com.liotw.springboot.mybatis.core.ProjectConstant;
import freemarker.template.TemplateExceptionHandler;
import org.apache.commons.lang3.StringUtils;
import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.*;
import org.mybatis.generator.internal.DefaultShellCallback;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 代码生成器，根据数据表名称生成对应的Domain、Mapper、Service、Controller、DTO简化开发。
 * @author jiangjialiang on 2017/12/25
 * @version 1.0.0
 */
public class CodeGenerator {
    /** JDBC配置，请修改为你项目的实际配置 */
    private static final String JDBC_URL = "jdbc:mysql://127.0.0.1:3306/uip?useSSL=false";
    private static final String JDBC_USERNAME = "root";
    private static final String JDBC_PASSWORD = "root";
    private static final String JDBC_DIVER_CLASS_NAME = "com.mysql.jdbc.Driver";

    /** 项目在硬盘上的基础路径 */
    private static final String PROJECT_PATH = System.getProperty("user.dir");
    /** 模板位置 */
    private static final String TEMPLATE_FILE_PATH = PROJECT_PATH + "/src/test/resources/generator/template";

    /** java文件路径 */
    private static final String JAVA_PATH = "/src/main/java";
    /** 资源文件路径 */
    private static final String RESOURCES_PATH = "/src/main/resources";

    /** 生成的Service存放路径 */
    private static final String PACKAGE_PATH_SERVICE = packageConvertPath(ProjectConstant.SERVICE_PACKAGE);
    /** 生成的Service实现存放路径 */
    private static final String PACKAGE_PATH_SERVICE_IMPL = packageConvertPath(ProjectConstant.SERVICE_IMPL_PACKAGE);
    /** 生成的Controller存放路径 */
    private static final String PACKAGE_PATH_CONTROLLER = packageConvertPath(ProjectConstant.CONTROLLER_PACKAGE);
    /** 生成的DTO存放路径 */
    private static final String PACKAGE_PATH_DTO = packageConvertPath(ProjectConstant.DTO_PACKAGE);

    /** author */
    private static final String AUTHOR = "jiangjialiang";
    /** date */
    private static final String DATE = new SimpleDateFormat("yyyy/MM/dd").format(new Date());

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

    /**
     * 通过数据表名称生成代码，Domain名称通过解析数据表名称获得，下划线转大驼峰的形式。
     * 如输入表名称 "t_user_detail" 将生成 TUserDetail、TUserDetailMapper、TUserDetailService ...
     * @param arrNames 数据表名称...
     */
    public static void genCode(String[][] arrNames) {
        String tableName = null, domainName = null, description = null, pkDataType = null;
        for (int i = 0; i < arrNames.length; i++) {
            for (int j = 0; j < arrNames[i].length; j++) {
                switch (j){
                    case 0: tableName = arrNames[i][j];break;
                    case 1: domainName = arrNames[i][j];break;
                    case 2: description = arrNames[i][j];break;
                    case 3: pkDataType = arrNames[i][j];break;
                }
            }
            genCodeByCustomDomainName(tableName, domainName, description, pkDataType);
        }
    }

    /**
     * 通过数据表名称，和自定义的 domain 名称生成代码
     * 如输入表名称 "t_user_detail" 和自定义的 Domain 名称 "User" 将生成 User、UserMapper、UserService ...
     * @param tableName 数据表名称
     * @param domainName 自定义的 domain 名称
     * @param description 类注释描述
     * @param pkDataType 主键数据类型
     */
    public static void genCodeByCustomDomainName(String tableName, String domainName, String description, String pkDataType) {
        genDomainAndMapper(tableName, domainName);
        genService(tableName, domainName, description, pkDataType);
        genController(tableName, domainName, description, pkDataType);
        genDTO(tableName, domainName, description, pkDataType);
    }

    public static void genDomainAndMapper(String tableName, String domainName) {
        Context context = new Context(ModelType.FLAT);
        context.setId("Potato");
        context.setTargetRuntime("MyBatis3Simple");
        context.addProperty(PropertyRegistry.CONTEXT_BEGINNING_DELIMITER, "`");
        context.addProperty(PropertyRegistry.CONTEXT_ENDING_DELIMITER, "`");

        JDBCConnectionConfiguration jdbcConnectionConfiguration = new JDBCConnectionConfiguration();
        jdbcConnectionConfiguration.setConnectionURL(JDBC_URL);
        jdbcConnectionConfiguration.setUserId(JDBC_USERNAME);
        jdbcConnectionConfiguration.setPassword(JDBC_PASSWORD);
        jdbcConnectionConfiguration.setDriverClass(JDBC_DIVER_CLASS_NAME);
        context.setJdbcConnectionConfiguration(jdbcConnectionConfiguration);

        PluginConfiguration pluginConfiguration = new PluginConfiguration();
        pluginConfiguration.setConfigurationType("tk.mybatis.mapper.generator.MapperPlugin");
        pluginConfiguration.addProperty("mappers", ProjectConstant.MAPPER_INTERFACE_REFERENCE);
        context.addPluginConfiguration(pluginConfiguration);

        // Domain实现序列化接口
        PluginConfiguration serializablePlugin = new PluginConfiguration();
        serializablePlugin.setConfigurationType("org.mybatis.generator.plugins.SerializablePlugin");
        serializablePlugin.addProperty("domain", ProjectConstant.DTO_PACKAGE);
        context.addPluginConfiguration(serializablePlugin);

        JavaModelGeneratorConfiguration javaModelGeneratorConfiguration = new JavaModelGeneratorConfiguration();
        javaModelGeneratorConfiguration.setTargetProject(PROJECT_PATH + JAVA_PATH);
        javaModelGeneratorConfiguration.setTargetPackage(ProjectConstant.DOMAIN_PACKAGE);
        context.setJavaModelGeneratorConfiguration(javaModelGeneratorConfiguration);

        SqlMapGeneratorConfiguration sqlMapGeneratorConfiguration = new SqlMapGeneratorConfiguration();
        sqlMapGeneratorConfiguration.setTargetProject(PROJECT_PATH + RESOURCES_PATH);
        sqlMapGeneratorConfiguration.setTargetPackage("mybatis/mapper");
        context.setSqlMapGeneratorConfiguration(sqlMapGeneratorConfiguration);

        JavaClientGeneratorConfiguration javaClientGeneratorConfiguration = new JavaClientGeneratorConfiguration();
        javaClientGeneratorConfiguration.setTargetProject(PROJECT_PATH + JAVA_PATH);
        javaClientGeneratorConfiguration.setTargetPackage(ProjectConstant.MAPPER_PACKAGE);
        javaClientGeneratorConfiguration.setConfigurationType("XMLMAPPER");
        context.setJavaClientGeneratorConfiguration(javaClientGeneratorConfiguration);

        TableConfiguration tableConfiguration = new TableConfiguration(context);
        tableConfiguration.setTableName(tableName);
        if (StringUtils.isNotEmpty(domainName))tableConfiguration.setDomainObjectName(domainName);
        tableConfiguration.setGeneratedKey(new GeneratedKey("id", "Mysql", true, null));
        context.addTableConfiguration(tableConfiguration);

        List<String> warnings;
        MyBatisGenerator generator;
        try {
            Configuration config = new Configuration();
            config.addContext(context);
            config.validate();

            boolean overwrite = true;
            DefaultShellCallback callback = new DefaultShellCallback(overwrite);
            warnings = new ArrayList<String>();
            generator = new MyBatisGenerator(config, callback, warnings);
            generator.generate(null);
        } catch (Exception e) {
            throw new RuntimeException("生成Domain和Mapper失败", e);
        }

        if (generator.getGeneratedJavaFiles().isEmpty() || generator.getGeneratedXmlFiles().isEmpty()) {
            throw new RuntimeException("生成Domain和Mapper失败：" + warnings);
        }
        if (StringUtils.isEmpty(domainName)) domainName = tableNameConvertUpperCamel(tableName);
        System.out.println(domainName + ".java 生成成功");
        System.out.println(domainName + "Mapper.java 生成成功");
        System.out.println(domainName + "Mapper.xml 生成成功");
    }

    public static void genService(String tableName, String domainName, String description, String pkDataType) {
        try {
            freemarker.template.Configuration cfg = getConfiguration();

            Map<String, Object> data = new HashMap<>();
            String desc = StringUtils.isEmpty(description) ? "" : description;
            data.put("description", desc);
            data.put("date", DATE);
            data.put("author", AUTHOR);
            data.put("pkDataType", pkDataType);
            String domainNameUpperCamel = StringUtils.isEmpty(domainName) ? tableNameConvertUpperCamel(tableName) : domainName;
            data.put("domainNameUpperCamel", domainNameUpperCamel);
            data.put("domainNameLowerCamel", tableNameConvertLowerCamel(tableName));
            data.put("basePackage", ProjectConstant.BASE_PACKAGE);

            File file = new File(PROJECT_PATH + JAVA_PATH + PACKAGE_PATH_SERVICE + domainNameUpperCamel + "Service.java");
            if (!file.getParentFile().exists()) {
                file.getParentFile().mkdirs();
            }
            cfg.getTemplate("service.ftl").process(data,
                    new FileWriter(file));
            System.out.println(domainNameUpperCamel + "Service.java 生成成功");

            File file1 = new File(PROJECT_PATH + JAVA_PATH + PACKAGE_PATH_SERVICE_IMPL + domainNameUpperCamel + "ServiceImpl.java");
            if (!file1.getParentFile().exists()) {
                file1.getParentFile().mkdirs();
            }
            cfg.getTemplate("service-impl.ftl").process(data, new FileWriter(file1));
            System.out.println(domainNameUpperCamel + "ServiceImpl.java 生成成功");
        } catch (Exception e) {
            throw new RuntimeException("生成Service失败", e);
        }
    }

    public static void genController(String tableName, String domainName, String description, String pkDataType) {
        try {
            freemarker.template.Configuration cfg = getConfiguration();

            Map<String, Object> data = new HashMap<>();
            String desc = StringUtils.isEmpty(description) ? "" : description;
            data.put("description", desc);
            data.put("date", DATE);
            data.put("author", AUTHOR);
            data.put("pkDataType", pkDataType);
            String domainNameUpperCamel = StringUtils.isEmpty(domainName) ? tableNameConvertUpperCamel(tableName) : domainName;
            data.put("baseRequestMapping", domainNameConvertMappingPath(domainNameUpperCamel));
            data.put("domainNameUpperCamel", domainNameUpperCamel);
            data.put("domainNameLowerCamel", CaseFormat.UPPER_CAMEL.to(CaseFormat.LOWER_CAMEL, domainNameUpperCamel));
            data.put("basePackage", ProjectConstant.BASE_PACKAGE);

            File file = new File(PROJECT_PATH + JAVA_PATH + PACKAGE_PATH_CONTROLLER + domainNameUpperCamel + "Controller.java");
            if (!file.getParentFile().exists()) {
                file.getParentFile().mkdirs();
            }
            cfg.getTemplate("controller.ftl").process(data, new FileWriter(file));
            System.out.println(domainNameUpperCamel + "Controller.java 生成成功");
        } catch (Exception e) {
            throw new RuntimeException("生成Controller失败", e);
        }

    }

    public static void genDTO(String tableName, String domainName, String description, String pkDataType) {
        try {
            freemarker.template.Configuration cfg = getConfiguration();

            Map<String, Object> data = new HashMap<>();
            String desc = StringUtils.isEmpty(description) ? "" : description;
            data.put("description", desc);
            data.put("date", DATE);
            data.put("author", AUTHOR);
            String domainNameUpperCamel = StringUtils.isEmpty(domainName) ? tableNameConvertUpperCamel(tableName) : domainName;
            data.put("baseRequestMapping", domainNameConvertMappingPath(domainNameUpperCamel));
            data.put("domainNameUpperCamel", domainNameUpperCamel);
            data.put("domainNameLowerCamel", CaseFormat.UPPER_CAMEL.to(CaseFormat.LOWER_CAMEL, domainNameUpperCamel));
            data.put("basePackage", ProjectConstant.BASE_PACKAGE);

            File file = new File(PROJECT_PATH + JAVA_PATH + PACKAGE_PATH_DTO + domainNameUpperCamel + "DTO.java");
            if (!file.getParentFile().exists()) {
                file.getParentFile().mkdirs();
            }
            cfg.getTemplate("dto.ftl").process(data, new FileWriter(file));
            System.out.println(domainNameUpperCamel + "DTO.java 生成成功");
        } catch (Exception e) {
            throw new RuntimeException("生成DTO失败", e);
        }

    }

    private static freemarker.template.Configuration getConfiguration() throws IOException {
        freemarker.template.Configuration cfg = new freemarker.template.Configuration(freemarker.template.Configuration.VERSION_2_3_23);
        cfg.setDirectoryForTemplateLoading(new File(TEMPLATE_FILE_PATH));
        cfg.setDefaultEncoding("UTF-8");
        cfg.setTemplateExceptionHandler(TemplateExceptionHandler.IGNORE_HANDLER);
        return cfg;
    }

    private static String tableNameConvertLowerCamel(String tableName) {
        return CaseFormat.LOWER_UNDERSCORE.to(CaseFormat.LOWER_CAMEL, tableName.toLowerCase());
    }

    private static String tableNameConvertUpperCamel(String tableName) {
        return CaseFormat.LOWER_UNDERSCORE.to(CaseFormat.UPPER_CAMEL, tableName.toLowerCase());
    }

    private static String tableNameConvertMappingPath(String tableName) {
        tableName = tableName.toLowerCase();//兼容使用大写的表名
//        return "/" + (tableName.contains("_") ? tableName.replaceAll("_", "/") : tableName);
        return "/" + CaseFormat.LOWER_UNDERSCORE.to(CaseFormat.LOWER_CAMEL, tableName);
    }

    private static String domainNameConvertMappingPath(String domainName) {
        String tableName = CaseFormat.UPPER_CAMEL.to(CaseFormat.LOWER_UNDERSCORE, domainName);
        return tableNameConvertMappingPath(tableName);
    }

    private static String packageConvertPath(String packageName) {
        return String.format("/%s/", packageName.contains(".") ? packageName.replaceAll("\\.", "/") : packageName);
    }

}
