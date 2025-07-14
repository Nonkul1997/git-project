package org.example.project;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.TemplateType;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * MySQL代码生成
 * </p>
 *
 * @author xiaochuan
 * @since 2023/10/24 16:08
 */
public class MybatisPlusGenerator {
    private static final String URL = "jdbc:mysql://localhost:3306/dev_database";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "123456";
    private static final String AUTHOR = "xiaochuan";
    private static final String[] TABLE_PREFIX = {"t_"};
    private static final String ENTITY_PACKAGE_NAME = "po";

    // 当前项目java源码目录，自定义
    private static final String PROJECT_JAVA_DIR = "git-user\\git-user-mapper\\src\\main\\java";
    // 生成文件的父包名，自定义
    private static final String PARENT_PACKAGE_NAME = "org.example.project";
    // 需要映射的表名（多张表逗号分隔），自定义
    private static final String TABLE_NAME = "t_user";

    public static void main(String[] args) {
        FastAutoGenerator.create(URL, USERNAME, PASSWORD)
                .globalConfig(builder ->
                    builder.author(AUTHOR) // 设置作者
                            .outputDir(PROJECT_JAVA_DIR) //指定输出目录
                            .disableOpenDir() //禁止打开输出目录
                            .dateType(DateType.ONLY_DATE) //时间策略
                )
                .packageConfig(builder ->
                    builder.parent(PARENT_PACKAGE_NAME) // 设置父包名
                            .entity(ENTITY_PACKAGE_NAME) // 设置实体包名
                )
                .templateConfig(builder ->
                    builder.disable(TemplateType.SERVICE, TemplateType.SERVICE_IMPL, TemplateType.CONTROLLER) // 禁用模板
                )
                .strategyConfig(builder ->
                    builder.addInclude(TABLE_NAME) // 设置需要映射的表名
                            .addTablePrefix(TABLE_PREFIX) // 设置实体层需要过滤的表前缀
                            .entityBuilder()
                            .enableFileOverride() // 设置实体层可覆盖
                            .disableSerialVersionUID() // 设置实体层不继承序列化接口
                            .enableChainModel() // 设置实体层开启链式模型
                            .enableLombok() // 设置实体层开启lombok模型
                            .enableTableFieldAnnotation() // 设置实体层生成字段注解
                            .columnNaming(NamingStrategy.underline_to_camel)
                            .mapperBuilder()
                            .enableFileOverride() //设置持久层可覆盖
                            .mapperAnnotation(Mapper.class) //设置持久层注解
                )
                .templateEngine(new FreemarkerTemplateEngine()) // 使用Freemarker引擎模板，默认的是Velocity引擎模板
                .execute();
    }
}
