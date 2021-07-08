package com.github.bashdi.wildcard.shutdownapp.gui;

import com.github.bashdi.wildcard.commons.utilities.Time;
import com.github.bashdi.wildcard.shutdownapp.logic.Shutdown;
import com.github.bashdi.wildcard.shutdownapp.logic.WindowsShutdown;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ShutdownPanel extends JPanel {

    private JPanel mainJPanel;
    private JLabel HeadlineLabel;
    private JPanel targetTimeJPanel;
    private JButton startButton;
    private JButton cancelButton;
    private JLabel targetTimeLabel;
    private JLabel targetTimeValueLabel;
    private JLabel hourLabel;
    private JSpinner hourSpinner;
    private JLabel minuteLabel;
    private JSpinner minuteSpinner;
    private JLabel secondsLabel;
    private JSpinner secondsSpinner;

    private Shutdown shutdown;

    public ShutdownPanel() {
        add(mainJPanel);

        shutdown = new WindowsShutdown();

        SpinnerNumberModel hourModel = new SpinnerNumberModel(0, 0, 9999, 1);
        SpinnerNumberModel minuteModel = new SpinnerNumberModel(0, 0, 9999, 1);
        SpinnerNumberModel secondModel = new SpinnerNumberModel(0, 0, 9999, 1);
        hourSpinner.setModel(hourModel);
        minuteSpinner.setModel(minuteModel);
        secondsSpinner.setModel(secondModel);
        updateTime();

        ChangeListener spinnerListener = new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                updateTime();
            }
        };

        hourSpinner.addChangeListener(spinnerListener);
        minuteSpinner.addChangeListener(spinnerListener);
        secondsSpinner.addChangeListener(spinnerListener);


        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int tSeconds = ((int) secondsSpinner.getValue()) +
                        Time.toSeconds((int) hourSpinner.getValue(), (int) minuteSpinner.getValue());
                if (tSeconds < 60) tSeconds = 60;
                shutdown.shutdown(tSeconds);
            }
        });
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                shutdown.cancelShutdown();
            }
        });
    }


    private void updateTime(){
        targetTimeValueLabel.setText(Time.localDateTimeToString(Time.addToCurrentTime(
                (int) hourSpinner.getValue(),
                (int) minuteSpinner.getValue(),
                (int) secondsSpinner.getValue()
                ))
        );
    }
}



