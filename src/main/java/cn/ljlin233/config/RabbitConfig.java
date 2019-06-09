// package cn.ljlin233.config;

// import java.util.Collections;

// import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
// import org.springframework.amqp.rabbit.connection.ConnectionFactory;
// import org.springframework.amqp.rabbit.core.ChannelAwareMessageListener;
// import org.springframework.amqp.rabbit.core.RabbitAdmin;
// import org.springframework.amqp.rabbit.core.RabbitTemplate;
// import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
// import org.springframework.beans.factory.annotation.Value;
// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.context.annotation.PropertySource;
// import org.springframework.retry.backoff.ExponentialBackOffPolicy;
// import org.springframework.retry.support.RetryTemplate;

// /**
//  * RabbitConfig
//  */
// @Configuration
// @PropertySource("classpath:properties/rabbitmq.properties")
// public class RabbitConfig {

//     @Value("${rabbit.hosts}")
//     private String host;

//     @Value("${rabbit.port}")
//     private int port;

//     @Value("${rabbit.username}")
//     private String username;

//     @Value("${rabbit.password}")
//     private String password;

//     @Value("${rabbit.routingKey}")
//     private String routingKey;

//     @Value("${rabbit.queue}")
//     private String queueName;

//     // 连接服务配置
//     @Bean
//     public ConnectionFactory connectionFactory() {
//         //CachingConnectionFactory factory = new CachingConnectionFactory(host, port);
//         CachingConnectionFactory factory = new CachingConnectionFactory();
//         factory.setHost(host);
//         factory.setPort(port);
//         //factory.setVirtualHost(virtualHost);
//         factory.setUsername(username);
//         factory.setPassword(password);

//         return factory;
//     }

//     @Bean
//     public RabbitAdmin rabbitAdmin(ConnectionFactory connectionFactory) {
//         RabbitAdmin rabbitAdmin = new RabbitAdmin(connectionFactory);

//         return rabbitAdmin;
//     }

//     @Bean
//     public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory) {
//         RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
//         //rabbitTemplate.setRoutingKey(routingKey);
//         // RetryTemplate retryTemplate = new RetryTemplate();
//         // ExponentialBackOffPolicy backOffPolicy = new ExponentialBackOffPolicy();
//         // backOffPolicy.setInitialInterval(500);
//         // backOffPolicy.setMultiplier(10.0);
//         // backOffPolicy.setMaxInterval(10000);
//         // retryTemplate.setBackOffPolicy(backOffPolicy);

//         // rabbitTemplate.setRetryTemplate(retryTemplate);
//         // rabbitTemplate.setRoutingKey(routingKey);

//         return rabbitTemplate;
//     }

//     // @Bean
//     // public ChannelAwareMessageListener channelAwareMessageListener()
//     //         throws InstantiationException, IllegalAccessException, ClassNotFoundException {

//     //     return (ChannelAwareMessageListener) Class.forName(listenClass).newInstance();
//     // }


//     // @Bean
//     // public SimpleMessageListenerContainer messageListenerContainer(ConnectionFactory connectionFactory,
//     //         ChannelAwareMessageListener channelAwareMessageListener) {
        
//     //     SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
//     //     container.setConnectionFactory(connectionFactory);
//     //     container.setChannelAwareMessageListener(channelAwareMessageListener);

//     //     String[] names = queuenames.split(",");

//     //     Queue[] queues = new Queue[names.length];
//     //     for (int i=0; i<queues.length; i++) {
//     //         Queue queue = new Queue(names[i]);
//     //         queues[i] = queue;
//     //     }
//     //     container.setQueues(queues);
//     //     container.setConsumerArguments(Collections.<String, Object> singletonMap("x-priority",Integer.valueOf(10)));

//     //     return container;
//     // }



// }