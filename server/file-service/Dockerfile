FROM java:8
# WORKDIR /file
#ENV 格式为  ENV <key> <value> 指定一个环境变量，会被后续  RUN  指令使用，并在容器运行时保持。
ENV PROJECT_ARTIFACTID="file" PROJECT_VERSION="0.0.1-SNAPSHOT"
#当使用本地目录为源目录时，推荐使用 COPY
# COPY target/$PROJECT_ARTIFACTID-$PROJECT_VERSION.jar /file/file.jar
COPY target/$PROJECT_ARTIFACTID-$PROJECT_VERSION.jar .
EXPOSE 8084
ENTRYPOINT ["java", "-jar", "file.jar"]