// package cn.zm.plus;
//
// import cn.smallbun.screw.core.Configuration;
// import cn.smallbun.screw.core.engine.EngineConfig;
// import cn.smallbun.screw.core.engine.EngineFileType;
// import cn.smallbun.screw.core.engine.EngineTemplateType;
// import cn.smallbun.screw.core.execute.DocumentationExecute;
// import cn.smallbun.screw.core.process.ProcessConfig;
// import com.zaxxer.hikari.HikariConfig;
// import com.zaxxer.hikari.HikariDataSource;
// import org.junit.Test;
// import org.springframework.boot.test.context.SpringBootTest;
//
// import javax.sql.DataSource;
// import java.util.ArrayList;
// import java.util.Arrays;
// import java.util.Collections;
// import java.util.List;
//
// /**
//  * 数据库文档生成器
//  */
// @SpringBootTest
// public class ScrewApplicationTests {
//     @Test
//     public void contextLoads() {
//         //数据源：HikariCP 线程池, SpringBoot 2.0开始内置了HikariCP，2.0之前的版本需要引入依赖
//         HikariConfig hikariConfig = new HikariConfig();
//         // com.mysql.jdbc.Driver MySQL5驱动；com.mysql.cj.jdbc.Driver MySQL6之后的驱动
//         hikariConfig.setDriverClassName("com.mysql.cj.jdbc.Driver");
//         hikariConfig.setJdbcUrl("jdbc:mysql://127.0.0.1:3306/pk_org_assess_dev?useUnicode=true&characterEncoding=UTF-8&serverTimezone=GMT%2B8");
//         hikariConfig.setUsername("root");
//         hikariConfig.setPassword("root");
//         //设置可以获取tables remarks信息
//         hikariConfig.addDataSourceProperty("useInformationSchema", "true");
//         hikariConfig.setMinimumIdle(2);
//         hikariConfig.setMaximumPoolSize(5);
//         DataSource dataSource = new HikariDataSource(hikariConfig);
//
//         // 1、生成文件配置
//         EngineConfig engineConfig = EngineConfig.builder()
//                 //生成文件路径(改成自己的生成路径)
//                 .fileOutputDir("/Users/Manager/Desktop")
//                 //生成后是否立即打开目录
//                 .openOutputDir(true)
//                 //文件类型 有HTML、WORD、MD三种枚举选择
//                 .fileType(EngineFileType.WORD)
//                 //生成模板实现
//                 .produceType(EngineTemplateType.freemarker).build();
//
//         // 忽略表名（可选）
//         List<String> ignoreTableName = Arrays.asList("aa", "test_group");
//         // 忽略表前缀（可选）
//         List<String> ignorePrefix = Collections.singletonList("czb_");
//         // 忽略表后缀（可选）
//         List<String> ignoreSuffix = Arrays.asList("_test", "_test1");
//
//         // 2、配置想要忽略的表（可选）
//         ProcessConfig processConfig = ProcessConfig.builder()
//                 .ignoreTableName(ignoreTableName)
//                 .ignoreTablePrefix(ignorePrefix)
//                 .ignoreTableSuffix(ignoreSuffix)
//                 .build();
//
//         // 3、生成文档配置（包含以下自定义版本号、标题、描述（数据库名 + 描述 = 文件名）等配置连接）
//         Configuration config = Configuration.builder()
//                 .version("1.0.0")
//                 .title("数据库文档")
//                 .description("数据库设计文档生成")
//                 .dataSource(dataSource)
//                 .engineConfig(engineConfig)
//                 .produceConfig(processConfig).build();
//
//         // 4、执行生成
//         new DocumentationExecute(config).execute();
//     }
// }