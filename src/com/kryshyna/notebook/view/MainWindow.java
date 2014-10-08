package com.kryshyna.notebook.view;

import com.kryshyna.notebook.DataTablePersons;
import com.kryshyna.notebook.DataTableTelephones;
import com.kryshyna.notebook.dao.DaoFactory;
import com.kryshyna.notebook.dao.PersonDao;
import com.kryshyna.notebook.dao.TelephoneDao;
import com.kryshyna.notebook.entity.Person;
import com.kryshyna.notebook.entity.Telephone;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.TableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.*;

/**
 * @author Vadym Kryshyna
 */
public class MainWindow extends JFrame {


    public static void main(String[] args) throws SQLException {
        DaoFactory factory = new DaoFactory();
        Connection connection = factory.getConnection();
        PersonDao personDao = factory.getPersonDao(connection);
        TelephoneDao telephoneDao = factory.getTelephoneDao(connection);

        JFrame frame = new MainWindow(personDao, telephoneDao);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);


    }


    public MainWindow(PersonDao personDao, TelephoneDao telephoneDao) throws SQLException {
        this.personDao = personDao;
        this.telephoneDao = telephoneDao;
        initComponents();
        initFunction();
        this.mainWindow = this;
    }

    private void initComponents() throws SQLException {
        menuBar = new JMenuBar();
        menu = new JMenu();
        menuItemAbout = new JMenuItem();
        panel = new JPanel();
        scrollPanePerson = new JScrollPane();
        tablePerson = new JTable();
        scrollPaneTelephone = new JScrollPane();
        tableTelephone = new JTable();
        labelPerson = new JLabel();
        labelTelephone = new JLabel();
        buttonAddPerson = new JButton();
        buttonRemovePerson = new JButton();
        buttonEditPerson = new JButton();
        buttonAddTelephone = new JButton();
        buttonRemoveTelephone = new JButton();
        buttonEditTelephone = new JButton();

        Container contentPane = getContentPane();
        {
            {
                menu.setText("Menu");
                menuItemAbout.setText("About");
                menu.add(menuItemAbout);
            }
            menuBar.add(menu);
        }
        setJMenuBar(menuBar);
        {
            {
                scrollPanePerson.setViewportView(tablePerson);
            }
            {
                scrollPaneTelephone.setViewportView(tableTelephone);
            }
            labelPerson.setText("Persons");
            labelPerson.setFont(labelPerson.getFont().deriveFont(labelPerson.getFont().getStyle() | Font.BOLD, labelPerson.getFont().getSize() + 3f));
            labelTelephone.setText("Telephones");
            labelTelephone.setFont(labelTelephone.getFont().deriveFont(labelTelephone.getFont().getStyle() | Font.ITALIC, labelTelephone.getFont().getSize() + 2f));
            buttonAddPerson.setText("Add");
            buttonRemovePerson.setText("Remove");
            buttonEditPerson.setText("Edit");
            buttonAddTelephone.setText("Add");
            buttonRemoveTelephone.setText("Remove");
            buttonEditTelephone.setText("Edit");

            GroupLayout panelLayout = new GroupLayout(panel);
            panel.setLayout(panelLayout);
            panelLayout.setHorizontalGroup(
                    panelLayout.createParallelGroup()
                            .addGroup(panelLayout.createSequentialGroup()
                                    .addContainerGap()
                                    .addGroup(panelLayout.createParallelGroup()
                                            .addGroup(panelLayout.createSequentialGroup()
                                                    .addGap(6, 6, 6)
                                                    .addComponent(buttonAddPerson, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(buttonEditPerson)
                                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(buttonRemovePerson)
                                                    .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                            .addGroup(panelLayout.createSequentialGroup()
                                                    .addGroup(panelLayout.createParallelGroup()
                                                            .addComponent(scrollPanePerson, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 0, Short.MAX_VALUE)
                                                            .addGroup(panelLayout.createSequentialGroup()
                                                                    .addGroup(panelLayout.createParallelGroup()
                                                                            .addComponent(labelPerson, GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE)
                                                                            .addComponent(labelTelephone)
                                                                            .addGroup(panelLayout.createSequentialGroup()
                                                                                    .addComponent(scrollPaneTelephone, GroupLayout.PREFERRED_SIZE, 275, GroupLayout.PREFERRED_SIZE)
                                                                                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                                                    .addGroup(panelLayout.createParallelGroup()
                                                                                            .addComponent(buttonAddTelephone, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
                                                                                            .addComponent(buttonEditTelephone, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
                                                                                            .addComponent(buttonRemoveTelephone))))
                                                                    .addGap(0, 10, Short.MAX_VALUE)))
                                                    .addContainerGap())))
            );
            panelLayout.setVerticalGroup(
                    panelLayout.createParallelGroup()
                            .addGroup(panelLayout.createSequentialGroup()
                                    .addContainerGap()
                                    .addComponent(labelPerson)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(panelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                            .addComponent(buttonAddPerson)
                                            .addComponent(buttonEditPerson)
                                            .addComponent(buttonRemovePerson))
                                    .addGap(4, 4, 4)
                                    .addComponent(scrollPanePerson, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE)
                                    .addGap(8, 8, 8)
                                    .addComponent(labelTelephone)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(panelLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                            .addGroup(panelLayout.createSequentialGroup()
                                                    .addComponent(buttonAddTelephone)
                                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(buttonEditTelephone)
                                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(buttonRemoveTelephone))
                                            .addComponent(scrollPaneTelephone, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE))
                                    .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            );
        }

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
                contentPaneLayout.createParallelGroup()
                        .addComponent(panel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        contentPaneLayout.setVerticalGroup(
                contentPaneLayout.createParallelGroup()
                        .addComponent(panel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pack();
        setLocationRelativeTo(getOwner());
    }

    private void initFunction() throws SQLException {
        tablePerson.setModel(new DataTablePersons(personDao.getAll()));

        tablePerson.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                updateTableTelephone();
            }
        });

        buttonAddPerson.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JDialog panel = new AddPersonWindow(mainWindow);
                panel.setVisible(true);
            }
        });

        buttonEditPerson.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(tablePerson.getSelectedRow()!=-1){
                    Person person = ((DataTablePersons)tablePerson.getModel()).getData().get(tablePerson.getSelectedRow());
                    JDialog panel = new AddPersonWindow(mainWindow, person);
                    panel.setVisible(true);
                }else{
                    JOptionPane.showMessageDialog(null, "Please select person");
                }
            }
        });

        buttonRemovePerson.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(tablePerson.getSelectedRow()==-1){
                    JOptionPane.showMessageDialog(null, "Please select person");
                }else if(((DataTableTelephones)tableTelephone.getModel()).getData().size()>0){
                    JOptionPane.showMessageDialog(null, "Please remove all telephones of this person");
                }else{
                    Person person = ((DataTablePersons)tablePerson.getModel()).getData().get(tablePerson.getSelectedRow());
                    try {
                        personDao.delete(person);
                    } catch (SQLException e1) {
                        e1.printStackTrace();
                    }
                    updateTablePerson();
                }
            }
        });

        buttonAddTelephone.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(tablePerson.getSelectedRow()!=-1){
                    int idfk = (int) tablePerson.getModel().getValueAt(tablePerson.getSelectedRow(), 0);
                    JDialog panel = new AddTelephoneWindow(mainWindow, idfk);
                    panel.setVisible(true);
                }else{
                    JOptionPane.showMessageDialog(null, "Please select person");
                }
            }
        });

        buttonEditTelephone.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(tableTelephone.getSelectedRow()!=-1){
                    Telephone telephone = ((DataTableTelephones)tableTelephone.getModel()).getData().get(tableTelephone.getSelectedRow());
                    JDialog panel = new AddTelephoneWindow(mainWindow, telephone);
                    panel.setVisible(true);
                }else{
                    JOptionPane.showMessageDialog(null, "Please select telephone");
                }
            }
        });

        buttonRemoveTelephone.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(tablePerson.getSelectedRow()==-1){
                    JOptionPane.showMessageDialog(null, "Please select person");
                }else if(tableTelephone.getSelectedRow()==-1){
                    JOptionPane.showMessageDialog(null, "Please select telephone");
                }else{
                    Telephone telephone = ((DataTableTelephones)tableTelephone.getModel()).getData().get(tableTelephone.getSelectedRow());
                    try {
                        telephoneDao.delete(telephone);
                    } catch (SQLException e1) {
                        e1.printStackTrace();
                    }
                    updateTableTelephone();
                }
            }
        });

        menuItemAbout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, messageAbout);
            }
        });

    }

    private void updateTablePerson(){
        try {
            ((DataTablePersons)tablePerson.getModel()).setData(personDao.getAll());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        ((DataTablePersons) tablePerson.getModel()).update();
    }

    private void updateTableTelephone(){
        if(tablePerson.getSelectedRow() != -1){

            int idfk = (int)tablePerson.getValueAt(tablePerson.getSelectedRow(),0);
            TableModel tableModelTelephone = new DataTableTelephones(new ArrayList<Telephone>());
            try {
                tableModelTelephone = new DataTableTelephones(telephoneDao.getAll(idfk));
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            tableTelephone.setModel(tableModelTelephone);
        }
    }

    public void updatePerson(Person person){
        try {
            personDao.update(person);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        updateTablePerson();
    }

    public void addPerson(Person person){
        try {
            personDao.create(person);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        updateTablePerson();
    }

    public void updateTelephone(Telephone telephone){
        try {
            telephoneDao.update(telephone);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        updateTableTelephone();
    }

    public void addTelephone(Telephone telephone){
        try {
            telephoneDao.create(telephone);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        updateTableTelephone();
    }

    private PersonDao personDao;
    private TelephoneDao telephoneDao;
    private MainWindow mainWindow;

    private JMenuBar menuBar;
    private JMenu menu;
    private JMenuItem menuItemAbout;
    private JPanel panel;
    private JScrollPane scrollPanePerson;
    private JTable tablePerson;
    private JScrollPane scrollPaneTelephone;
    private JTable tableTelephone;
    private JLabel labelPerson;
    private JLabel labelTelephone;
    private JButton buttonAddPerson;
    private JButton buttonRemovePerson;
    private JButton buttonEditPerson;
    private JButton buttonAddTelephone;
    private JButton buttonRemoveTelephone;
    private JButton buttonEditTelephone;
    private String messageAbout = "@Author: Vadym Kryshyna \n     2014";
}
