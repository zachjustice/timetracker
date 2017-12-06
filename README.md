To push to pcf timetracker app:

```
./gradlew clean build
cf push timetracker -p build/libs/my-jar-file.jar
```