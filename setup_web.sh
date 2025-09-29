#!/bin/bash

echo "🌐 Setting up Professional Login System - Web Application"
echo

# Check if PHP is installed
if ! command -v php &> /dev/null; then
    echo "❌ PHP is not installed or not in PATH"
    echo "Please install PHP 7.4 or higher with PDO MySQL extension"
    exit 1
fi

# Check if MySQL is available
if ! command -v mysql &> /dev/null; then
    echo "⚠️  MySQL client not found in PATH"
    echo "Please ensure MySQL is installed and accessible"
    echo
fi

echo "✅ PHP found"
echo

# Create logs directory
if [ ! -d "web/logs" ]; then
    mkdir -p "web/logs"
    echo "✅ Created logs directory"
fi

# Set up database
echo "🔨 Setting up database..."
echo "Please enter your MySQL root password when prompted:"
mysql -u root -p < database/setup.sql

if [ $? -ne 0 ]; then
    echo "❌ Database setup failed"
    echo "Please check your MySQL credentials and try again"
    exit 1
fi

echo "✅ Database setup successful"
echo

# Start web server
echo "🚀 Starting web server..."
echo
echo "📝 Access the application at:"
echo "   Login: http://localhost:8000/index.html"
echo "   Signup: http://localhost:8000/signup.html"
echo
echo "📝 Default test credentials:"
echo "   Username: admin"
echo "   Password: password"
echo
echo "Press Ctrl+C to stop the server"
echo

cd web
php -S localhost:8000

echo
echo "👋 Web server stopped"
