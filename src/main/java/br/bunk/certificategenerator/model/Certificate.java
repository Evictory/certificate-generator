package br.bunk.certificategenerator.model;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.tool.xml.XMLWorkerHelper;
import java.io.*;

public class Certificate {

    private long id;
    private Course course;
    private Person person;
    private BackgroundImage backgroundImage;
    private String about;

    public Certificate(Course course, Person person) {
        this.course = course;
        this.person = person;
//        this.backgroundImage = backgroundImage;
        this.about = "de participação";
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

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public void setBackgroundImage(BackgroundImage backgroundImage) {
        this.backgroundImage = backgroundImage;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public BackgroundImage getBackgroundImage() {
        return backgroundImage;
    }

    public static void generateCertificatePDF(Document document, String filename, Boolean newPage) throws IOException, DocumentException {
        document.setPageSize(PageSize.A4.rotate());

        if(newPage){
            document.newPage();

            return;
        }

        PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("src/PDF/certificate"+filename.split("-")[1].replace(".html",".pdf")));
        document.open();
//        document.add(new Paragraph("Test Page 1"));
//        document.newPage();
//        document.add(new Paragraph("Test Page 2"));
        document.newPage();
        XMLWorkerHelper.getInstance().parseXHtml(writer, document, new FileInputStream(filename));
        document.close();

        return;
    }
}
