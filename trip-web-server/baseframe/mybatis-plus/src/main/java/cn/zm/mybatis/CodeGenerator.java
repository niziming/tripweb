package cn.zm.mybatis;

import cn.zm.mybatis.utils.ObjectConvert;
import com.baomidou.mybatisplus.core.exceptions.MybatisPlusException;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.config.YamlPropertiesFactoryBean;
import org.springframework.core.io.ClassPathResource;

import java.util.*;

/** 功能描述: <br>
 * <逆向工程生成类>
 *
 * @author 十渊
 * @date 2021/10/12 13:29
 * @return
 */
public class CodeGenerator {
    private static YamlPropertiesFactoryBean factoryBean = new YamlPropertiesFactoryBean();;
    private static Properties object;
    private static String driver;
    private static String url;
    private static String username;
    private static String password;
    private static String packageName;
    private static String module;
    // 代码生成器
    private static AutoGenerator mpg;
    // 全局配置
    private static GlobalConfig gc;
    private static TemplateConfig templateConfig;
    private static String projectPath = System.getProperty("user.dir");

    static {
        templateConfig = new TemplateConfig();

        // 配置自定义输出模板
        //指定自定义模板路径，注意不要带上.ftl/.vm, 会根据使用的模板引擎自动识别
        // templateConfig.setEntity("templates/entity2.java");
        // templateConfig.setService();
        // templateConfig.setController();
        templateConfig.setEntity("/templates/code/entity.java");
        templateConfig.setMapper("/templates/code/mapper.java");
        templateConfig.setService("/templates/code/service.java");
        templateConfig.setServiceImpl("/templates/code/serviceImpl.java");
        templateConfig.setController("/templates/code/controller.java");
        templateConfig.setXml(null);
    }

    public static void main(String[] args) {
        String[] tables = scanner("表名，多个英文逗号分割").split(",");
        ClassPathResource app = new ClassPathResource("gen.yml");
        ClassPathResource[] apps = new ClassPathResource[]{app};

        factoryBean.setResources(apps);
        object = factoryBean.getObject();
        driver = object.getProperty("spring.datasource.driver-class-name");
        url = object.getProperty("spring.datasource.url");
        username = object.getProperty("spring.datasource.username");
        password = object.getProperty("spring.datasource.password");
        packageName = object.getProperty("mybatis-plus.generate.package");
        module = object.getProperty("mybatis-plus.generate.module");
        // 代码生成器
        mpg = new AutoGenerator();
        // 全局配置
        gc = new GlobalConfig();

        genDO(tables);
        genDTO(tables);
        genVO(tables);
    }
    /**
     * <p>
     * 读取控制台内容
     * </p>
     */
    public static String scanner(String tip) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入" + tip + "：");
        if (scanner.hasNext()) {
            String ipt = scanner.next();
            if (StringUtils.isNotBlank(ipt)) {
                return ipt;
            }
        }
        throw new MybatisPlusException("请输入正确的" + tip + "！");
    }
    private static void genDO(String[] tables, ClassPathResource... apps) {
        // YamlPropertiesFactoryBean factoryBean = new YamlPropertiesFactoryBean();
        // factoryBean.setResources(apps);
        // Properties object = factoryBean.getObject();
        // String driver = object.getProperty("spring.datasource.driver-class-name");
        // String url = object.getProperty("spring.datasource.url");
        // String username = object.getProperty("spring.datasource.username");
        // String password = object.getProperty("spring.datasource.password");
        // String packageName = object.getProperty("mybatis-plus.generate.package");
        //
        // // 代码生成器
        // AutoGenerator mpg = new AutoGenerator();
        //
        // // 全局配置
        // GlobalConfig gc = new GlobalConfig();
        // String projectPath = System.getProperty("user.dir");
        gc.setOutputDir(projectPath + '/' + module + "/src/main/java");
        gc.setAuthor("十渊");
        gc.setOpen(false);
        gc.setSwagger2(true); //实体属性 Swagger2 注解

        gc.setEntityName("%s");
        //gc.setMapperName("%sMapper");
        //gc.setXmlName("%sMapper");
        //gc.setServiceName("%sService");
        //gc.setServiceImplName("%sServiceImpl");
        // gc.setControllerName("%rest");
        mpg.setGlobalConfig(gc);

        // 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setUrl(url);
        dsc.setDriverName(driver);
        dsc.setUsername(username);
        dsc.setPassword(password);
        mpg.setDataSource(dsc);

        // 包配置
        PackageConfig pc = new PackageConfig();
        pc.setModuleName("web");
        pc.setParent(packageName);
        pc.setEntity("entity");
        pc.setController("rest");
        pc.setService("service");
        pc.setServiceImpl("service.impl");
        pc.setMapper("mapper");
        mpg.setPackageInfo(pc);

        // 自定义配置
        InjectionConfig cfg = new InjectionConfig() {
            @Override
            public void initMap() {
                // to do nothing
            }
        };

        // 如果模板引擎是 freemarker
        String templatePath = "/templates/code/mapper.xml.ftl";
        // 如果模板引擎是 velocity
        // String templatePath = "/templates/mapper.xml.vm";

        // 自定义输出配置
        List<FileOutConfig> focList = new ArrayList<>();
        // 自定义配置会被优先输出
        focList.add(new FileOutConfig(templatePath) {
            @Override
            public String outputFile(TableInfo tableInfo) {
                // 自定义输出文件名 ， 如果你 Entity 设置了前后缀、此处注意 xml 的名称会跟着发生变化！！
                //return projectPath + "/src/main/resources/mapper/" + pc.getModuleName()
                return projectPath + '/' + module + "/src/main/resources/mapper/"
                        + "/" + tableInfo.getEntityName() + "Mapper" + StringPool.DOT_XML;
            }
        });
         /*
         cfg.setFileCreate(new IFileCreate() {
             @Override
             public boolean isCreate(ConfigBuilder configBuilder, FileType fileType, String filePath) {
                 // 判断自定义文件夹是否需要创建
                 checkDir("调用默认方法创建的目录，自定义目录用");
                 if (fileType == FileType.MAPPER) {
                     // 已经生成 mapper 文件判断存在，不想重新生成返回 false
                     return !new File(filePath).exists();
                 }
                 // 允许生成模板文件
                 return true;
             }
         });
         */
        cfg.setFileOutConfigList(focList);
        mpg.setCfg(cfg);

        // // 配置模板
        // templateConfig = new TemplateConfig();
        //
        // // 配置自定义输出模板
        // //指定自定义模板路径，注意不要带上.ftl/.vm, 会根据使用的模板引擎自动识别
        // // templateConfig.setEntity("templates/entity2.java");
        // // templateConfig.setService();
        // // templateConfig.setController();
        // templateConfig.setEntity("/templates/code/entity.java");
        // templateConfig.setMapper("/templates/code/mapper.java");
        // templateConfig.setService("/templates/code/service.java");
        // templateConfig.setServiceImpl("/templates/code/serviceImpl.java");
        // templateConfig.setController("/templates/code/controller.java");
        // templateConfig.setXml(null);
        mpg.setTemplate(templateConfig);

        // 策略配置
        StrategyConfig strategy = new StrategyConfig();
        strategy.setNaming(NamingStrategy.underline_to_camel);
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
        strategy.setSuperEntityClass(ObjectConvert.class);
        strategy.setEntityLombokModel(true);
        strategy.setRestControllerStyle(true);
        // 公共父类
        strategy.setSuperControllerClass("cn.zm.plus.base.BaseController");
        // 写于父类中的公共字段
        //strategy.setSuperEntityColumns("id");
        strategy.setInclude(tables);
        //strategy.setInclude(new String[]{"account", "student"});
        strategy.setControllerMappingHyphenStyle(true);
        strategy.setTablePrefix(pc.getModuleName() + "_");
        mpg.setStrategy(strategy);
        mpg.setTemplateEngine(new FreemarkerTemplateEngine());
        mpg.execute();
    }
    private static void genDTO(String[] tables) {
        gc.setOutputDir(projectPath + '/' + module + "/src/main/java");
        gc.setAuthor("十渊");
        gc.setOpen(false);
        gc.setSwagger2(true); //实体属性 Swagger2 注解
        gc.setEntityName("%sDTO");

        // 代码生成器
        AutoGenerator mpg = new AutoGenerator();
        mpg.setGlobalConfig(gc);

        // 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setUrl(url);
        dsc.setDriverName(driver);
        dsc.setUsername(username);
        dsc.setPassword(password);
        mpg.setDataSource(dsc);

        // 包配置
        PackageConfig pc = new PackageConfig();
        pc.setModuleName("web");
        pc.setParent(packageName);
        pc.setEntity("entity.dto");
        pc.setController("rest");
        mpg.setPackageInfo(pc);

        // 自定义配置
        InjectionConfig cfg = new InjectionConfig() {
            @Override
            public void initMap() {
                // to do nothing
            }
        };

        mpg.setTemplate(templateConfig);

        // 策略配置
        StrategyConfig strategy = new StrategyConfig();
        strategy.setNaming(NamingStrategy.underline_to_camel);
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
        strategy.setSuperEntityClass(ObjectConvert.class);
        strategy.setEntityLombokModel(true);
        strategy.setRestControllerStyle(true);
        // 公共父类
        strategy.setSuperControllerClass(packageName + ".config." +"BaseController");
        // 写于父类中的公共字段
        //strategy.setSuperEntityColumns("id");
        strategy.setInclude(tables);
        //strategy.setInclude(new String[]{"account", "student"});
        strategy.setControllerMappingHyphenStyle(true);
        strategy.setTablePrefix(pc.getModuleName() + "_");
        mpg.setStrategy(strategy);
        mpg.setTemplateEngine(new FreemarkerTemplateEngine());
        mpg.execute();
    }
    private static void genVO(String[] tables) {
        gc.setOutputDir(projectPath + '/' + module + "/src/main/java");
        gc.setAuthor("十渊");
        gc.setOpen(false);
        gc.setSwagger2(true); //实体属性 Swagger2 注解
        gc.setEntityName("%sVO");

        AutoGenerator mpg = new AutoGenerator();
        mpg.setGlobalConfig(gc);

        // 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setUrl(url);
        dsc.setDriverName(driver);
        dsc.setUsername(username);
        dsc.setPassword(password);
        mpg.setDataSource(dsc);

        // 包配置
        PackageConfig pc = new PackageConfig();
        pc.setModuleName("web");
        pc.setParent(packageName);
        pc.setEntity("entity.vo");
        pc.setController("rest");

        mpg.setPackageInfo(pc);

        // 自定义配置
        InjectionConfig cfg = new InjectionConfig() {
            @Override
            public void initMap() {
                // to do nothing
            }
        };


        mpg.setTemplate(templateConfig);

        // 策略配置
        StrategyConfig strategy = new StrategyConfig();
        strategy.setNaming(NamingStrategy.underline_to_camel);
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
        strategy.setSuperEntityClass(ObjectConvert.class);
        strategy.setEntityLombokModel(true);
        strategy.setRestControllerStyle(true);
        // 公共父类
        strategy.setSuperControllerClass(packageName + ".config." +"BaseController");
        // 写于父类中的公共字段
        //strategy.setSuperEntityColumns("id");
        strategy.setInclude(tables);
        //strategy.setInclude(new String[]{"account", "student"});
        strategy.setControllerMappingHyphenStyle(true);
        strategy.setTablePrefix(pc.getModuleName() + "_");
        mpg.setStrategy(strategy);
        mpg.setTemplateEngine(new FreemarkerTemplateEngine());
        mpg.execute();
    }
}
