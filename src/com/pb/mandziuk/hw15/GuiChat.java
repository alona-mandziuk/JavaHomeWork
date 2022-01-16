package com.pb.mandziuk.hw15;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class GuiChat extends JFrame {
    private JTextField jtfMessage;
    private JTextField jtfName;
    private JTextArea jtaTextAreaMessage;
    private String clientName = "";
    private PrintWriter outMessage;
    private Scanner inMessage;
    private Socket clientSocket;
        public GuiChat(JTextField jtfMessage, JTextField jtfName, JTextArea jtaTextAreaMessage) {
        this.jtfMessage = jtfMessage;
        this.jtfName = jtfName;
        this.jtaTextAreaMessage = jtaTextAreaMessage;
    }
    public GuiChat() {
            }

    public String getClientName() {
        return this.clientName;
    }
    public void ClientWindow(){
    setBounds(500, 250, 500, 400);
    setTitle("Client");
    setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    jtaTextAreaMessage = new JTextArea();
    jtaTextAreaMessage.setEditable(false);
    jtaTextAreaMessage.setLineWrap(true);
    JScrollPane jsp = new JScrollPane(jtaTextAreaMessage);
    add(jsp, BorderLayout.CENTER);

    JLabel jlNumberOfClients = new JLabel("Количество клиентов в чате: ");
    add(jlNumberOfClients, BorderLayout.NORTH);
    JPanel bottomPanel = new JPanel(new BorderLayout());
    add(bottomPanel, BorderLayout.SOUTH);
    JButton jbSendMessage = new JButton("Отправить");
    bottomPanel.add(jbSendMessage, BorderLayout.EAST);
    jtfMessage = new JTextField("Введите ваше сообщение: ");
    bottomPanel.add(jtfMessage, BorderLayout.CENTER);
    jtfName = new JTextField("Введите ваше имя: ");
    bottomPanel.add(jtfName, BorderLayout.WEST);

    jbSendMessage.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {

            if (!jtfMessage.getText().trim().isEmpty() && !jtfName.getText().trim().isEmpty()) {
                clientName = jtfName.getText();

                jtfMessage.grabFocus();
            }
        }
    });
    // при фокусе поле сообщения очищается
    jtfMessage.addFocusListener(new FocusAdapter() {
        @Override
        public void focusGained(FocusEvent e) {
            jtfMessage.setText("");
        }
    });

    jtfName.addFocusListener(new FocusAdapter() {
        @Override
        public void focusGained(FocusEvent e) {
            jtfName.setText("");
        }
    });


    addWindowListener(new WindowAdapter() {
        @Override
        public void windowClosing(WindowEvent e) {
            super.windowClosing(e);
            try {
                // здесь проверяем, что имя клиента непустое и не равно значению по умолчанию
                if (!clientName.isEmpty() && clientName != "Введите ваше имя: ") {
                    outMessage.println(clientName + " вышел из чата!");
                } else {
                    outMessage.println("Участник вышел из чата, так и не представившись!");
                }
                // отправляем служебное сообщение, которое является признаком того, что клиент вышел из чата
                outMessage.println("##session##end##");
                outMessage.flush();
                outMessage.close();
                inMessage.close();
                clientSocket.close();
            } catch (IOException exc) {

            }
        }
    });
    // отображаем форму
    setVisible(true);
}
}
