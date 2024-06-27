package com.li.rabbitmqconsumer.config;

import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.listener.api.ChannelAwareMessageListener;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName MyAckReceiver
 * @Description TODO
 * @Author LiYe
 * @Date 2024/6/27 14:37
 * @Version 1.0
 */
@Component
public class MyAckReceiver implements ChannelAwareMessageListener {

    @Override
    public void onMessage(Message message, Channel channel) throws Exception {
        long deliveryTag = message.getMessageProperties().getDeliveryTag();
        try {
            String msg = message.toString();
            String[] msgArray = msg.split("'");
            Map<String, String> msgMap = mapStringToMap(msgArray[1].trim(), 3);
            String messageId = msgMap.get("messageId");
            String messageData = msgMap.get("messageData");
            String createTime = msgMap.get("createTime");

            if ("directRabbitQueue".equals(message.getMessageProperties().getConsumerQueue())) {
                System.out.println("消费的消息来自的队列名为：" + message.getMessageProperties().getConsumerQueue());
                System.out.println("消息成功消费到  messageId:" + messageId + "  messageData:" + messageData + "  createTime:" + createTime);
                System.out.println("执行TestDirectQueue中的消息的业务处理流程......");
            }
            if ("fanout.A".equals(message.getMessageProperties().getConsumerQueue())) {
                System.out.println("消费的消息来自的队列名为：" + message.getMessageProperties().getConsumerQueue());
                System.out.println("消息成功消费到  messageId:" + messageId + "  messageData:" + messageData + "  createTime:" + createTime);
                System.out.println("执行fanout.A中的消息的业务处理流程......");
            }

            // System.out.println("  MyAckReceiver  messageId:" + messageId + "  messageData:" + messageData + "  createTime:" + createTime);
            // System.out.println("消费的主题消息来自：" + message.getMessageProperties().getConsumerQueue());
            channel.basicAck(deliveryTag, true);//第二个参数，手动确认可以被批处理，当该参数为 true 时，则可以一次性确认 delivery_tag 小于等于传入值的所有消息
            //channel.basicReject(deliveryTag, true);//第二个参数，true会重新放回队列，所以需要自己根据业务逻辑判断什么时候使用拒绝
        } catch (Exception e) {
            channel.basicReject(deliveryTag, false);
            e.printStackTrace();
        }

    }

    private Map<String, String> mapStringToMap(String str, int entryNum) {
        str = str.substring(1, str.length() - 1);
        String[] strs = str.split(",", entryNum);
        Map<String, String> map = new HashMap<>();
        for (String string : strs) {
            String key = string.split("=")[0].trim();
            String value = string.split("=")[1];
            map.put(key, value);
        }
        return map;
    }
}
