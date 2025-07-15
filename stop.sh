#!/bin/bash

SBB_PID=$(ps -ef | grep java | grep sbb | awk '{ print $2 }')

if [ -z "$SBB_PID" ];
then 
	echo "SBB is not running"
else
	kill -9 $SBB_PID
	echo "SBB stopped"
fi
