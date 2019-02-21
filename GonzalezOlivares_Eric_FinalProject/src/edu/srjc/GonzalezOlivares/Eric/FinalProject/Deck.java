package edu.srjc.GonzalezOlivares.Eric.FinalProject;

import javafx.scene.image.Image;

import java.util.ArrayList;

public class Deck extends ArrayList<Card>
{

    private Image aceSpades = new Image("/images/ace_of_spades.png");
    private Image twoSpades = new Image("/images/2_of_spades.png");
    private Image threeSpades = new Image("/images/3_of_spades.png");
    private Image fourSpades = new Image("/images/4_of_spades.png");
    private Image fiveSpades = new Image("/images/5_of_spades.png");
    private Image sixSpades = new Image("/images/6_of_spades.png");
    private Image sevenSpades = new Image("/images/7_of_spades.png");
    private Image eightSpades = new Image("/images/8_of_spades.png");
    private Image nineSpades = new Image("/images/9_of_spades.png");
    private Image tenSpades = new Image("/images/10_of_spades.png");
    private Image jackSpades = new Image("/images/jack_of_spades.png");
    private Image queenSpades = new Image("/images/queen_of_spades.png");
    private Image kingSpades = new Image("/images/king_of_spades.png");

    private Image aceHearts = new Image("/images/ace_of_hearts.png");
    private Image twoHearts = new Image("/images/2_of_hearts.png");
    private Image threeHearts = new Image("/images/3_of_hearts.png");
    private Image fourHearts = new Image("/images/4_of_hearts.png");
    private Image fiveHearts = new Image("/images/5_of_hearts.png");
    private Image sixHearts = new Image("/images/6_of_hearts.png");
    private Image sevenHearts = new Image("/images/7_of_hearts.png");
    private Image eightHearts = new Image("/images/8_of_hearts.png");
    private Image nineHearts = new Image("/images/9_of_hearts.png");
    private Image tenHearts = new Image("/images/10_of_hearts.png");
    private Image jackHearts = new Image("/images/jack_of_hearts.png");
    private Image queenHearts = new Image("/images/queen_of_hearts.png");
    private Image kingHearts = new Image("/images/king_of_hearts.png");

    private Image aceDiamonds = new Image("/images/ace_of_diamonds.png");
    private Image twoDiamonds = new Image("/images/2_of_diamonds.png");
    private Image threeDiamonds = new Image("/images/3_of_diamonds.png");
    private Image fourDiamonds = new Image("/images/4_of_diamonds.png");
    private Image fiveDiamonds = new Image("/images/5_of_diamonds.png");
    private Image sixDiamonds = new Image("/images/6_of_diamonds.png");
    private Image sevenDiamonds = new Image("/images/7_of_diamonds.png");
    private Image eightDiamonds = new Image("/images/8_of_diamonds.png");
    private Image nineDiamonds = new Image("/images/9_of_diamonds.png");
    private Image tenDiamonds = new Image("/images/10_of_diamonds.png");
    private Image jackDiamonds = new Image("/images/jack_of_diamonds.png");
    private Image queenDiamonds = new Image("/images/queen_of_diamonds.png");
    private Image kingDiamonds = new Image("/images/king_of_diamonds.png");

    private Image aceClubs = new Image("/images/ace_of_clubs.png");
    private Image twoClubs = new Image("/images/2_of_clubs.png");
    private Image threeClubs = new Image("/images/3_of_clubs.png");
    private Image fourClubs = new Image("/images/4_of_clubs.png");
    private Image fiveClubs = new Image("/images/5_of_clubs.png");
    private Image sixClubs = new Image("/images/6_of_clubs.png");
    private Image sevenClubs = new Image("/images/7_of_clubs.png");
    private Image eightClubs = new Image("/images/8_of_clubs.png");
    private Image nineClubs = new Image("/images/9_of_clubs.png");
    private Image tenClubs = new Image("/images/10_of_clubs.png");
    private Image jackClubs = new Image("/images/jack_of_clubs.png");
    private Image queenClubs = new Image("/images/queen_of_clubs.png");
    private Image kingClubs = new Image("/images/king_of_clubs.png");

    private Image[] imageList = new Image[]{twoSpades, threeSpades, fourSpades, fiveSpades, sixSpades, sevenSpades, eightSpades, nineSpades, tenSpades, jackSpades, queenSpades, kingSpades, aceSpades,
                twoHearts, threeHearts, fourHearts, fiveHearts, sixHearts, sevenHearts, eightHearts, nineHearts, tenHearts, jackHearts, queenHearts, kingHearts, aceHearts,
                twoDiamonds, threeDiamonds, fourDiamonds, fiveDiamonds, sixDiamonds, sevenDiamonds, eightDiamonds, nineDiamonds, tenDiamonds, jackDiamonds, queenDiamonds, kingDiamonds, aceDiamonds,
                twoClubs, threeClubs, fourClubs, fiveClubs, sixClubs, sevenClubs, eightClubs, nineClubs, tenClubs, jackClubs, queenClubs, kingClubs, aceClubs};

    public Deck()
    {
        super();

        int i = 0;
        int j = 2;
        for (Card.Suits suit : Card.Suits.values())
        {
            for (Card.Ranks rank : Card.Ranks.values())
            {
                this.add(new Card(rank, suit, imageList[i], j));
                i++;
                j++;
            }
            j = 2;
        }
    }

    public void splitDeck(ArrayList<Card> deck1, ArrayList<Card> deck2)
    {
        int i = 1;
        for(Card c : this)
        {
            if(i % 2 == 0)
            {
                deck1.add(c);
            }
            else
            {
                deck2.add(c);
            }
            i++;
        }
    }
}
