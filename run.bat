@echo off
echo 🚀 Starting SecureAuth Pro - Enterprise Authentication...
echo.

REM Check if Java is installed
java -version >nul 2>&1
if %errorlevel% neq 0 (
    echo ❌ Java is not installed or not in PATH
    echo Please install Java 11 or higher
    pause
    exit /b 1
)

REM Check if Maven is installed
mvn -version >nul 2>&1
if %errorlevel% neq 0 (
    echo ❌ Maven is not installed or not in PATH
    echo Please install Maven 3.6 or higher
    pause
    exit /b 1
)

echo ✅ Java and Maven found
echo.

REM Compile and run the application
echo 🔨 Compiling application...
mvn clean compile -q

if %errorlevel% neq 0 (
    echo ❌ Compilation failed
    pause
    exit /b 1
)

echo ✅ Compilation successful
echo.

echo 🎨 Launching SecureAuth Pro...
echo.
echo 📝 Default credentials:
echo    Username: admin
echo    Password: password
echo.

REM Run the application
mvn exec:java -Dexec.mainClass="com.loginapp.LoginApp" -q

echo.
echo 👋 Application closed
pause


