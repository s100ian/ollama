# Spring Boot AI and Ollama Workshop

## Introduction

### Brief overview of Spring AI and its capabilities
[Spring AI](https://docs.spring.io/spring-ai/reference/) is an extension of the Spring Framework that simplifies AI integration in Java applications. It provides abstractions over various AI providers and models, offering a consistent API for text generation, image generation, embeddings and more. The library handles authentication, model selection and response processing with Spring's familiar programming model.

### Ollama - lightweight LLM runner for local deployment
[Ollama](https://ollama.com/) is an open-source tool that allows running large language models locally without reliance on cloud services. It features optimized model packaging, simple command-line interface and an HTTP API. Ollama supports various models like Llama, Mistral and Gemma while managing model downloads, weights and inference locally with minimal setup.

## Ollama vs other service AI providers
The main benefits of using Ollama instead of OpenAI or other AI providers include:

- **Local execution**: Ollama runs AI models locally on your hardware, eliminating network latency and internet dependency.

- **Privacy**: Your data never leaves your system, making it suitable for sensitive business information and complying with data residency requirements. Some cloud services store and use **your** data for model improvement, some state they won't do that (see [Microsoft's OpenAI data privacy policy](https://learn.microsoft.com/en-us/legal/cognitive-services/openai/data-privacy?tabs=azure-portal)).

- **Cost efficiency**: No API usage fees or subscription costs compared to commercial services like OpenAI.

- **Customization**: Easier to fine-tune and customize models for your specific domain needs.

- **Control over infrastructure**: You manage the compute resources, scaling, and availability based on your requirements.

- **Offline operation**: Run AI capabilities in air-gapped environments without internet connectivity.

- **Open source ecosystem**: Leverage community-contributed models and integrations.

- **Lower latency**: Reduced response times, especially important for the marking device functionality shown in your code where real-time interaction is needed.

## Why companies release open-source AI models

- **Ecosystem Growth**: Open-sourcing models can accelerate adoption and create a broader ecosystem around a company's technology stack. More developers using the model means more applications and integrations.

- **Community Contributions**: The open source community can help improve the model through testing, finding bugs, and contributing enhancements, effectively distributing R&D efforts.

- **Talent Acquisition**: Being known for open source contributions helps attract AI talent who want to work with cutting-edge technologies and organizations committed to open research.

- **Standards Setting**: By making their models widely available, companies can influence industry standards and technical approaches.

- **Differential Business Model**: Companies may open source the base model while offering premium features, enterprise support, or cloud-based managed services as their revenue stream.

- **Research Advancement**: Open models allow academic researchers to build upon existing work, potentially leading to breakthroughs that benefit the original company.

- **Ethical Considerations**: Transparency through open source can help address concerns about AI bias, safety, and responsible use.

In the case of models like Llama, Meta has pursued this strategy while companies like Anthropic and OpenAI have kept their models closed-source but accessible through APIs.

## Use cases for AI integration in enterprise applications
Enterprise AI applications commonly include:
- Customer service chatbots and virtual assistants
- Document processing and information extraction
- Personalized content generation for marketing
- Code assistance and documentation generation
- Data analysis and pattern recognition
- Decision support systems with contextual recommendations
- Knowledge management with RAG (Retrieval Augmented Generation)
- Process automation for repetitive tasks

These applications leverage local model deployment for enhanced data privacy, reduced latency and controlled operational costs.

## Core Concepts
These core concepts establish the foundation for implementing AI capabilities in Spring Boot applications with Ollama integration.

### Spring AI Architecture and Components
Spring AI follows a modular architecture with several key components:
- **AI Services**: High-level abstractions like `ChatClient`, `EmbeddingClient` and `ImageClient`
- **Model Clients**: Adapters for specific model providers (OpenAI, Anthropic, Ollama, etc.)
- **Prompts Management**: Templates and mechanisms for structured prompt construction
- **Response Handling**: Parsers and processors to extract and format model outputs
- **Tokenization**: Utilities to manage token counting and optimization
- **Vector Store Integration**: Connectors for popular vector databases

### Model Types Supported in Spring AI
Spring AI supports various model types for different tasks:
- **LLMs (Large Language Models)**: For text generation and conversations
- **Embedding Models**: For converting text to vector representations
- **Image Generation Models**: For creating images from text prompts
- **Document Processing Models**: For structured data extraction
- **Multimodal Models**: Supporting both text and image inputs/outputs

### Ollama Model Management and Deployment
Ollama provides streamlined model management:
- **Model Library**: Access to various open models like Llama, Mistral, Phi
- **Pull Command**: Simple model download with `ollama pull <model>`
- **Custom Models**: Creating and customizing models via Modelfiles
- **Quantization Options**: Different precision levels (Q4_0, Q4_K_M, etc.)
- **Model Serving**: Automatic HTTP API exposure on port 11434
- **Resource Management**: Memory and GPU allocation for different models

### Prompt Engineering Basics
Core concepts in effective prompt design:
- **Zero/Few-Shot Learning**: Using examples within prompts
- **Chain of Thought**: Breaking problems into steps for better reasoning
- **System Instructions**: Setting model behavior and constraints
- **Structured Outputs**: Techniques to enforce specific output formats
- **Prompt Templates**: Parameterized prompts for dynamic content
- **Context Windows**: Understanding and managing token limitations

## Technical Setup

### Spring Boot Project Configuration
- **Project Initialization**: Creating a Spring Boot project using Spring Initializr or Spring Boot CLI with Java 17+ compatibility
- **Project Structure**: Standard Spring Boot layout with controllers, services, and configuration classes
- **Application Properties**: Setting up `application.properties` or YAML files with AI-specific configurations
- **Profiles Configuration**: Setting up development/production profiles for different AI service endpoints

### Spring AI Dependency Setup
- **Maven/Gradle Dependencies**: Adding Spring AI BOM (Bill of Materials) and specific dependencies:
  ```xml
  <dependency>
      <groupId>org.springframework.ai</groupId>
      <artifactId>spring-ai-bom</artifactId>
      <version>1.0.0-M6</version>
      <type>pom</type>
      <scope>import</scope>
  </dependency>
  <dependency>
      <groupId>org.springframework.ai</groupId>
      <artifactId>spring-ai-ollama</artifactId>
  </dependency>
  ```
- **Auto-configuration**: How Spring Boot automatically configures AI components based on classpath
- **Bean Definitions**: Setting up custom beans for AI services and clients

### Installing and Configuring Ollama
- **Installation Process**: Platform-specific installation instructions (Linux, macOS, Windows)
- **System Requirements**: CPU/RAM/storage requirements for different model sizes
- **GPU Support Setup**: CUDA configuration for acceleration on NVIDIA GPUs
- **API Configuration**: Setting up API access and security parameters
- **Docker Deployment**: Alternative containerized setup with Docker compose examples

### Loading Models in Ollama
- **Model Library**: Available models from Ollama library
- **Pull Commands**: `ollama run llama3.2` and similar commands for different models
- **Custom Modelfiles**: Creating custom Modelfiles for specialized use cases
- **Quantization Options**: Different quantization levels for memory/performance tradeoffs
- **Model Serving**: Starting and managing model instances through CLI or API
- **Model Verification**: Testing model functionality through Ollama's built-in CLI chat

These technical setup details provide concrete steps for participants to prepare their development environment before moving to the implementation phase of the workshop.

## Implementation Workshop
- Creating a Spring Boot AI service
- Connecting to Ollama models
- Handling prompts and completions
- Link to the repo: [github.com/s100ian/ollama](https://github.com/s100ian/ollama)

## Advanced Topics
These advanced topics extend beyond basic implementation to address sophisticated use cases and optimization techniques when working with LLMs through Spring AI and Ollama.

### Embeddings and Vector Databases
- **Embedding Generation**: Creating vector representations of text using models like `all-MiniLM-L6-v2`
- **Vector Storage**: Integrating with databases such as PostgreSQL (pgvector), Milvus, or Qdrant
- **Similarity Search**: Implementing efficient nearest neighbor queries for semantic matching
- **Dimensionality Optimization**: Techniques for balancing vector size and semantic accuracy
- **Hybrid Search**: Combining vector similarity with keyword-based filtering for better results

### RAG (Retrieval Augmented Generation) with Spring AI
- **Document Processing**: Creating a pipeline for document ingestion, chunking, and embedding
- **Context Selection**: Algorithms for selecting the most relevant documents for a query
- **Prompt Construction**: Building prompts that effectively incorporate retrieved information
- **Answer Synthesis**: Guiding the model to generate responses based on retrieved context
- **Evaluation Framework**: Methods to measure RAG system effectiveness and accuracy

### Streaming Responses
- **Server-Sent Events**: Implementing SSE endpoints for token-by-token delivery
- **Reactive Endpoints**: Using Spring WebFlux for non-blocking streaming responses
- **Client Integration**: Techniques for handling streaming responses in frontend applications
- **Progress Indicators**: Implementing UI feedback during ongoing generation
- **Cancellation Support**: Handling user-initiated cancellation of streaming responses

### Token Management and Optimization
- **Context Window Utilization**: Techniques to maximize the effective use of limited context windows
- **Chunking Strategies**: Methods for breaking documents into optimal semantic units
- **Token Counting**: Implementing tokenization tools to estimate and track token usage
- **Response Trimming**: Techniques to generate concise responses while preserving information
- **Batching Requests**: Combining related requests to reduce overhead and improve throughput

### Model Context Protocol
A standard for connecting AI assistants to the systems where data lives, including content repositories, business tools, and development environments. Its aim is to help frontier models produce better, more relevant responses.

- **Command Standardization**: Creating consistent command formats for model interaction
- **Parameter Binding**: Methods for dynamically injecting variables into model prompts
- **Response Parsing**: Techniques for extracting structured data from free-form responses
- **Context Management**: Maintaining conversational state across multiple interactions
- **Protocol Versioning**: Managing compatibility as model capabilities evolve

## Best Practices
These best practices guide development decisions throughout the application lifecycle, ensuring optimal model utilization, robust security, and efficient performance with Ollama and Spring AI.

### Model Selection Guidelines
- **Task Alignment**: Choose models based on specific use cases (Mistral for reasoning, Llama for creative tasks, Phi for efficiency)
- **Resource Constraints**: Match model size to available hardware (7B models for standard laptops, 3B models for limited resources)
- **Quantization Tradeoffs**: Balance between performance and quality with appropriate quantization levels
- **Specialization Requirements**: Select models with domain expertise for specialized tasks like medical or legal applications
- **Latency Requirements**: Consider smaller models for real-time applications and larger ones for quality-critical offline tasks

### Prompt Design Patterns
- **System Message Structuring**: Define clear AI assistant role and constraints in system messages
- **Few-Shot Learning**: Provide 2-3 high-quality examples of desired input/output pairs
- **Chain of Thought Technique**: Instruct models to "think step by step" for complex reasoning tasks
- **Output Formatting**: Use explicit instructions for output structure like JSON or markdown
- **Context Windowing**: Strategically place most relevant information at the beginning and end of prompts

### Security Considerations
- **Input Sanitization**: Remove potential prompt injection patterns before passing to models
- **Output Filtering**: Implement post-processing to detect and block sensitive/harmful content
- **Authorization Layers**: Apply role-based access controls to AI capabilities
- **Request Validation**: Validate parameters and enforce rate limits on AI endpoints
- **Logging Practices**: Implement comprehensive logging without capturing sensitive user inputs

### Performance Optimization
- **Connection Pooling**: Maintain persistent connections to Ollama API for reduced latency
- **Response Caching**: Implement semantic caching to avoid redundant model calls
- **Batch Processing**: Group similar requests when possible to optimize throughput
- **Async Processing**: Use non-blocking calls with CompletableFuture for parallel requests
- **Resource Management**: Configure appropriate timeouts and graceful degradation strategies
