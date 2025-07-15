#!/bin/bash

JAR=sbb-0.0.2.jar
LOG=~/sbb/sbb.log

nohup java -Dspring.profiles.active=prod -Dserver.port=8000 -jar $JAR > $LOG 2>&1 &

## change JAR value to match JAR file location
