package com.fmas.examples;

import com.fmas.core.agents.Agent;
import com.fmas.core.agents.AgentContext;
import com.fmas.core.agents.AgentCard;
import com.fmas.core.agents.A2ARequest;
import com.fmas.core.agents.A2AResponse;
import com.fmas.core.tasks.Task;
import com.fmas.core.tasks.TaskOutput;
import org.apache.flink.api.common.functions.RuntimeContext;
import java.util.concurrent.CompletableFuture;

public class SimpleAgent implements Agent {
    private final String id;
    private final String role;
    private final String goal;
    private final String backstory;

    public SimpleAgent(String id, String role, String goal, String backstory) {
        this.id = id;
        this.role = role;
        this.goal = goal;
        this.backstory = backstory;
    }

    public String getId() {
        return id;
    }

    public String getRole() {
        return role;
    }

    public String getGoal() {
        return goal;
    }

    public String getBackstory() {
        return backstory;
    }

    public void initialize(RuntimeContext flinkRuntimeContext) throws Exception {
        // Placeholder for Flink state initialization
    }

    public CompletableFuture<TaskOutput> executeTask(Task task, AgentContext context) {
        TaskOutput output = new TaskOutput(task.getId());
        output.addOutput("result", "Executed: " + task.getDescription());
        return CompletableFuture.completedFuture(output);
    }

    public A2AResponse handleA2ARequest(A2ARequest request) {
        return new A2AResponse(); // Stub
    }

    public AgentCard getAgentCard() {
        return new AgentCard(); // Stub
    }
}
