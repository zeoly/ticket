package com.yahacode.ticket.fx;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * @author zengyongli 2019-12-26
 */
public class TicketFxApplication extends Application {

    private final TableView table = new TableView();

    @Override
    public void start(Stage primaryStage) throws Exception {
        TableColumn trainNoCol = new TableColumn("车次");
        TableColumn startStationCol = new TableColumn("始发站");
        TableColumn destStationCol = new TableColumn("到达站");
        TableColumn startDate = new TableColumn("始发时间");
        TableColumn destDate = new TableColumn("到达时间");
        table.getColumns().addAll(trainNoCol, startStationCol, destStationCol, startDate, destDate);


    }
}
