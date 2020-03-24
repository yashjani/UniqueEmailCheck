Project have spring boot behaviour so please import as maven and run it.

POST : http://localhost:8080/api/emailcheck
Payload :[
	"test.te@gmail.com",
	"test.te@gmail.com",
	"test+te@gmail.com",
	"test.te@yahoo.com",
	"+.@gmail.com",
	".@gmail.com",
	"@gmail.com.t",
	"tgamil.com"
]

1. Comprasion is enabled in application.properties file for request and response payload(If request or response have huge payload system      will take care of it by comparasion and will make sure request get fulfilled on time).
2. Global Exception handler is written in case of system failure.
3. Tried to cover diffrent input.
