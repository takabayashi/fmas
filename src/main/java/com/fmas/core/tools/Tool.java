package com.fmas.core.tools;

import java.util.concurrent.CompletableFuture;

public interface Tool {
    String getName();

    String getDescription();

    String getInputSchema();

    String getOutputSchema();

    CompletableFuture<ToolOutput> execute(ToolInput input);
}