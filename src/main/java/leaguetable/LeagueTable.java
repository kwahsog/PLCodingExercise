package leaguetable;

import java.util.*;

/**
 * LeagueTable class, generating a collection of LeagueTableEntrys from Match input data.
 * Can output sorted LeagueTableEntry by each team's rank in the table.
 */

public class LeagueTable {

    private HashMap<String, LeagueTableEntry> leagueTableMap;
    private enum Result {HOME_WIN, AWAY_WIN, DRAW};

    /**
     * LeagueTable constructor, processing all matches into an internal hashmap.
     * Assumption made that all matches are well formed.
     * @param matches list of matches to store.
     */
    public LeagueTable(final List<Match> matches) {
        leagueTableMap = new HashMap<>();
        for (Match match : matches) {
            this.processMatches(match);
        }
    }

    /**
     * Internal method to convert each match result into LeagueTableEntrys and update data as required.
     * @param match match to convert.
     */
    private void processMatches(Match match) {

        if (!leagueTableMap.containsKey(match.getHomeTeam())) {
            leagueTableMap.put(match.getHomeTeam(), new LeagueTableEntry(match.getHomeTeam(),0,0,0,0,0,0,0,0));
        }

        if (!leagueTableMap.containsKey(match.getAwayTeam())) {
            leagueTableMap.put(match.getAwayTeam(), new LeagueTableEntry(match.getAwayTeam(),0,0,0,0,0,0,0,0));
        }

        //calculate match result
        Result tempResult = Result.DRAW;
        if (match.getHomeScore() > match.getAwayScore()) {
            tempResult = Result.HOME_WIN;
        } else if (match.getHomeScore() < match.getAwayScore()) {
            tempResult = Result.AWAY_WIN;
        }

        //Update home and away team with result of the match
        LeagueTableEntry tempHomeTeam = leagueTableMap.get(match.getHomeTeam());
        LeagueTableEntry tempAwayTeam = leagueTableMap.get(match.getAwayTeam());

        tempHomeTeam.setPlayed((tempHomeTeam.getPlayed() + 1));
        tempHomeTeam.setGoalsFor(tempHomeTeam.getGoalsFor() + match.getHomeScore());
        tempHomeTeam.setGoalsAgainst(tempHomeTeam.getGoalsAgainst() + match.getAwayScore());
        tempHomeTeam.setGoalDifference(tempHomeTeam.getGoalsFor() - tempHomeTeam.getGoalsAgainst());

        tempAwayTeam.setPlayed((tempAwayTeam.getPlayed() + 1));
        tempAwayTeam.setGoalsFor(tempAwayTeam.getGoalsFor() + match.getAwayScore());
        tempAwayTeam.setGoalsAgainst(tempAwayTeam.getGoalsAgainst() + match.getHomeScore());
        tempAwayTeam.setGoalDifference(tempAwayTeam.getGoalsFor() - tempAwayTeam.getGoalsAgainst());

        //update points and W/D/L result
        if (tempResult == Result.HOME_WIN) {
            tempHomeTeam.setWon(tempHomeTeam.getWon() + 1);
            tempHomeTeam.setPoints(tempHomeTeam.getPoints() + 3);
            tempAwayTeam.setLost(tempAwayTeam.getLost() + 1);
        } else if (tempResult == Result.AWAY_WIN) {
            tempAwayTeam.setWon(tempAwayTeam.getWon() + 1);
            tempAwayTeam.setPoints(tempAwayTeam.getPoints() + 3);
            tempHomeTeam.setLost(tempHomeTeam.getLost() + 1);
        } else {
            tempHomeTeam.setDrawn(tempHomeTeam.getDrawn() + 1);
            tempHomeTeam.setPoints(tempHomeTeam.getPoints() + 1);

            tempAwayTeam.setDrawn(tempAwayTeam.getDrawn() + 1);
            tempAwayTeam.setPoints(tempAwayTeam.getPoints() + 1);
        }

    }

    /**
     * Get the ordered list of league table entries for this league table.
     * LeagueTableEntry objects are sorted by points, goal difference, goals for and then team names (a first).
     *
     * @return ArrayList of LeagueTableEntry for each team.
     */
    public List<LeagueTableEntry> getTableEntries() {
        List<LeagueTableEntry> result = new ArrayList<>();
        for (LeagueTableEntry value : leagueTableMap.values()) {
            result.add(value);
        }
        result.sort(Comparator.comparing(LeagueTableEntry::getPoints, Comparator.reverseOrder()).thenComparing(LeagueTableEntry::getGoalDifference,
                Comparator.reverseOrder()).thenComparing(LeagueTableEntry::getGoalsFor, Comparator.reverseOrder()).thenComparing(LeagueTableEntry::getTeamName));
        return result;
    }
}