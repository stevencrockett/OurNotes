#!/bin/bash

curl -v -H "Content-Type: application/json" -d '{"groupId":"TEST GROUP", "content":"TEST CONTENT"}' http://localhost:8080/ournotes/api/v1/notes