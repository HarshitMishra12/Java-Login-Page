<?php
/**
 * Signup Handler - Professional Login System
 * Handles user registration with validation and security
 */

session_start();
require_once '../config/database.php';

// Check if form was submitted
if ($_SERVER['REQUEST_METHOD'] !== 'POST') {
    header('Location: ../signup.html');
    exit;
}

// Get form data
$username = trim($_POST['username'] ?? '');
$email = trim($_POST['email'] ?? '');
$password = $_POST['password'] ?? '';
$confirm_password = $_POST['confirm_password'] ?? '';

// Validate input
$errors = [];

// Username validation
if (empty($username)) {
    $errors[] = 'Username is required';
} elseif (strlen($username) < 3) {
    $errors[] = 'Username must be at least 3 characters long';
} elseif (!preg_match('/^[a-zA-Z0-9_]+$/', $username)) {
    $errors[] = 'Username can only contain letters, numbers, and underscores';
}

// Email validation
if (empty($email)) {
    $errors[] = 'Email is required';
} elseif (!filter_var($email, FILTER_VALIDATE_EMAIL)) {
    $errors[] = 'Please enter a valid email address';
}

// Password validation
if (empty($password)) {
    $errors[] = 'Password is required';
} elseif (strlen($password) < 6) {
    $errors[] = 'Password must be at least 6 characters long';
}

// Confirm password validation
if (empty($confirm_password)) {
    $errors[] = 'Please confirm your password';
} elseif ($password !== $confirm_password) {
    $errors[] = 'Passwords do not match';
}

// If there are validation errors, redirect back with error
if (!empty($errors)) {
    $_SESSION['error'] = implode(', ', $errors);
    header('Location: ../signup.html');
    exit;
}

try {
    // Get database connection
    $pdo = getDBConnection();
    
    // Check if username already exists
    $stmt = $pdo->prepare("SELECT id FROM users WHERE username = ?");
    $stmt->execute([$username]);
    if ($stmt->fetch()) {
        $_SESSION['error'] = 'Username already exists. Please choose a different one.';
        header('Location: ../signup.html');
        exit;
    }
    
    // Check if email already exists
    $stmt = $pdo->prepare("SELECT id FROM users WHERE email = ?");
    $stmt->execute([$email]);
    if ($stmt->fetch()) {
        $_SESSION['error'] = 'Email already exists. Please use a different email address.';
        header('Location: ../signup.html');
        exit;
    }
    
    // Hash the password
    $hashedPassword = password_hash($password, PASSWORD_DEFAULT);
    
    // Insert new user into database
    $stmt = $pdo->prepare("INSERT INTO users (username, email, password) VALUES (?, ?, ?)");
    $result = $stmt->execute([$username, $email, $hashedPassword]);
    
    if ($result) {
        // Registration successful
        $_SESSION['success'] = 'Account created successfully! Please log in with your credentials.';
        header('Location: ../index.html');
        exit;
    } else {
        throw new Exception('Failed to create account');
    }
    
} catch (PDOException $e) {
    error_log("Signup error: " . $e->getMessage());
    $_SESSION['error'] = 'An error occurred during registration. Please try again.';
    header('Location: ../signup.html');
    exit;
} catch (Exception $e) {
    error_log("Signup error: " . $e->getMessage());
    $_SESSION['error'] = 'An unexpected error occurred. Please try again.';
    header('Location: ../signup.html');
    exit;
}
?>
