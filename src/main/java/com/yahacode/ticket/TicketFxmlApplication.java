package com.yahacode.ticket;

import de.felixroske.jfxsupport.AbstractJavaFxApplicationSupport;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author zengyongli 2020-01-14
 */
@ComponentScan
public class TicketFxmlApplication extends AbstractJavaFxApplicationSupport {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("left_ticket.fxml"));
        Scene scene = new Scene(root);
        primaryStage.setTitle("Ticket Application Alpha");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

//    public static void main(String[] args) {
//        launchApp(TicketFxmlApplication.class, args);
//    }
}
