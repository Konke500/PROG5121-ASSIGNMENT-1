import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Pattern;

public class RegistrationPage2 extends JPanel {
    private MainApplication mainApp;
    private JTextField firstNameField;
    private JTextField lastNameField;
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JTextField phoneField;
    private JTextArea outputArea;

    public RegistrationPage2(MainApplication mainApp) {
        this.mainApp = mainApp;
        setLayout(new BorderLayout(10, 10));
        setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        setBackground(new Color(240, 240, 240));

        // Header
        JLabel headerLabel = new JLabel("User Registration", JLabel.CENTER);
        headerLabel.setFont(new Font("Arial", Font.BOLD, 20));
        headerLabel.setForeground(new Color(0, 82, 136));
        headerLabel.setBorder(BorderFactory.createEmptyBorder(10, 0, 20, 0));
        add(headerLabel, BorderLayout.NORTH);

        // Form panel
        JPanel formPanel = new JPanel(new GridBagLayout());
        formPanel.setBorder(BorderFactory.createTitledBorder("Enter Your Details"));
        formPanel.setBackground(Color.WHITE);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(8, 8, 8, 8);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // First name field
        gbc.gridx = 0;
        gbc.gridy = 0;
        formPanel.add(new JLabel("First Name:"), gbc);
        gbc.gridx = 1;
        firstNameField = new JTextField(20);
        formPanel.add(firstNameField, gbc);

        // Last name field
        gbc.gridx = 0;
        gbc.gridy = 1;
        formPanel.add(new JLabel("Last Name:"), gbc);
        gbc.gridx = 1;
        lastNameField = new JTextField(20);
        formPanel.add(lastNameField, gbc);

        // Username field
        gbc.gridx = 0;
        gbc.gridy = 2;
        formPanel.add(new JLabel("Username:"), gbc);
        gbc.gridx = 1;
        usernameField = new JTextField(20);
        formPanel.add(usernameField, gbc);

        // Password field
        gbc.gridx = 0;
        gbc.gridy = 3;
        formPanel.add(new JLabel("Password:"), gbc);
        gbc.gridx = 1;
        passwordField = new JPasswordField(20);
        formPanel.add(passwordField, gbc);

        // Phone number field
        gbc.gridx = 0;
        gbc.gridy = 4;
        formPanel.add(new JLabel("Phone Number:"), gbc);
        gbc.gridx = 1;
        phoneField = new JTextField(20);
        formPanel.add(phoneField, gbc);

        add(formPanel, BorderLayout.NORTH);

        // Button panel
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 15));
        buttonPanel.setBackground(new Color(240, 240, 240));
        
        JButton registerButton = new JButton("Register");
        styleButton(registerButton, new Color(0, 120, 215));
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                registerUser();
            }
        });
        
        JButton clearButton = new JButton("Clear");
        styleButton(clearButton, new Color(102, 102, 102));
        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clearFields();
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
        
        buttonPanel.add(registerButton);
        buttonPanel.add(clearButton);
        buttonPanel.add(backButton);
        
        add(buttonPanel, BorderLayout.CENTER);

        // Output area
        outputArea = new JTextArea(8, 50);
        outputArea.setEditable(false);
        outputArea.setFont(new Font("Monospaced", Font.PLAIN, 12));
        JScrollPane scrollPane = new JScrollPane(outputArea);
        scrollPane.setBorder(BorderFactory.createTitledBorder("Registration Status"));
        
        add(scrollPane, BorderLayout.SOUTH);
        
        // Display requirements message
        outputArea.setText("Registration Requirements:\n\n" +
                "1. Username: Must contain an underscore and be no more than 5 characters\n" +
                "   Example: kyl_1 (valid), kyle!!!!!!! (invalid)\n\n" +
                "2. Password: Must be at least 8 characters with:\n" +
                "   - An uppercase letter\n   - A number\n   - A special character\n" +
                "   Example: Ch&&sec@kes9! (valid), password (invalid)\n\n" +
                "3. Phone: Must be a South African number with international code\n" +
                "   Example: +27838968976 (valid), 08966553 (invalid)");
    }
    
    private void styleButton(JButton button, Color color) {
        button.setFont(new Font("Arial", Font.BOLD, 14));
        button.setBackground(color);
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        button.setBorder(BorderFactory.createEmptyBorder(10, 15, 10, 15));
    }
    
    private void registerUser() {
        String firstName = firstNameField.getText().trim();
        String lastName = lastNameField.getText().trim();
        String username = usernameField.getText().trim();
        String password = new String(passwordField.getPassword()).trim();
        String phoneNumber = phoneField.getText().trim();

        // Validate inputs
        if (firstName.isEmpty() || lastName.isEmpty() || username.isEmpty() || password.isEmpty() || phoneNumber.isEmpty()) {
            outputArea.setText("Error: All fields must be filled out.");
            return;
        }

        // Check username requirements
        if (!isValidUsername(username)) {
            outputArea.setText("Username is not correctly formatted, please ensure that your username contains an underscore and is no more than five characters in length.");
            return;
        }

        // Check password requirements
        if (!isValidPassword(password)) {
            outputArea.setText("Password is not correctly formatted; please ensure that the password contains at least eight characters, a capital letter, a number, and a special character.");
            return;
        }

        // Check phone number format
        if (!isValidSouthAfricanPhoneNumber(phoneNumber)) {
            outputArea.setText("Cell phone number incorrectly formatted or does not contain international code.");
            return;
        }

        // If all validations pass
        outputArea.setText("Registration successful!\n\n" +
                "Name: " + firstName + " " + lastName + "\n" +
                "Username: " + username + "\n" +
                "Phone: " + formatPhoneNumber(phoneNumber) + "\n\n" +
                "You can now login with your credentials.");
    }
    
    private void clearFields() {
        firstNameField.setText("");
        lastNameField.setText("");
        usernameField.setText("");
        passwordField.setText("");
        phoneField.setText("");
        outputArea.setText("All fields cleared.\n\n" +
                "Registration Requirements:\n\n" +
                "1. Username: Must contain an underscore and be no more than 5 characters\n" +
                "   Example: kyl_1 (valid), kyle!!!!!!! (invalid)\n\n" +
                "2. Password: Must be at least 8 characters with:\n" +
                "   - An uppercase letter\n   - A number\n   - A special character\n" +
                "   Example: Ch&&sec@kes9! (valid), password (invalid)\n\n" +
                "3. Phone: Must be a South African number with international code\n" +
                "   Example: +27838968976 (valid), 08966553 (invalid)");
    }
    
    private boolean isValidUsername(String username) {
        return username.contains("_") && username.length() <= 5;
    }
    
    private boolean isValidPassword(String password) {
        if (password.length() < 8) {
            return false;
        }
        
        boolean hasUppercase = !password.equals(password.toLowerCase());
        boolean hasDigit = password.matches(".*\\d.*");
        boolean hasSpecial = !password.matches("[A-Za-z0-9 ]*");
        
        return hasUppercase && hasDigit && hasSpecial;
    }
    
    private boolean isValidSouthAfricanPhoneNumber(String phoneNumber) {
        // This regex pattern was created with the assistance of ChatGPT (OpenAI, 2023)
        // Reference: OpenAI. (2023). ChatGPT (September 25 version) [Large language model]. https://chat.openai.com
        return Pattern.matches("^\\+27[0-9]{9}$", phoneNumber);
    }
    
    private String formatPhoneNumber(String phoneNumber) {
        if (phoneNumber.length() == 12 && phoneNumber.startsWith("+27")) {
            return "+27 " + phoneNumber.substring(3, 6) + " " + 
                   phoneNumber.substring(6, 9) + " " + 
                   phoneNumber.substring(9);
        }
        return phoneNumber;
    }
}