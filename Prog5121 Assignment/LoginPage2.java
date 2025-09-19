import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginPage2 extends JPanel {
    private MainApplication mainApp;
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JTextArea outputArea;

    public LoginPage2(MainApplication mainApp) {
        this.mainApp = mainApp;
        setLayout(new BorderLayout(10, 10));
        setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        setBackground(new Color(240, 240, 240));

        // Header
        JLabel headerLabel = new JLabel("User Login", JLabel.CENTER);
        headerLabel.setFont(new Font("Arial", Font.BOLD, 20));
        headerLabel.setForeground(new Color(0, 82, 136));
        headerLabel.setBorder(BorderFactory.createEmptyBorder(10, 0, 20, 0));
        add(headerLabel, BorderLayout.NORTH);

        // Form panel
        JPanel formPanel = new JPanel(new GridBagLayout());
        formPanel.setBorder(BorderFactory.createTitledBorder("Enter Your Credentials"));
        formPanel.setBackground(Color.WHITE);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(8, 8, 8, 8);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Username field
        gbc.gridx = 0;
        gbc.gridy = 0;
        formPanel.add(new JLabel("Username:"), gbc);
        gbc.gridx = 1;
        usernameField = new JTextField(20);
        formPanel.add(usernameField, gbc);

        // Password field
        gbc.gridx = 0;
        gbc.gridy = 1;
        formPanel.add(new JLabel("Password:"), gbc);
        gbc.gridx = 1;
        passwordField = new JPasswordField(20);
        formPanel.add(passwordField, gbc);

        add(formPanel, BorderLayout.NORTH);

        // Button panel
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 15));
        buttonPanel.setBackground(new Color(240, 240, 240));
        
        JButton loginButton = new JButton("Login");
        styleButton(loginButton, new Color(0, 153, 76));
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                outputArea.setText("Login functionality would be implemented here.");
            }
        });
        
        JButton clearButton = new JButton("Clear");
        styleButton(clearButton, new Color(102, 102, 102));
        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                usernameField.setText("");
                passwordField.setText("");
                outputArea.setText("Fields cleared.");
            }
        });
        
        JButton backButton = new JButton("Back to Main");
        styleButton(backButton, new Color(204, 0, 0));
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainApp.showPage("Main");
            }
        });
        
        buttonPanel.add(loginButton);
        buttonPanel.add(clearButton);
        buttonPanel.add(backButton);
        
        add(buttonPanel, BorderLayout.CENTER);

        // Output area
        outputArea = new JTextArea(8, 50);
        outputArea.setEditable(false);
        outputArea.setFont(new Font("Monospaced", Font.PLAIN, 12));
        JScrollPane scrollPane = new JScrollPane(outputArea);
        scrollPane.setBorder(BorderFactory.createTitledBorder("Login Status"));
        
        add(scrollPane, BorderLayout.SOUTH);
    }
    
    private void styleButton(JButton button, Color color) {
        button.setFont(new Font("Arial", Font.BOLD, 14));
        button.setBackground(color);
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        button.setBorder(BorderFactory.createEmptyBorder(10, 15, 10, 15));
    }
}