curl -d'{"lastName":"Parker"}' -H'Content-Type:application/json'  -k http://localhost:8080/employee/lastName
curl -d'{"lastName":"Parker", "firstName":"Peter", "age":20, "email":"spiderman@web.com", "id":1}' -H'Content-Type:application/json'  -k http://localhost:8080/employee/save
curl -k http://localhost:8080/employee/all
