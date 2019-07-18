# elasticuser

A very simple demo that models users stored in an ElasticSearch backend,
exposed via Spring Data REST along with an integration test. 

## Building

Use `./mvnw clean package` to run the (rather non-existant) unit tests, integration tests 
and to create the JAR and docker image. 

## Examples

(see also: [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/))

Create an user:

`curl -i -X POST -H "Content-Type:application/json" -d '{"email": "foo@example.org", "firstName": "foo", "lastName": "bar"}' http://localhost:8080/users`

List users:

`curl http://localhost:8080/users`

Create/Update an user:

`curl -i -X PUT -H "Content-Type:application/json" -d '{"email": "foo@example.org", "firstName": "car", "lastName": "bar"}' http://localhost:8080/users/foo@example.org`

Delete an user:

`curl -i -X DELETE http://localhost:8080/users/foo@example.org`
