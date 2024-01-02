@echo off

if not exist "%JAVA_HOME%\bin\java.exe" echo Please set the JAVA_HOME variable in your environment, We need java(x64)! jdk8 or later is better! & EXIT /B 1
set "JAVA=%JAVA_HOME%\bin\java.exe"

setlocal enabledelayedexpansion

set BASE_DIR=%~dp0
rem added double quotation marks to avoid the issue caused by the folder names containing spaces.
rem removed the last 5 chars(which means \bin\) to get the base DIR.
set BASE_DIR="%BASE_DIR:~0,-5%"

set CUSTOM_SEARCH_LOCATIONS=file:%BASE_DIR%/conf/

set SERVER=t-music-server

set "MUSIC_JVM_OPTS=-Xms512m -Xmx512m -Xmn256m"

rem set music server options
set "MUSIC_OPTS=%MUSIC_OPTS% -jar %BASE_DIR%\target\%SERVER%.jar"

rem set music server spring config location
set "MUSIC_CONFIG_OPTS=--spring.config.additional-location=%CUSTOM_SEARCH_LOCATIONS%"

rem set music server log4j file location
set "MUSIC_LOG4J_OPTS=--logging.config=%BASE_DIR%/conf/t-music-server-logback.xml"

set COMMAND="%JAVA%" %MUSIC_JVM_OPTS% %MUSIC_OPTS% %MUSIC_CONFIG_OPTS% %MUSIC_LOG4J_OPTS% music.server %*

echo "music server is starting..."

rem start music server command
%COMMAND%

echo "music server is started!"
