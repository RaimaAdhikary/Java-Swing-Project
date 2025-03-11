package aswing;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;

public class EmployeeM implements ActionListener {

    JFrame fme;
    private Container r;
    private Font f;
    JLabel title, fn,ln,id,salary;
    JTextField ff,ll,i,s;

    JScrollPane sp;
    JTable tab; JButton adds,delt,update,clear,exit;
    private DefaultTableModel dm;
    String[] cols={"First Name","Last Name","Employee ID","Salary"};
    String[] rows=new String[4];
    EmployeeM(){
        JFrame fme=new JFrame("Database Frame");

        init();
    }
    public void init(){
       // fme=new JFrame("Database Frame");
        //fme.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       // fme.setBounds(200,200,750,650);
       // fme.setTitle("Employee Management System");

        fme=new JFrame("Database Frame");
        // fme.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fme.setBounds(200,200,750,650);
        fme.setTitle("Employee Management System");
        r=fme.getContentPane();
        r.setLayout(null);
        r.setBackground(Color.cyan);
        f=new Font("Cambria",Font.ITALIC, 13);
        // label
        title=new JLabel("Employee Management Label");
        title.setFont(f);
        title.setBounds(140,10,250,50);
        r.add(title);
        fn=new JLabel("First Name");
        fn.setFont(f);
        fn.setBounds(10,80,140,30);
        r.add(fn);
        ff=new JTextField();
        ff.setFont(f);
        ff.setBounds(110,80,200,30);
        r.add(ff);
        adds=new JButton("Add");
        adds.setFont(f);
        adds.setBounds(400,80,100,30);
    r.add(adds);
        ln=new JLabel("Surname");
        ln.setFont(f);
        ln.setBounds(10,130,150,30);
        r.add(ln);
        ll=new JTextField();
        ll.setFont(f);
        ll.setBounds(110,130,200,30);
        r.add(ll);
        delt=new JButton("Delete");
        delt.setFont(f);
        delt.setBounds(400,130,100,30);
        r.add(delt);
        // 3rd line
        id=new JLabel("Employee ID");
        id.setFont(f);
        id.setBounds(10,180,150,30);
        r.add(id);
        i=new JTextField();
        i.setFont(f);
        i.setBounds(110,180,200,30);
        r.add(i);
        update=new JButton("Update");
        update.setFont(f);
        update.setBounds(400,180,100,30);
        r.add(update);

        //4th linesalary
        salary=new JLabel("Salary");
        salary.setFont(f);
        salary.setBounds(10,230,150,30);
        r.add(salary);
        s=new JTextField();
        s.setFont(f);
        s.setBounds(110,230,200,30);
        r.add(s);
        clear=new JButton("Clear");
        clear.setFont(f);
        clear.setBounds(400,230,100,30);
        r.add(clear);
        exit=new JButton("Exit");
        exit.setFont(f);
        exit.setBounds(400,270,100,30);
        r.add(exit);
        //table setup
        tab=new JTable();
        dm=new DefaultTableModel();
        dm.setColumnIdentifiers(cols);
        tab.setModel(dm);
        tab.setFont(f);
        tab.setSelectionBackground(Color.green);
        tab.setRowHeight(30);
        // scroll
        sp=new JScrollPane(tab);
        sp.setBounds(10,360,740,200);
        r.add(sp);
        adds.addActionListener(this);
        delt.addActionListener(this);
        update.addActionListener(this);
        clear.addActionListener(this);
        exit.addActionListener(this);
        fme.setVisible(true);



    }
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==adds){
            rows[0]=ff.getText();
            rows[1]=ll.getText();
            rows[2]=i.getText();
            rows[3]=s.getText();
            dm.addRow(rows);
        }
        if(e.getSource()==delt){
            int noOfRows=tab.getSelectedRow();
            if(noOfRows>=0){
                dm.removeRow(noOfRows);
            } else{
                JOptionPane.showMessageDialog(null,
                        "No rows is selected");
            }
        }
        if(e.getSource()==clear){
            ff.setText("");
            ll.setText("");
            i.setText("");
            s.setText("");
        }
        if(e.getSource()==update){
            int noOfRows=tab.getSelectedRow();
            if(noOfRows>=0){
                dm.setValueAt(ff.getText(),noOfRows,0);
                dm.setValueAt(ll.getText(),noOfRows,1);
                dm.setValueAt(i.getText(),noOfRows,2);
                dm.setValueAt(s.getText(),noOfRows,3);
            }else{
                JOptionPane.showMessageDialog(null,
                        "No rows is selected for updating");
            }


 } if(e.getSource()==exit){
            JOptionPane.showMessageDialog(fme, "Exited");
            fme.dispose();// inside method init , another method is invoking
            // local variable resolving
            new Login();


        }

    }

}
