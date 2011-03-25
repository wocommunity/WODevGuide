//
// FO2PDFSerializer.java
// Project ForumReports0B
//
// Created by ravi on Sun Mar 10 2002
//

import java.io.ByteArrayOutputStream;

import org.apache.log4j.Hierarchy;
import org.apache.log4j.Logger;
import org.w3c.dom.Document;

import com.webobjects.appserver.WOComponent;
import com.webobjects.appserver.WOContext;
import com.webobjects.appserver.WOResponse;
import com.webobjects.foundation.NSData;
import com.webobjects.foundation.NSLog;

public class FO2PDFSerializer extends WOComponent {
    
    /*
     * constructor
     */
    public FO2PDFSerializer(WOContext context) {
        super(context);
    }

    /*
     * request/response
     */
    public void appendToResponse(WOResponse response, WOContext context) {
        super.appendToResponse(response, context);

        // parse FO tree
        Document document = response.contentAsDOMDocument();
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        Logger log = Hierarchy.getDefaultHierarchy().getLoggerFor("fop");
        Driver driver = new Driver();

        driver.setRenderer(Driver.RENDER_PDF);
        driver.setOutputStream(out);
        driver.setLogger(log);

        // render to PDF
        try { driver.render(document); }
        catch (Exception exception) {
            NSLog.err.appendln("PDF: render: " + exception);
        }

        // set the PDF content and header
        response.setContent(new NSData(out.toByteArray()));
        response.setHeader("application/pdf", "Content-Type");
    }
}