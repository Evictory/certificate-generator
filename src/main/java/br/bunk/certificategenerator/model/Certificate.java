package br.bunk.certificategenerator.model;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.tool.xml.XMLWorkerHelper;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;

import javax.xml.parsers.ParserConfigurationException;
import java.io.*;

public class Certificate {
    private static final String HTML = "src/main/resources/templates/certificate.html";

    //remove, only tests proposes
    public static void main(String[] args) {
        try {
            transformHTMLPDF();
            generateCertificatePDF(HTML);
        } catch (IOException | ParserConfigurationException | DocumentException e) {
            e.printStackTrace();
        }
    }

    private static void transformHTMLPDF() throws IOException {
        File input = new File(HTML);
        org.jsoup.nodes.Document doc = Jsoup.parse(input, "UTF-8", HTML);
        Element div = doc.select("div#title").first();
        div.html("<p>Alterado</p>");

        FileWriter writer = new FileWriter(HTML);
        writer.write(doc.toString());
        writer.flush();
        writer.close();
    }

    private static void generateCertificatePDF(String filename) throws ParserConfigurationException, IOException, DocumentException {
        Document document = new Document();
        PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("src/PDF/certificate.pdf"));
        document.open();
        XMLWorkerHelper.getInstance().parseXHtml(writer, document, new FileInputStream(HTML));
        document.close();
    }

}
