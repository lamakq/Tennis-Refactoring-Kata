package domain;

import static utills.AppConstant.ALL;
import static utills.AppConstant.DEUCE;
import static utills.AppConstant.FIFTEEN;
import static utills.AppConstant.FORTY;
import static utills.AppConstant.LOVE;
import static utills.AppConstant.THIRTY;

public class Score {

    public String handleScoreEqualCase(Player player) {
        switch (player.getScore()) {
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

    public String getScoreDisplayName(Player player) {
        switch (player.getScore()) {
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
}
