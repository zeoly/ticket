package com.yahacode.ticket;

import com.yahacode.ticket.fx.GridPaneFxApplication;
import com.yahacode.ticket.fx.TableFxApplication;
import com.yahacode.ticket.fx.TicketFxApplication;
import javafx.application.Application;
import org.springframework.boot.Banner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;

/**
 * @author zengyongli 2019-12-26
 */
public class DesktopApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(DesktopApplication.class);
        app.setBannerMode(Banner.Mode.OFF);
        app.run(args);
    }

    @Override
    public void run(String... args) throws Exception {
//        Application.launch(TicketFxApplication.class, args);
//        Application.launch(GridPaneFxApplication.class, args);
        Application.launch(TableFxApplication.class, args);
    }
}
