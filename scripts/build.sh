#!/bin/bash -eux

echo "---> scripts/build.sh"

echo "execute maven build..."
mvn clean install -U -Dmaven.test.skip=true

