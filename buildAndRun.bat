@echo off
call mvn clean package
call docker build -t gt.com.walterkstro/ctrl-customers .
call docker rm -f ctrl-customers
call docker run -d -p 9080:9080 -p 9443:9443 --name ctrl-customers gt.com.walterkstro/ctrl-customers