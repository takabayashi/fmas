package com.streamagents.core.agents;

import java.util.concurrent.CompletableFuture;

public interface A2ACommunicator {
    CompletableFuture<A2AResponse> sendA2ARequest(String targetAgentId, A2ARequest request);
}