FROM alpine
RUN apk add openjdk11
RUN apk add curl jq
ENV PATH=$PATH:/usr/lib/jvm/java-11-openjdk/bin
WORKDIR /runs/tests
ADD target/Docker_Selenium-1.0-SNAPSHOT.jar            Docker_Selenium-1.0-SNAPSHOT.jar
ADD target/Docker_Selenium-1.0-SNAPSHOT-tests.jar      Docker_Selenium-1.0-SNAPSHOT-tests.jar
ADD target/libs										   libs
ADD healthcheck.sh  								   healthcheck.sh
ADD FlightBookingTest.xml							   FlightBookingTest.xml
ADD SearchModuleTest.xml							   SearchModuleTest.xml
ENTRYPOINT sh healthcheck.sh