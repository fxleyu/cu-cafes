package fx.leyu.mq.rocketmq.consumer;

import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.common.message.MessageExt;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class Consumer {
    public static void main(String[] args) throws MQClientException {
        // Instantiate with specified consumer group name.
        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer("mq_fxleyu_group_name_4");

        // Specify name server addresses.
        consumer.setNamesrvAddr("127.0.0.1:9876");
        consumer.setConsumeThreadMin(1);
        consumer.setConsumeThreadMax(1);
        consumer.setConsumeMessageBatchMaxSize(3);

        // Subscribe one more more topics to consume.
        consumer.subscribe("FX_Topic_Test", "*");

        AtomicInteger integer = new AtomicInteger(0);
        // Register callback to execute on arrival of messages fetched from brokers.
        consumer.registerMessageListener(new MessageListenerConcurrently() {

            @Override
            public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> msgs,
                                                            ConsumeConcurrentlyContext context) {
                try {
                    //TimeUnit.SECONDS.sleep(1);
                } catch (Exception ignored) {
                }

                // System.out.printf("%s Receive New Messages -  %s %n", Thread.currentThread().getName(), msgs);
                String msg = msgs.stream().map(x -> new String(x.getBody())).collect(Collectors.joining());
                System.out.println("msg's size is " + integer.addAndGet(msgs.size()) + ", msg is " + msg);
                return ConsumeConcurrentlyStatus.RECONSUME_LATER;
            }
        });

        //Launch the consumer instance.
        consumer.start();

        System.out.printf("Consumer Started.%n");
    }
}
