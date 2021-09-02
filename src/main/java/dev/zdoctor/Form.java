package dev.zdoctor;

import purejavacomm.CommPortIdentifier;
import purejavacomm.NoSuchPortException;
import purejavacomm.PortInUseException;
import purejavacomm.SerialPort;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;

/**
 * @Author >> zDoctor_
 * Date >> 8/16/2021
 **/

public class Form extends JFrame {


    public JPanel gui;


    public JLabel label;
    public JButton connect;
    JComboBox<String> jComboBox;
    public JButton on;
    public JButton off;

    OutputStream outStream;
    InputStream inStream;

    public Form() {
        super("ArduinoApp");

        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }

        gui = new JPanel(null);


        label = new JLabel("Not connected");

        String[] optionsToChoose = {"COM1", "COM2", "COM3", "COM4", "COM5"};
        jComboBox = new JComboBox<>(optionsToChoose);

        connect = new JButton("Connect");
        on = new JButton("ON");
        off = new JButton("OFF");


        gui.add(label);
        label.setBounds(30, 30, label.getPreferredSize().width, label.getPreferredSize().height);
        gui.add(jComboBox);
        jComboBox.setPreferredSize(new Dimension(100, 25));
        jComboBox.setBounds(300, 150, jComboBox.getPreferredSize().width, jComboBox.getPreferredSize().height);
        gui.add(connect);
        connect.setPreferredSize(new Dimension(100, 25));
        connect.setBounds(300, 175, connect.getPreferredSize().width, connect.getPreferredSize().height);
        gui.add(on);
        on.setVisible(false);
        on.setPreferredSize(new Dimension(100, 25));
        on.setBounds(50, 200, on.getPreferredSize().width, on.getPreferredSize().height);
        gui.add(off);
        off.setVisible(false);
        off.setPreferredSize(new Dimension(100, 25));
        off.setBounds(550, 200, off.getPreferredSize().width, off.getPreferredSize().height);


        add(gui);


        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);



        connect.addActionListener(e -> {
            try {
                CommPortIdentifier portId = CommPortIdentifier.getPortIdentifier((String) jComboBox.getSelectedItem());
                SerialPort port = (SerialPort) portId.open("Arduinoo", 1000);
                outStream = port.getOutputStream();
                inStream = port.getInputStream();
                label.setText("Connected!");
                on.setVisible(true);
                off.setVisible(true);
            } catch (IOException | NoSuchPortException | PortInUseException ioException) {
                ioException.printStackTrace();
                label.setText("Error!");
            }
        });

        on.addActionListener(e -> {
            try {
                outStream.write("!on".getBytes());
                label.setText("Led on!");
            } catch (IOException ioException) {
                ioException.printStackTrace();
                label.setText("Error!");
            }
        });
        off.addActionListener(e -> {
            try {
                outStream.write("off".getBytes());
                label.setText("Led off!");
            } catch (IOException ioException) {
                ioException.printStackTrace();
                label.setText("Error!");
            }
        });

        setSize(700, 400);
        setResizable(false);
        setVisible(true);
    }
}
