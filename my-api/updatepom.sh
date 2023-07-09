#!/bin/bash 

#####################################################################

#Author: Harris Anyanwu

#Revision: 1.0

#Description: This script updates the pom.xml version (timestamp inclusive), builds and runs the java artifact

#####################################################################

#STEP 1 - SET VARIABLES

# set a command line argument by assigning a value 'POM_FILE' to the pom.xml file
# $1 means you are required to pass one argument, in this case the path to the pom.xml file which will enable the script to locate the pom.xml file
# if you use $2, it means you are expected to pass 2 arguments 
# $(date +%s) is the current epoch time in seconds.


POM_FILE=$1

timestamp=$(date +%s)


# STEP 2: Update project to version 1.0.1.timestamp
# the 'sed' command performs a substitution operation to replace the current project version with the new project version defined by the version number and the current timestamp

sed -i '' "s|<version>1.0.0.1591234567<\/version>|<version>1.0.1.$timestamp<\/version>|" $POM_FILE

# echo pom.xml file is updated with the latest version and current epoch time
echo "$POM_FILE updated with version 1.0.1 ${timestamp}"

# mvn install builds the java package
# the clean flag removes any previous artifact in the target folder. You don't want to have many jar artifacts in your target file.
# '-DskipTests' bypasses unit tests during the build stage

mvn clean install -DskipTests 

# change directory to the target folder where you have the jar artifact
cd target

# run the jar artifact with the updated timestamp and version 
java -jar my-api-1.0.1.$timestamp.jar
