package ohtu;

public class TennisGame {
    
    private Player player1;
    private Player player2;
    private String score;
    private int currentScore;

    public TennisGame(String player1Name, String player2Name) {
        this.player1 = new Player(player1Name);
        this.player2 = new Player(player2Name);
    }

    public void wonPoint(String playerName) {
        if (player1.getName() == playerName) {
            player1.scorePoint();
        } else {
            player2.scorePoint();
        }
    }

    public String getScore() {
        score = "";
        currentScore = 0;

        if (player1.getPoints() == player2.getPoints()) {
            equalPoints(player1);
        } else if (player1.getPoints() >= 4 || player2.getPoints() >= 4) {
            gameOutcome(player1, player2);
        } else {
            currentScore(player1, player2);
        }
        
        return score;
    }

    private void equalPoints(Player player1) {
        switch (player1.getPoints()) {
            case 0:
                score = "Love-All";
                break;
            case 1:
                score = "Fifteen-All";
                break;
            case 2:
                score = "Thirty-All";
                break;
            case 3:
                score = "Forty-All";
                break;
            default:
                score = "Deuce";
                break;
        }
    }

    private void gameOutcome(Player player1, Player player2) {
        int minusResult = player1.getPoints() - player2.getPoints();

        if (minusResult == 1) {
            score = "Advantage " + player1.getName();
        } else if (minusResult == -1) {
            score = "Advantage " + player2.getName();
        } else if (minusResult >= 2) {
            score = "Win for " + player1.getName();
        } else {
            score = "Win for " + player2.getName();
        }
    }

    private void currentScore(Player player1, Player player2) {
        for (int i = 1; i < 3; i++) {
            if (i == 1) {
                currentScore = player1.getPoints();
            } else { 
                score += "-"; 
                currentScore = player2.getPoints();
            }
            
            switch(currentScore) {
                case 0:
                    score += "Love";
                    break;
                case 1:
                    score += "Fifteen";
                    break;
                case 2:
                    score += "Thirty";
                    break;
                case 3:
                    score += "Forty";
                    break;
            }
        }
    }
}