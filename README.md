# Multi-Services Spring Boot AWS Kafka

This project demonstrates a microservices architecture using Spring Boot, AWS, and Kafka for messaging and communication between services. It includes multiple services communicating through Kafka for event-driven architecture.

## Features
- Microservices Architecture: Built using Spring Boot for multiple services that interact with each other.
- AWS Integration: Utilizes AWS services like Amazon MSK (Managed Streaming for Kafka) for Kafka messaging.
- Kafka Messaging: Each service communicates asynchronously via Kafka topics and consumers.
- Event-Driven Design: Implements event-driven architecture for better scalability and decoupled communication.
- Spring Boot Setup: Configured for easy integration with AWS and Kafka.

## Technologies Used
- **Spring Boot** (Backend framework)
- **Kafka** (Messaging)
- **AWS S3, EC2, SES** (AWS Services)
- **Maven** (Dependency management)

## Prerequisites
- **JDK 8** or higher
- **Maven** for dependency management
- **Kafka setup**
- **AWS account**

## Setup
1. **Clone the repository**:
   ```bash
   git clone https://github.com/rabiyag/multiservices-spring-boot-aws-kafka.git
   cd multiservices-spring-boot-aws-kafka
   ```

2. **Configure Kafka Properties in application.properties for each service**:
    ```properties
    spring.kafka.bootstrap-servers=your-kafka-broker-url
    spring.kafka.consumer.group-id=your-consumer-group
    spring.kafka.consumer.auto-offset-reset=earliest
    ```

3. **Build the project with Maven**:
   ```bash
   mvn clean install
   ```

## Running the Application
1. **Run each service in the project by navigating to the respective service's directory and executing**:

   ```bash
   mvn spring-boot:run
   ```
    

## API Endpoints

**Create Order**: POST /api/orders** (This is an api endpoint in bookingservice.)

Upon creating an order , an event will be sent to kafka topic and emailservice will listen to it.

Upon getting the message, emailservice will send email to user that order has been received.
