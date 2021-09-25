# 基础镜像
FROM java:8-alpine

# 安装初始化程序
RUN apk add --no-cache tini

# 设置容器工作目录
WORKDIR /app

# 拷贝文件至镜像容器
COPY ./docker/env/*.env /app/env/
COPY ./docker/entrypoint-docker.sh /app/entrypoint-docker.sh
COPY ./grid-starter/target/*.jar /app/


# 启动命令
ENTRYPOINT ["tini", "--", "/bin/sh", "./entrypoint-docker.sh"]
