package com.tazine.evo.flink;

import org.apache.flink.api.common.functions.FlatMapFunction;
import org.apache.flink.api.java.DataSet;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.util.Collector;
import scala.Tuple2;

/**
 * Flink WordCount
 *
 * @author frank
 * @date 2018/11/22
 */
public class WordCount {

    public static void main(String[] args) {

        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();

        DataStream<String> text = env.fromElements(" To be, or not to be, that is the question",
            "Hello from the other side , I must call it thousand times",
            "when i am down, and oh my soul so weary", "");

        DataStream<Tuple2<String, Integer>> result = text.flatMap(
            new FlatMapFunction<String, Tuple2<String, Integer>>() {
                @Override
                public void flatMap(String s, Collector<Tuple2<String, Integer>> collector) throws Exception {
                    //for (String word : )
                }
            });

    }

}
