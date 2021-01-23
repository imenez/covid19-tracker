package com.imenez.covid16tracker.controller;


import com.imenez.covid16tracker.models.LocationStats;
import com.imenez.covid16tracker.services.CoronaVirusDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    CoronaVirusDataService coronaVirusDataService;



    @GetMapping("/")
    public String home(Model model) {
       /* private int totalReportedCases = 0;
        private int totalNewCases = 0;
        private int caseIndex = 0;
        model.addAttribute("locationStats", coronaVirusDataService.getAllStats());

        for (caseIndex = 0; caseIndex < coronaVirusDataService.getAllStats().size(); caseIndex++){
            totalReportedCases = coronaVirusDataService.getAllStats().get(caseIndex).getLatestTotalCases() + totalReportedCases;
            totalNewCases = coronaVirusDataService.getAllStats().get(caseIndex).getDiffFromPrevDay() + totalNewCases;
        }
        model.addAttribute("totalReportedCases", totalReportedCases);
        model.addAttribute("totalNewCases", totalNewCases);*/

        List<LocationStats> allStats = coronaVirusDataService.getAllStats();
        int totalReportedCases = allStats.stream().mapToInt(stat -> stat.getLatestTotalCases()).sum();
        int totalNewCases = allStats.stream().mapToInt(stat -> stat.getDiffFromPrevDay()).sum();
        model.addAttribute("locationStats", allStats);
        model.addAttribute("totalReportedCases", totalReportedCases);
        model.addAttribute("totalNewCases", totalNewCases);


        return "HOME";
    }
}
