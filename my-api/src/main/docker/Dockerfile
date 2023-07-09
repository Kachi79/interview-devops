FROM maven:3.8.4-openjdk-11-slim AS builder 
# this is a multi-stage Dockerfile.
# I chose to use a multi-stage Dockerfile to reduce the size of the final image
# using a multi-stage Dockerfile gives you the advantage of including various packages and/or files in the AS builder image
# before passing them to the final image. This as i mentioned above helps keep the final image size reduced
# because of the reduction in the number of build layers in the final image.

WORKDIR /app
# the WORKDIR command allows you to delare your work directory.
# the work directory is where you deploy the files and packages you want to run

COPY target/my-api-1.0.1.1688928905.jar /app/
# the COPY command allows you to copy the artifact or any other file to a specified directory
# in this case, we are copying the jar file from the target folder in our local repository to the workdir in the container

#STAGE 2: creating the final image 

FROM openjdk:11-jre-slim
# here we have specified a second image as our final build image

WORKDIR /app
# again we declare the work directory

COPY --from=builder /app/my-api-1.0.1.1688928905.jar /app/
# we now copy the compiled application in the AS builder image to the work directory in the final image

EXPOSE 8080
# EXPOSE command assigns a port to the container.

CMD ["java", "-jar", "/app/my-api-1.0.1.1688928905.jar"]
#CMD sets the command at runtime
#CMD is a runtime command because it only becomes active at runtime.
# runtime is when a container is being started from an image
# CMD can be bypassed  by passing a command in the terminal during the runtime stage
# here, we declare the application type (java), give the run flag (-jar), 
# and the location/name the jar artifact to be started (/app/my-api-1.0.1.1688928905.jar)