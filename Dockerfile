FROM openjdk:8
ADD target/pet-clinic-spring-boot.jar pet-clinic-spring-boot.jar
EXPOSE 8085
ENTRYPOINT ["java", "-jar", "pet-clinic-spring-boot.jar"]