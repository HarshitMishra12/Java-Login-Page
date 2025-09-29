<?php
/**
 * Initialization File - Professional Login System
 * Sets up error handling, sessions, and includes
 */

// Start session
session_start();

// Set error reporting
error_reporting(E_ALL);
ini_set('display_errors', 1);

// Set timezone
date_default_timezone_set('UTC');

// Include configuration
require_once '../config/database.php';
require_once 'auth.php';

// Create logs directory if it doesn't exist
$logDir = '../logs';
if (!file_exists($logDir)) {
    mkdir($logDir, 0755, true);
}

// Handle error messages from session
function displayMessages() {
    if (isset($_SESSION['error'])) {
        echo '<div class="message error">' . htmlspecialchars($_SESSION['error']) . '</div>';
        unset($_SESSION['error']);
    }
    
    if (isset($_SESSION['success'])) {
        echo '<div class="message success">' . htmlspecialchars($_SESSION['success']) . '</div>';
        unset($_SESSION['success']);
    }
}

// Handle URL messages
function displayURLMessages() {
    if (isset($_GET['message'])) {
        $message = $_GET['message'];
        switch ($message) {
            case 'logged_out':
                echo '<div class="message success">You have been successfully logged out.</div>';
                break;
            case 'session_expired':
                echo '<div class="message error">Your session has expired. Please log in again.</div>';
                break;
        }
    }
}
?>
