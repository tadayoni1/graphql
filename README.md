# graphql
A sample graphql project


# Running application
`mvn spring-boot:run`

# Testing application
1. Open postman and set the request to POST
1. Enter this url `http://localhost:8080/graphql/`
1. ake sure to add a Header with `Content-Type` as `application/json`.
1. Set the body to raw and add this query 
    1. `{"query":"{findAllDogs{ name id breed}}"}`
