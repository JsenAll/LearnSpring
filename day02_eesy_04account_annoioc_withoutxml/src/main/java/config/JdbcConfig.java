package config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;

/**
 * 和spring连接数据库相关的配置类
 */
//@Configuration
//@ComponentScan(value = {"com.itheima"})
public class JdbcConfig {
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
            ds.setDriverClass("com.mysql.jdbc.Driver");//驱动
            ds.setJdbcUrl("jdbc:mysql://localhost:3306/eesy");
            ds.setUser("root");
            ds.setPassword("jhs123");
        } catch (PropertyVetoException e) {
            e.printStackTrace();
        }
        return ds;
    }

}
