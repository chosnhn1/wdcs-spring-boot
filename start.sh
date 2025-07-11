#!/bin/bash

JAR=sbb-0.0.2.jar
LOG=/home/ubuntu/sbb/sbb.log

nohup java -Dspring.profiles.active=prod -jar $JAR > $LOG 2>&1 &

## change JAR value to match JAR file location
