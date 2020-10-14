package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class CurrencyConverterView {
    JFrame frame;
    JPanel panel;
    JComboBox<String> comboBoxFrom, comboBoxTo;
    JButton buttonConvert, buttonSwap;
    JLabel labelError;
    JTextField textFieldFrom, textFieldTo;

    private void init(){
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panel = new JPanel();

        BorderLayout bl = new BorderLayout();
        panel.setLayout(bl);

        comboBoxFrom = new JComboBox<>();
        comboBoxTo = new JComboBox<>();
        buttonConvert = new JButton("Przelicz");
        buttonSwap = new JButton("Zamień miejscami");
        labelError = new JLabel("", JLabel.CENTER);
        textFieldTo = new JTextField();
        textFieldFrom = new JTextField();

        Dimension d = new Dimension(150, 20);
        textFieldFrom.setPreferredSize(d);
        textFieldTo.setPreferredSize(d);
        labelError.setPreferredSize(d);
        textFieldTo.setFocusable(false);

        JPanel panelLineStart = new JPanel();
        panelLineStart.setLayout(new GridLayout(2,0, 0,150));
        JPanel panelLineEnd = new JPanel();
        panelLineEnd.setLayout(new GridLayout(2,0, 0,150));
        JPanel panelCenter = new JPanel();
        panelCenter.setLayout(new GridLayout(2,0));

        panelLineStart.add(comboBoxFrom);
        panelLineStart.add(textFieldFrom);
        panelCenter.add(buttonConvert);
        panelCenter.add(buttonSwap);
        panelLineEnd.add(comboBoxTo);
        panelLineEnd.add(textFieldTo);

        panel.add(panelLineStart, BorderLayout.LINE_START);
        panel.add(panelLineEnd, BorderLayout.LINE_END);
        panel.add(panelCenter, BorderLayout.PAGE_END);
        panel.add(labelError, BorderLayout.PAGE_START);

        frame.pack();
        frame.setTitle("Przelicznik Walut");
        frame.setSize(600, 300);
        frame.setResizable(false);
        frame.add(panel);

        frame.setVisible(true);
    }

    public void populateComboBox(ArrayList<String> currencyList){
        currencyList.forEach(name -> {
            comboBoxFrom.addItem(name);
            comboBoxTo.addItem(name);
        });
    }

    public void addButtonConvertClickListener(ActionListener action){
        buttonConvert.addActionListener(action);
    }

    public void addButtonSwapClickListener(ActionListener action){
        buttonSwap.addActionListener(action);
    }

    public int getFromCurrency(){
        return comboBoxFrom.getSelectedIndex();
    }

    public int getToCurrency(){
        return comboBoxTo.getSelectedIndex();
    }

    public void setFromCurrency(int index){
        comboBoxFrom.setSelectedIndex(index);
    }

    public void setToCurrency(int index){
        comboBoxTo.setSelectedIndex(index);
    }

    public String getValue(){
        return textFieldFrom.getText();
    }

    public void setErrorMessage(String message){
        labelError.setText(message);
    }

    public void setTextFieldToText(String result){
        textFieldTo.setText(result);
    }

    public CurrencyConverterView(){
        init();
    }
}
