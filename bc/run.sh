#!/usr/bin/env bash
for i in {1..50}
do
  subPort=$((9000 + i))
  nohup java -jar target/bc-1.0-SNAPSHOT.jar --client.pubPort=40124 --client.subPort=$subPort &
done
