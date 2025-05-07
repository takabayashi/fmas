package com.fmas.examples;

import org.apache.flink.api.common.eventtime.WatermarkStrategy;
import org.apache.flink.connector.kafka.source.KafkaSource;
import org.apache.flink.connector.kafka.source.enumerator.initializer.OffsetsInitializer;
import org.apache.flink.streaming.api.datastream.DataStreamSource;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.api.common.serialization.SimpleStringSchema;
import org.apache.flink.api.common.functions.MapFunction;

import com.fmas.core.agents.*;
import com.fmas.core.tasks.*;

import java.util.concurrent.CompletableFuture;
import java.util.Collections;
import java.util.Map;

public class App {
    public static void main(String[] args) throws Exception {
        final StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
        // env.getConfig().setMaxParallelism(12);

        KafkaSource<String> source = KafkaSource.<String>builder()
                .setBootstrapServers("localhost:9092")
                .setTopics("test-input")
                .setGroupId("streamagents-group")
                .setStartingOffsets(OffsetsInitializer.earliest())
                .setValueOnlyDeserializer(new SimpleStringSchema())
                .build();

        DataStreamSource<String> stream = env.fromSource(
                source,
                WatermarkStrategy.noWatermarks(),
                "KafkaSource");

        stream.map(new MapFunction<String, String>() {
            @Override
            public String map(String message) throws Exception {
                SimpleAgent agent = new SimpleAgent(
                        "agent-1",
                        "TestAgent",
                        "Process tasks",
                        "Backstory of the agent");

                Task task = new SimpleTask(
                        "task-1", message,
                        "text",
                        Collections.emptyList(),
                        Map.of("input", message),
                        false,
                        null);

                CompletableFuture<TaskOutput> future = agent.executeTask(task, new AgentContext());
                TaskOutput output = future.get(); // blocking for demo purposes

                return "[Agent Result] " + output.getOutput("result");
            }
        }).print();

        env.execute("StreamAgents Job");
    }
}