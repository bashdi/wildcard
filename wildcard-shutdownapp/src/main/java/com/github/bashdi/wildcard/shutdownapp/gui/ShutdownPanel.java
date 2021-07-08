package com.github.bashdi.wildcard.shutdownapp.gui;

import com.github.bashdi.wildcard.commons.utilities.Time;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

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

    public ShutdownPanel() {
        add(mainJPanel);

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



