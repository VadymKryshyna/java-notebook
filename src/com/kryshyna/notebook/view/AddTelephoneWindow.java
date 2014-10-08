package com.kryshyna.notebook.view;

import com.kryshyna.notebook.entity.Telephone;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author  Vadym Kryshyna
 */
public class AddTelephoneWindow extends JDialog {

    public AddTelephoneWindow(MainWindow mainWindow, int idfk) {
        this.mainWindow = mainWindow;
        initComponents();
        initFunction(idfk);
    }

    public AddTelephoneWindow(MainWindow mainWindow, Telephone telephone) {
        this.mainWindow = mainWindow;
        this.telephone = telephone;
        initComponents();
        setParameters();
        initFunction(telephone.getFkid());
    }

    private void initComponents() {
        labelTelephone = new JLabel();
        labelNumber = new JLabel();
        textFieldNumber = new JTextField();
        buttonSave = new JButton();
        buttonCancel = new JButton();

        Container contentPane = getContentPane();

        labelTelephone.setText("Telephone");
        labelTelephone.setFont(labelTelephone.getFont().deriveFont(labelTelephone.getFont().getSize() + 3f));
        labelTelephone.setHorizontalAlignment(SwingConstants.CENTER);
        labelNumber.setText("Number");
        labelNumber.setFont(labelNumber.getFont().deriveFont(labelNumber.getFont().getSize() + 1f));
        buttonSave.setText("Save");
        buttonCancel.setText("Cancel");

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
                contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                                .addGroup(contentPaneLayout.createParallelGroup()
                                        .addGroup(contentPaneLayout.createSequentialGroup()
                                                .addGap(73, 73, 73)
                                                .addComponent(labelTelephone, GroupLayout.PREFERRED_SIZE, 105, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(contentPaneLayout.createSequentialGroup()
                                                .addGap(19, 19, 19)
                                                .addGroup(contentPaneLayout.createParallelGroup()
                                                        .addComponent(labelNumber)
                                                        .addComponent(buttonSave, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE))
                                                .addGap(30, 30, 30)
                                                .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                                        .addComponent(textFieldNumber, GroupLayout.PREFERRED_SIZE, 105, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(buttonCancel, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE))))
                                .addContainerGap(15, Short.MAX_VALUE))
        );
        contentPaneLayout.setVerticalGroup(
                contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(labelTelephone)
                                .addGap(18, 18, 18)
                                .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(labelNumber)
                                        .addComponent(textFieldNumber, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(buttonSave)
                                        .addComponent(buttonCancel))
                                .addContainerGap(12, Short.MAX_VALUE))
        );
        pack();
        setLocationRelativeTo(getOwner());
    }

    private void initFunction(final int fkid) {

        buttonCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        buttonSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(textFieldNumber.getText().trim().length()==0){
                    JOptionPane.showMessageDialog(null, "Input number");
                }else if(telephone == null){
                    telephone = new Telephone();
                    telephone.setNumber(textFieldNumber.getText().trim());
                    telephone.setFkid(fkid);
                    mainWindow.addTelephone(telephone);
                    dispose();
                }else{
                    telephone.setNumber(textFieldNumber.getText().trim());
                    mainWindow.updateTelephone(telephone);
                    dispose();
                }
            }
        });

    }

    private void setParameters(){
        textFieldNumber.setText(telephone.getNumber());
    }


    private MainWindow mainWindow;
    private JLabel labelTelephone;
    private JLabel labelNumber;
    private JTextField textFieldNumber;
    private JButton buttonSave;
    private JButton buttonCancel;
    private Telephone telephone;
}

