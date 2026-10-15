package lab1;

import javax.swing.*;
import java.awt.*;

public class Module3 extends JDialog {
    private final Runnable onBack;
    private final Runnable onOk;
    private final Runnable onCancel;

    public Module3(JFrame parent, Runnable onBack, Runnable onOk, Runnable onCancel) {
        super(parent, "Робота 2 — Вікно 2 із 2", true);
        this.onBack = onBack;
        this.onOk = onOk;
        this.onCancel = onCancel;

        setSize(380, 160);
        setLocationRelativeTo(parent);
        setResizable(false);
        setLayout(new BorderLayout(10, 10));

        JLabel label = new JLabel("Друге вікно діалогу. Оберіть дію:", SwingConstants.CENTER);
        label.setFont(new Font("SansSerif", Font.PLAIN, 14));

        JPanel buttonPanel = createButtonPanel();

        add(buttonPanel, BorderLayout.CENTER);

    }

    private JPanel createButtonPanel() {
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 12));
        JButton btnBack = new JButton("Назад");
        JButton btnOk = new JButton("Так");
        JButton btnCancel = new JButton("Відміна");


        btnBack.addActionListener(e -> this.handleBack());
        btnOk.addActionListener(e -> this.handleOk());
        btnCancel.addActionListener(e -> this.handleCancel());

        buttonPanel.add(btnBack);
        buttonPanel.add(btnOk);
        buttonPanel.add(btnCancel);
        return buttonPanel;
    }

    private void handleBack() {
        this.dispose();
        if (this.onBack != null) {
            this.onBack.run();
        }
    }

    private void handleOk() {
        this.dispose();
        if (this.onOk != null) {
            this.onOk.run();
        }
    }

    private void handleCancel() {
        this.dispose();
        if (this.onCancel != null) {
            this.onCancel.run();
        }
    }
}