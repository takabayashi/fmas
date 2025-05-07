package com.fmas.core.tasks;

import java.util.HashMap;
import java.util.Map;

public class TaskOutput {
    private final String taskId;
    private final Map<String, Object> outputData;

    public TaskOutput(String taskId) {
        this.taskId = taskId;
        this.outputData = new HashMap<>();
    }

    public TaskOutput(String taskId, Object result) {
        this.taskId = taskId;
        this.outputData = new HashMap<>();
        this.outputData.put("result", result);
    }

    public String getTaskId() {
        return taskId;
    }

    public Map<String, Object> getOutputData() {
        return outputData;
    }

    public void addOutput(String key, Object value) {
        outputData.put(key, value);
    }

    public Object getOutput(String key) {
        return outputData.get(key);
    }
}