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

        if (this.player1Point == this.player2Point && this.player1Point < 4)
        {
            if (this.player1Point ==0)
                score = "Love";
            if (this.player1Point ==1)
                score = "Fifteen";
            if (this.player1Point ==2)
                score = "Thirty";
            score += "-All";
        }
        if (this.player1Point == this.player2Point && this.player1Point >=3)
            score = "Deuce";



        
        if (this.player1Point > 0 && this.player2Point ==0)
        {
            if (this.player1Point ==1)
                this.player1Response = "Fifteen";
            if (this.player1Point ==2)
                this.player1Response = "Thirty";
            if (this.player1Point ==3)
                this.player1Response = "Forty";

            this.player2Response = "Love";
            score = this.player1Response + "-" + this.player2Response;
        }



        if (this.player2Point > 0 && this.player1Point ==0)
        {
            if (this.player2Point ==1)
                this.player2Response = "Fifteen";
            if (this.player2Point ==2)
                this.player2Response = "Thirty";
            if (this.player2Point ==3)
                this.player2Response = "Forty";

            this.player1Response = "Love";
            score = this.player1Response + "-" + this.player2Response;
        }



        
        if (this.player1Point > this.player2Point && this.player1Point < 4)
        {
            if (this.player1Point ==2)
                this.player1Response ="Thirty";
            if (this.player1Point ==3)
                this.player1Response ="Forty";
            if (this.player2Point ==1)
                this.player2Response ="Fifteen";
            if (this.player2Point ==2)
                this.player2Response ="Thirty";
            score = this.player1Response + "-" + this.player2Response;
        }



        if (this.player2Point > this.player1Point && this.player2Point < 4)
        {
            if (this.player2Point ==2)
                this.player2Response ="Thirty";
            if (this.player2Point ==3)
                this.player2Response ="Forty";
            if (this.player1Point ==1)
                this.player1Response ="Fifteen";
            if (this.player1Point ==2)
                this.player1Response ="Thirty";
            score = this.player1Response + "-" + this.player2Response;
        }


        score = getAdvantageOrWinScore(score);
        return score;
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