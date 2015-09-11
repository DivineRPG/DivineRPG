@echo off
echo Adding all non ignored files
git add -A
set /p msg="Enter commit message: "
echo Committing added files
git commit -m "%msg%"
