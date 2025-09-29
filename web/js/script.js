// Professional Login System - JavaScript for Enhanced UX

document.addEventListener('DOMContentLoaded', function() {
    // Form validation and enhancement
    const loginForm = document.getElementById('loginForm');
    const signupForm = document.getElementById('signupForm');
    
    if (loginForm) {
        enhanceLoginForm();
    }
    
    if (signupForm) {
        enhanceSignupForm();
    }
});

function enhanceLoginForm() {
    const form = document.getElementById('loginForm');
    const submitBtn = form.querySelector('.btn-primary');
    
    form.addEventListener('submit', function(e) {
        e.preventDefault();
        
        const username = form.querySelector('#username').value.trim();
        const password = form.querySelector('#password').value;
        
        if (!username || !password) {
            showMessage('Please fill in all fields', 'error');
            return;
        }
        
        // Show loading state
        showLoading(submitBtn);
        
        // Submit form
        form.submit();
    });
}

function enhanceSignupForm() {
    const form = document.getElementById('signupForm');
    const submitBtn = form.querySelector('.btn-primary');
    const passwordField = form.querySelector('#password');
    const confirmPasswordField = form.querySelector('#confirm_password');
    
    // Add password strength indicator
    if (passwordField) {
        addPasswordStrengthIndicator(passwordField);
    }
    
    // Real-time password confirmation validation
    if (confirmPasswordField) {
        confirmPasswordField.addEventListener('input', function() {
            validatePasswordMatch();
        });
    }
    
    form.addEventListener('submit', function(e) {
        e.preventDefault();
        
        const username = form.querySelector('#username').value.trim();
        const email = form.querySelector('#email').value.trim();
        const password = passwordField.value;
        const confirmPassword = confirmPasswordField.value;
        
        // Validation
        if (!username || !email || !password || !confirmPassword) {
            showMessage('Please fill in all fields', 'error');
            return;
        }
        
        if (password !== confirmPassword) {
            showMessage('Passwords do not match', 'error');
            return;
        }
        
        if (password.length < 6) {
            showMessage('Password must be at least 6 characters long', 'error');
            return;
        }
        
        if (!isValidEmail(email)) {
            showMessage('Please enter a valid email address', 'error');
            return;
        }
        
        // Show loading state
        showLoading(submitBtn);
        
        // Submit form
        form.submit();
    });
}

function addPasswordStrengthIndicator(passwordField) {
    const strengthContainer = document.createElement('div');
    strengthContainer.className = 'password-strength';
    
    const strengthBar = document.createElement('div');
    strengthBar.className = 'password-strength-bar';
    strengthContainer.appendChild(strengthBar);
    
    passwordField.parentNode.appendChild(strengthContainer);
    
    passwordField.addEventListener('input', function() {
        const password = this.value;
        const strength = calculatePasswordStrength(password);
        
        strengthContainer.className = 'password-strength ' + strength.level;
        strengthBar.style.width = strength.percentage + '%';
    });
}

function calculatePasswordStrength(password) {
    let score = 0;
    
    if (password.length >= 6) score += 1;
    if (password.length >= 8) score += 1;
    if (/[a-z]/.test(password)) score += 1;
    if (/[A-Z]/.test(password)) score += 1;
    if (/[0-9]/.test(password)) score += 1;
    if (/[^A-Za-z0-9]/.test(password)) score += 1;
    
    if (score < 2) return { level: 'weak', percentage: 25 };
    if (score < 4) return { level: 'fair', percentage: 50 };
    if (score < 6) return { level: 'good', percentage: 75 };
    return { level: 'strong', percentage: 100 };
}

function validatePasswordMatch() {
    const password = document.querySelector('#password').value;
    const confirmPassword = document.querySelector('#confirm_password').value;
    
    if (confirmPassword && password !== confirmPassword) {
        showMessage('Passwords do not match', 'error');
    } else if (confirmPassword && password === confirmPassword) {
        clearMessages();
    }
}

function isValidEmail(email) {
    const emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
    return emailRegex.test(email);
}

function showLoading(button) {
    const originalText = button.textContent;
    button.innerHTML = '<span class="loading"></span> Signing In...';
    button.disabled = true;
    
    // Re-enable after 5 seconds as fallback
    setTimeout(() => {
        button.textContent = originalText;
        button.disabled = false;
    }, 5000);
}

function showMessage(message, type) {
    // Remove existing messages
    clearMessages();
    
    const messageDiv = document.createElement('div');
    messageDiv.className = `message ${type}`;
    messageDiv.textContent = message;
    
    const form = document.querySelector('.form-container');
    form.insertBefore(messageDiv, form.querySelector('form'));
    
    // Auto-remove after 5 seconds
    setTimeout(() => {
        if (messageDiv.parentNode) {
            messageDiv.parentNode.removeChild(messageDiv);
        }
    }, 5000);
}

function clearMessages() {
    const messages = document.querySelectorAll('.message');
    messages.forEach(message => message.remove());
}

// Add smooth animations to form elements
document.querySelectorAll('input').forEach(input => {
    input.addEventListener('focus', function() {
        this.parentNode.classList.add('focused');
    });
    
    input.addEventListener('blur', function() {
        this.parentNode.classList.remove('focused');
    });
});
