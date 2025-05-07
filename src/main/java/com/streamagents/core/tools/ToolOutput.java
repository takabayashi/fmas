package com.streamagents.core.tools;

public class ToolOutput {
    public Object result;
    public String error;

    public ToolOutput(Object result, String error) {
        this.result = result;
        this.error = error;
    }
}