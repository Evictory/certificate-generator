package br.bunk.certificategenerator.controller;

import br.bunk.certificategenerator.model.Certificate;
import br.bunk.certificategenerator.model.Course;
import br.bunk.certificategenerator.model.Person;
import br.bunk.certificategenerator.model.PersonDocument;
import br.bunk.certificategenerator.service.CertificateService;
import com.itextpdf.text.DocumentException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MainTest {
    public static void main(String[] args) throws IOException, DocumentException {
        CertificateService service = new CertificateService();

        List<PersonDocument> listDocuments = new ArrayList<PersonDocument>();
        PersonDocument document = new PersonDocument("RG","11111");
        listDocuments.add(document);

        List<Person> people = new ArrayList<>();
        Person person = new Person("Vinicois Viado", listDocuments);
        people.add(person);
//        Person person2 = new Person("VitorioOsoOsoOso", listDocuments);
//        people.add(person2);

        Course course = new Course();
        course.setPeople(people);
        course.setDescription("Curso igual mas mt bom");
        course.setWorkload(22);

        for (Person p: course.getPeople()) {
            Certificate certificate = new Certificate(course, p);
            service.transformHTML(certificate);
        }
    }
}
