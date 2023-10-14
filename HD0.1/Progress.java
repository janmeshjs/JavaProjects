import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class Progress {
    private static JFrame frame;
    private JProgressBar progressBar;
    private Timer timer;

    public Progress() {
        frame = new JFrame("Progress Bar");
        frame.setSize(350, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);
        frame.setLocation(
            (Toolkit.getDefaultToolkit().getScreenSize().width - frame.getWidth()) / 2,
            (Toolkit.getDefaultToolkit().getScreenSize().height - frame.getHeight()) / 2
        );
        frame.setUndecorated(true);

        JLabel headingLabel = new JLabel("HD1.0");
        headingLabel.setBounds(100, 28, 380, 60);
        headingLabel.setFont(new Font("Monotype Corsiva", Font.BOLD, 55));
        headingLabel.setForeground(new Color(128, 0, 128));
        frame.add(headingLabel);

        progressBar = new JProgressBar(0, 100);
        progressBar.setBounds(60, 108, 250, 30);
        progressBar.setStringPainted(true);
        frame.add(progressBar);

        frame.setVisible(true);

        timer = new Timer(90, new ActionListener() {
            int progress = 0;

            @Override
            public void actionPerformed(ActionEvent e) {
                progressBar.setValue(progress);
                if (progress == 100) {
                    timer.stop();
                    frame.dispose(); // Close the progress frame
                    SwingUtilities.invokeLater(() -> {
                        new Login(); // Open the Login page
                    });
                }
                progress++;
            }
        });
        timer.start();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new Progress();
        });
    }
}
