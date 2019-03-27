.DEFAULT_GOAL := build-run

build-run: build run

build:
	./mvnw verify
	chmod +x ./target/spring-demo4-0.0.1-SNAPSHOT.jar

run:
	./mvnw spring-boot:run -Dspring.profiles.active=local
#	./target/spring-demo4-0.0.1-SNAPSHOT.jar
#	java -jar ./target/spring-demo4-0.0.1-SNAPSHOT.jar

clear:
	./mvnw clear

test:
	./mvnw test

update:
	./mvnw versions:update-parent versions:update-properties versions:display-plugin-updates

init:
	mvn -N io.takari:maven:wrapper -Dmaven=3.6.0
	chmod +x ./mvnw
	ln -s ./src/main/java lombok
	ln -s ./src/test/java lombok
	echo "/src/main/lombok" >> ./git/info/exclude
	echo "/src/test/lombok" >> ./git/info/exclude

delombok:
	./mvnw clean
	mkdir -p ./target/generated-sources/delombok ./target/generated-test-sources/delombok
	./mvnw lombok:delombok lombok:testDelombok
