package FilesManipulation;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

@WebServlet(name = "UpDownImageProductController", value = "/UpDownImageProductController")
public class UpDownImageProductController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private ServletFileUpload uploader = null;

    public void init() throws ServletException {
        DiskFileItemFactory fileFactory = new DiskFileItemFactory();
        File filesDir = (File) getServletContext().getAttribute("FILES_DIR_TEMPPRODUCT");
        fileFactory.setRepository(filesDir);
        this.uploader = new ServletFileUpload(fileFactory);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String fileName = request.getParameter("fileName");
        if (fileName == null || fileName.equals(""))
            throw new ServletException("File name can't be null or empty");
        File file = new File(request.getServletContext().getAttribute("TEMPPRODUCT_DIR") + File.separator + fileName);
        if (!file.exists()) {
            throw new ServletException("File doesn't exist");
        }
        response.sendRedirect(request.getServletContext().getAttribute("TEMPPRODUCT_DIR") + File.separator + fileName);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (!ServletFileUpload.isMultipartContent(request)) {
            throw new ServletException("content type is not multipart");
        }
        try {
            List<FileItem> fileItemList = uploader.parseRequest(request);
            Iterator<FileItem> fileItemIterable = fileItemList.iterator();
            while (fileItemIterable.hasNext()) {
                FileItem fileItem = fileItemIterable.next();
                File file = new File(request.getServletContext().getAttribute("TEMPPRODUCT_DIR") + File.separator + fileItem.getName());
                if (!file.exists())
                    fileItem.write(file);
            }
        } catch (FileUploadException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
