package com.tazine.evo.flink;

import org.apache.flink.api.common.functions.FlatMapFunction;
import org.apache.flink.api.java.tuple.Tuple2;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.streaming.api.windowing.time.Time;
import org.apache.flink.util.Collector;

/**
 * SocketWordCount
 *
 * @author frank
 * @date 2018/11/29
 */
public class SocketWordCount {

    public static void main(String[] args) throws Exception {

        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();

        DataStream<Tuple2<String, Integer>> dataStream = env.socketTextStream("127.0.0.1", 9999)
            .flatMap(new Splitter()).keyBy(0).timeWindow(Time.seconds(5)).sum(1);

        dataStream.print();
        // 启动项目
        env.execute("window WordCount");
    }

    public static class Splitter implements FlatMapFunction<String, Tuple2<String,Integer>> {

        @Override
        public void flatMap(String sentence, Collector<Tuple2<String, Integer>> out) throws Exception {
            for(String word:sentence.split(" ")){
                out.collect(new Tuple2<String,Integer>(word,1));
            }

        }

    }
}
