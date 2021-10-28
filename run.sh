gradle --stop
gradle build --continuous --quiet  &
gradle bootRun -Pdebug  --stacktrace --info 