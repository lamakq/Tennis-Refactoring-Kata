package domain;

import static utills.AppConstant.ALL;
import static utills.AppConstant.DEUCE;
import static utills.AppConstant.FIFTEEN;
import static utills.AppConstant.FORTY;
import static utills.AppConstant.LOVE;
import static utills.AppConstant.THIRTY;

public class Score {

    private int score;

    public Score(){
        this.score= 0;
    }

    public String handleScoreEqualCase() {
        switch (score) {
            case 0:
                return LOVE + "-" + ALL;
            case 1:
                return FIFTEEN + "-" + ALL;
            case 2:
                return THIRTY + "-" + ALL;
            default:
                return DEUCE;
        }
    }

    public String getScoreDisplayName() {
        switch (score) {
            case 0:
                return LOVE;
            case 1:
                return FIFTEEN;
            case 2:
                return THIRTY;
            case 3:
                return FORTY;
            default:
                return "";
        }
    }

    public void addScore() {
        score++;
    }

    public int getScore() {
        return score;
    }
}
