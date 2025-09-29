#!/bin/bash

echo "🚀 Starting Professional Login System..."
echo

# Check if Java is installed
if ! command -v java &> /dev/null; then
    echo "❌ Java is not installed or not in PATH"
    echo "Please install Java 11 or higher"
    exit 1
fi

# Check if Maven is installed
if ! command -v mvn &> /dev/null; then
    echo "❌ Maven is not installed or not in PATH"
    echo "Please install Maven 3.6 or higher"
    exit 1
fi

echo "✅ Java and Maven found"
echo

# Compile and run the application
echo "🔨 Compiling application..."
mvn clean compile -q

if [ $? -ne 0 ]; then
    echo "❌ Compilation failed"
    exit 1
fi

echo "✅ Compilation successful"
echo

echo "🎨 Launching Professional Login System..."
echo
echo "📝 Default credentials:"
echo "   Username: admin"
echo "   Password: password"
echo

# Run the application
mvn exec:java -Dexec.mainClass="com.loginapp.LoginApp" -q

echo
echo "👋 Application closed"






