# Testing Pyramid

## Unit Testing
Smallest Unit of the code will be tested. We mok the Database and API.

## Integrated Testing
Actual API will be invoked in the testing. We don't mok the database and API. We mok the outside the system. In Microservices if microservice is outside of current service then we mok outside one.

## End-to-End Testing
Same as Integration Test, We don't mok other APIs as well. We start al the server and connection with each other. We don't mok anything in E2E Testing. No Mock inside system, can be testing with UI.

## Acceptance Testing
Acceptance test can be anything from above testing, these tests are provided by the business. Business will provide the flow of testing and according to that flow we perform the testing. 

## Contract Testing
We keep testing multiple microservices. We store the product request and response, We store the mocked response and use it whenever required. 