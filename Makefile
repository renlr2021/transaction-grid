# import config.
# You can change the default config with `make cnf="config_special.env" build`
cnf ?= ./docker/env/default.env
include $(cnf)
export $(shell sed 's/=.*//' $(cnf))

APP_NAME ?= transaction-grid
APP_PORT ?= 15089


# HELP
.PHONY: help

help: ## 帮助信息
	@awk 'BEGIN {FS = ":.*?## "} /^[a-zA-Z_-]+:.*?## / {printf "\033[36m%-30s\033[0m %s\n", $$1, $$2}' $(MAKEFILE_LIST)

.DEFAULT_GOAL := help



build: ## 编译项目并构建镜像
	bash ./scripts/build.sh
	docker build -t ${APP_NAME} -f ./docker/Dockerfile .

run: ## 启动镜像
	docker run -d --rm -p=$(APP_PORT):$(APP_PORT) --name="$(APP_NAME)" $(APP_NAME)

buildrun: build run ## 执行编译构建并启动镜像

stop: ## 停止正在运行的容器
	docker stop $(APP_NAME); docker rm $(APP_NAME)

