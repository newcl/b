#!/usr/bin/env bash
for i in {1..100}
do
  subPort=$((9000 + i))
  java -jar target/bc-1.0-SNAPSHOT.jar --client.pubPort=40125 --client.subPort=$subPort &
done