#FROM openjdk:8-jre-slim
FROM openjdk:8u191-jre-alpine3.8

RUN apk add curl jq

#Workspace
WORKDIR /usr/share/automation

# ADD .jar under target from host
# into this image
ADD target/selenium-docker.jar libs/selenium-docker.jar
ADD target/selenium-docker-tests.jar libs/selenium-docker-tests.jar
ADD target/libs libs
ADD target/classes classes

# in case of any other dependency like .csv / .json /.xls
# please ADD that as well
ADD placeOrders.csv placeOrders.csv

#ADD suite files
ADD AllTests.xml AllTests.xml

#ADD healthcheck.sh
#ADD healthcheck.sh healthcheck.sh

#ENTRYPOINT sh healthcheck.sh
ENTRYPOINT java -cp classes:libs/* -DHUB_HOST=$HUB_HOST -DBROWSER=$BROWSER org.testng.TestNG $MODULE
