package com.hyf.message.config;

import com.hyf.encapsulation.constants.UserConstants;
import com.hyf.message.service.MessageReceiver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.listener.PatternTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;

/**
 * @author Howinfun
 * @desc
 * @date 2019/5/14
 */
@Configuration
public class RedisConfig {

    /**
     * redis消息监听器容器
     * 可以添加多个监听不同话题的redis监听器，只需要把消息监听器和相应的消息订阅处理器绑定，该消息监听器
     * 通过反射技术调用消息订阅处理器的相关方法进行一些业务处理
     * @param messageListener
     * @return
     */
    @Bean
    RedisMessageListenerContainer container(RedisConnectionFactory connectionFactory,
                                            MessageListenerAdapter messageListener) {

        RedisMessageListenerContainer container = new RedisMessageListenerContainer();
        container.setConnectionFactory(connectionFactory);
        //mailListener订阅了一个叫user:register 的通道
        container.addMessageListener(messageListener, new PatternTopic(UserConstants.USER_REGISTER));
        return container;
    }

    /**
     * 消息监听器适配器，绑定消息处理器，利用反射技术调用消息处理器的业务方法
     * @param receiver
     * @return
     */
    @Bean
    MessageListenerAdapter messageListener(MessageReceiver receiver) {
        //这个地方 是给messageListenerAdapter 传入一个消息接受的处理器，利用反射的方法调用“receiveMessage”
        //MessageListenerAdapter提供的默认调用处理器的方法是handleMessage 可以自己到源码里面看
        // 所以如果我们定义的方法不是这个，需要在构造函数这添加上
        return new MessageListenerAdapter(receiver, "receiveMessage");
    }
}
