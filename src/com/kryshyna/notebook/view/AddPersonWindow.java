package com.kryshyna.notebook.view;

import com.kryshyna.notebook.entity.Person;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Vadym Kryshyna
 */
public class AddPersonWindow extends JDialog {
    public AddPersonWindow(MainWindow mainWindow) {
        this.mainWindow = mainWindow;
        initComponents();
        initFunction();
    }

    public AddPersonWindow(MainWindow mainWindow, Person person) {
        this(mainWindow);
        this.person = person;
        setParameters();
    }


    private void initComponents() {
        labelPerson = new JLabel();
        labelFirstname = new JLabel();
        labelLastname = new JLabel();
        textFieldFirstname = new JTextField();
        textFieldLastname = new JTextField();
        buttonSave = new JButton();
        buttonCancel = new JButton();

        Container contentPane = getContentPane();
        labelPerson.setText("Person");
        labelPerson.setFont(labelPerson.getFont().deriveFont(labelPerson.getFont().getSize() + 3f));
        labelPerson.setHorizontalAlignment(SwingConstants.CENTER);
        labelFirstname.setText("First name");
        labelFirstname.setFont(labelFirstname.getFont().deriveFont(labelFirstname.getFont().getSize() + 1f));
        labelLastname.setText("Last name");
        labelLastname.setFont(labelLastname.getFont().deriveFont(labelLastname.getFont().getSize() + 1f));
        buttonSave.setText("Save");
        buttonCancel.setText("Cancel");

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
                contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                                .addGroup(contentPaneLayout.createParallelGroup()
                                        .addGroup(contentPaneLayout.createSequentialGroup()
                                                .addGap(19, 19, 19)
                                                .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                        .addGroup(contentPaneLayout.createSequentialGroup()
                                                                .addComponent(labelFirstname)
                                                                .addGap(38, 38, 38)
                                                                .addComponent(textFieldFirstname, GroupLayout.PREFERRED_SIZE, 105, GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(contentPaneLayout.createSequentialGroup()
                                                                .addGroup(contentPaneLayout.createParallelGroup()
                                                                        .addGroup(contentPaneLayout.createSequentialGroup()
                                                                                .addComponent(labelLastname)
                                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                                        .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                                                                                .addGap(0, 0, Short.MAX_VALUE)
                                                                                .addComponent(buttonSave, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
                                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                                                .addGroup(contentPaneLayout.createParallelGroup()
                                                                        .addComponent(textFieldLastname, GroupLayout.PREFERRED_SIZE, 105, GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(buttonCancel, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)))))
                                        .addGroup(contentPaneLayout.createSequentialGroup()
                                                .addGap(73, 73, 73)
                                                .addComponent(labelPerson, GroupLayout.PREFERRED_SIZE, 105, GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        contentPaneLayout.setVerticalGroup(
                contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(labelPerson)
                                .addGap(18, 18, 18)
                                .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(labelFirstname)
                                        .addComponent(textFieldFirstname, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(labelLastname)
                                        .addComponent(textFieldLastname, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(buttonSave)
                                        .addComponent(buttonCancel))
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pack();
        setLocationRelativeTo(getOwner());
    }

    private void initFunction() {

        buttonCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        buttonSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(textFieldFirstname.getText().trim().length()==0){
                    JOptionPane.showMessageDialog(null, "Input first name");
                }
                else if (textFieldLastname.getText().trim().length()==0){
                    JOptionPane.showMessageDialog(null, "Input last name");
                }else if(person == null){
                    person = new Person();
                    person.setFirstname(textFieldFirstname.getText().trim());
                    person.setLastname(textFieldLastname.getText().trim());
                    mainWindow.addPerson(person);
                    dispose();
                }else{
                    person.setFirstname(textFieldFirstname.getText().trim());
                    person.setLastname(textFieldLastname.getText().trim());
                    mainWindow.updatePerson(person);
                    dispose();
                }
            }
        });
    }

    private void setParameters(){
        textFieldFirstname.setText(person.getFirstname());
        textFieldLastname.setText(person.getLastname());
    }

    MainWindow mainWindow;
    private JLabel labelPerson;
    private JLabel labelFirstname;
    private JLabel labelLastname;
    private JTextField textFieldFirstname;
    private JTextField textFieldLastname;
    private JButton buttonSave;
    private JButton buttonCancel;
    private Person person;
}
