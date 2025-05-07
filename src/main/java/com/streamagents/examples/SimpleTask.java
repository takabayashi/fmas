package com.streamagents.examples;

import java.util.List;
import java.util.Map;

import com.streamagents.core.tasks.Task;
import com.streamagents.core.tasks.TaskOutput;
import com.streamagents.core.tasks.TaskStatus;

import java.util.HashMap;

public class SimpleTask implements Task {
    private final String id;
    private final String description;
    private String assignedAgentId;
    private final String expectedOutputFormat;
    private final List<String> contextTaskIds;
    private final Map<String, Object> inputData;
    private TaskStatus status = TaskStatus.PENDING;
    private TaskOutput output;
    private final boolean asyncExecution;
    private final String outputFile;

    public SimpleTask(String id, String description, String expectedOutputFormat,
            List<String> contextTaskIds, Map<String, Object> inputData,
            boolean asyncExecution, String outputFile) {
        this.id = id;
        this.description = description;
        this.expectedOutputFormat = expectedOutputFormat;
        this.contextTaskIds = contextTaskIds;
        this.inputData = inputData != null ? inputData : new HashMap<>();
        this.asyncExecution = asyncExecution;
        this.outputFile = outputFile;
    }

    public String getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public String getAssignedAgentId() {
        return assignedAgentId;
    }

    public void setAssignedAgentId(String agentId) {
        this.assignedAgentId = agentId;
    }

    public String getExpectedOutputFormat() {
        return expectedOutputFormat;
    }

    public List<String> getContextTaskIds() {
        return contextTaskIds;
    }

    public Map<String, Object> getInputData() {
        return inputData;
    }

    public TaskStatus getStatus() {
        return status;
    }

    public void setStatus(TaskStatus status) {
        this.status = status;
    }

    public TaskOutput getTaskOutput() {
        return output;
    }

    public void setTaskOutput(TaskOutput output) {
        this.output = output;
    }

    public boolean isAsyncExecution() {
        return asyncExecution;
    }

    public String getOutputFile() {
        return outputFile;
    }
}
