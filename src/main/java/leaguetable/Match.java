package leaguetable;

/**
 * Match class to store the result of a single game.
 */

public class Match {

    private String homeTeam;
    private String awayTeam;
    private int homeScore;
    private int awayScore;

    /**
     * Constructor to store result of the game.
     *
     * @param homeTeam  the home team.
     * @param awayTeam  the away team.
     * @param homeScore the home team's score.
     * @param awayScore the away team's score.
     */
    public Match(final String homeTeam, final String awayTeam, final int homeScore, final int awayScore) {
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.homeScore = homeScore;
        this.awayScore = awayScore;
    }

    public String getHomeTeam() {
        return homeTeam;
    }

    public String getAwayTeam() {
        return awayTeam;
    }

    public int getHomeScore() {
        return homeScore;
    }

    public int getAwayScore() {
        return awayScore;
    }

}
