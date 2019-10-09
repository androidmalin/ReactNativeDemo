#!/bin/bash
#stop react-native start ==> starts the webserver
#ps -ef | grep "launchPackager.command" | grep -v "grep" | awk 'NR==1' | awk  '{print $2}' | xargs sudo kill
killall node
