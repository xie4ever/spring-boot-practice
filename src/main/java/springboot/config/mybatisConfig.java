package springboot.config;

import java.io.IOException;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import com.alibaba.druid.pool.DruidDataSourceFactory;

@Configuration // 注解指定@Configuration指定该类为配置类，需要被spring扫描
@MapperScan(basePackages = "springboot.dao") // 指定映射的dao包（放置操作类的目录）
public class mybatisConfig {

	@Bean
	public DataSource getDataSource() {

		Properties properties = new Properties();

		properties.put("driverClassName", "com.mysql.jdbc.Driver"); // 数据库驱动
		properties.put("url",
				"jdbc:mysql://127.0.0.1:3306/1.9cool?zeroDateTimeBehavior=convertToNull&amp;useUnicode=true&amp;characterEncoding=utf-8");
		// 数据库链接
		properties.put("username", "root"); // 用户名
		properties.put("password", "root"); // 密码

		try {

			return DruidDataSourceFactory.createDataSource(properties);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

			return null;
		}
	}

	@Bean
	public SqlSessionFactory sqlSessionFactory(DataSource dataSource) {

		SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();

		sqlSessionFactoryBean.setDataSource(dataSource);

		sqlSessionFactoryBean.setTypeAliasesPackage("springboot.pojo"); //指定映射的pojo包（放置实体类的目录）

		try {

			sqlSessionFactoryBean.setMapperLocations(
					new PathMatchingResourcePatternResolver().getResources("classpath:springboot/mapper/*.xml")); //指定映射的mapper包（放置映射文件的目录）

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {

			return sqlSessionFactoryBean.getObject();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

			return null;
		}
	}
}
