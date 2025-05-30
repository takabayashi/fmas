package com.fmas.core.agents;

import org.apache.flink.api.common.functions.RuntimeContext;

import com.fmas.core.tasks.Task;
import com.fmas.core.tasks.TaskOutput;

import java.util.concurrent.CompletableFuture;

public interface Agent {
    String getId();

    String getRole();

    String getGoal();

    String getBackstory();

    void initialize(RuntimeContext flinkRuntimeContext) throws Exception;

    CompletableFuture<TaskOutput> executeTask(Task task, AgentContext context);

    A2AResponse handleA2ARequest(A2ARequest request);

    AgentCard getAgentCard();
}