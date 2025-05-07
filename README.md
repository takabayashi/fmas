# StreamAgents

StreamAgents is a Java framework for developing intelligent agents in data streaming, built on top of Apache Flink and Apache Kafka.

## 🚀 Features

- Native integration with Apache Flink for stream processing
- Support for agent-to-agent communication (A2A)
- Asynchronous task processing
- Integration with Apache Kafka for data ingestion
- Extensible tools system
- Avro serialization support

## 📋 Prerequisites

- Java 17 or higher
- Maven 3.6 or higher
- Apache Kafka (for streaming examples)
- Apache Flink 1.18.1

## 🛠️ Installation

1. Clone the repository:
```bash
git clone https://github.com/your-username/streamagents.git
cd streamagents
```

2. Build the project:
```bash
mvn clean package
```

## 🏗️ Project Structure

```
src/
├── main/java/com/streamagents/
│   ├── core/           # Framework core
│   │   ├── agents/     # Agent implementations
│   │   ├── tasks/      # Task system
│   │   └── tools/      # Available tools
│   └── examples/       # Usage examples
└── test/              # Unit tests
```

## 💻 Basic Usage

```java
// Creating a simple agent
SimpleAgent agent = new SimpleAgent(
    "agent-1",
    "TestAgent",
    "Process tasks",
    "Backstory of the agent"
);

// Creating a task
Task task = new SimpleTask(
    "task-1",
    "Process message",
    "text",
    Collections.emptyList(),
    Map.of("input", "message"),
    false,
    null
);

// Executing the task
CompletableFuture<TaskOutput> future = agent.executeTask(task, new AgentContext());
TaskOutput output = future.get();
```

## 🔧 Kafka Configuration

To run the examples with Kafka, set up a local Kafka server:

```bash
# Start Zookeeper
bin/zookeeper-server-start.sh config/zookeeper.properties

# Start Kafka
bin/kafka-server-start.sh config/server.properties

# Create test topic
bin/kafka-topics.sh --create --topic test-input --bootstrap-server localhost:9092 --partitions 1 --replication-factor 1
```

## 📦 Main Dependencies

- Apache Flink 1.18.1
- Apache Kafka 3.1.0
- Avro 1.11.1
- SLF4J 2.0.7

## 🤝 Contributing

1. Fork the project
2. Create your Feature Branch (`git checkout -b feature/AmazingFeature`)
3. Commit your changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the Branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

## 📝 License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## 📫 Contact

Your Name - [@your_twitter](https://twitter.com/your_twitter) - email@example.com

Project Link: [https://github.com/your-username/streamagents](https://github.com/your-username/streamagents) 