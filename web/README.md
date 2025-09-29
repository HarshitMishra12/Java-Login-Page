# 🌐 Professional Login System - Web Application

A complete, secure web-based login and signup system built with PHP, MySQL, HTML, CSS, and JavaScript.

## ✨ Features

### 🔐 Authentication & Security
- **User Registration**: Secure signup with validation
- **User Login**: Email/username and password authentication
- **Password Hashing**: Secure password storage using PHP's `password_hash()`
- **Session Management**: Secure session handling
- **Input Validation**: Server-side and client-side validation
- **SQL Injection Protection**: Prepared statements
- **XSS Protection**: Input sanitization

### 🎨 Modern UI/UX
- **Responsive Design**: Works on all devices
- **Modern CSS**: Gradient backgrounds, rounded corners, animations
- **Interactive Elements**: Hover effects, loading states
- **Form Validation**: Real-time client-side validation
- **Password Strength Indicator**: Visual password strength feedback
- **Error Handling**: User-friendly error messages

### 🛠️ Technical Features
- **Clean Code**: Well-structured, commented code
- **Security Best Practices**: CSRF protection, input sanitization
- **Database Integration**: MySQL with PDO
- **Error Logging**: Comprehensive error tracking
- **Session Security**: Secure session management

## 🚀 Quick Start

### Prerequisites
- **PHP 7.4+** with PDO MySQL extension
- **MySQL 5.7+** or **MariaDB 10.2+**
- **Web Server** (Apache, Nginx, or PHP built-in server)

### Installation

1. **Clone/Download the project**
   ```bash
   # If using git
   git clone <repository-url>
   cd "Task 3/web"
   ```

2. **Set up the database**
   ```bash
   # Import the database schema
   mysql -u root -p < ../database/setup.sql
   ```

3. **Configure database connection**
   Edit `config/database.php` with your database credentials:
   ```php
   define('DB_HOST', 'localhost');
   define('DB_NAME', 'user_auth');
   define('DB_USER', 'your_username');
   define('DB_PASS', 'your_password');
   ```

4. **Start the web server**
   ```bash
   # Using PHP built-in server
   php -S localhost:8000
   
   # Or using Apache/Nginx
   # Point document root to the 'web' directory
   ```

5. **Access the application**
   Open your browser and go to:
   - **Login**: `http://localhost:8000/index.html`
   - **Signup**: `http://localhost:8000/signup.html`

## 📁 Project Structure

```
web/
├── index.html              # Login page
├── signup.html             # Registration page
├── css/
│   └── style.css           # Modern CSS styles
├── js/
│   └── script.js           # JavaScript functionality
├── php/
│   ├── init.php            # Initialization and setup
│   ├── auth.php            # Authentication helpers
│   ├── login.php           # Login handler
│   ├── signup.php          # Registration handler
│   ├── dashboard.php       # Protected dashboard
│   └── logout.php          # Logout handler
├── config/
│   └── database.php        # Database configuration
└── logs/                   # Error logs (auto-created)
```

## 🎯 Usage

### For Users

1. **Registration**
   - Visit the signup page
   - Fill in username, email, and password
   - Confirm password
   - Click "Create Account"

2. **Login**
   - Visit the login page
   - Enter username/email and password
   - Click "Sign In"

3. **Dashboard**
   - View account information
   - Access account settings
   - Logout when done

### For Developers

1. **Database Schema**
   ```sql
   CREATE TABLE users (
       id INT PRIMARY KEY AUTO_INCREMENT,
       username VARCHAR(50) UNIQUE NOT NULL,
       email VARCHAR(100) UNIQUE NOT NULL,
       password VARCHAR(255) NOT NULL,
       created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
       updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
   );
   ```

2. **Security Features**
   - Password hashing with `password_hash()`
   - Prepared statements for SQL injection protection
   - Input sanitization with `htmlspecialchars()`
   - Session security with proper cleanup
   - CSRF token support (ready for implementation)

## 🔧 Configuration

### Database Settings
Edit `config/database.php`:
```php
define('DB_HOST', 'localhost');    // Database host
define('DB_NAME', 'user_auth');   // Database name
define('DB_USER', 'root');        // Database username
define('DB_PASS', '');            // Database password
```

### Security Settings
- Change default passwords in production
- Enable HTTPS in production
- Configure proper file permissions
- Set up proper error logging

## 🎨 Customization

### Styling
- Edit `css/style.css` for visual changes
- Modify color schemes in CSS variables
- Add custom animations and effects

### Functionality
- Add new form fields in HTML
- Update validation in PHP files
- Add new features in JavaScript

## 🐛 Troubleshooting

### Common Issues

1. **Database Connection Error**
   - Check database credentials in `config/database.php`
   - Ensure MySQL is running
   - Verify database exists

2. **Permission Errors**
   - Check file permissions on logs directory
   - Ensure web server can write to logs

3. **Session Issues**
   - Check PHP session configuration
   - Ensure session directory is writable

### Debug Mode
Enable debug mode by setting in `php/init.php`:
```php
ini_set('display_errors', 1);
error_reporting(E_ALL);
```

## 📝 API Reference

### PHP Functions

#### `isLoggedIn()`
Returns true if user is logged in.

#### `requireAuth()`
Redirects to login if user is not authenticated.

#### `getCurrentUser()`
Returns current user data array.

#### `sanitizeInput($data)`
Sanitizes input data for security.

#### `validatePassword($password)`
Validates password strength.

## 🔒 Security Considerations

- **Password Security**: Uses PHP's `password_hash()` with default algorithm
- **SQL Injection**: Protected with prepared statements
- **XSS Protection**: Input sanitization with `htmlspecialchars()`
- **Session Security**: Proper session management and cleanup
- **Input Validation**: Both client-side and server-side validation

## 🚀 Production Deployment

1. **Environment Setup**
   - Use production database
   - Enable HTTPS
   - Configure proper file permissions

2. **Security Hardening**
   - Change default passwords
   - Enable error logging
   - Disable debug mode
   - Use environment variables for sensitive data

3. **Performance Optimization**
   - Enable PHP OPcache
   - Use CDN for static assets
   - Configure proper caching headers

## 📄 License

This project is part of a professional development task and is for educational purposes.

---

**Built with ❤️ using PHP, MySQL, HTML5, CSS3, and JavaScript**
