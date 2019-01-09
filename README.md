# aws_customauth
There are three Java Lambda functions, two of them intended to be exposed over API Gateway. These projects are intended to help someone trying to secure a webservice through a JWT token. Hopefully it would help someone.
* Token Generator
* Token Validator
* A Simple service that needs to be secured

The Token Generator project generates a JWT token using a username and password. Token Validator is not exposed directly, but acts as validating the JWT token that is sent as a header when calling a simple service.
