# Fieldwire-API-Challenge

## Introduction

Build an API for a service that allows users to manage projects and floorplans.
Here’s what the typical new user flow would look like using the API:
1. User creates a project
2. User uploads image(s) that are processed and become floorplans in that project
3. User can then manipulate existing projects and floorplans

## Install

MySQL version 5.6 or better. 

JDK 1.8 or later

Maven 3.2+

## Run
```mvn spring-boot:run```


## API

#### Projects:

`curl  --request GET  http://localhost:8080/projects`

`curl  --request GET  http://localhost:8080/projects/0`

`curl -H "Content-Type: application/json" --request POST --data '{"name":"project one"}' http://localhost:8080/projects`

`curl -H "Content-Type: application/json" --request PATCH --data '{"name":"project zero"}' http://localhost:8080/projects/0`

`curl  --request DELETE  http://localhost:8080/projects/0`

#### Floorplans:

`curl  --request GET  http://localhost:8080/projects/0/floorplans`

`curl  --request GET  http://localhost:8080/projects/0/floorplans/0`

`curl -H "Content-Type: application/json" --request POST --data '{"name":"floorplan one", "project_id":"0", "original":"/Users/pujiewang/Desktop/one.jpg"}' http://localhost:8080/projects/0/floorplans`

`curl -H "Content-Type: application/json" --request PATCH --data '{"name":"floorplan ten", "original":"/Users/pujiewang/Desktop/two.jpg"}' http://localhost:8080/projects/0/floorplans/0`

`curl  --request DELETE  http://localhost:8080/projects/0/floorplans/0`