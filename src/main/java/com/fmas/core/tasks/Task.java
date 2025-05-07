package com.fmas.core.tasks;

import java.util.List;
import java.util.Map;

public interface Task {
    String getId();

    String getDescription();

    String getAssignedAgentId();

    void setAssignedAgentId(String agentId);

    String getExpectedOutputFormat();

    List<String> getContextTaskIds();

    Map<String, Object> getInputData();

    TaskStatus getStatus();

    void setStatus(TaskStatus status);

    TaskOutput getTaskOutput();

    void setTaskOutput(TaskOutput output);

    boolean isAsyncExecution();

    String getOutputFile();
}