package br.bunk.certificategenerator.service;

import br.bunk.certificategenerator.model.Certificate;
import br.bunk.certificategenerator.model.Course;
import br.bunk.certificategenerator.model.Person;
import com.itextpdf.text.DocumentException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

public class CertificateService {
    private static final String HTML = "src/main/resources/templates/certificate.html";
    private com.itextpdf.text.Document finalDocument = new com.itextpdf.text.Document();

    public void transformHTML(Certificate certificate) throws IOException, DocumentException {
        File input = new File(HTML);
        Document doc = Jsoup.parse(input, "UTF-8", HTML);
        String pathNewFile = HTML.replace("certificate", "certificate-" + certificate.getId());

        Course course = certificate.getCourse();
        List<Person> people = course.getPeople();

        Element about = doc.select(".certificate_about").first();
        about.text(certificate.getAbout());

        Element courseName = doc.select(".course").first();
        courseName.text(course.getDescription());

        for (Iterator<Person> it = people.iterator(); it.hasNext(); ) {
            Person person = it.next();

            Element name = doc.select(".certified_name").first();
            name.text(person.getName());

            FileWriter writer = new FileWriter(pathNewFile);
            writer.write(doc.toString());
            writer.flush();
            writer.close();

            certificate.generateCertificatePDF(finalDocument, pathNewFile, true);

        }

        certificate.generateCertificatePDF(finalDocument, pathNewFile, false);
    }



}
