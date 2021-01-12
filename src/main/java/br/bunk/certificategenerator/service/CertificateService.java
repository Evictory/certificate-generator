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
import java.util.Set;

public class CertificateService {
    private static final String HTML = "src/main/resources/templates/certificate.html";
    private com.itextpdf.text.Document finalDocument = new com.itextpdf.text.Document();


    private void transformHTML(Certificate certificate) throws IOException, DocumentException {
        File input = new File(HTML);
        Document doc = Jsoup.parse(input, "UTF-8", HTML);
        String newFile = HTML.replace("certificate", "certificate-" + certificate.getId());

        Course course = certificate.getCourse();
        Set<Person> people = course.getPeople();

        for (int i = 0; i < people.size(); i++){

            Element about = doc.select(".certificate_about").first();
            about.text("de participação");

            Element name = doc.select(".certified_name").first();
            name.text("EMERSON NOVO");

            FileWriter writer = new FileWriter(newFile);
            writer.write(doc.toString());
            writer.flush();
            writer.close();

            Certificate.generateCertificatePDF(finalDocument, newFile, true);

        }

        Certificate.generateCertificatePDF(finalDocument, newFile, false);
    }



}
