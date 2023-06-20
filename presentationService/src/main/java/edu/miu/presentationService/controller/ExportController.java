package edu.miu.presentationService.controller;

import edu.miu.presentationService.domain.EarthQuake;
import edu.miu.presentationService.repository.EarthQuakeRepository;
import edu.miu.presentationService.service.ExportService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.supercsv.io.CsvBeanWriter;
import org.supercsv.io.ICsvBeanWriter;
import org.supercsv.prefs.CsvPreference;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/export")
public class ExportController {

    @Autowired
    private ExportService exportService;

    @Autowired
    private EarthQuakeRepository earthQuakeRepository;

    @GetMapping("/csv")
    public void exportToCSV(HttpServletResponse response) throws IOException {
        response.setContentType("text/csv");
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
        String currentDateTime = dateFormatter.format(new Date());

        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=earthquakeReport_" + currentDateTime + ".csv";
        response.setHeader(headerKey, headerValue);



        ICsvBeanWriter csvWriter = new CsvBeanWriter(response.getWriter(), CsvPreference.STANDARD_PREFERENCE);
        String[] csvHeader = {"Time", "Magnitude", "Place"};
        String[] nameMapping = {"time", "magnitude", "place"};

        csvWriter.writeHeader(csvHeader);

        List<EarthQuake> list =  earthQuakeRepository.findAll();
        for(EarthQuake item : list)
            csvWriter.write(item, nameMapping);

        csvWriter.close();

    }



}
