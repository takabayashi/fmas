package com.fmas.examples;

import com.fmas.core.tools.Tool;
import com.fmas.core.tools.ToolInput;
import com.fmas.core.tools.ToolOutput;
import java.util.concurrent.CompletableFuture;
import java.util.Map;
import java.util.HashMap;

public class EchoTool implements Tool {
    public String getName() {
        return "echo_tool";
    }

    public String getDescription() {
        return "Echoes back the input parameter.";
    }

    public String getInputSchema() {
        return "{ 'type': 'object', 'properties': { 'message': { 'type': 'string' } } }";
    }

    public String getOutputSchema() {
        return "{ 'type': 'object', 'properties': { 'echo': { 'type': 'string' } } }";
    }

    public CompletableFuture<ToolOutput> execute(ToolInput input) {
        Object message = input.parameters.getOrDefault("message", "");
        Map<String, Object> output = new HashMap<>();
        output.put("echo", message);
        return CompletableFuture.completedFuture(new ToolOutput(output, null));
    }
}