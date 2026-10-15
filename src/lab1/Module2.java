package lab1;

import javax.swing.*;
import java.awt.*;

public class Module2 extends JDialog {
    private final Runnable onNext;
    private final Runnable onCancel;

    public Module2(JFrame parent, Runnable onNext, Runnable onCancel) {
        super(parent, "Робота 2 — Вікно 1 із 2", true);
        this.onNext = onNext;
        this.onCancel = onCancel;

        setSize(360, 360);
        setLocationRelativeTo(parent);
        setResizable(false);
        setLayout(new BorderLayout(10, 10));

        JLabel label = new JLabel("Перейти далі?", SwingConstants.CENTER);
        label.setFont(new Font("SansSerif", Font.PLAIN, 14));

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 12));
        JButton btnNext = new JButton("Далі >");
        JButton btnCancel = new JButton("Відміна");

        btnNext.addActionListener(e -> handleNext());
        btnCancel.addActionListener(e -> handleCancel());

        buttonPanel.add(btnNext);
        buttonPanel.add(btnCancel);

        add(label, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
    }

    private void handleNext () {
        this.dispose();
        if (this.onNext != null) {
            this.onNext.run();
        }
    }

    private void handleCancel() {
        this.dispose();
    }
}