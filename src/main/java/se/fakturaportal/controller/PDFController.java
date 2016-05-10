package se.fakturaportal.controller;

import com.google.gson.Gson;
import org.apache.pdfbox.exceptions.COSVisitorException;
import org.apache.pdfbox.pdmodel.*;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.edit.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.graphics.xobject.PDJpeg;
import org.apache.pdfbox.pdmodel.graphics.xobject.PDXObjectImage;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import se.fakturaportal.core.model.Invoice;

import java.io.*;

/**
 * Created by Linda on 2016-05-09.
 */
@RestController
public class PDFController {

    PDDocument document;
    PDPage page;

    // Create a document and add a page to it
    @RequestMapping(value="/views/printInvoice", method = RequestMethod.POST)
   public void printPDF(@RequestBody String invoice) throws IOException, COSVisitorException {
        Invoice newInvoice = new Gson().fromJson(invoice, Invoice.class);
    document = new PDDocument();
    page = new PDPage();

    document.addPage( page );

    // Create a new font object selecting one of the PDF base fonts
    PDFont font = PDType1Font.HELVETICA_BOLD;
        PDFont font2 = PDType1Font.HELVETICA;

    // Start a new content stream which will "hold" the to be created content
    PDPageContentStream contentStream = new PDPageContentStream(document, page);
        PDXObjectImage image = new PDJpeg(document, new FileInputStream("C:\\Users\\Linda\\FakturaportalWeb\\src\\main\\webapp\\app\\images\\minilogga.jpg"));


// Define a text content stream using the selected font, moving the cursor and drawing the text "Hello World"
//    contentStream.beginText();
//    contentStream.setFont( font, 12 );
//    contentStream.moveTextPositionByAmount( 20, 750 );
//    contentStream.drawString( "Logga" );
        contentStream.drawImage(image, 20, 750);
//        contentStream.endText();

        contentStream.beginText();
        contentStream.setFont( font2, 12 );
        contentStream.moveTextPositionByAmount( 20, 700 );
        contentStream.drawString( "Att betala: " + newInvoice.getInvoiceTotal() + " SEK" );
        contentStream.endText();
        contentStream.beginText();
        contentStream.setFont( font2, 12 );
        contentStream.moveTextPositionByAmount( 20, 690 );
        contentStream.drawString( "Förfallodatum: " + newInvoice.getDueDate() );
        contentStream.endText();
        contentStream.beginText();
        contentStream.setFont( font2, 12 );
        contentStream.moveTextPositionByAmount( 20, 680 );
        contentStream.drawString( "Bankgiro: 555-6664 " );
        contentStream.endText();
        contentStream.beginText();
        contentStream.setFont( font2, 12 );
        contentStream.moveTextPositionByAmount( 20, 670 );
        contentStream.drawString( "Fakturanummer: " + newInvoice.getInvoiceNo() );
        contentStream.endText();
        contentStream.beginText();
        contentStream.setFont( font2, 12 );
        contentStream.moveTextPositionByAmount( 20, 670 );
        contentStream.drawString( "Ordernummer: " + newInvoice.getOrderNo() );
        contentStream.endText();
        contentStream.beginText();
        contentStream.setFont( font2, 12 );
        contentStream.moveTextPositionByAmount( 20, 660 );
        contentStream.drawString( "Kundnummer: " + newInvoice.getClient().getClientNo() );
        contentStream.endText();

        contentStream.beginText();
        contentStream.setFont( font2, 12 );
        contentStream.moveTextPositionByAmount( 320, 700 );
        contentStream.drawString(newInvoice.getClient().getCompanyName() );
        contentStream.endText();
        contentStream.beginText();
        contentStream.setFont( font2, 12 );
        contentStream.moveTextPositionByAmount( 320, 690 );
        contentStream.drawString(newInvoice.getClient().getContact());
        contentStream.endText();
        contentStream.beginText();
        contentStream.setFont( font2, 12 );
        contentStream.moveTextPositionByAmount( 320, 680 );
        contentStream.drawString(newInvoice.getClient().getAddress1());
        contentStream.endText();
        if(newInvoice.getClient().getAddress2() != null){
            contentStream.beginText();
            contentStream.setFont( font2, 12 );
            contentStream.moveTextPositionByAmount( 320, 670 );
            contentStream.drawString(newInvoice.getClient().getAddress2() );
            contentStream.endText();
        }

        contentStream.beginText();
        contentStream.setFont( font2, 12 );
        contentStream.moveTextPositionByAmount( 320, 660 );
        contentStream.drawString( newInvoice.getClient().getPostCode() + " " + newInvoice.getClient().getPostAddress() );
        contentStream.endText();



// Make sure that the content stream is closed:
    contentStream.close();

// Save the results and ensure that the document is properly closed:
    document.save("C:\\Users\\Linda\\FakturaportalWeb\\" + newInvoice.getInvoiceNo() + ".pdf");
    document.close();
   }


}
