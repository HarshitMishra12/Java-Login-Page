<?php
/**
 * Login Handler - Professional Login System
 * Handles user authentication and session management
 */

session_start();
require_once '../config/database.php';

// Check if form was submitted
if ($_SERVER['REQUEST_METHOD'] !== 'POST') {
    header('Location: ../index.html');
    exit;
}

// Get form data
$username = trim($_POST['username'] ?? '');
$password = $_POST['password'] ?? '';

// Validate input
$errors = [];

if (empty($username)) {
    $errors[] = 'Username or email is required';
}

if (empty($password)) {
    $errors[] = 'Password is required';
}

// If there are validation errors, redirect back with error
if (!empty($errors)) {
    $_SESSION['error'] = implode(', ', $errors);
    header('Location: ../index.html');
    exit;
}

try {
    // Get database connection
    $pdo = getDBConnection();
    
    // Prepare query to find user by username or email
    $stmt = $pdo->prepare("SELECT id, username, email, password FROM users WHERE username = ? OR email = ?");
    $stmt->execute([$username, $username]);
    $user = $stmt->fetch();
    
    // Check if user exists and password is correct
    if ($user && password_verify($password, $user['password'])) {
        // Login successful - start session
        $_SESSION['user_id'] = $user['id'];
        $_SESSION['username'] = $user['username'];
        $_SESSION['email'] = $user['email'];
        $_SESSION['logged_in'] = true;
        
        // Redirect to dashboard
        header('Location: dashboard.php');
        exit;
    } else {
        // Invalid credentials
        $_SESSION['error'] = 'Invalid username/email or password';
        header('Location: ../index.html');
        exit;
    }
    
} catch (PDOException $e) {
    error_log("Login error: " . $e->getMessage());
    $_SESSION['error'] = 'An error occurred during login. Please try again.';
    header('Location: ../index.html');
    exit;
} catch (Exception $e) {
    error_log("Login error: " . $e->getMessage());
    $_SESSION['error'] = 'An unexpected error occurred. Please try again.';
    header('Location: ../index.html');
    exit;
}
?>
