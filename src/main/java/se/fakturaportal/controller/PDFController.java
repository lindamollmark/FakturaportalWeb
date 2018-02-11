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
import se.fakturaportal.core.model.InvoiceRow;

import javax.servlet.http.HttpSession;
import java.awt.*;
import java.io.*;

/**
 * Controller for building the PDF document of a Invoice
 */
@RestController
public class PDFController {

    // Create a document and add a page to it
    @RequestMapping(value="/views/printInvoice", method = RequestMethod.POST)
    public void printPDF(@RequestBody String invoice, HttpSession session) throws IOException, COSVisitorException {
        Invoice newInvoice = new Gson().fromJson(invoice, Invoice.class);
        PDDocument document = new PDDocument();
        PDPage page = new PDPage();

        document.addPage(page);

        // Create a new font object selecting one of the PDF base fonts
        PDFont font = PDType1Font.HELVETICA_BOLD;
        PDFont font2 = PDType1Font.HELVETICA;

        // Start a new content stream which will "hold" the to be created content
        PDPageContentStream contentStream = new PDPageContentStream(document, page);
        PDXObjectImage logga = new PDJpeg(document, new FileInputStream("C:\\Users\\Linda\\FakturaportalWeb\\src\\main\\webapp\\app\\images\\minilogga.jpg"));

        // logga
        contentStream.drawImage(logga, 50, 720);
        // Defines a text content stream using the selected font, moving the cursor and drawing the text
        createPaymentInfoBox(newInvoice, font2, contentStream);

        contentStream.beginText();
        contentStream.setFont( font2, 12 );
        contentStream.moveTextPositionByAmount( 420, 700 );
        contentStream.drawString(newInvoice.getClient().getCompanyName() );
        contentStream.endText();
        contentStream.beginText();
        contentStream.setFont( font2, 12 );
        contentStream.moveTextPositionByAmount( 420, 685 );
        contentStream.drawString(newInvoice.getClient().getContact());
        contentStream.endText();
        contentStream.beginText();
        contentStream.setFont( font2, 12 );
        contentStream.moveTextPositionByAmount( 420, 670 );
        contentStream.drawString(newInvoice.getClient().getInvoiceAddress().getAddress1());
        contentStream.endText();
        if(newInvoice.getClient().getInvoiceAddress().getAddress2() != null){
            contentStream.beginText();
            contentStream.setFont( font2, 12 );
            contentStream.moveTextPositionByAmount( 420, 655 );
            contentStream.drawString(newInvoice.getClient().getInvoiceAddress().getAddress2() );
            contentStream.endText();
        }

        contentStream.beginText();
        contentStream.setFont( font2, 12 );
        contentStream.moveTextPositionByAmount( 420, 640 );
        contentStream.drawString( newInvoice.getClient().getInvoiceAddress().getPostCode() + " " + newInvoice.getClient().getInvoiceAddress().getPostAddress() );
        contentStream.endText();

        //creates a table for the invoieRows
        int yTable = 460;
        createTableHeader(font, contentStream, yTable);
        tableRows(newInvoice, font2, contentStream, yTable);

        contentStream.setStrokingColor(Color.black);
        contentStream.drawLine(55,65,560,65);

        //Creates the footer
        contentStream.beginText();
        contentStream.setFont( font2, 8 );
        contentStream.moveTextPositionByAmount( 60, 50 );
        contentStream.drawString( newInvoice.getUser().getUserCompanyName() );
        contentStream.endText();
        contentStream.beginText();
        contentStream.setFont( font2, 8 );
        contentStream.moveTextPositionByAmount( 60, 40 );
        contentStream.drawString( newInvoice.getUser().getAddress1());
        contentStream.endText();
        contentStream.beginText();
        contentStream.setFont( font2, 8 );
        contentStream.moveTextPositionByAmount( 60, 30 );
        contentStream.drawString( newInvoice.getUser().getPostCode() + newInvoice.getUser().getPostAddress() );
        contentStream.endText();
        contentStream.beginText();
        contentStream.setFont( font2, 8 );
        contentStream.moveTextPositionByAmount( 180, 50 );
        contentStream.drawString( "Telefon: " + newInvoice.getUser().getPhoneNumber() );
        contentStream.endText();
        contentStream.beginText();
        contentStream.setFont( font2, 8 );
        contentStream.moveTextPositionByAmount( 180, 40 );
        contentStream.drawString( "Mobil: " + newInvoice.getUser().getPhoneNumber() );
        contentStream.endText();
        contentStream.beginText();
        contentStream.setFont( font2, 8 );
        contentStream.moveTextPositionByAmount( 180, 30 );
        contentStream.drawString( "E-post: " +newInvoice.getUser().getEmail() );
        contentStream.endText();
        contentStream.beginText();
        contentStream.setFont( font2, 8 );
        contentStream.moveTextPositionByAmount( 350, 50 );
        contentStream.drawString( "Orgnr: " + newInvoice.getUser().getOrgNumber() );
        contentStream.endText();
        contentStream.beginText();
        contentStream.setFont( font2, 8 );
        contentStream.moveTextPositionByAmount( 350, 40 );
        contentStream.drawString( "Bankgiro: " + newInvoice.getUser().getBankNumber() );
        contentStream.endText();

        // Make sure that the content stream is closed:
        contentStream.close();

        // Save the results and ensure that the document is properly closed:
        document.save("C:\\Users\\Linda\\FakturaportalWeb\\" + newInvoice.getInvoiceNo() + ".pdf");
        document.close();
    }

    /**
     * Help method for creating the informationbox on the invoice
     * @param newInvoice the invoice with it´s content
     * @param font2 the font to use on the text.
     * @param contentStream the stream for the text
     * @throws IOException if the streams fails.
     */
    private void createPaymentInfoBox(Invoice newInvoice, PDFont font2, PDPageContentStream contentStream) throws IOException {
        contentStream.drawLine(45,670,260,670);
        contentStream.drawLine(45,565,260,565);
        contentStream.drawLine(45,670,45,565);
        contentStream.drawLine(260,670,260,565);
        contentStream.beginText();
        contentStream.setFont( font2, 12 );
        contentStream.moveTextPositionByAmount( 50, 650 );
        contentStream.drawString( "Att betala: " + newInvoice.getInvoiceTotal() + " SEK" );
        contentStream.endText();
        contentStream.beginText();
        contentStream.setFont( font2, 12 );
        contentStream.moveTextPositionByAmount( 50, 635 );
        contentStream.drawString( "Förfallodatum: " + newInvoice.getDueDate() );
        contentStream.endText();
        contentStream.beginText();
        contentStream.setFont( font2, 12 );
        contentStream.moveTextPositionByAmount( 50, 620 );
        contentStream.drawString( "Bankgiro: " + newInvoice.getUser().getBankNumber());
        contentStream.endText();
        contentStream.beginText();
        contentStream.setFont( font2, 12 );
        contentStream.moveTextPositionByAmount( 50, 605 );
        contentStream.drawString( "Fakturanummer: " + newInvoice.getInvoiceNo() );
        contentStream.endText();
        contentStream.beginText();
        contentStream.setFont( font2, 12 );
        contentStream.moveTextPositionByAmount( 50, 590 );
        contentStream.drawString( "Ordernummer: " + newInvoice.getOrderNo() );
        contentStream.endText();
        contentStream.beginText();
        contentStream.setFont( font2, 12 );
        contentStream.moveTextPositionByAmount( 50, 575 );
        contentStream.drawString( "Kundnummer: " + newInvoice.getClient().getClientNo() );
        contentStream.endText();
    }

    /**
     * Help method for creating the table header
     * @param font the font style and size
     * @param contentStream the stream for the text
     * @param yTable the y position
     * @throws IOException thrown if the stream fails
     */
    private void createTableHeader(PDFont font, PDPageContentStream contentStream, int yTable) throws IOException {
        contentStream.drawLine(55,475,560,475);
        contentStream.beginText();
        contentStream.setFont( font, 12 );
        contentStream.moveTextPositionByAmount( 60, yTable );
        contentStream.drawString( "Artikelnr" );
        contentStream.endText();
        contentStream.beginText();
        contentStream.setFont( font, 12 );
        contentStream.moveTextPositionByAmount( 120, yTable );
        contentStream.drawString( "Antal" );
        contentStream.endText();
        contentStream.beginText();
        contentStream.setFont( font, 12 );
        contentStream.moveTextPositionByAmount( 220, yTable );
        contentStream.drawString( "Benämning" );
        contentStream.endText();
        contentStream.beginText();
        contentStream.setFont( font, 12 );
        contentStream.moveTextPositionByAmount( 340, yTable );
        contentStream.drawString("Pris/st" );
        contentStream.endText();
        contentStream.beginText();
        contentStream.setFont( font, 12 );
        contentStream.moveTextPositionByAmount( 440, yTable );
        contentStream.drawString( "Totalt" );
        contentStream.endText();
    }

    /**
     * Help method for setting the invoiceRows on the table
     * @param newInvoice the invoiceInformation
     * @param font2 the font style and size
     * @param contentStream the stream for the text
     * @param yTable the y position
     * @throws IOException thrown if the stream fails.
     */
    private void tableRows(Invoice newInvoice, PDFont font2, PDPageContentStream contentStream, int yTable) throws IOException {
        for(InvoiceRow row : newInvoice.getInvoiceRows()){
            yTable = yTable-15;
            contentStream.beginText();
            contentStream.setFont( font2, 12 );
            contentStream.moveTextPositionByAmount( 60, yTable );
            contentStream.drawString(row.getArticleNo() );
            contentStream.endText();
            contentStream.beginText();
            contentStream.setFont( font2, 12 );
            contentStream.moveTextPositionByAmount( 120, yTable );
            contentStream.drawString(Integer.toString(row.getQuantity()));
            contentStream.endText();
            contentStream.beginText();
            contentStream.setFont( font2, 12 );
            contentStream.moveTextPositionByAmount( 220, yTable );
            contentStream.drawString(row.getDescription() );
            contentStream.endText();
            contentStream.beginText();
            contentStream.setFont( font2, 12 );
            contentStream.moveTextPositionByAmount( 340, yTable );
            contentStream.drawString(Double.toString(row.getUnitPrice()));
            contentStream.endText();
            contentStream.beginText();
            contentStream.setFont( font2, 12 );
            contentStream.moveTextPositionByAmount( 440, yTable );
            contentStream.drawString(Double.toString(row.getRowTotal()) );
            contentStream.endText();
        }
    }


}
