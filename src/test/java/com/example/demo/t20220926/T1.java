package com.example.demo.t20220926;

/**
 * @program: demoes
 * @description:
 * @author: jiangjianfei
 * @create: 2022-09-27 15:48
 **/
public class T1 {
    /**
     * 自我介绍
     *
     */

    /**
     * 项目经验
     *
     */

    /**
     * rabbitmq kafka 如何保证消息的可靠传输
     * --数据的丢失问题，可能出现在生产者、MQ、消费者中
     * --生产者丢失：
     * 所以一般在生产者这块避免数据丢失，都是用confirm机制的
     *
     * --MQ中丢失：
     * 设置持久化有两个步骤：创建 queue 的时候将其设置为持
     * 久化，这样就可以保证 RabbitMQ 持久化 queue 的元数据，但是不会持久化 queue 里的数据。第二个是发送消息的时候将消息的
     * deliveryMode 设置为 2，就是将消息设置为持久化的，此时 RabbitMQ 就会将消息持久化到磁盘上去。
     *
     * --消费端丢失：
     * 这个时候得用 RabbitMQ 提供的ack机制，简单来说，就是你关闭 RabbitMQ 的自动ack，可以通过一个 api 来调用就行，然后每次你
     * 自己代码里确保处理完的时候，再在程序里ack一把。
     *
     *
     * Kafka 是一种高吞吐量、分布式、基于发布/订阅的消息系统，最初由 LinkedIn 公司开发，使用Scala 语言编写，目前是 Apache 的开源项目。
     * partition 中的每条 Message 包含了以下三个属性： offset， MessageSize， data， 其中 offset 表示 Message 在这个 partition 中的偏移量， offset 不是该 Message 在
     * partition 数据文件中的实际存储位置，而是逻辑上一个值，它唯一确定了 partition 中的一条 Message，可以认为 offset 是partition 中 Message 的 id； MessageSize 表示消息
     * 内容 data 的大小； data 为 Message 的具体内容。
     * Kafka 面试题
     * 1、Kafka 是什么
     * 1. broker： Kafka 服务器，负责消息存储和转发
     * 2. topic：消息类别， Kafka 按照 topic 来分类消息
     * 3. partition： topic 的分区，一个 topic 可以包含多个 partition， topic 消息保存在各个partition 上
     * 4. offset：消息在日志中的位置，可以理解是消息在 partition 上的偏移量，也是代表该消息的唯一序号
     * 5. Producer：消息生产者
     * 6. Consumer：消息消费者
     * 7. Consumer Group：消费者分组，每个 Consumer 必须属于一个 group
     * 8. Zookeeper：保存着集群 broker、 topic、 partition 等 meta 数据；另外，还负责 broker 故障发现， partition leader 选举，负载均衡等功能
     * 从 Producer 往 Broker 发送消息、Topic 分区副本以及 Leader 选举几个角度介绍 Kafka 是如何保证可靠性的。
     *
     * -Producer 往 Broker 发送消息
     * acks = all（这个和 request.required.acks = -1 含义一样）：意味着 Leader 在返回确认或错误响应之前，
     * 会等待所有同步副本都收到消息。如果和 min.insync.replicas 参数结合起来，
     * 就可以决定在返回确认前至少有多少个副本能够收到消息，生产者会一直重试直到消息被成功提交。
     * 不过这也是最慢的做法，因为生产者在继续发送其他消息之前需要等待所有副本都收到当前的消息。
     * 如果需要确保消息的可靠性，必须将 producer.type 设置为 sync。
     *
     * -Topic 分区副本
     * 也就是说每个分区可以人为的配置几个副本
     * （比如创建主题的时候指定 replication-factor，也可以在 Broker 级别进行配置 default.replication.factor），一般会设置为 3。
     *
     * -Leader 选举
     * 每个分区的 Leader 会维护一个 ISR 列表，ISR 列表里面包括 Leader 副本和 Follower 副本的 Broker 编号，
     * 只有跟得上 Leader 的 Follower 副本才能加入到 ISR 里面，这个是通过 replica.lag.time.max.ms 参数配置的，
     * 这个参数的含义是 Follower 副本能够落后 Leader 副本的最长时间间隔，默认值是 10 秒。
     * 这就是说，只要一个 Follower 副本落后 Leader 副本的时间不连续超过 10 秒，
     * 那么 Kafka 就认为该 Follower 副本与 Leader 是同步的，即使此时 Follower 副本中保存的消息明显少于 Leader 副本中的消息。
     *
     * -Broker端
     * 默认情况下，Broker将消息写入PageCache终之后就会向Producer响应成功写入的消息，
     * 为了防止系统崩溃、系统掉电等重大事故时PageCache中的数据丢失，那么将Broker的刷盘策略改为同步刷盘即可，
     * 目前Kafka的Broker没有直接提供同步选项，但是有两个broker参数可以选择：
     * flush.messages：默认空，表示写入多少条消息之后进行一次fsync刷盘。
     * flush.ms：默认空，表示进过多少毫秒之后进行一次fsync刷盘。
     *
     * -Consumer端
     * 将enable.auto.commit设置为false表示使用手动提交，这样的好处就是自己控制是否提交offset，
     * 但是这同样无法避免重复消费。比如拉取的消息，消费完毕，在准备提交的时候，消费者宕机了，那么重启时将会再次消费该消息。
     * 所以说，无论是自动提交还是手动提交，kafka都会保证消息至少到达消费者一次，
     * 从这方面来说，只会可能导致重复消费，是不存在消费者消息丢失的，除非编写错误的消费代码。
     * 注意：
     * 对于使用spring-kafka依赖的项目并且是使用@KafkaListener机制来消费消息的项目。
     * 如果仅仅把enable.auto.commit设置为false，
     * 还需要设置AckMode属性，即设置手动提交的模式，一般设置为MANUAL，也就是在代码中手动提交，
     * 如果不设置AckMode，那么默认为AckMode为BATCH，也就是poll的一批数据处理完之后由Spring的代码来给你提交。
     *
     * -唯一可能导致消费者弄丢数据的情况：就是说，你已经消费到了这个消息，然后消费者那边自动提交了 offset，
     * 让 Kafka 以为你已经消费好了这个消息，但其实你才刚准备处理这个消息，但是还没处理，消费端就挂了，此时这条消息就丢了。
     *
     * 解决方案：
     * 关闭自动提交 offset，在处理完之后自己手动提交 offset，就可以保证数据不会丢。
     * 但是此时确实还是可能会有重复消费，比如你刚处理完，还没提交 offset，结果自己挂了，此时肯定会重复消费一次，自己保证幂等性就好了。
     *
     *
     */

    /**
     * mysql默认隔离级别，能实现避免幻读吗
     */

    /**
     * 编程题1道
     */
}
