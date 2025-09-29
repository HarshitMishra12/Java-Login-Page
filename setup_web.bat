@echo off
echo 🌐 Setting up SecureAuth Pro - Web Application
echo.

REM Check if PHP is installed
php -v >nul 2>&1
if %errorlevel% neq 0 (
    echo ❌ PHP is not installed or not in PATH
    echo Please install PHP 7.4 or higher with PDO MySQL extension
    pause
    exit /b 1
)

REM Check if MySQL is available
mysql --version >nul 2>&1
if %errorlevel% neq 0 (
    echo ⚠️  MySQL client not found in PATH
    echo Please ensure MySQL is installed and accessible
    echo.
)

echo ✅ PHP found
echo.

REM Create logs directory
if not exist "web\logs" (
    mkdir "web\logs"
    echo ✅ Created logs directory
)

REM Set up database
echo 🔨 Setting up database...
echo Please enter your MySQL root password when prompted:
mysql -u root -p < database\setup.sql

if %errorlevel% neq 0 (
    echo ❌ Database setup failed
    echo Please check your MySQL credentials and try again
    pause
    exit /b 1
)

echo ✅ Database setup successful
echo.

REM Start web server
echo 🚀 Starting web server...
echo.
echo 📝 Access the application at:
echo    Login: http://localhost:8000/index.html
echo    Signup: http://localhost:8000/signup.html
echo.
echo 📝 Default test credentials:
echo    Username: admin
echo    Password: password
echo.
echo Press Ctrl+C to stop the server
echo.

cd web
php -S localhost:8000

echo.
echo 👋 Web server stopped
pause
