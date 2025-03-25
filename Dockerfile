#Use OpenJDK runtime
FROM openjdk:21

#set the working directory to /app
WORKDIR /app

#Copy the current directory contents into the container at /app
COPY build/libs/schedulleNotification-schedule-1.0.jar /app

#Env
ENV SPRING_DATASOURCE_URL=jdbc:postgresql://db-schedule:5432/scheduledb
ENV SPRING_DATASOURCE_USERNAME=scheduleuser
ENV SPRING_DATASOURCE_PASSWORD=schedulepass
ENV SPRING_PROFILES_ACTIVE=prod
#Make the port available to outside.
EXPOSE 8080

#Run simiosHuman.jar when the container launches
CMD [ "java", "-jar", "schedulleNotification-schedule-1.0.jar", "--enable-preview" ]