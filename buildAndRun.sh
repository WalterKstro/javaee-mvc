#!/bin/sh
mvn clean package && docker build -t gt.com.walterkstro/ctrl-customers .
docker rm -f ctrl-customers || true && docker run -d -p 9080:9080 -p 9443:9443 --name ctrl-customers gt.com.walterkstro/ctrl-customers