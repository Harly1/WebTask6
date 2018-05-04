package servlets;

import resourceService.ResourceService;
import resources.TestResource;
import sax.ReadXMLFileSAX;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class ResourceServlet extends HttpServlet {

    public static final String PAGE_URL = "/resources";

    private ResourceService resourceService;

    public ResourceServlet(ResourceService resourceService){

        this.resourceService =resourceService;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String path = req.getParameter("path");
//        TestResource resource = (TestResource) ReadXMLFileSAX.readXML("data\\resource.xml");
        TestResource resource = (TestResource) ReadXMLFileSAX.readXML(path);
        resourceService.setResource(resource);

        String name =  resource.getName();
        int    age  =  resource.getAge();


        resp.getWriter().println("name: "+name+" age: "+age+ " path: "+ path);
    }
}
