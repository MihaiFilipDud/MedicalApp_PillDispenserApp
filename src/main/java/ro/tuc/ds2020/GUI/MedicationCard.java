package ro.tuc.ds2020.GUI;

import ro.tuc.ds2020.entities.Medication;
import ro.tuc.ds2020.entities.MedicationPlan;
import ro.tuc.ds2020.entities.MedicationStatus;
import ro.tuc.ds2020.hessian_rmi.MedicationPlanTransfer;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class MedicationCard extends JPanel implements ActionListener {

    public Date curTime;
    public Medication medication;
    public MedicationPlan medicationPlan;
    public MedicationPlanTransfer medicationPlanTransfer;
    public JButton takeMedBut;
    public Boolean destroy = false;
    public JPanel card = this;


    public MedicationCard(int sel, Medication medication, MedicationPlan medicationPlan, MedicationPlanTransfer medicationPlanTransfer) {
        this.curTime = curTime;
        this.medication = medication;
        this.medicationPlan = medicationPlan;
        this.medicationPlanTransfer = medicationPlanTransfer;


        int timeDelay = 500;
        ActionListener time;
        time = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent evt) {
                curTime = new Date();
                if((curTime.getHours() < medicationPlan.getIntakeIntervalStart().getHours() ||
                        curTime.getHours() == medicationPlan.getIntakeIntervalStart().getHours()  && curTime.getMinutes() < medicationPlan.getIntakeIntervalStart().getMinutes() ||
                        curTime.getHours() == medicationPlan.getIntakeIntervalStart().getHours()  && curTime.getMinutes() == medicationPlan.getIntakeIntervalStart().getMinutes() && curTime.getSeconds() < medicationPlan.getIntakeIntervalStart().getSeconds()
                ) || (curTime.getHours() > medicationPlan.getIntakeIntervalEnd().getHours() ||
                        curTime.getHours() == medicationPlan.getIntakeIntervalEnd().getHours()  && curTime.getMinutes() > medicationPlan.getIntakeIntervalEnd().getMinutes() ||
                        curTime.getHours() == medicationPlan.getIntakeIntervalEnd().getHours()  && curTime.getMinutes() == medicationPlan.getIntakeIntervalEnd().getMinutes() && curTime.getSeconds() > medicationPlan.getIntakeIntervalEnd().getSeconds()

                        )){
                    if(!destroy && sel%2==0) {
                        medicationPlanTransfer.medicationStatusResponse(new MedicationStatus(curTime, false, medication));
                        takeMedBut.setEnabled(false);
                        destroy = true;
                    }
                    //card.removeAll();
                }else{
                    takeMedBut.setEnabled(true);
                }
            }
        };

        new Timer(timeDelay, time).start();

        JLabel medName = new JLabel(medication.getName());
        JLabel intakeStart = new JLabel(medicationPlan.getIntakeIntervalStart().toString());
        JLabel intakeEnd = new JLabel(medicationPlan.getIntakeIntervalEnd().toString());

        takeMedBut = new JButton("Take");

        this.add(medName);
        this.add(intakeStart);
        this.add(intakeEnd);
        this.add(takeMedBut);
        this.setVisible(true);
        this.setSize(200,100);

        takeMedBut.addActionListener(new ActionListener() {


            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                System.out.println(medication.getName()+ " taken");
                medicationPlanTransfer.medicationStatusResponse(new MedicationStatus(curTime, true, medication));
                card.removeAll();
                destroy = true;

            }
        });


    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {

    }
}
