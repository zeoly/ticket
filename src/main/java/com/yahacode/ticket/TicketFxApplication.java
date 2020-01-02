package com.yahacode.ticket;

import com.yahacode.ticket.model.Detail;
import com.yahacode.ticket.service.QueryService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.StringConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 * @author zengyongli 2019-12-26
 */
@SpringBootApplication
public class TicketFxApplication extends AbstractJavaFxApplicationSupport {

    private final TableView table = new TableView();

    private final ObservableList<Detail> data = FXCollections.observableArrayList();

    @Autowired
    private QueryService queryService;

    @Override
    public void start(Stage primaryStage) throws Exception {
        Scene scene = new Scene(new Group());
        primaryStage.setTitle("Ticket Application Alpha");
        primaryStage.setWidth(1150);
        primaryStage.setHeight(550);

        final Label startStationLabel = new Label("始发站");
        final TextField startStationText = new TextField();
        final Label destStationLabel = new Label("到达站");
        final TextField destStationText = new TextField();
        final Label startDateLabel = new Label("出发日期");
        final DatePicker startDatePicker = new DatePicker();
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
        final Button queryButton = new Button("查询");
        queryButton.setOnAction((ActionEvent e) -> {
            List<Detail> list = queryService.queryDetail("", "", startDatePicker.getEditor().getText());
            data.clear();
            data.addAll(list);
        });

        final HBox hb = new HBox();
        hb.setSpacing(3);
        hb.getChildren().addAll(startStationLabel, startStationText, destStationLabel, destStationText,
                startDateLabel, startDatePicker, queryButton);

        TableColumn trainNoCol = new TableColumn("车次");
        trainNoCol.setCellValueFactory(new PropertyValueFactory<>("trainNo"));
        TableColumn startStationCol = new TableColumn("始发站");
        startStationCol.setCellValueFactory(new PropertyValueFactory<>("startStation"));
        TableColumn destStationCol = new TableColumn("到达站");
        destStationCol.setCellValueFactory(new PropertyValueFactory<>("destStation"));
        TableColumn startDateCol = new TableColumn("始发时间");
        startDateCol.setCellValueFactory(new PropertyValueFactory<>("startDate"));
        TableColumn destDateCol = new TableColumn("到达时间");
        destDateCol.setCellValueFactory(new PropertyValueFactory<>("destDate"));
        TableColumn durationCol = new TableColumn("历时");
        durationCol.setCellValueFactory(new PropertyValueFactory<>("duration"));
        TableColumn businessClassCol = new TableColumn("商务座");
        businessClassCol.setCellValueFactory(new PropertyValueFactory<>("businessClass"));
        businessClassCol.setMaxWidth(50);
        TableColumn firstClassCol = new TableColumn("一等座");
        firstClassCol.setCellValueFactory(new PropertyValueFactory<>("firstClass"));
        firstClassCol.setMaxWidth(50);
        TableColumn secondClassCol = new TableColumn("二等座");
        secondClassCol.setCellValueFactory(new PropertyValueFactory<>("secondClass"));
        secondClassCol.setMaxWidth(50);
        TableColumn exclusiveSoftSleeperCol = new TableColumn("高级软卧");
        exclusiveSoftSleeperCol.setCellValueFactory(new PropertyValueFactory<>("exclusiveSoftSleeper"));
        exclusiveSoftSleeperCol.setMaxWidth(60);
        TableColumn softSleeperCol = new TableColumn("软卧");
        softSleeperCol.setCellValueFactory(new PropertyValueFactory<>("softSleeper"));
        softSleeperCol.setMaxWidth(50);
        TableColumn highSpeedSleeperCol = new TableColumn("动卧");
        highSpeedSleeperCol.setCellValueFactory(new PropertyValueFactory<>("highSpeedSleeper"));
        highSpeedSleeperCol.setMaxWidth(50);
        TableColumn hardSleeperCol = new TableColumn("硬卧");
        hardSleeperCol.setCellValueFactory(new PropertyValueFactory<>("hardSleeper"));
        hardSleeperCol.setMaxWidth(50);
        TableColumn softSeatCol = new TableColumn("软座");
        softSeatCol.setCellValueFactory(new PropertyValueFactory<>("softSeat"));
        softSeatCol.setMaxWidth(50);
        TableColumn hardSeatCol = new TableColumn("硬座");
        hardSeatCol.setCellValueFactory(new PropertyValueFactory<>("hardSeat"));
        hardSeatCol.setMaxWidth(50);
        TableColumn noSeatCol = new TableColumn("无座");
        noSeatCol.setCellValueFactory(new PropertyValueFactory<>("noSeat"));
        noSeatCol.setMaxWidth(50);
        TableColumn otherCol = new TableColumn("其他");
        otherCol.setCellValueFactory(new PropertyValueFactory<>("other"));
        otherCol.setMaxWidth(50);
        TableColumn commentCol = new TableColumn("备注");
        commentCol.setMaxWidth(60);

        table.setItems(data);
        table.getColumns().addAll(trainNoCol, startStationCol, destStationCol, startDateCol, destDateCol, durationCol
                , businessClassCol, firstClassCol, secondClassCol, exclusiveSoftSleeperCol, softSleeperCol,
                highSpeedSleeperCol, hardSleeperCol, softSeatCol, hardSeatCol, noSeatCol, otherCol, commentCol);
        table.setMaxWidth(1100);

        final VBox vbox = new VBox();
        vbox.setSpacing(5);
        vbox.setPadding(new Insets(10, 0, 0, 10));
        vbox.getChildren().addAll(hb, table);

        ((Group) scene.getRoot()).getChildren().addAll(vbox);

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launchApp(TicketFxApplication.class, args);
    }
}
