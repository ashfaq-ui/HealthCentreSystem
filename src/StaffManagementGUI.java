import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.awt.*;
import java.util.*;

class StaffTableModel extends AbstractTableModel {

    private String[] column = {"ID", "Name", "Surname", "Role", "Date of Birth", "Contact"};
    private ArrayList<StaffMember> staffList;

    public StaffTableModel(ArrayList<StaffMember> gStaff){
        staffList = gStaff;
    }
    @Override
    public int getColumnCount(){
        return column.length;
    }

    @Override
    public int getRowCount(){
        return staffList.size();
    }

    @Override
    public String getColumnName(int col){
        return column[col];
    }

    public Object getValueAt(int row, int col){
        StaffMember staff = staffList.get(row);
        switch(col){
            case 1:
                return staff.getId();
            case 2:
                return staff.getName();
            case 3:
                return staff.getSurname();
            case 4:
                return staff.getDob();
            case 5:
                return staff.getContactNo();
            default :
                return null;
        }
    }

}



class StaffManagementGUI extends JFrame{

    public StaffManagementGUI(ArrayList<StaffMember> staff){


        setTitle("StaffManagementGUI");
        setSize(500,500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel p1 = new JPanel();
        StaffTableModel Model =  new StaffTableModel(staff);
        JTable table = new JTable(Model);
        JScrollPane JscrollPane = new JScrollPane(table);
        p1.add(JscrollPane);




        JPanel p2 = new JPanel();
        p2.setLayout(new GridLayout(1,5));
        p2.add(new JButton("Add Staff"));
        p2.add(new JButton("Remove Staff"));
        p2.add(new JButton("Show Static"));
        p2.add(new JButton("Refresh"));
        p2.add(new JButton("Exit"));

        JPanel p3 = new JPanel();
        p3.setLayout(new BorderLayout());
        p3.add(new JTextField("Table Area"), BorderLayout.NORTH);

        p3.add(p1, BorderLayout.CENTER);
        p3.add(p2, BorderLayout.SOUTH);

        add(p3);


        setVisible(true);
    }

}