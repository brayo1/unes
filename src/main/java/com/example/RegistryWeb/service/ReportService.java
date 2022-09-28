package com.example.RegistryWeb.service;

import com.example.RegistryWeb.models.Person;
import com.example.RegistryWeb.repository.PersonRepository;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import net.sf.jasperreports.engine.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

@Service
public class ReportService {
    @Autowired
    private PersonRepository repository;

    public String exportReport(String reportFormat) throws FileNotFoundException, JRException {
        List<Person> personList = repository.findAll();
        File file = ResourceUtils.getFile("classpath:persons.jrxml");
        String path = "C:\\reports";

        JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(personList);
        Map<String, Object> params = new HashMap<>();
        params.put("created by:", "Brian Kariuki");
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, params, dataSource);

        if (reportFormat.equalsIgnoreCase("html")){
            JasperExportManager.exportReportToHtmlFile(jasperPrint, path+"\\persons.html");
        }
        if (reportFormat.equalsIgnoreCase("pdf")){
            JasperExportManager.exportReportToPdfFile(jasperPrint, path+"\\persons.pdf");
        }

        return "report generated in path: "+path;
    }
}
