package edu.miu.presentationService.controller;

import edu.miu.presentationService.domain.Coordinate;
import edu.miu.presentationService.domain.EarthQuake;
import edu.miu.presentationService.domain.User;
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

    @GetMapping("/csv")
    public void exportToCSV(HttpServletResponse response) throws IOException {
        response.setContentType("text/csv");
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
        String currentDateTime = dateFormatter.format(new Date());

        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=earthquakeReport_" + currentDateTime + ".csv";
        response.setHeader(headerKey, headerValue);


        ICsvBeanWriter csvWriter = new CsvBeanWriter(response.getWriter(), CsvPreference.STANDARD_PREFERENCE);
        String[] csvHeader = {"Time", "Magnitude", "State"};
        String[] nameMapping = {"time", "mg", "state"};

        csvWriter.writeHeader(csvHeader);

        Coordinate coordinate = new Coordinate( -148.085, 67.9423,1.1);
        EarthQuake earthQuake1 = new EarthQuake("ak0237teb8pn", 2.7, "CA", LocalDateTime.now(), coordinate);
        EarthQuake earthQuake2 = new EarthQuake("ak0237teb8pm", 3.7, "CA", LocalDateTime.now(), coordinate);
        EarthQuake earthQuake3 = new EarthQuake("ak0237teb8pc", 4.7, "Alaska", LocalDateTime.now(), coordinate);

        List<EarthQuake> list = new ArrayList<>(Arrays.asList(earthQuake1, earthQuake2, earthQuake3));

        for(EarthQuake item : list)
            csvWriter.write(item, nameMapping);

        csvWriter.close();

    }

}
