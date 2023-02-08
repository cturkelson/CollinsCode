package SuiteOfGames;

/**
 * This class is used to store the strings that pop up when an option from the
 * rules menu is selected.
 */
class NMMRules {
    NMMRules() {
    }

    /**
     * This method returns a string object that explains the basic goals and
     * rules of the game.
     * @return A string containing the goals and rules of the game.
     */
    String basicsOfTheGame() {

        return "Basics of Nine Men's Morris " + "\n" + "\n" + "Remove"
                + " your opponent's pieces by maneuvering three of your pieces"
                + " into a line (called a run). " + "\n" + "Runs can be "
                + "vertical or horizontal, but cannot be diagonal. " + "\n"
                + "When you have created a run, you may select one of your "
                + "opponent's pieces and remove it from the board. " + "\n"
                + "The selected piece must NOT be a part of a run. " + "\n"
                + "The player to remove all but two of their opponent's pieces"
                + " is the winner." + "\n" + "\n" + "***Important Note: There "
                + "is no way to regain or replace a removed piece. ***" + "\n";
    }

    /**
     * This method returns a string object that explains the first phase of the
     * game where the players are placing their pieces on the board. This
     * method is called by the Rules Menu and can be accessed at anytime when
     * the Nine Men's Morris program is running.
     * @return A string that explains the first phase of the game.
     */
    String beginningTheGame() {

        return "Beginning the Game " + "\n" + "\n" + "project1.Player 1 will "
                + "use the black pieces. " + "\n" + "project1.Player 2 will use"
                + " the white pieces." + "\n" + "project1.Player 1 goes first "
                + "\n" + "\n" + "Players alternate placing their pieces on "
                + "unoccupied spaces + (colored tan) on the board attempting"
                + " to create runs. " + "\n" + "Once both players have placed"
                + " nine pieces, the game transitions to the second phase. "
                + "\n" + "In the second phase of the game players take turns"
                + " sliding their pieces to an adjacent, unoccupied spot on"
                + " the board" + "\n" + "This phase continues until 1 player"
                + " has only three pieces remaining. " + "\n" + "That player"
                + " may now move their remaining pieces to any open spot on"
                + " the board. " + "\n" + "This continues until 1 player has"
                + " only two pieces left. " + "\n" + "Since they are no longer"
                + " able to create a run of three to remove their opponent's "
                + "piece, the game is over." + "\n";
    }

    /**
     * This method returns a string object that explains the second and third
     * phases of the game where players slide, and then move their pieces
     * around the board. This method is called by the Rules Menu and can be
     * accessed at anytime when the Nine Men's Morris program is running.
     * @return A string that explains the second and third phases of the game.
     */
    String slidingAndMoving() {
        return "Sliding and Moving " + "\n" + "\n" + "In the second "
                + "phase of the game players take turns sliding their pieces "
                + "to an open, adjacent, space on the board, attempting to "
                + "create a run of three. " + "\n" + "\n" + "This phase "
                + "continues until 1 player has only three pieces left.** "
                + "\n" + "\n" + "The player with only three pieces left can "
                + "now move their pieces to any open spot on the board. This "
                + "continues until 1 player is left with only 2 pieces. The "
                + "game is then over and the other player wins." + "\n" + "\n"
                + "**Note: If both players have only three pieces, both are"
                + " able to move their pieces to any open spot on the board.";
    }

    /**
     * This method returns a string object that offers the user some basic tips
     * and strategies. This method is called by the Rules Menu and can be
     * accessed at anytime when the Nine Men's Morris program is running.
     * @return A string that contains tips and strategies for the game.
     */
    String tipsAndTricks() {
        return "Tips and Strategy" + "\n" + "\n" + "Block your"
                + " opponent from creating a run whenever possible." + "\n"
                + "\n" + "When placing your pieces keep the sliding portion of"
                + " the game in mind. Don't box yourself in, set up your pieces"
                + " so you are able to move them around in the next phase."
                + "\n" + "\n" + "A run can be made in the same location over "
                + "and over again. One way to take advantage of this is to "
                + "move one piece out of the run, and then back in on your "
                + "next turn." + "\n" + "\n" + "Just watch your opponent's "
                + "pieces so they don't" +  "get a run and remove your piece"
                + " while it is outside the run" + "\n" + "\n" + "Try to set"
                + " up your pieces so you have partial runs next to each "
                + "other. This way you can complete them over and over by "
                + "sliding one piece between them.";
    }

}
