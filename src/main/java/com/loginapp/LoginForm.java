package com.loginapp;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.RoundRectangle2D;

/**
 * Professional Login Form with Modern UI and Smooth Animations
 */
public class LoginForm extends JFrame {
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton;
    private JLabel titleLabel;
    private JPanel mainPanel;
    private Timer fadeTimer;
    private int fadeAlpha = 0;
    private boolean isAnimating = false;

    public LoginForm() {
        initializeComponents();
        setupLayout();
        setupAnimations();
        setupEventHandlers();
        applyModernStyling();
        
        // Center and show window
        setSize(450, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        
        // Start fade-in animation
        startFadeInAnimation();
    }

    private void initializeComponents() {
        // Main panel with animated gradient background
        mainPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2d = (Graphics2D) g.create();
                g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
                
                // Professional dark gradient background
                Color color1 = new Color(15, 15, 25);  // Deep dark blue
                Color color2 = new Color(25, 25, 35);  // Slightly lighter dark
                
                GradientPaint gradient = new GradientPaint(
                    0, 0, color1,
                    getWidth(), getHeight(), color2
                );
                g2d.setPaint(gradient);
                g2d.fillRect(0, 0, getWidth(), getHeight());
                
                // Professional subtle pattern overlay
                g2d.setColor(new Color(255, 255, 255, 5));
                for (int i = 0; i < getWidth(); i += 60) {
                    for (int j = 0; j < getHeight(); j += 60) {
                        g2d.fillOval(i, j, 1, 1);
                    }
                }
                
                // Professional grid lines
                g2d.setColor(new Color(255, 255, 255, 8));
                g2d.setStroke(new BasicStroke(0.5f));
                for (int i = 0; i < getWidth(); i += 50) {
                    g2d.drawLine(i, 0, i, getHeight());
                }
                for (int j = 0; j < getHeight(); j += 50) {
                    g2d.drawLine(0, j, getWidth(), j);
                }
                
                g2d.dispose();
            }
        };
        mainPanel.setLayout(new BorderLayout());
        mainPanel.setBorder(new EmptyBorder(40, 50, 40, 50));

        // Professional title with clean styling
        titleLabel = new JLabel("SECUREAUTH PRO", SwingConstants.CENTER) {
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2d = (Graphics2D) g.create();
                g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
                
                // Draw professional text shadow
                g2d.setColor(new Color(0, 0, 0, 150));
                g2d.setFont(new Font("Segoe UI", Font.BOLD, 28));
                FontMetrics fm = g2d.getFontMetrics();
                int x = (getWidth() - fm.stringWidth(getText())) / 2 + 2;
                int y = (getHeight() + fm.getAscent()) / 2 + 2;
                g2d.drawString(getText(), x, y);
                
                // Draw main text with professional gradient
                GradientPaint textGradient = new GradientPaint(
                    0, 0, new Color(200, 200, 255),
                    getWidth(), getHeight(), new Color(255, 255, 255)
                );
                g2d.setPaint(textGradient);
                g2d.drawString(getText(), x-2, y-2);
                
                g2d.dispose();
            }
        };
        titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 28));
        titleLabel.setForeground(new Color(200, 200, 255));
        titleLabel.setBorder(new EmptyBorder(0, 0, 40, 0));

        // Username field
        usernameField = createStyledTextField("Username");
        usernameField.setName("usernameField");

        // Password field
        passwordField = createStyledPasswordField("Password");
        passwordField.setName("passwordField");

        // Login button with modern styling
        loginButton = createStyledButton("Sign In");
        loginButton.setName("loginButton");
    }

    private JTextField createStyledTextField(String placeholder) {
        JTextField field = new JTextField(20) {
            private boolean isFocused = false;
            
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2d = (Graphics2D) g.create();
                g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
                
                // Professional dark background
                g2d.setColor(new Color(30, 30, 40));
                g2d.fillRoundRect(0, 0, getWidth(), getHeight(), 8, 8);
                
                // Professional border
                if (isFocused) {
                    g2d.setColor(new Color(100, 150, 255));
                    g2d.setStroke(new BasicStroke(2));
                } else {
                    g2d.setColor(new Color(60, 60, 70));
                    g2d.setStroke(new BasicStroke(1));
                }
                g2d.drawRoundRect(1, 1, getWidth()-2, getHeight()-2, 8, 8);
                
                g2d.dispose();
                super.paintComponent(g);
            }
        };
        
        field.setOpaque(false);
        field.setBorder(new EmptyBorder(12, 15, 12, 15));
        field.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        field.setForeground(new Color(220, 220, 220));
        field.setCaretColor(new Color(100, 150, 255));
        field.setToolTipText("Enter your " + placeholder.toLowerCase());
        
        // Professional focus listeners
        field.addFocusListener(new java.awt.event.FocusListener() {
            @Override
            public void focusGained(java.awt.event.FocusEvent e) {
                try {
                    java.lang.reflect.Field fieldRef = field.getClass().getDeclaredField("isFocused");
                    fieldRef.setAccessible(true);
                    fieldRef.set(field, true);
                } catch (Exception ex) {}
                field.repaint();
            }
            
            @Override
            public void focusLost(java.awt.event.FocusEvent e) {
                try {
                    java.lang.reflect.Field fieldRef = field.getClass().getDeclaredField("isFocused");
                    fieldRef.setAccessible(true);
                    fieldRef.set(field, false);
                } catch (Exception ex) {}
                field.repaint();
            }
        });
        
        return field;
    }

    private JPasswordField createStyledPasswordField(String placeholder) {
        JPasswordField field = new JPasswordField(20) {
            private boolean isFocused = false;
            
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2d = (Graphics2D) g.create();
                g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
                
                // Professional dark background
                g2d.setColor(new Color(30, 30, 40));
                g2d.fillRoundRect(0, 0, getWidth(), getHeight(), 8, 8);
                
                // Professional border
                if (isFocused) {
                    g2d.setColor(new Color(100, 150, 255));
                    g2d.setStroke(new BasicStroke(2));
                } else {
                    g2d.setColor(new Color(60, 60, 70));
                    g2d.setStroke(new BasicStroke(1));
                }
                g2d.drawRoundRect(1, 1, getWidth()-2, getHeight()-2, 8, 8);
                
                g2d.dispose();
                super.paintComponent(g);
            }
        };
        
        field.setOpaque(false);
        field.setBorder(new EmptyBorder(12, 15, 12, 15));
        field.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        field.setForeground(new Color(220, 220, 220));
        field.setCaretColor(new Color(100, 150, 255));
        field.setToolTipText("Enter your " + placeholder.toLowerCase());
        
        // Professional focus listeners
        field.addFocusListener(new java.awt.event.FocusListener() {
            @Override
            public void focusGained(java.awt.event.FocusEvent e) {
                try {
                    java.lang.reflect.Field fieldRef = field.getClass().getDeclaredField("isFocused");
                    fieldRef.setAccessible(true);
                    fieldRef.set(field, true);
                } catch (Exception ex) {}
                field.repaint();
            }
            
            @Override
            public void focusLost(java.awt.event.FocusEvent e) {
                try {
                    java.lang.reflect.Field fieldRef = field.getClass().getDeclaredField("isFocused");
                    fieldRef.setAccessible(true);
                    fieldRef.set(field, false);
                } catch (Exception ex) {}
                field.repaint();
            }
        });
        
        return field;
    }

    private JButton createStyledButton(String text) {
        JButton button = new JButton(text) {
            private boolean isHovered = false;
            
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2d = (Graphics2D) g.create();
                g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
                
                // Professional button background
                if (isHovered) {
                    GradientPaint gradient = new GradientPaint(
                        0, 0, new Color(100, 150, 255),
                        getWidth(), getHeight(), new Color(80, 130, 235)
                    );
                    g2d.setPaint(gradient);
                } else {
                    GradientPaint gradient = new GradientPaint(
                        0, 0, new Color(60, 100, 200),
                        getWidth(), getHeight(), new Color(40, 80, 180)
                    );
                    g2d.setPaint(gradient);
                }
                g2d.fillRoundRect(0, 0, getWidth(), getHeight(), 8, 8);
                
                // Professional border
                g2d.setColor(new Color(255, 255, 255, 30));
                g2d.setStroke(new BasicStroke(1));
                g2d.drawRoundRect(1, 1, getWidth()-2, getHeight()-2, 8, 8);
                
                // Professional text
                g2d.setColor(Color.WHITE);
                g2d.setFont(new Font("Segoe UI", Font.BOLD, 14));
                FontMetrics fm = g2d.getFontMetrics();
                int x = (getWidth() - fm.stringWidth(getText())) / 2;
                int y = (getHeight() - fm.getHeight()) / 2 + fm.getAscent();
                g2d.drawString(getText(), x, y);
                
                g2d.dispose();
            }
        };
        
        button.setOpaque(false);
        button.setBorderPainted(false);
        button.setFocusPainted(false);
        button.setContentAreaFilled(false);
        button.setPreferredSize(new Dimension(180, 40));
        button.setFont(new Font("Segoe UI", Font.BOLD, 14));
        
        // Professional hover effects
        button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                try {
                    java.lang.reflect.Field field = button.getClass().getDeclaredField("isHovered");
                    field.setAccessible(true);
                    field.set(button, true);
                } catch (Exception ex) {}
                button.setCursor(new Cursor(Cursor.HAND_CURSOR));
                button.repaint();
            }
            
            @Override
            public void mouseExited(MouseEvent e) {
                try {
                    java.lang.reflect.Field field = button.getClass().getDeclaredField("isHovered");
                    field.setAccessible(true);
                    field.set(button, false);
                } catch (Exception ex) {}
                button.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                button.repaint();
            }
        });
        
        return button;
    }

    private void setupLayout() {
        // Create form panel
        JPanel formPanel = new JPanel();
        formPanel.setOpaque(false);
        formPanel.setLayout(new BoxLayout(formPanel, BoxLayout.Y_AXIS));
        formPanel.setBorder(new EmptyBorder(20, 0, 20, 0));

        // Add components with spacing
        formPanel.add(Box.createVerticalStrut(20));
        formPanel.add(usernameField);
        formPanel.add(Box.createVerticalStrut(20));
        formPanel.add(passwordField);
        formPanel.add(Box.createVerticalStrut(30));
        formPanel.add(loginButton);
        formPanel.add(Box.createVerticalStrut(20));

        // Add everything to main panel
        mainPanel.add(titleLabel, BorderLayout.NORTH);
        mainPanel.add(formPanel, BorderLayout.CENTER);
        
        add(mainPanel);
    }

    private void setupAnimations() {
        // Simple fade-in animation
        fadeTimer = new Timer(20, e -> {
            fadeAlpha += 8;
            if (fadeAlpha >= 255) {
                fadeAlpha = 255;
                fadeTimer.stop();
                isAnimating = false;
            }
            repaint();
        });
    }

    private void setupEventHandlers() {
        // Login button action
        loginButton.addActionListener(e -> {
            if (isAnimating) return;
            
            String username = usernameField.getText().trim();
            String password = new String(passwordField.getPassword());
            
            if (username.isEmpty() || password.isEmpty()) {
                showAnimatedError("Please fill in all fields");
                return;
            }
            
            // Simulate login process with loading animation
            simulateLogin(username, password);
        });

        // Hover effects for text fields
        addHoverEffect(usernameField);
        addHoverEffect(passwordField);
        
        // Button hover effect
        loginButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                if (!isAnimating) {
                    loginButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
                    animateButtonScale(loginButton, 1.05f);
                }
            }
            
            @Override
            public void mouseExited(MouseEvent e) {
                if (!isAnimating) {
                    loginButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                    animateButtonScale(loginButton, 1.0f);
                }
            }
        });

        // Enter key support
        KeyStroke enterKey = KeyStroke.getKeyStroke("ENTER");
        loginButton.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(enterKey, "login");
        loginButton.getActionMap().put("login", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loginButton.doClick();
            }
        });
    }

    private void addHoverEffect(JComponent component) {
        component.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                if (!isAnimating) {
                    component.setCursor(new Cursor(Cursor.TEXT_CURSOR));
                    animateComponentGlow(component, true);
                }
            }
            
            @Override
            public void mouseExited(MouseEvent e) {
                if (!isAnimating) {
                    component.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                    animateComponentGlow(component, false);
                }
            }
        });
    }

    private void animateButtonHover(JButton button, float targetScale) {
        Timer scaleTimer = new Timer(16, null);
        scaleTimer.addActionListener(e -> {
            // Access the button's hoverScale field through reflection or create a custom button class
            try {
                java.lang.reflect.Field field = button.getClass().getDeclaredField("hoverScale");
                field.setAccessible(true);
                float currentScale = (float) field.get(button);
                float newScale = currentScale + (targetScale - currentScale) * 0.2f;
                field.set(button, newScale);
                
                if (Math.abs(newScale - targetScale) < 0.01f) {
                    field.set(button, targetScale);
                    scaleTimer.stop();
                }
                button.repaint();
            } catch (Exception ex) {
                scaleTimer.stop();
            }
        });
        scaleTimer.start();
    }
    
    private void animateButtonScale(JButton button, float scale) {
        Timer scaleTimer = new Timer(10, null);
        scaleTimer.addActionListener(e -> {
            // Simple scale animation
            button.setSize((int)(button.getWidth() * scale), (int)(button.getHeight() * scale));
            if (scaleTimer.getDelay() > 50) {
                scaleTimer.stop();
            } else {
                scaleTimer.setDelay(scaleTimer.getDelay() + 5);
            }
        });
        scaleTimer.start();
    }

    private void animateComponentGlow(JComponent component, boolean glow) {
        // Simple glow effect by repainting
        component.repaint();
    }

    private void simulateLogin(String username, String password) {
        isAnimating = true;
        
        // Show loading animation
        loginButton.setText("Signing In...");
        loginButton.setEnabled(false);
        
        Timer loadingTimer = new Timer(2000, e -> {
            // Simulate login validation
            if ("admin".equals(username) && "password".equals(password)) {
                showSuccessMessage();
            } else {
                showAnimatedError("Invalid credentials");
            }
            
            loginButton.setText("Sign In");
            loginButton.setEnabled(true);
            isAnimating = false;
        });
        loadingTimer.setRepeats(false);
        loadingTimer.start();
    }

    private void showSuccessMessage() {
        JOptionPane.showMessageDialog(this, 
            "Login successful! Welcome, " + usernameField.getText(),
            "Success", JOptionPane.INFORMATION_MESSAGE);
    }

    private void showAnimatedError(String message) {
        // Create custom error dialog with animation
        JDialog errorDialog = new JDialog(this, "Error", true);
        errorDialog.setSize(300, 150);
        errorDialog.setLocationRelativeTo(this);
        errorDialog.setUndecorated(true);
        
        JPanel errorPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2d = (Graphics2D) g.create();
                g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                
                g2d.setColor(new Color(255, 107, 107));
                g2d.fillRoundRect(0, 0, getWidth(), getHeight(), 15, 15);
                
                g2d.setColor(Color.WHITE);
                g2d.setFont(new Font("Segoe UI", Font.BOLD, 14));
                FontMetrics fm = g2d.getFontMetrics();
                int x = (getWidth() - fm.stringWidth(message)) / 2;
                int y = (getHeight() + fm.getAscent()) / 2;
                g2d.drawString(message, x, y);
                
                g2d.dispose();
            }
        };
        
        errorDialog.add(errorPanel);
        
        // Auto-close after 3 seconds
        Timer closeTimer = new Timer(3000, e -> errorDialog.dispose());
        closeTimer.setRepeats(false);
        closeTimer.start();
        
        errorDialog.setVisible(true);
    }

    private void startFadeInAnimation() {
        isAnimating = true;
        fadeTimer.start();
    }

    private void applyModernStyling() {
        // Set window properties
        setTitle("SecureAuth Pro - Enterprise Authentication");
        setUndecorated(false);
        
        // Apply modern look and feel
        try {
            UIManager.put("Button.background", new Color(255, 107, 107));
            UIManager.put("Button.foreground", Color.WHITE);
            UIManager.put("Button.font", new Font("Segoe UI", Font.BOLD, 14));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    
    @Override
    public void paint(Graphics g) {
        if (fadeAlpha < 255) {
            Graphics2D g2d = (Graphics2D) g.create();
            g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, fadeAlpha / 255.0f));
            super.paint(g2d);
            g2d.dispose();
        } else {
            super.paint(g);
        }
    }
    
}

