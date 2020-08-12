@echo off
echo Selected file is %1

mvn install
mvn spring-boot:run -Dspring-boot.run.arguments=%1