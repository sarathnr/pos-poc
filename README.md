# Zooplus Rest API
REST API(s) to create a customer, add an order and register the payment.
# DB
H2 in-memory db

Client - http://localhost:8080/pos-poc/h2-console/

# API(s)
* Customer signup
* Create Order
* Register payment

# API Documentation
* OpenAPI doc - /api-docs/openapi.yaml
* Swagger URL - http://localhost:8080/pos-poc/swagger-ui.html

# Assumptions

* Customer balance: Debit or credit amount for the order in case of no previous balance. In case of existing customer balance from previous order,  debit or credit amount adjusted from existing balance
* Order balance: Debit amount for the order

# Known issues
Mocked mapper object comes off as null which fails the test in service classes. Hence have disabled few tests for convenience.

