# wealth-management-platform
The Investment Banking Platform is a modern, production-ready application designed for wealth management and financial planning. Built with Spring Boot and ReactJS/TypeScript, it leverages microservices architecture for scalability and modularity. Key features include GraphQL APIs, Netflix DGS, Spring AI, and event-driven communication via Kafka.

## Git error:
git throws"fatal: the remote end hung up unexpectedly
" error
Cause: Pushing a large amount of data can cause the server to terminate the connection.
Solution: Try splitting your commits into smaller chunks or increase the buffer size with:
### Fix: git config http.postBuffer 524288000  # 500 MB