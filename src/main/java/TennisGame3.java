
public class TennisGame3 implements TennisGame {

    private int player1Point;
    private int player2Point;
    private final String player1;
    private final String player2;

    public TennisGame3(String player1, String player2) {
        this.player1 = player1;
        this.player2 = player2;
        this.player1Point=0;
        this.player2Point=0;
    }

    public String getScore() {

        if (pointVerified()) {
            return getScoreMessage();
        }
        return getWinOrAdvantageMessage();
    }

    private boolean pointVerified() {
        int sumPoint = this.player1Point + this.player2Point;

        return sumPoint!=6 && pointLessThanFour();
    }

    private boolean pointLessThanFour(){
        return this.player1Point<4 && this.player2Point<4;
    }

    private String getWinOrAdvantageMessage() {
        if (this.player1Point == this.player2Point)
            return "Deuce";
        return winOrAdvantageMessage();
    }

    private String winOrAdvantageMessage() {
        String score;
        score = this.player1Point > this.player2Point ? this.player1 : this.player2;

        return getMessage(score);
    }

    private String getMessage(String score) {

        return pointOperationLessThanOne() ? "Advantage " + score : "Win for " + score;
    }

    private boolean pointOperationLessThanOne() {
        int pointOperation = (this.player1Point - this.player2Point);
        pointOperation = (int) Math.pow(pointOperation, 2);
        return pointOperation == 1;
    }


    private String getScoreMessage() {
        String score = "";

        if(this.player1Point<4){
            score = buildScoreMessage();
        }

        return score;
    }

    private String buildScoreMessage(){

        String[] points = {"Love", "Fifteen", "Thirty", "Forty"};

        if(this.player1Point == this.player2Point){
            return points[this.player2Point] + "-All";
        }
        return points[this.player1Point] + "-"+ points[this.player2Point];
    }

    public void wonPoint(String playerName) {
        if (playerName.equals(this.player1))
            this.player1Point += 1;
        else
            this.player2Point += 1;
    }

}
