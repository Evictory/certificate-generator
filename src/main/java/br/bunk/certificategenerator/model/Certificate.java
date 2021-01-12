package br.bunk.certificategenerator.model;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.tool.xml.XMLWorkerHelper;
import java.io.*;

public class Certificate {

    private long id;
    private Course course;
    private BackgroundImage backgroundImage;

    public Certificate(Course course, BackgroundImage backgroundImage) {
        this.course = course;
        this.backgroundImage = backgroundImage;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public void setBackgroundImage(BackgroundImage backgroundImage) {
        this.backgroundImage = backgroundImage;
    }

    public BackgroundImage getBackgroundImage() {
        return backgroundImage;
    }

    //
//    //remove, only tests proposes
//    public static void main(String[] args) {
//        try {
//            transformHTMLPDF();
//            generateCertificatePDF(HTML);
//        } catch (IOException | ParserConfigurationException | DocumentException e) {
//            e.printStackTrace();
//        }
//    }

    public static void generateCertificatePDF(Document document, String filename, Boolean newPage) throws IOException, DocumentException {
        PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("src/PDF/certificate.pdf"));
        document.setPageSize(PageSize.A4.rotate());

        if(newPage){
            document.newPage();

            return;
        }

        document.open();
        XMLWorkerHelper.getInstance().parseXHtml(writer, document, new FileInputStream(filename));
        document.close();

        return;
    }
}
