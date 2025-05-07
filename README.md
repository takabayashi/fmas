# StreamAgents

StreamAgents é um framework Java para desenvolvimento de agentes inteligentes em streaming de dados, construído sobre Apache Flink e Apache Kafka.

## 🚀 Características

- Integração nativa com Apache Flink para processamento de streaming
- Suporte a comunicação entre agentes (A2A - Agent-to-Agent)
- Processamento assíncrono de tarefas
- Integração com Apache Kafka para ingestão de dados
- Sistema de ferramentas extensível
- Suporte a serialização Avro

## 📋 Pré-requisitos

- Java 17 ou superior
- Maven 3.6 ou superior
- Apache Kafka (para exemplos de streaming)
- Apache Flink 1.18.1

## 🛠️ Instalação

1. Clone o repositório:
```bash
git clone https://github.com/seu-usuario/streamagents.git
cd streamagents
```

2. Compile o projeto:
```bash
mvn clean package
```

## 🏗️ Estrutura do Projeto

```
src/
├── main/java/com/streamagents/
│   ├── core/           # Núcleo do framework
│   │   ├── agents/     # Implementações de agentes
│   │   ├── tasks/      # Sistema de tarefas
│   │   └── tools/      # Ferramentas disponíveis
│   └── examples/       # Exemplos de uso
└── test/              # Testes unitários
```

## 💻 Uso Básico

```java
// Criando um agente simples
SimpleAgent agent = new SimpleAgent(
    "agent-1",
    "TestAgent",
    "Process tasks",
    "Backstory of the agent"
);

// Criando uma tarefa
Task task = new SimpleTask(
    "task-1",
    "Process message",
    "text",
    Collections.emptyList(),
    Map.of("input", "message"),
    false,
    null
);

// Executando a tarefa
CompletableFuture<TaskOutput> future = agent.executeTask(task, new AgentContext());
TaskOutput output = future.get();
```

## 🔧 Configuração do Kafka

Para executar os exemplos com Kafka, configure um servidor Kafka local:

```bash
# Iniciar o Zookeeper
bin/zookeeper-server-start.sh config/zookeeper.properties

# Iniciar o Kafka
bin/kafka-server-start.sh config/server.properties

# Criar o tópico de teste
bin/kafka-topics.sh --create --topic test-input --bootstrap-server localhost:9092 --partitions 1 --replication-factor 1
```

## 📦 Dependências Principais

- Apache Flink 1.18.1
- Apache Kafka 3.1.0
- Avro 1.11.1
- SLF4J 2.0.7

## 🤝 Contribuindo

1. Faça um Fork do projeto
2. Crie uma Branch para sua Feature (`git checkout -b feature/AmazingFeature`)
3. Commit suas mudanças (`git commit -m 'Add some AmazingFeature'`)
4. Push para a Branch (`git push origin feature/AmazingFeature`)
5. Abra um Pull Request

## 📝 Licença

Este projeto está sob a licença MIT. Veja o arquivo [LICENSE](LICENSE) para mais detalhes.

## 📫 Contato

Seu Nome - [@seu_twitter](https://twitter.com/seu_twitter) - email@exemplo.com

Link do Projeto: [https://github.com/seu-usuario/streamagents](https://github.com/seu-usuario/streamagents) 