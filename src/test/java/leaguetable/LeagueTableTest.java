package leaguetable;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * JUnit test class for LeagueTable implementation.
 */

public class LeagueTableTest {

    /*
        Test constructor LeagueTableTest with an empty list of matches.
     */
    @Test
    void emptyLeagueTableTest() {
        List<Match> emptyMatchList = new ArrayList<>();
        LeagueTable emptyLeagueTable = new LeagueTable(emptyMatchList);
        assertEquals(0, emptyLeagueTable.getTableEntries().size());
    }


    /*
        Test for null pointer exception when creating with a null list of matches.
     */
    @Test
    void throwsNullPointerExceptionLeagueTableTest() {
        assertThrows(NullPointerException.class, ()-> {
            LeagueTable emptyLeagueTable = new LeagueTable(null);
        });
    }

    @Test
    void oneGameHomeWinTest() {
        List<Match> matchList = new ArrayList<>();
        Match matchOne = new Match("homeTeam","awayTeam", 3,0);
        matchList.add(matchOne);
        LeagueTable oneHomeWinTable = new LeagueTable(matchList);
        assertEquals(2, oneHomeWinTable.getTableEntries().size());

        LeagueTableEntry firstTeam = oneHomeWinTable.getTableEntries().get(0);
        LeagueTableEntry secondTeam = oneHomeWinTable.getTableEntries().get(1);

        assertEquals("homeTeam", firstTeam.getTeamName());
        assertEquals(1, firstTeam.getPlayed());
        assertEquals(1, firstTeam.getWon());
        assertEquals(0, firstTeam.getDrawn());
        assertEquals(0, firstTeam.getLost());
        assertEquals(3, firstTeam.getGoalsFor());
        assertEquals(0, firstTeam.getGoalsAgainst());
        assertEquals(3, firstTeam.getGoalDifference());
        assertEquals(3, firstTeam.getPoints());

        assertEquals("awayTeam", secondTeam.getTeamName());
        assertEquals(1, secondTeam.getPlayed());
        assertEquals(0, secondTeam.getWon());
        assertEquals(0, secondTeam.getDrawn());
        assertEquals(1, secondTeam.getLost());
        assertEquals(0, secondTeam.getGoalsFor());
        assertEquals(3, secondTeam.getGoalsAgainst());
        assertEquals(-3, secondTeam.getGoalDifference());
        assertEquals(0, secondTeam.getPoints());
    }

    @Test
    void oneGameAwayWinTest() {
        List<Match> matchList = new ArrayList<>();
        Match matchOne = new Match("homeTeam","awayTeam", 0,3);
        matchList.add(matchOne);
        LeagueTable oneHomeWinTable = new LeagueTable(matchList);
        assertEquals(2, oneHomeWinTable.getTableEntries().size());

        LeagueTableEntry firstTeam = oneHomeWinTable.getTableEntries().get(0);
        LeagueTableEntry secondTeam = oneHomeWinTable.getTableEntries().get(1);

        assertEquals("awayTeam", firstTeam.getTeamName());
        assertEquals(1, firstTeam.getPlayed());
        assertEquals(1, firstTeam.getWon());
        assertEquals(0, firstTeam.getDrawn());
        assertEquals(0, firstTeam.getLost());
        assertEquals(3, firstTeam.getGoalsFor());
        assertEquals(0, firstTeam.getGoalsAgainst());
        assertEquals(3, firstTeam.getGoalDifference());
        assertEquals(3, firstTeam.getPoints());

        assertEquals("homeTeam", secondTeam.getTeamName());
        assertEquals(1, secondTeam.getPlayed());
        assertEquals(0, secondTeam.getWon());
        assertEquals(0, secondTeam.getDrawn());
        assertEquals(1, secondTeam.getLost());
        assertEquals(0, secondTeam.getGoalsFor());
        assertEquals(3, secondTeam.getGoalsAgainst());
        assertEquals(-3, secondTeam.getGoalDifference());
        assertEquals(0, secondTeam.getPoints());
    }

    @Test
    void oneGameDrawTest() {
        List<Match> matchList = new ArrayList<>();
        Match matchOne = new Match("homeTeam","awayTeam", 1,1);
        matchList.add(matchOne);
        LeagueTable oneHomeWinTable = new LeagueTable(matchList);
        assertEquals(2, oneHomeWinTable.getTableEntries().size());

        LeagueTableEntry firstTeam = oneHomeWinTable.getTableEntries().get(0);
        LeagueTableEntry secondTeam = oneHomeWinTable.getTableEntries().get(1);

        assertEquals("awayTeam", firstTeam.getTeamName());
        assertEquals(1, firstTeam.getPlayed());
        assertEquals(0, firstTeam.getWon());
        assertEquals(1, firstTeam.getDrawn());
        assertEquals(0, firstTeam.getLost());
        assertEquals(1, firstTeam.getGoalsFor());
        assertEquals(1, firstTeam.getGoalsAgainst());
        assertEquals(0, firstTeam.getGoalDifference());
        assertEquals(1, firstTeam.getPoints());

        assertEquals("homeTeam", secondTeam.getTeamName());
        assertEquals(1, secondTeam.getPlayed());
        assertEquals(0, secondTeam.getWon());
        assertEquals(1, secondTeam.getDrawn());
        assertEquals(0, secondTeam.getLost());
        assertEquals(1, secondTeam.getGoalsFor());
        assertEquals(1, secondTeam.getGoalsAgainst());
        assertEquals(0, secondTeam.getGoalDifference());
        assertEquals(1, secondTeam.getPoints());
    }

    /*
        Simulate Group A of 2014 World Cup
     */
    @Test
    void sixMatchesTest() {
        List<Match> matchList = new ArrayList<>();
        Match matchOne = new Match("Brazil","Croatia", 3,1);
        Match matchTwo = new Match("Mexico","Cameroon", 1,0);
        Match matchThree = new Match("Brazil","Mexico", 0,0);
        Match matchFour = new Match("Cameroon","Croatia", 0,4);
        Match matchFive = new Match("Cameroon","Brazil", 1,4);
        Match matchSix = new Match("Croatia","Mexico", 1,3);
        matchList.add(matchOne);
        matchList.add(matchTwo);
        matchList.add(matchThree);
        matchList.add(matchFour);
        matchList.add(matchFive);
        matchList.add(matchSix);

        LeagueTable worldCupGroupA = new LeagueTable(matchList);
        assertEquals(4, worldCupGroupA.getTableEntries().size());

        LeagueTableEntry firstTeam = worldCupGroupA.getTableEntries().get(0);
        LeagueTableEntry secondTeam = worldCupGroupA.getTableEntries().get(1);
        LeagueTableEntry thirdTeam = worldCupGroupA.getTableEntries().get(2);
        LeagueTableEntry fourthTeam = worldCupGroupA.getTableEntries().get(3);

        assertEquals("Brazil", firstTeam.getTeamName());
        assertEquals(3, firstTeam.getPlayed());
        assertEquals(2, firstTeam.getWon());
        assertEquals(1, firstTeam.getDrawn());
        assertEquals(0, firstTeam.getLost());
        assertEquals(7, firstTeam.getGoalsFor());
        assertEquals(2, firstTeam.getGoalsAgainst());
        assertEquals(5, firstTeam.getGoalDifference());
        assertEquals(7, firstTeam.getPoints());

        assertEquals("Mexico", secondTeam.getTeamName());
        assertEquals(3, secondTeam.getPlayed());
        assertEquals(2, secondTeam.getWon());
        assertEquals(1, secondTeam.getDrawn());
        assertEquals(0, secondTeam.getLost());
        assertEquals(4, secondTeam.getGoalsFor());
        assertEquals(1, secondTeam.getGoalsAgainst());
        assertEquals(3, secondTeam.getGoalDifference());
        assertEquals(7, secondTeam.getPoints());

        assertEquals("Croatia", thirdTeam.getTeamName());
        assertEquals(3, thirdTeam.getPlayed());
        assertEquals(1, thirdTeam.getWon());
        assertEquals(0, thirdTeam.getDrawn());
        assertEquals(2, thirdTeam.getLost());
        assertEquals(6, thirdTeam.getGoalsFor());
        assertEquals(6, thirdTeam.getGoalsAgainst());
        assertEquals(0, thirdTeam.getGoalDifference());
        assertEquals(3, thirdTeam.getPoints());

        assertEquals("Cameroon", fourthTeam.getTeamName());
        assertEquals(3, fourthTeam.getPlayed());
        assertEquals(0, fourthTeam.getWon());
        assertEquals(0, fourthTeam.getDrawn());
        assertEquals(3, fourthTeam.getLost());
        assertEquals(1, fourthTeam.getGoalsFor());
        assertEquals(9, fourthTeam.getGoalsAgainst());
        assertEquals(-8, fourthTeam.getGoalDifference());
        assertEquals(0, fourthTeam.getPoints());

    }

}
