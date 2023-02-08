package SuiteOfGames;

/**
 * Player is an enum class that holds four objects, each is a different player.
 *
 * @author Collin Turkelson
 * */
public enum Player {
    /**
     * Object that holds the place of the jack player.
     */
    Jack,

    /**
     * Object that holds the place of the black player.
     */
    Black,

    /**
     * Object that holds the place of the hook player.
     */
    Hook,

    /**
     * Object that holds the place of the will player.
     */
    Will;

    /**
     *  Changes the player to whoever is playing next.
     * @return the next player to play
     */
    public Player next() {
        if (this == Jack) {
            return Black;
        } else if (this == Black) {
            return Hook;
        } else if (this == Hook) {
            return Will;
        } else {
            return Jack;
        }
    }

}