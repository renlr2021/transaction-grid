#!/bin/sh

set -ex

# 默认环境变量
JAVA_OPTS="-Xms1048m -Xmx1048m -Djava.security.egd=file:/dev/./urandom"

# 载入自定义环境变量
source "/app/env/default.env"

JAR_FILE=`find /app/ -name \*.jar`

exec java $JAVA_OPTS -jar $JAR_FILE
