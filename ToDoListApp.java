package com.technohacks;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ToDoListApp extends JFrame {
    private DefaultListModel<String> listModel;
    private JList<String> taskList;
    private JTextField taskInputField;
    private JButton addButton;
    private JButton removeButton;

    public ToDoListApp() {
    	
        setTitle("To-Do List Application");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        listModel = new DefaultListModel<>();
        taskList = new JList<>(listModel);
        taskList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        taskList.setBackground(Color.black);
        taskList.setForeground(Color.white);
        taskList.setFont(new Font("Arial", Font.PLAIN, 15));
        JScrollPane listScrollPane = new JScrollPane(taskList);

        taskInputField = new JTextField();
        taskInputField.setPreferredSize(new Dimension(200, 30));

        addButton = new JButton("Add Task");
        removeButton = new JButton("Remove Task");

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String task = taskInputField.getText();
                if (!task.isEmpty()) {
                    listModel.addElement(task);
                    taskInputField.setText("");
                }
            }
        });

        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedIndex = taskList.getSelectedIndex();
                if (selectedIndex != -1) {
                    listModel.remove(selectedIndex);
                }
            }
        });

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new BorderLayout(5, 5));
        inputPanel.add(taskInputField, BorderLayout.CENTER);
        inputPanel.add(addButton, BorderLayout.EAST);

        JPanel controlPanel = new JPanel();
        controlPanel.setLayout(new BorderLayout(5, 5));
        controlPanel.add(inputPanel, BorderLayout.NORTH);
        controlPanel.add(removeButton, BorderLayout.SOUTH);

        getContentPane().add(listScrollPane, BorderLayout.CENTER);
        getContentPane().add(controlPanel, BorderLayout.SOUTH);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ToDoListApp().setVisible(true);
            }
        });
    }
}
