package lab1;

import javax.swing.*;
import java.awt.*;
import java.util.function.IntConsumer;

public class Module1 extends JDialog {

    private final JScrollBar scrollBar;
    private final JLabel valueLabel;
    private final IntConsumer onConfirm;

    public Module1(JFrame parent, IntConsumer onConfirm) {
        super(parent, "Робота 1 — Введення числа (1..100)", true);
        this.onConfirm = onConfirm;

        setSize(360, 190);
        setLocationRelativeTo(parent);
        setResizable(false);
        setLayout(new BorderLayout(10, 10));

        this.scrollBar = new JScrollBar(JScrollBar.HORIZONTAL, 50, 1, 1, 101);
        this.scrollBar.setPreferredSize(new Dimension(280, 24));

        this.valueLabel = new JLabel("Вибране число: 50 " + this.scrollBar.getValue(), SwingConstants.CENTER);
        this.valueLabel.setFont(new Font("SansSerif", Font.BOLD, 14));

        this.scrollBar.addAdjustmentListener(e -> this.handleScroll());

        JPanel centerPanel = new JPanel(new GridLayout(2, 1, 5, 5));
        centerPanel.setBorder(BorderFactory.createEmptyBorder(15, 25, 5, 25));
        centerPanel.add(this.scrollBar);
        centerPanel.add(this.valueLabel);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 10));
        JButton btnOk = new JButton("Так");
        JButton btnCancel = new JButton("Відміна");

        btnOk.addActionListener(e -> this.handleOk());
        btnCancel.addActionListener(e -> this.handleCancel());

        buttonPanel.add(btnOk);
        buttonPanel.add(btnCancel);

        add(centerPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
    }


    private void handleScroll() {
        int currentVal = this.scrollBar.getValue();
        this.valueLabel.setText("Вибране число: " + currentVal);
    }

    private void handleOk() {
        int selectedValue = this.scrollBar.getValue();
        this.dispose();
        if (this.onConfirm != null) {
            this.onConfirm.accept(selectedValue);
        }
    }

    private void handleCancel() {
        this.dispose();
    }
}