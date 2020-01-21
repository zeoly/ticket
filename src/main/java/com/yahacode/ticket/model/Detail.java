package com.yahacode.ticket.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

/**
 * @author zengyongli 2020-01-02
 */
@Data
@Builder
@AllArgsConstructor
public class Detail {

    private SimpleStringProperty trainNo = new SimpleStringProperty();

    private SimpleStringProperty stationTrainCode = new SimpleStringProperty();

    private String startStation;

    private String destStation;

    private String startDate;

    private String destDate;

    private String duration;

    private String businessClass;

    private String firstClass;

    private String secondClass;

    private String exclusiveSoftSleeper;

    private String softSleeper;

    private String highSpeedSleeper;

    private String hardSleeper;

    private String softSeat;

    private String hardSeat;

    private String noSeat;

    private String other;

    private String candidateFlag;

    private String candidateSeatLimit;

    private String canWebBuy;

    public StringProperty stationTrainCodeProperty() {
        return stationTrainCode;
    }

    public String getStationTrainCode() {
        return stationTrainCode.get();
    }

    public void setStationTrainCode(String stationTrainCode) {
        this.stationTrainCode = new SimpleStringProperty(stationTrainCode);
        this.stationTrainCode.set(stationTrainCode);
    }

    public StringProperty trainNoProperty() {
        return trainNo;
    }

    public String getTrainNo() {
        return trainNo.get();
    }

    public void setTrainNo(String trainNo) {
        this.trainNo = new SimpleStringProperty(trainNo);
        this.trainNo.set(trainNo);
    }
}
