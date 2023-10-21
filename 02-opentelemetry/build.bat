call gradle spring-open-telemetry-1:bootjar
copy .\spring-open-telemetry-1\build\libs\spring-open-telemetry-1-0.0.1-SNAPSHOT.jar spring-open-telemetry-1.jar

call gradle spring-open-telemetry-2:bootjar
copy .\spring-open-telemetry-2\build\libs\spring-open-telemetry-2-0.0.1-SNAPSHOT.jar spring-open-telemetry-2.jar

START .\start-1.bat
START .\start-2.bat
pause
