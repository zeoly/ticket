package com.yahacode.ticket.fx;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * @author zengyongli 2019-12-26
 */
public class TicketFxApplication extends Application {

    private final TableView table = new TableView();

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

        final HBox hb = new HBox();
        hb.setSpacing(3);
        hb.getChildren().addAll(startStationLabel, startStationText, destStationLabel, destStationText,
                startDateLabel, startDatePicker);

        TableColumn trainNoCol = new TableColumn("车次");
        TableColumn startStationCol = new TableColumn("始发站");
        TableColumn destStationCol = new TableColumn("到达站");
        TableColumn startDate = new TableColumn("始发时间");
        TableColumn destDate = new TableColumn("到达时间");
        TableColumn duration = new TableColumn("历时");
        TableColumn businessClass = new TableColumn("商务座");
        businessClass.setMaxWidth(50);
        TableColumn firstClass = new TableColumn("一等座");
        firstClass.setMaxWidth(50);
        TableColumn secondClass = new TableColumn("二等座");
        secondClass.setMaxWidth(50);
        TableColumn exclusiveSoftSleeper = new TableColumn("高级软卧");
        exclusiveSoftSleeper.setMaxWidth(50);
        TableColumn softSleeper = new TableColumn("软卧");
        softSleeper.setMaxWidth(50);
        TableColumn highSpeedSleeper = new TableColumn("动卧");
        highSpeedSleeper.setMaxWidth(50);
        TableColumn hardSleeper = new TableColumn("硬卧");
        hardSleeper.setMaxWidth(50);
        TableColumn softSeat = new TableColumn("软座");
        softSeat.setMaxWidth(50);
        TableColumn hardSeat = new TableColumn("硬座");
        hardSeat.setMaxWidth(50);
        TableColumn noSeat = new TableColumn("无座");
        noSeat.setMaxWidth(50);
        TableColumn other = new TableColumn("其他");
        other.setMaxWidth(50);
        TableColumn comment = new TableColumn("备注");
        comment.setMaxWidth(60);

        table.getColumns().addAll(trainNoCol, startStationCol, destStationCol, startDate, destDate, duration,
                businessClass, firstClass, secondClass, exclusiveSoftSleeper, softSleeper, highSpeedSleeper,
                hardSleeper, softSeat, hardSeat, noSeat, other, comment);
        table.setMaxWidth(1100);

        final VBox vbox = new VBox();
        vbox.setSpacing(5);
        vbox.setPadding(new Insets(10, 0, 0, 10));
        vbox.getChildren().addAll(hb, table);

        ((Group) scene.getRoot()).getChildren().addAll(vbox);

        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
