#!/usr/bin/env bash

mvn clean package -Dmaven.test.skip=true

echo 'Copy files...'

scp -i ~/.ssh \
    target/demo-0.0.1-SNAPSHOT.jar \
    user@192.168.238.107:/home/user/

echo 'Restart server...'

scp -i ~/.ssh  user@192.168.238.107 <<EOF

pgrep java | xargs kill -9
java -jar demo-0.0.1-SNAPSHOT.jar > log1.txt &

EOF

echo 'Bye'