import java.util.Objects;

public class TennisGame2 implements TennisGame
{
    private int player1Point;
    private int player2Point;
    private String player1Response;
    private String player2Response;
    private final String player1Name;
    private final String player2Name;

    public TennisGame2(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
        this.player1Point = 0;
        this.player2Point=0;
        this.player1Response="";
        this.player2Response="";
    }

    public String getScore(){
        String score = "";

        score = setScorePlayer1(score);
        score = getResponseAndSetScorePlayer1(score);
        score = getResponseAndSetScorePlayer2(score);
        score = setScorePlayer1And2(score);
        score = setScorePlayer2And1(score);
        score = getAdvantageOrWinScore(score);

        return score;
    }

    private String setScorePlayer2And1(String score) {
        if (pointPlayer2MoreThanPlayer1AndLessThanFour())
        {
            String[] points = {"Love", "Fifteen", "Thirty", "Forty"};
            this.player2Response = points[this.player2Point];
            this.player1Response = points[this.player1Point];

            score = this.player1Response + "-" + this.player2Response;
        }
        return score;
    }

    private boolean pointPlayer2MoreThanPlayer1AndLessThanFour(){
        return (this.player2Point > this.player1Point && this.player2Point < 4);
    }

    private String setScorePlayer1And2(String score) {
        if (pointPlayer1MoreThanPlayer2AndLessThanFour())
        {
            String[] points = {"Love", "Fifteen", "Thirty", "Forty"};
            this.player1Response = points[this.player1Point];
            this.player2Response = points[this.player2Point];

            score = this.player1Response + "-" + this.player2Response;
        }
        return score;
    }
    private boolean pointPlayer1MoreThanPlayer2AndLessThanFour(){
        return (this.player1Point > this.player2Point && this.player1Point < 4);
    }

    private String getResponseAndSetScorePlayer2(String score) {
        if (this.player2Point > 0 && this.player1Point ==0)
        {
            String[] points = {"Love", "Fifteen", "Thirty", "Forty", "Deuce"};
            this.player2Response = points[this.player2Point];
            this.player1Response = points[this.player1Point];
            score = this.player1Response + "-" + this.player2Response;
        }
        return score;
    }

    private String getResponseAndSetScorePlayer1(String score) {

        if (this.player1Point > 0 && this.player2Point ==0)
        {
            String[] points = {"Love", "Fifteen", "Thirty", "Forty", "Deuce"};
            this.player1Response = points[this.player1Point];
            this.player2Response = points[this.player2Point];
            score = this.player1Response + "-" + this.player2Response;
        }
        return score;
    }






    private String setScorePlayer1(String score) {

        if (scorePlayersEqualsAndPlayer1LessThanFour()){

            String[] points = {"Love", "Fifteen", "Thirty", "Forty"};
            score += points[this.player1Point] + "-All";
        }

        if (scorePlayersEqualsAndPlayer1LessThanThree())
            score = "Deuce";

        return score;
    }

    private boolean scorePlayersEqualsAndPlayer1LessThanFour(){
        return (this.player1Point == this.player2Point && this.player1Point < 4);
    }

    private boolean scorePlayersEqualsAndPlayer1LessThanThree(){
        return (this.player1Point == this.player2Point && this.player1Point >=3);
    }





    private String getAdvantageOrWinScore(String score) {
        score = assignScoreAdvantageToplayer(score);
        score = getWinnerScore(score);
        return score;
    }

    private String getWinnerScore(String score) {
        if (player1Win())
        {
            score = "Win for " + this.player1Name;
        }
        if (player2Win())
        {
            score = "Win for " + this.player2Name;;
        }
        return score;
    }

    private boolean player1Win(){
        int substractPoint = this.player1Point - this.player2Point;
        return (isVerifiedPlayer1Point() && substractPoint >= 2);
    }

    private boolean isVerifiedPlayer1Point() {
        return this.player1Point >= 4 && this.player2Point >= 0;
    }

    private boolean player2Win(){
        int substractPoint = this.player2Point - this.player1Point;
        return (isVerifiedPlayer2Point() && substractPoint >= 2);
    }

    private boolean isVerifiedPlayer2Point() {
        return this.player2Point >=4 && this.player1Point >=0;
    }

    private String assignScoreAdvantageToplayer(String score) {
        if (player1GetAdvantage())
        {
            score = "Advantage " + this.player1Name;
        }

        if (player2GetAdvantage())
        {
            score = "Advantage " + this.player2Name;
        }
        return score;
    }

    private boolean player1GetAdvantage(){
        return (this.player1Point > this.player2Point && this.player2Point >= 3);
    }

    private boolean player2GetAdvantage(){
        return (this.player2Point > this.player1Point && this.player1Point >= 3);
    }

    public void setP1Score(int number){

        for (int i = 0; i < number; i++)
        {
            player1IncrementScore();
        }

    }

    public void setPlayer2Score(int number){

        for (int i = 0; i < number; i++)
        {
            player2IncrementScore();
        }

    }

    public void player1IncrementScore(){
        this.player1Point++;
    }

    public void player2IncrementScore(){
        this.player2Point++;
    }

    public void wonPoint(String player) {
        if (Objects.equals(player, this.player1Name))
            player1IncrementScore();
        else
            player2IncrementScore();
    }
}