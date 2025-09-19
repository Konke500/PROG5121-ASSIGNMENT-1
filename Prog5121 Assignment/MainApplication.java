import javax.swing.*;
import java.awt.*;

public class MainApplication extends JFrame {
    private CardLayout cardLayout;
    private JPanel cardPanel;
    
    public MainApplication() {
        setTitle("PROG5121 Assignment - Student Portal");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);
        
        // Initialize card layout
        cardLayout = new CardLayout();
        cardPanel = new JPanel(cardLayout);
        
        // Create the different pages
        MainPage2 mainPage = new MainPage2(this);
        RegistrationPage2 registrationPage = new RegistrationPage2(this);
        LoginPage2 loginPage = new LoginPage2(this);
        
        // Add pages to card layout
        cardPanel.add(mainPage, "Main");
        cardPanel.add(registrationPage, "Registration");
        cardPanel.add(loginPage, "Login");
        
        add(cardPanel);
        
        // Show main panel first
        cardLayout.show(cardPanel, "Main");
    }
    
    public void showPage(String pageName) {
        cardLayout.show(cardPanel, pageName);
    }
    
    public static void main(String[] args) {
        // Set look and feel to system default for better appearance
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        // Create and show the GUI
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MainApplication().setVisible(true);
            }
        });
    }
}