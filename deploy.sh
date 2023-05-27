#!/bin/sh
export JAVA_HOME=/usr/lib/jvm/java-17-openjdk-amd64/
./mvnw -DskipTests package appengine:deploy
