#!/usr/bin/env bash
for i in {1..5}
do
  subPort=$((9000 + i))
  nohup java -jar target/bc-1.0-SNAPSHOT.jar --client.pubPort=40125 --client.subPort=$subPort &
done