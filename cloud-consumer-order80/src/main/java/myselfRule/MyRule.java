package myselfRule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author AIXDL
 * @description: 自定义ribbon负载均衡算法
 * 1.不能放在@ComponentScan所扫描的当前包下以及子包下，否则我们自定义的这个配置类就会被所有的Ribbon客户端所共享，达不到特殊化定制的目的了
 * 2.自定义配置类
 *  @Bean
 *     public IRule myRule(){
 *         return new RandomRule();//定义为随机
 *     }
 * 3.在主启动类上添加@RibbonClient(name = "CLOUD-PAYMENT-SERVICE",configuration = MyRule.class)
 * name:指定的是服务名称 表示为调用CLOUD-PAYMENT-SERVICE服务使用自定义的负载均衡算法
 * configuration:指定的是自定义的负载均衡算法
 * @date 2023-07-14 11:19
 * @version: 1.0
 */
@Configuration
public class MyRule {
    @Bean
    public IRule myselfRule(){
        return new RandomRule();//定义为随机
    }
}
