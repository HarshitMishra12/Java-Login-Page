# 🔐 SecureAuth Pro - Enterprise Authentication System

A complete enterprise-grade authentication system with both **Java Swing Desktop Application** and **Web Application** implementations. Features modern dark theme UI design, professional styling, and enterprise-grade security.

## 🎯 Project Overview

This project implements **Task 2** (PHP/MySQL Web Application) and **Task 3** (Java Swing Desktop Application) requirements, providing a comprehensive authentication solution with:

- **Desktop Application**: Modern Java Swing with animations and professional UI
- **Web Application**: Complete PHP/MySQL web-based login system
- **Security**: Password hashing, session management, and input validation
- **Modern Design**: Responsive layouts with gradient backgrounds and smooth animations

## ✨ Features

### 🖥️ Desktop Application (Java Swing)
- **Modern UI Design**: Gradient backgrounds, rounded corners, and professional color scheme
- **Smooth Animations**: Fade-in effects, hover animations, and loading states
- **Interactive Elements**: Hover effects on all components with visual feedback
- **Form Validation**: Real-time validation with animated error messages
- **Responsive Design**: Centered layout with proper spacing and alignment
- **Professional Styling**: Custom fonts, colors, and modern design patterns

### 🌐 Web Application (PHP/MySQL)
- **User Registration**: Secure signup with comprehensive validation
- **User Login**: Email/username and password authentication
- **Password Security**: Hashing with `password_hash()` and strength validation
- **Session Management**: Secure session handling and dashboard
- **Database Integration**: MySQL with PDO and prepared statements
- **Modern UI**: Responsive design with CSS3 animations and effects

## 🎨 Design Features

- **Gradient Background**: Beautiful blue-to-green gradient with subtle pattern overlay
- **Rounded Components**: All input fields and buttons have modern rounded corners
- **Hover Effects**: Interactive hover states for better user experience
- **Loading Animation**: Animated loading state during login process
- **Error Handling**: Custom animated error dialogs
- **Smooth Transitions**: Fade-in animation on startup

## 🛠️ Technology Stack

- **Java 11+**: Modern Java features and performance
- **Swing**: Native Java GUI framework
- **Graphics2D**: Custom rendering for animations and effects
- **Maven**: Dependency management and build automation

## 🚀 Quick Start

### 🖥️ Desktop Application (Java Swing)

#### Prerequisites
- Java 11 or higher
- Maven 3.6 or higher

#### Running the Desktop Application

1. **Navigate to the project directory**
   ```bash
   cd "Task 3"
   ```

2. **Compile and run with Maven**
   ```bash
   mvn clean compile exec:java -Dexec.mainClass="com.loginapp.LoginApp"
   ```

3. **Or use the provided scripts**
   ```bash
   # Windows
   run.bat
   
   # Linux/Mac
   ./run.sh
   ```

4. **Or build and run the JAR**
   ```bash
   mvn clean package
   java -jar target/professional-login-system-1.0.0.jar
   ```

### 🌐 Web Application (PHP/MySQL)

#### Prerequisites
- PHP 7.4+ with PDO MySQL extension
- MySQL 5.7+ or MariaDB 10.2+
- Web server (Apache, Nginx, or PHP built-in server)

#### Running the Web Application

1. **Set up the database**
   ```bash
   mysql -u root -p < database/setup.sql
   ```

2. **Configure database connection**
   Edit `web/config/database.php` with your credentials

3. **Start the web server**
   ```bash
   # Using provided scripts
   # Windows
   setup_web.bat
   
   # Linux/Mac
   ./setup_web.sh
   
   # Or manually
   cd web
   php -S localhost:8000
   ```

4. **Access the application**
   - **Login**: http://localhost:8000/index.html
   - **Signup**: http://localhost:8000/signup.html

### Default Credentials
- **Username**: `admin`
- **Password**: `password`

## 🎯 Usage

1. **Launch the application** - The login form will appear with a smooth fade-in animation
2. **Enter credentials** - Type your username and password in the styled input fields
3. **Click Sign In** - The button will show a loading animation during authentication
4. **View results** - Success or error messages will be displayed with animations

## 🎨 Customization

The application is designed to be easily customizable:

- **Colors**: Modify the gradient colors in the `paintComponent` methods
- **Fonts**: Change font families and sizes in the component creation methods
- **Animations**: Adjust timing and effects in the animation methods
- **Layout**: Modify spacing and positioning in the `setupLayout` method

## 📁 Project Structure

```
Task 3/
├── src/main/java/com/loginapp/     # Java Swing Desktop Application
│   ├── LoginApp.java               # Main application entry point
│   └── LoginForm.java              # Main login form with UI and animations
├── web/                            # PHP/MySQL Web Application
│   ├── index.html                  # Login page
│   ├── signup.html                 # Registration page
│   ├── css/style.css               # Modern CSS styles
│   ├── js/script.js                # JavaScript functionality
│   ├── php/                        # PHP backend
│   │   ├── init.php                # Initialization and setup
│   │   ├── auth.php                # Authentication helpers
│   │   ├── login.php               # Login handler
│   │   ├── signup.php              # Registration handler
│   │   ├── dashboard.php           # Protected dashboard
│   │   └── logout.php              # Logout handler
│   ├── config/database.php         # Database configuration
│   └── logs/                       # Error logs
├── database/
│   └── setup.sql                   # Database schema
├── pom.xml                         # Maven configuration
├── run.bat / run.sh                # Desktop app run scripts
├── setup_web.bat / setup_web.sh    # Web app setup scripts
└── README.md                       # This file
```

## 🔧 Development

### Building from Source
```bash
mvn clean compile
```

### Running Tests
```bash
mvn test
```

### Creating Executable JAR
```bash
mvn clean package
```

## 🎪 Animation Details

- **Fade-in Effect**: Window appears with smooth alpha transition
- **Hover Animations**: Components scale and glow on mouse hover
- **Loading States**: Button text changes and disables during authentication
- **Error Feedback**: Custom animated error dialogs with auto-dismiss
- **Smooth Transitions**: All state changes use smooth animations

## 🎨 Color Scheme

- **Primary Gradient**: Blue (#4A90E2) to Green (#50C878)
- **Button Gradient**: Red (#FF6B6B) to Orange (#FF8E53)
- **Text**: Dark Gray (#3C3C3C) on white backgrounds
- **Accents**: White with transparency for modern glass effect

## 📱 Responsive Design

The application is designed to work well on different screen sizes:
- **Minimum Size**: 450x600 pixels
- **Centered Layout**: Always centers on screen
- **Scalable Components**: Input fields and buttons scale appropriately

## 🚀 Performance

- **Hardware Acceleration**: Uses Graphics2D with anti-aliasing
- **Efficient Animations**: Timer-based animations with proper cleanup
- **Memory Management**: Proper disposal of graphics objects
- **Smooth Rendering**: 60fps animations for professional feel

---

**Built with ❤️ using Java Swing and modern UI principles**

