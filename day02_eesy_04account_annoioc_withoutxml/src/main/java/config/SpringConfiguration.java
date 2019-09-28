package config;

import org.springframework.context.annotation.*;


/**
 * 该类是个配置类 作用和xml配置类是一样的
 * 如何得知这个类是配置类?------------------
 * <p>
 * 新注解:Configuration
 * 作用:指定当前类为配置类
 * 细节:AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringConfiguration.class);
 * 是当前的配置类 这可以不加 ,Configuration
 *
 * <p>
 * 新注解:CoomponentScan
 * 作用:用于通过注解指定Spring在创建容器时要扫描的包
 * 属性:
 * basePackages:
 * value:
 * 这两个属性都是指定要扫描的包
 *
 * @ComponentScan(basePackages = "com.itheima")
 * @ComponentScan(value = "com.itheima")
 * 这两个等价都等价于xml中的   <context:component-scan base-package="com.itheima"></context:component-scan>
 * <p>
 * 新注解:Bean
 * 作用:
 * 将当前方法的返回值的返回值作为bean对象存入spring的ioc容器中
 * 属性
 * name:用于指定bean的id.不写时,默认值为当前方法的名称
 * <p>
 * 新注解:Scope
 * 作用 当前对象时多例还是单例
 * prototype:多例
 * singleton:不写默认单例   ----@Scope("prototype")
 * <p>
 * 新注解:Import
 * 作用:导入其它的配置类 这样其他的配置类就不需要添加别的注解了
 * *      作用：用于导入其他的配置类
 * *      属性：
 * *          value：用于指定其他配置类的字节码。
 * *                  当我们使用Import的注解之后，有Import注解的类就父配置类，而导入的都是子配置类
 * *
 * *  PropertySource
 * *      作用：用于指定properties文件的位置
 * *      属性：
 * *          value：指定文件的名称和路径。
 * *                  关键字：classpath，表示类路径下
 * , JdbcConfig.class
 */
@Configuration
@ComponentScan(value = {"com.itheima", "config"})
@Import(value = {OptimizeJdbcConfig.class})
@PropertySource("classpath:jdbcConfig.properties")
public class SpringConfiguration {

}
