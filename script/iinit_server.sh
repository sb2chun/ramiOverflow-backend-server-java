echo "> ramiOverflow pid 확인"
CURRENT_PID=$(ps -ef | grep java | grep ramiOverflow | grep -v nohup | awk '{print $2}')
echo "> ${CURRENT_PID}"
if [ -z ${CURRENT_PID} ];
then
	echo "> 현재 구동중인 애플리케이션이 없으므로 종료하지 않습니다."
else
	echo "> sudo kill -9 $CURRENT_PID"
	sudo kill -9 $CURRENT_PID
	sleep 10
fi
echo "> ramiOverflow 배포"
JAR_PATH=$(ls -t /home/sb2chun/ramiOverflow-backend-server-java/deploy/*.jar | head -1)
sudo nohup java -jar -DServer.port=8080 -Dspring.profiles.active=prod ${JAR_PATH} &