package com.example.rosterapp;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.List;

public class Roster {
    private static final List<String> patternList = Arrays.asList(
            "RD",
            "RD/NIGHT", "NIGHT", "NIGHT", "NIGHT", "NIGHT", "NIGHT", "NIGHT",
            "LD", "PDO", "RD", "RD", "RD", "RD",
            "DAY", "DAY", "DAY", "DAY",
            "ARVO", "ARVO", "ARVO",
            "RD", "RD",
            "ARVO", "ARVO",
            "DAY",
            "RD", "RD",
            "ARVO", "ARVO",
            "DAY", "DAY", "DAY", "DAY", "DAY");

    private static final LocalDate alphaStart = LocalDate.of(2024, 12, 2);
    private static final LocalDate bravoStart = LocalDate.of(2024, 12, 9);
    private static final LocalDate charlieStart = LocalDate.of(2024, 12, 16);
    private static final LocalDate deltaStart = LocalDate.of(2024, 12, 23);
    private static final LocalDate echoStart = LocalDate.of(2024, 11, 25);


    public static String whatRoster(LocalDate date, String squad) {
        switch (squad) {
            case "alpha":
                return whatRosterWithSquadStart(date, alphaStart);
            case "bravo":
                return whatRosterWithSquadStart(date, bravoStart);
            case "charlie":
                return whatRosterWithSquadStart(date, charlieStart);
            case "delta":
                return whatRosterWithSquadStart(date, deltaStart);
            case "echo":
                return whatRosterWithSquadStart(date, echoStart);
            default:
                return "Error: invalid squad name";
        }
    }

    private static String whatRosterWithSquadStart(LocalDate date, LocalDate squadStartDate) {
        if (date.isBefore(squadStartDate)) {
            return patternList.get(patternList.size() - (int) (Math.abs(ChronoUnit.DAYS.between(date, squadStartDate)) % patternList.size()));
        } else {
            return patternList.get((int) (Math.abs(ChronoUnit.DAYS.between(date, squadStartDate)) % patternList.size()));
        }
    }
}