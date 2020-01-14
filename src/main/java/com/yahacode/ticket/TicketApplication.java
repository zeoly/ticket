package com.yahacode.ticket;

import com.yahacode.ticket.view.LeftTicketView;
import de.felixroske.jfxsupport.AbstractJavaFxApplicationSupport;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author zengyongli 2020-01-14
 */
@SpringBootApplication
public class TicketApplication extends AbstractJavaFxApplicationSupport {

    public static void main(String[] args) {
        launch(TicketApplication.class, LeftTicketView.class, args);
    }
}
