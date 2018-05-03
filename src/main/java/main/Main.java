package main;

import accountServer.AccountServer;
import accountServer.AccountServerController;
import accountServer.AccountServerControllerMBean;
import accountServer.AccountServerI;

import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.HandlerList;
import org.eclipse.jetty.server.handler.ResourceHandler;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

import servlets.ResourceServlet;

import javax.management.MBeanServer;
import javax.management.ObjectName;
import java.lang.management.ManagementFactory;
import java.util.logging.Logger;

public class Main {
    public static void main(String[] args) throws Exception {

        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        context.addServlet(new ServletHolder(new ResourceServlet()),ResourceServlet.PAGE_URL);

        AccountServerI accountServer = new AccountServer(1);

        AccountServerControllerMBean serverStatistics = new AccountServerController(accountServer);
        MBeanServer mbs = ManagementFactory.getPlatformMBeanServer();
        ObjectName name = new ObjectName("Admin:type=ResourceServerController");
        mbs.registerMBean(serverStatistics,name );


        ResourceHandler resource_handler = new ResourceHandler();
        resource_handler.setResourceBase("publicPage/index.html");

        HandlerList handlers = new HandlerList();
        handlers.setHandlers(new Handler[]{resource_handler, context});

        Server server = new Server(8080);
        server.setHandler(handlers);
        server.start();
        Logger.getGlobal().info("Server started");
        server.join();
    }

}
