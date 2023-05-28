#!/bin/sh
export JAVA_HOME=/usr/lib/jvm/java-17-openjdk-amd64/
mvn -DskipTests package appengine:deploy
