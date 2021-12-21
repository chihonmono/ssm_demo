package games.seac.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;

/**
 * 核心配置类
 * @author Honmono
 * @date 2021/11/16 - 15:37
 */
@Configuration //标注该类是Spring的核心配置类

/*配置组件扫描，替换：
    <context:component-scan base-package="games.seac"/>
 */
@ComponentScan("games.seac")

@Import({DataSourceConfiguration.class}) //加载分配置类，参数可以是数组，加载多个配置类
public class SpringConfiguration {



}
