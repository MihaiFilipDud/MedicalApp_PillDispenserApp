package ro.tuc.ds2020.GUI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import ro.tuc.ds2020.entities.Medication;
import ro.tuc.ds2020.entities.MedicationPlan;
import ro.tuc.ds2020.hessian_rmi.MedicationPlanTransfer;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Component
public class MainFrame extends JFrame {

    public List<MedicationPlan> planList;
    public Date curTime;

    public JLabel timeLabel;
    public JScrollPane medPlanTablePane = new JScrollPane();
    public JPanel medCardsPane;
    public JTable medPlanTable;
    private MedicationPlanTransfer medicationPlanTransfer;
    static int sel = 0;

    @Autowired
    public MainFrame(MedicationPlanTransfer medicationPlanTransfer) {
        this.medicationPlanTransfer = medicationPlanTransfer;
        //planList = medicationPlanTransfer.transferMedPlan(UUID.fromString("ed1b6e0b-130f-46fe-a2a2-c6cc8a87995e"));
        init();
    }


    @Scheduled(fixedDelay = 86400000)
    //@Scheduled(fixedDelay = 1000)
    public void getMedPlans(){
        medPlanTablePane.removeAll();
        planList = medicationPlanTransfer.transferMedPlan(UUID.fromString("ed1b6e0b-130f-46fe-a2a2-c6cc8a87995e"));
        //planList = medicationPlanTransfer.transferMedPlan(UUID.fromString("895b0d69-1f20-4c1a-8763-a2348ec45af9"));
        String column[]={"Medication Plan"};
//
        String data[][] = new String[100000][2];
        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");

        for(MedicationPlan medicationPlan:planList) {
            data[planList.indexOf(medicationPlan)][0] = "Medication plan "+(planList.indexOf(medicationPlan)+1)+": "+format.format(medicationPlan.getTreatmentStart())+" - "+format.format(medicationPlan.getTreatmentEnd());
        }
        medPlanTable=new JTable(data,column);

        medPlanTable.setCellSelectionEnabled(true);
        ListSelectionModel select= medPlanTable.getSelectionModel();
        select.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        select.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e) {
                sel++;
                System.out.println(sel);
                medCardsPane.removeAll();

                String Data = null;
                int[] row = medPlanTable.getSelectedRows();
                int i;
                if(row[0] > planList.size()-1){
                    i = planList.size()-1;
                } else{
                    i = row[0];
                }


                for(Medication medication:planList.get(i).getMedications()){
                    medCardsPane.add(new MedicationCard(sel, medication, planList.get(i), medicationPlanTransfer));
                }
//
            }
        });


        medPlanTablePane = new JScrollPane(medPlanTable);

    }

    public void init(){
        JFrame f = new JFrame("Pill Dispenser Application");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLayout(new GridLayout(1, 2));
        medCardsPane = new JPanel();
        medCardsPane.setVisible(true);
        medCardsPane.setLayout(new BoxLayout(medCardsPane,BoxLayout.Y_AXIS));


        timeLabel = new JLabel();
        SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
        int timeDelay = 1000;
        ActionListener time;
        time = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent evt) {
                curTime = new Date();
                timeLabel.setText(dateFormat.format(curTime));
                f.setSize(1001, 500);
                f.setSize(1000, 500);
            }
        };

        new Timer(timeDelay, time).start();


        JPanel rightPane = new JPanel();
        rightPane.setLayout(new BoxLayout(rightPane,BoxLayout.Y_AXIS));

        rightPane.add(timeLabel);
        rightPane.add(Box.createRigidArea(new Dimension(0,60)));
        rightPane.add(medCardsPane);
        getMedPlans();

        f.add(medPlanTablePane);
        f.add(rightPane);

        f.setSize(1000, 500);
        f.setVisible(true);
    }



}
