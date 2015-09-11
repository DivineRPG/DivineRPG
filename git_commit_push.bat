@echo off
echo Checking status
git status
echo Staging untracked, modified, and deleted files
CALL git_commit.bat
echo Pushing committed files with message: "%msg%"
CALL git_push.bat
echo Process finished
pause
