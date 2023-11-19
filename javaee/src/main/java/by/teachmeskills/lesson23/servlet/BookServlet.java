package by.teachmeskills.lesson23.servlet;

import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@WebServlet("/book")
@MultipartConfig(fileSizeThreshold = 1024 * 1024, maxFileSize = 1024 * 1024 * 10)
public class BookServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String fileName = req.getParameter("file-name");
        // PrintWriter writer = resp.getWriter(); // resp.getOutputStream() некорректно работает вместе с resp.getWriter(). Почему?
        if (fileName == null || fileName.isEmpty()) {
            // writer.println("Parameter file name not found");
            return;
        }
        Path path = Path.of("/Users/kirilldikun/Desktop/javaee-c24-onl/src/main/resources", fileName);
        if (!Files.exists(path)) {
            // writer.println("File not found");
            return;
        }
        File file = path.toFile();
        String contentType = getServletContext().getMimeType(file.getName());
        if (contentType == null) {
            contentType = "application/octet-stream";
        }
        resp.setContentType(contentType);
        resp.setHeader("Content-Disposition", "attachment; filename=\"" + file.getName() + "\"");
        try (FileInputStream fileInputStream = new FileInputStream(file);
             ServletOutputStream servletOutputStream = resp.getOutputStream()) {
            byte[] buffer = new byte[1024];
            while (fileInputStream.read(buffer) != -1) {
                servletOutputStream.write(buffer);
            }
        }
    }
}
