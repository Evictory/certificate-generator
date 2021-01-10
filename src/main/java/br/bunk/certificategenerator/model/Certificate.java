package br.bunk.certificategenerator.model;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.tool.xml.XMLWorkerHelper;

import javax.xml.parsers.ParserConfigurationException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Certificate {
    private static final String HTML = "src/main/resources/templates/certificate.html";

    //remove, only tests proposes
    public static void main(String[] args) {
        try {
            generateCertificatePDF(HTML);
        } catch (IOException | ParserConfigurationException | DocumentException e) {
            e.printStackTrace();
        }
    }

    private static void generateCertificatePDF(String filename) throws ParserConfigurationException, IOException, DocumentException {
        Document document = new Document();
        PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("src/PDF/certificate.pdf"));
        document.open();
        XMLWorkerHelper.getInstance().parseXHtml(writer, document, new FileInputStream(HTML));
        document.close();
    }

}
