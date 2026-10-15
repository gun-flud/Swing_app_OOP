package lab1;

import javax.swing.*;
import java.awt.*;

public class Lab1 extends JFrame {
    private final JLabel statusLabel;

    public Lab1() {
        super("Лабораторна робота №1 — Варіант 13");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 300);
        setLocationRelativeTo(null);
        setResizable(false);

        this.statusLabel = new JLabel("Оберіть пункт меню", SwingConstants.CENTER);
        this.statusLabel.setFont(new Font("SansSerif", Font.BOLD, 15));

        setLayout(new BorderLayout());
        add(this.statusLabel, BorderLayout.CENTER);

        setJMenuBar(this.createMenuBar());
    }

    private JMenuBar createMenuBar() {
        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("Меню робіт");

        JMenuItem menuItem1 = new JMenuItem("Робота1");
        JMenuItem menuItem2 = new JMenuItem("Робота2");

        menuItem1.addActionListener(e -> this.openMenu1());
        menuItem2.addActionListener(e -> this.openMenu2Step1());

        menu.add(menuItem1);
        menu.add(menuItem2);
        menuBar.add(menu);

        return menuBar;
    }

    private void openMenu1() {
        Module1 dialog = new Module1(this, selectedNumber -> {
            this.statusLabel.setText("Робота 1: вибрано число " + selectedNumber);
        });
        dialog.setVisible(true);
    }

    private void openMenu2Step1() {
        Module2 step1 = new Module2(
                this,
                this::openMenu2Step2,
                () -> this.statusLabel.setText("Робота 2: скасовано у вікні 1")
        );
        step1.setVisible(true);
    }

    private void openMenu2Step2() {
        Module3 step2 = new Module3(
                this,
                this::openMenu2Step1,
                () -> this.statusLabel.setText("Робота 2: завершено, натиснуто [Так]"),
                () -> this.statusLabel.setText("Робота 2: скасовано у вікні 2")
        );
        step2.setVisible(true);
    }

    public static void main (String[] args) {
        SwingUtilities.invokeLater(() -> {
            Lab1 app = new Lab1();
            app.setVisible(true);
        });
    }

}