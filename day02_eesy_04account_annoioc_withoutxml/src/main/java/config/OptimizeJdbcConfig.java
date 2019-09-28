package config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;

/**
 * 优化jdbc数据库链接
 * 链接数据库的信息在jdbcConfig.properties文件中
 */
public class OptimizeJdbcConfig {
    @Value("${jdbc.driver}")
    private String driver;

    @Value("${jdbc.url}")
    private String url;

    @Value("${jdbc.username}")
    private String username;

    @Value("${jdbc.password}")
    private String password;

    /**
     * 创建一个QueryRunner对象
     *
     * @param dataSource
     * @return
     */
    @Bean("runner")
    @Scope("singleton")
    public QueryRunner createQueryRunner(DataSource dataSource) {
        return new QueryRunner(dataSource);

    }

    /**
     * 创建数据源 DataSource 对象
     *
     * @return
     */
    @Bean("dataSourse")
    public DataSource createDataSourse() {
        ComboPooledDataSource ds = new ComboPooledDataSource();
        try {
            ds.setDriverClass(driver);//驱动
            ds.setJdbcUrl(url);
            ds.setUser(username);
            ds.setPassword(password);
        } catch (PropertyVetoException e) {
            e.printStackTrace();
        }
        return ds;
    }

}
