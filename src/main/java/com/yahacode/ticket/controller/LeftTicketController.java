package com.yahacode.ticket.controller;

import com.yahacode.ticket.model.Detail;
import com.yahacode.ticket.service.QueryService;
import de.felixroske.jfxsupport.FXMLController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DateCell;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;
import javafx.util.StringConverter;
import org.springframework.beans.factory.annotation.Autowired;

import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.ResourceBundle;

/**
 * @author zengyongli 2020-01-14
 */
@FXMLController
public class LeftTicketController implements Initializable {

    @Autowired
    private QueryService queryService;

    @FXML
    private TextField startStationText;

    @FXML
    private TextField destStationText;

    @FXML
    private DatePicker startDatePicker;

    @FXML
    TableView leftTicketTable;
    @FXML
    TableColumn trainNoCol;
    @FXML
    TableColumn startStationCol;
    @FXML
    TableColumn destStationCol;
    @FXML
    TableColumn startDateCol;
    @FXML
    TableColumn destDateCol;
    @FXML
    TableColumn durationCol;
    @FXML
    TableColumn businessClassCol;
    @FXML
    TableColumn firstClassCol;
    @FXML
    TableColumn secondClassCol;
    @FXML
    TableColumn exclusiveSoftSleeperCol;
    @FXML
    TableColumn softSleeperCol;
    @FXML
    TableColumn highSpeedSleeperCol;
    @FXML
    TableColumn hardSleeperCol;
    @FXML
    TableColumn softSeatCol;
    @FXML
    TableColumn hardSeatCol;
    @FXML
    TableColumn noSeatCol;

    private ObservableList<Detail> leftTicketData = FXCollections.observableArrayList();

    @FXML
    protected void exchangeStation(ActionEvent event) {
        String tmp = startStationText.getText();
        startStationText.setText(destStationText.getText());
        destStationText.setText(tmp);
    }

    @FXML
    protected void queryLeftTicket(ActionEvent event) {
        leftTicketData.clear();
        List<Detail> list = queryService.queryDetail(startStationText.getText(), destStationText.getText(),
                startDatePicker.getEditor().getText());
        leftTicketData.addAll(list);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        startStationText.setText("CQW");
        destStationText.setText("SZQ");
        initDatePicker();
        initTableView();
    }

    private void initDatePicker() {
        startDatePicker.setConverter(new StringConverter<LocalDate>() {
            DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

            @Override
            public String toString(LocalDate date) {
                if (date != null) {
                    return dateFormatter.format(date);
                } else {
                    return "";
                }
            }

            @Override
            public LocalDate fromString(String string) {
                if (string != null && !string.isEmpty()) {
                    return LocalDate.parse(string, dateFormatter);
                } else {
                    return null;
                }
            }
        });
        startDatePicker.setDayCellFactory(new Callback<DatePicker, DateCell>() {
            @Override
            public DateCell call(final DatePicker param) {
                return new DateCell() {
                    @Override
                    public void updateItem(LocalDate item, boolean empty) {
                        super.updateItem(item, empty);
                        if (item.isBefore(LocalDate.now()) || item.isAfter(LocalDate.now().plusDays(29))) {
                            setDisable(true);
                            setStyle("-fx-background-color: #ffc0cb;");
                        }
                    }
                };
            }
        });
    }

    private void initTableView() {
        trainNoCol.setCellValueFactory(new PropertyValueFactory<>("trainNo"));
        startStationCol.setCellValueFactory(new PropertyValueFactory<>("startStation"));
        destStationCol.setCellValueFactory(new PropertyValueFactory<>("destStation"));
        startDateCol.setCellValueFactory(new PropertyValueFactory<>("startDate"));
        destDateCol.setCellValueFactory(new PropertyValueFactory<>("destDate"));
        durationCol.setCellValueFactory(new PropertyValueFactory<>("duration"));
        businessClassCol.setCellValueFactory(new PropertyValueFactory<>("businessClass"));
        firstClassCol.setCellValueFactory(new PropertyValueFactory<>("firstClass"));
        secondClassCol.setCellValueFactory(new PropertyValueFactory<>("secondClass"));
        exclusiveSoftSleeperCol.setCellValueFactory(new PropertyValueFactory<>("exclusiveSoftSleeper"));
        softSleeperCol.setCellValueFactory(new PropertyValueFactory<>("softSleeper"));
        highSpeedSleeperCol.setCellValueFactory(new PropertyValueFactory<>("highSpeedSleeper"));
        hardSleeperCol.setCellValueFactory(new PropertyValueFactory<>("hardSleeper"));
        softSeatCol.setCellValueFactory(new PropertyValueFactory<>("softSeat"));
        hardSeatCol.setCellValueFactory(new PropertyValueFactory<>("hardSeat"));
        noSeatCol.setCellValueFactory(new PropertyValueFactory<>("noSeat"));
        leftTicketTable.setItems(leftTicketData);
    }
}
