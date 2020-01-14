package com.yahacode.ticket;

import com.yahacode.ticket.model.Detail;
import com.yahacode.ticket.service.QueryService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DateCell;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Dialog;
import javafx.scene.control.DialogPane;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Callback;
import javafx.util.StringConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.util.JdkIdGenerator;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 * @author zengyongli 2019-12-26
 */
@SpringBootApplication
public class TicketFxApplication {

    private final TableView table = new TableView();

    private final ObservableList<Detail> data = FXCollections.observableArrayList();

    @Autowired
    private QueryService queryService;

    public void start(Stage primaryStage) throws Exception {
        Scene scene = new Scene(new Group());
        primaryStage.setTitle("Ticket Application Alpha");
        primaryStage.setWidth(1250);
        primaryStage.setHeight(550);

        final Button loginBtn = new Button("登录");
        loginBtn.setOnAction(event -> {
            Dialog<String> dialog = new Dialog();
            dialog.setTitle("车次详情");
            dialog.setContentText("I have a great message for you!");
            dialog.showAndWait();
        });
        final Label startStationLabel = new Label("始发站");
        final TextField startStationText = new TextField();
        startStationText.setText("CQW");
        final Button exchangeBtn = new Button("<>");
        final Label destStationLabel = new Label("到达站");
        final TextField destStationText = new TextField();
        destStationText.setText("SZQ");
        final Label startDateLabel = new Label("出发日期");
        exchangeBtn.setOnAction(event -> {
            String tmp = startStationText.getText();
            startStationText.setText(destStationText.getText());
            destStationText.setText(tmp);
        });
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
        final Button queryButton = new Button("查询");
        queryButton.setOnAction(event -> {
            List<Detail> list = queryService.queryDetail(startStationText.getText(), destStationText.getText(),
                    startDatePicker.getEditor().getText());
            data.clear();
            data.addAll(list);
        });

        final HBox hb = new HBox();
        hb.setSpacing(3);
        hb.getChildren().addAll(loginBtn, startStationLabel, startStationText, exchangeBtn, destStationLabel,
                destStationText, startDateLabel, startDatePicker, queryButton);

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
        businessClassCol.setMaxWidth(60);
        TableColumn firstClassCol = new TableColumn("一等座");
        firstClassCol.setCellValueFactory(new PropertyValueFactory<>("firstClass"));
        firstClassCol.setMaxWidth(60);
        TableColumn secondClassCol = new TableColumn("二等座");
        secondClassCol.setCellValueFactory(new PropertyValueFactory<>("secondClass"));
        secondClassCol.setMaxWidth(60);
        TableColumn exclusiveSoftSleeperCol = new TableColumn("高级软卧");
        exclusiveSoftSleeperCol.setCellValueFactory(new PropertyValueFactory<>("exclusiveSoftSleeper"));
        exclusiveSoftSleeperCol.setMaxWidth(60);
        TableColumn softSleeperCol = new TableColumn("软卧");
        softSleeperCol.setCellValueFactory(new PropertyValueFactory<>("softSleeper"));
        softSleeperCol.setMaxWidth(60);
        TableColumn highSpeedSleeperCol = new TableColumn("动卧");
        highSpeedSleeperCol.setCellValueFactory(new PropertyValueFactory<>("highSpeedSleeper"));
        highSpeedSleeperCol.setMaxWidth(60);
        TableColumn hardSleeperCol = new TableColumn("硬卧");
        hardSleeperCol.setCellValueFactory(new PropertyValueFactory<>("hardSleeper"));
        hardSleeperCol.setMaxWidth(60);
        TableColumn softSeatCol = new TableColumn("软座");
        softSeatCol.setCellValueFactory(new PropertyValueFactory<>("softSeat"));
        softSeatCol.setMaxWidth(60);
        TableColumn hardSeatCol = new TableColumn("硬座");
        hardSeatCol.setCellValueFactory(new PropertyValueFactory<>("hardSeat"));
        hardSeatCol.setMaxWidth(50);
        TableColumn noSeatCol = new TableColumn("无座");
        noSeatCol.setCellValueFactory(new PropertyValueFactory<>("noSeat"));
        noSeatCol.setMaxWidth(60);
        TableColumn otherCol = new TableColumn("其他");
        otherCol.setCellValueFactory(new PropertyValueFactory<>("other"));
        otherCol.setMaxWidth(60);
        TableColumn commentCol = new TableColumn("备注");
        commentCol.setMaxWidth(60);

        table.setItems(data);
        table.getColumns().addAll(trainNoCol, startStationCol, destStationCol, startDateCol, destDateCol, durationCol
                , businessClassCol, firstClassCol, secondClassCol, exclusiveSoftSleeperCol, softSleeperCol,
                highSpeedSleeperCol, hardSleeperCol, softSeatCol, hardSeatCol, noSeatCol, otherCol, commentCol);
        table.setMaxWidth(1200);

        final VBox vbox = new VBox();
        vbox.setSpacing(5);
        vbox.setPadding(new Insets(10, 0, 0, 10));
        vbox.getChildren().addAll(hb, table);

        ((Group) scene.getRoot()).getChildren().addAll(vbox);

        primaryStage.setScene(scene);
        primaryStage.show();
    }

}
