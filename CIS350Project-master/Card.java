package SuiteOfGames;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;

import javax.imageio.ImageIO;

/**
 * The Card class holds all the information for the cards in solitaire.
 * @author Christina Kidwell
 *
 */
public class Card {
    /**Static integer used to store the width of the card object.*/
    static int width = 100;
    /**Static integer used to store the width of the card object.*/
    static int height = 140;
    /**Integer that is used as a numerical representation of the Clubs suite.*/
    private static final int CLUB = 0;
    /**Integer used as a numerical representation of the Hearts suite.*/
    private static final int HEART = 1;
    /**Integer used as a numerical representation of the Spades suite.*/
    private static final int SPADE = 2;
    /**Integer used as a numerical representation of the Diamonds suite.*/
    private static final int DIAMOND = 3;
    /**Boolean used to identify if a card is a face card.*/
    private boolean face;
    /**Integer used to represent the value of a card.*/
    private int rank;
    /**Integer used to represent the suite of a card.*/
    private int suit;
    /**BufferedImage variable used to store the pictures for the cards.*/
    private BufferedImage image = null;

    /**
     * Card constructor used to create a new card object.
     * @param sv the suit of the new card object
     * @param rv numerical representation of the value of the new card object.
     * @throws URISyntaxException add description here.
     * @throws IOException add description here.
     */
    Card(final int sv, final int rv) throws IOException, URISyntaxException {
        suit = sv;
        rank = rv;
        face = false;
        if (suit == CLUB) {
            switch (rank) {
                case 0:
                    image =
                    ImageIO.read(new File(getClass().getResource(
                            "/resources/clubsA.png").toURI()));
                    break;
                case 1:
                    image =
                    ImageIO.read(new File(getClass().getResource(
                            "/resources/clubs2.png").toURI()));
                    break;
                case 2:
                    image =
                    ImageIO.read(new File(getClass().getResource(
                            "/resources/clubs3.png").toURI()));
                    break;
                case 3:
                    image =
                    ImageIO.read(new File(getClass().getResource(
                            "/resources/clubs4.png").toURI()));
                    break;
                case 4:
                    image =
                    ImageIO.read(new File(getClass().getResource(
                            "/resources/clubs5.png").toURI()));
                    break;
                case 5:
                    image =
                    ImageIO.read(new File(getClass().getResource(
                            "/resources/clubs6.png").toURI()));
                    break;
                case 6:
                    image =
                    ImageIO.read(new File(getClass().getResource(
                            "/resources/clubs7.png").toURI()));
                    break;
                case 7:
                    image =
                    ImageIO.read(new File(getClass().getResource(
                            "/resources/clubs8.png").toURI()));
                    break;
                case 8:
                    image =
                    ImageIO.read(new File(getClass().getResource(
                            "/resources/clubs9.png").toURI()));
                    break;
                case 9:
                    image =
                    ImageIO.read(new File(getClass().getResource(
                            "/resources/clubs10.png").toURI()));
                    break;
                case 10:
                    image =
                    ImageIO.read(new File(getClass().getResource(
                            "/resources/clubsJ.png").toURI()));
                    break;
                case 11:
                    image =
                    ImageIO.read(new File(getClass().getResource(
                            "/resources/clubsQ.png").toURI()));
                    break;
                case 12:
                    image =
                    ImageIO.read(new File(getClass().getResource(
                            "/resources/clubsK.png").toURI()));
                    break;
                default:
                    break;
            }
        } else if (suit == HEART) {
            switch (rank) {
                case 0:
                    image =
                    ImageIO.read(new File(getClass().getResource(
                            "/resources/heartsA.png").toURI()));
                    break;
                case 1:
                    image =
                    ImageIO.read(new File(getClass().getResource(
                            "/resources/hearts2.png").toURI()));
                    break;
                case 2:
                    image =
                    ImageIO.read(new File(getClass().getResource(
                            "/resources/hearts3.png").toURI()));
                    break;
                case 3:
                    image =
                    ImageIO.read(new File(getClass().getResource(
                            "/resources/hearts4.png").toURI()));
                    break;
                case 4:
                    image =
                    ImageIO.read(new File(getClass().getResource(
                            "/resources/hearts5.png").toURI()));
                    break;
                case 5:
                    image =
                    ImageIO.read(new File(getClass().getResource(
                            "/resources/hearts6.png").toURI()));
                    break;
                case 6:
                    image =
                    ImageIO.read(new File(getClass().getResource(
                            "/resources/hearts7.png").toURI()));
                    break;
                case 7:
                    image =
                    ImageIO.read(new File(getClass().getResource(
                            "/resources/hearts8.png").toURI()));
                    break;
                case 8:
                    image =
                    ImageIO.read(new File(getClass().getResource(
                            "/resources/hearts9.png").toURI()));
                    break;
                case 9:
                    image =
                    ImageIO.read(new File(getClass().getResource(
                            "/resources/hearts10.png").toURI()));
                    break;
                case 10:
                    image =
                    ImageIO.read(new File(getClass().getResource(
                            "/resources/heartsJ.png").toURI()));
                    break;
                case 11:
                    image =
                    ImageIO.read(new File(getClass().getResource(
                            "/resources/heartsQ.png").toURI()));
                    break;
                case 12:
                    image =
                    ImageIO.read(new File(getClass().getResource(
                            "/resources/heartsK.png").toURI()));
                    break;
                default:
                    break;
            }
        } else if (suit == SPADE) {
            switch (rank) {
                case 0:
                    image = ImageIO.read(new File(getClass().getResource(
                            "/resources/spadesA.png").toURI()));
                    break;
                case 1:
                    image = ImageIO.read(new File(getClass().getResource(
                            "/resources/spades2.png").toURI()));
                    break;
                case 2:
                    image = ImageIO.read(new File(getClass().getResource(
                            "/resources/spades3.png").toURI()));
                    break;
                case 3:
                    image = ImageIO.read(new File(getClass().getResource(
                            "/resources/spades4.png").toURI()));
                    break;
                case 4:
                    image = ImageIO.read(new File(getClass().getResource(
                            "/resources/spades5.png").toURI()));
                    break;
                case 5:
                    image = ImageIO.read(new File(getClass().getResource(
                            "/resources/spades6.png").toURI()));
                    break;
                case 6:
                    image = ImageIO.read(new File(getClass().getResource(
                            "/resources/spades7.png").toURI()));
                    break;
                case 7:
                    image = ImageIO.read(new File(getClass().getResource(
                            "/resources/spades8.png").toURI()));
                    break;
                case 8:
                    image = ImageIO.read(new File(getClass().getResource(
                            "/resources/spades9.png").toURI()));
                    break;
                case 9:
                    image = ImageIO.read(new File(getClass().getResource(
                            "/resources/spades10.png").toURI()));
                    break;
                case 10:
                    image = ImageIO.read(new File(getClass().getResource(
                            "/resources/spadesJ.png").toURI()));
                    break;
                case 11:
                    image = ImageIO.read(new File(getClass().getResource(
                            "/resources/spadesQ.png").toURI()));
                    break;
                case 12:
                    image = ImageIO.read(new File(getClass().getResource(
                            "/resources/spadesK.png").toURI()));
                    break;
                default:
                    break;
            }
        } else if (suit == DIAMOND) {
            switch (rank) {
                case 0:
                    image = ImageIO.read(new File(getClass().getResource(
                            "/resources/diamondsA.png").toURI()));
                    break;
                case 1:
                    image = ImageIO.read(new File(getClass().getResource(
                            "/resources/diamonds2.png").toURI()));
                    break;
                case 2:
                    image = ImageIO.read(new File(getClass().getResource(
                            "/resources/diamonds3.png").toURI()));
                    break;
                case 3:
                    image = ImageIO.read(new File(getClass().getResource(
                            "/resources/diamonds4.png").toURI()));
                    break;
                case 4:
                    image = ImageIO.read(new File(getClass().getResource(
                            "/resources/diamonds5.png").toURI()));
                    break;
                case 5:
                    image = ImageIO.read(new File(getClass().getResource(
                            "/resources/diamonds6.png").toURI()));
                    break;
                case 6:
                    image = ImageIO.read(new File(getClass().getResource(
                            "/resources/diamonds7.png").toURI()));
                    break;
                case 7:
                    image = ImageIO.read(new File(getClass().getResource(
                            "/resources/diamonds8.png").toURI()));
                    break;
                case 8:
                    image = ImageIO.read(new File(getClass().getResource(
                            "/resources/diamonds9.png").toURI()));
                    break;
                case 9:
                    image = ImageIO.read(new File(getClass().getResource(
                            "/resources/diamonds10.png").toURI()));
                    break;
                case 10:
                    image = ImageIO.read(new File(getClass().getResource(
                            "/resources/diamondsJ.png").toURI()));
                    break;
                case 11:
                    image = ImageIO.read(new File(getClass().getResource(
                            "/resources/diamondsQ.png").toURI()));
                    break;
                case 12:
                    image = ImageIO.read(new File(getClass().getResource(
                            "/resources/diamondsK.png").toURI()));
                    break;
            default:
                break;
            }
        }
    }

    /**
     * Access the numeric representation of the value of the card.
     * @return a numeric representation of the value of the card.
     */
    int getRank() {
        return rank;
    }

    /**
     * Access the numeric representation of the suite of the card.
     * @return a numeric representation of the suite of the card.
     */
    int getSuit() {
        return suit;
    }

    /**
     * Access if a card is face up or face down.
     * True means the card is face up.
     * @return a boolean that represents if a card is face up or face down.
     */
    boolean getFace() {
        return face;
    }

    /**
     * Access the image of the card.
     * @return the image on the card.
     */
    private BufferedImage getImage() {
        return image;
    }

    /**
     * Access the color (red or black) of the card.
     * @return the color of the card.
     */
    Color getColor() {
        if (getSuit() == HEART || getSuit() == DIAMOND) {
            return Color.red;
        }
        return Color.black;
    }

    /**
     * Flips the card from either face up to face down or vice versa.
     */
    void flip() {
        face = !face;
    }

    /**
     * Creates an image of the card to be used by the GUI.
     * @param g The design of the card.
     * @param x the width of the image of the card.
     * @param y the height of the image of the card.
     */
    void draw(final Graphics g, final int x, final int y) {
        g.clearRect(x, y, width, height);
        if (getFace()) {
            Image scaled = scaleImage(getImage(), width, height);
            g.drawImage(scaled, x, y, null);
        } else {
            Image scaled = scaleImage(Solitaire.backImage, width, height);
            g.drawImage(scaled, x, y, null);
        }
    }

    /**
     * Creates and returns an image of the card scaled to the specifications
     * input as parameters.
     * @param image the image on the card.
     * @param w the width of the returned image
     * @param h the height of the returned image.
     * @return the newly constructed image.
     */
    private Image scaleImage(final Image image, final int w, final int h) {
        return image.getScaledInstance(w, h, Image.SCALE_SMOOTH);
    }

}