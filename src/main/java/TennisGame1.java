import java.util.Objects;

public class TennisGame1 implements TennisGame {
    
    private int mScore1;
    private int mScore2;
    private final String player1Name;
    private final String player2Name;

    public TennisGame1(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
        this.mScore1=0;
        this.mScore2=0;
    }

    public void wonPoint(String playerName) {

        if (Objects.equals(playerName, this.player1Name))
            mScore1 += 1;

        if (Objects.equals(playerName, this.player2Name))
            mScore2 += 1;
    }

    public String getScore() {

        if (isEqualScore())
        {
            return buildEqualScore();
        }
        else {
            return scoreNotEquals();
        }

    }

    private boolean isEqualScore(){
        return this.mScore1 == this.mScore2;
    }

    private String scoreNotEquals(){
        return scoreMayorEqualsThanFours() ? findWinnerOrAdvantage() : noWinnerNoAdvantager();
    }

    private boolean scoreMayorEqualsThanFours(){
        return (this.mScore1 >=4 || this.mScore2 >=4);
    }


    private String buildEqualScore() {

        String[] listaDeRetornos = {"Love-All", "Fifteen-All", "Thirty-All", "Deuce"};

        if(this.mScore1<=3){
            return listaDeRetornos[this.mScore1];
        }

        return listaDeRetornos[3];
    }

    private String findWinnerOrAdvantage() {

        int scoreDifference = mScore1 - mScore2;

        switch (scoreDifference){
            case 1: case -1:
                return buildAdvantagerMessage(scoreDifference);
            default:
                return buildWinnerMessage(scoreDifference);
        }
    }

    private String buildWinnerMessage(int scoreDifference){

        String message = "Win for ";

        if (scoreDifference>=2) message += this.player1Name;
        else message += this.player2Name;

        return message;
    }

    private String buildAdvantagerMessage(int scoreDifference){

        String message = "Advantage ";

        if (scoreDifference==1) message += this.player1Name;
        if (scoreDifference ==-1) message += this.player2Name;

        return message;
    }

    private String noWinnerNoAdvantager() {

        StringBuilder score= new StringBuilder();

        for (int i=1; i<3; i++)
        {
            buildScore(score, i);
        }

        return score.toString();
    }

    private void buildScore(StringBuilder score, int i) {

        int tempScore;

        if (i ==1) tempScore = mScore1;
        else { score.append("-"); tempScore = mScore2;}

        score.append(getTempScore(tempScore));
    }

    private String getTempScore(int tempScore) {

        String[] listaDeRetornos = {"Love", "Fifteen", "Thirty", "Forty"};
        return listaDeRetornos[tempScore];
    }
}
