docker compose down
# docker image rm native-playground
$BuildStartTimestamp = get-date -f yyyy-MM-dd_hh-mm
echo $BuildStartTimestamp
mvn clean org.springframework.boot:spring-boot-maven-plugin:build-image -D skipTests=true -P native,native-fast-build |
 Tee-Object -file ("logs/build-log-$($BuildStartTimestamp).txt") &&
docker compose up -d `
--force-recreate &&
docker logs --follow native-playground-container |
    Tee-Object -file ("logs/run-log-$($BuildStartTimestamp).txt")