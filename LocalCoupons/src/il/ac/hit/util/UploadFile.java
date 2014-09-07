package il.ac.hit.util;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;

/**A utility class that allows uploading a file to an FTP
 * server.
 * 
 *
 */
public class UploadFile {
	private static Logger log = LogManager.getRootLogger();

	
	public UploadFile()
	{
		BasicConfigurator.configure();
	}
	
	/**
	 * 
	 * @param HttpServletRequest request
	 * @return
	 * @throws ServletException
	 */
	public String upload(HttpServletRequest request) throws ServletException
	{
		log.info("UploadFile | uploading file:");
        FTPClient ftpClient = new FTPClient();
        InputStream is = null;
        String remoteFile = null, fileName = null;
        
        try {
        	
            ftpClient.connect("mahshev.herobo.com", 21);
            ftpClient.login("a2039291", "jrcta18101989");
            ftpClient.enterLocalPassiveMode();
            log.info("UploadFile | Connecting to FTP Server - OK!");
            ftpClient.setFileType(FTP.LOCAL_FILE_TYPE);
            //File firstLocalFile = new File(fileName);
 
            for(Part part : request.getParts()) {
            	String name = part.getName();
            	
            	if (name.equals("image"))
            	{
    	            is = request.getPart(name).getInputStream();
    	            fileName = part.getSubmittedFileName();
    	            remoteFile = "/public_html/agcoupons/" + fileName;
            	}
            }
            
            //InputStream inputStream = new FileInputStream(firstLocalFile);
 
            boolean done = ftpClient.storeFile(remoteFile, is);
            is.close();
            if (done) {
                log.info("UploadFile | File Uploaded Successfully!");
            }
        } catch (IOException ex) {
            System.out.println("Error: " + ex.getMessage());
            ex.printStackTrace();
        } finally {
            try {
                if (ftpClient.isConnected()) {
                    ftpClient.logout();
                    ftpClient.disconnect();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        
        return fileName;
    }
}

