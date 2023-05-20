package FilesManipulation;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import java.io.File;

@WebListener
public class FileLocationContextListener implements ServletContextListener, HttpSessionListener, HttpSessionAttributeListener {

    public FileLocationContextListener() {
    }

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        String rootPath = System.getProperty("catalina.home");
        ServletContext ctx = sce.getServletContext();
        String productRelativePath = ctx.getInitParameter("tempproduct.dir");
        String newsRelativePath = ctx.getInitParameter("tempnews.dir");
        String avatarRelativePath = ctx.getInitParameter("tempavatar.dir");
        File tempproduct = new File(rootPath + File.separator + "webapps" + File.separator + productRelativePath);
        File tempnews = new File(rootPath + File.separator + "webapps" + File.separator + newsRelativePath);
        File tempavatar = new File(rootPath + File.separator + "webapps" + File.separator + avatarRelativePath);
        if (!tempproduct.exists())
            tempproduct.mkdirs();
        if (!tempnews.exists())
            tempnews.mkdirs();
        if (!tempavatar.exists())
            tempavatar.mkdirs();
        ctx.setAttribute("FILES_DIR_TEMPPRODUCT", tempproduct);
        ctx.setAttribute("FILES_DIR_TEMPNEWS", tempnews);
        ctx.setAttribute("FILES_DIR_TEMPAVATAR", tempavatar);
        ctx.setAttribute("TEMPPRODUCT_DIR", rootPath + File.separator + "webapps" + File.separator + productRelativePath);
        ctx.setAttribute("TEMPNEWS_DIR", rootPath + File.separator + "webapps" + File.separator + newsRelativePath);
        ctx.setAttribute("TEMPAVATAR_DIR", rootPath + File.separator + "webapps" + File.separator + avatarRelativePath);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        /* This method is called when the servlet Context is undeployed or Application Server shuts down. */
    }

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        /* Session is created. */
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        /* Session is destroyed. */
    }

    @Override
    public void attributeAdded(HttpSessionBindingEvent sbe) {
        /* This method is called when an attribute is added to a session. */
    }

    @Override
    public void attributeRemoved(HttpSessionBindingEvent sbe) {
        /* This method is called when an attribute is removed from a session. */
    }

    @Override
    public void attributeReplaced(HttpSessionBindingEvent sbe) {
        /* This method is called when an attribute is replaced in a session. */
    }
}
