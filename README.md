First of all you need to install mvn in your computer <br />
You can find validate.bat file in the project
--To run the application in command line you should run: validate.bat *.txt
If this file in another directory please use the exact path like C:\Users\user\project\*.txt
It is for windows if you want to test in linux please make sure using linux paths

I tested below cases and added unit tests
- If any row and column contain any invalid number (For example in 9x9 board it should not be contain values that smaller than 0 and bigger than 9) It will return error message
- If any row and column contain repeated numbers it will return error message
- If any subsquare contains any invalid number or repeated values it will return error message
- For file reading: If file is not located in given path it will return error message
- If file contains empty line or rows and colums that are not equal it will return error message 

Test reports can be found under target/surefire-reports directory
