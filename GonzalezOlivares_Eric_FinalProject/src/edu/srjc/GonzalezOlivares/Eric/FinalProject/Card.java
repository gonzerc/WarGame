package edu.srjc.GonzalezOlivares.Eric.FinalProject;

import javafx.scene.image.Image;

public class Card
{
    private Ranks rank;
    private Suits suit;
    private Image image;
    private int intRank;

    public enum Ranks
    {
        Two,
        Three,
        Four,
        Five,
        Six,
        Seven,
        Eight,
        Nine,
        Ten,
        Jack,
        Queen,
        King,
        Ace
    }

    public enum Suits
    {
        Spades,
        Hearts,
        Diamonds,
        Clubs
    }

    public Card()
    {

    }

    public Card(Ranks rank, Suits suit, Image image, int intRank)
    {
        this.rank = rank;
        this.suit = suit;
        this.image = image;
        this.intRank = intRank;
    }


    public Ranks getRank()
    {
        return rank;
    }

    public void setRank(Ranks rank)
    {
        this.rank = rank;
    }

    public Suits getSuit()
    {
        return suit;
    }

    public void setSuit(Suits suit)
    {
        this.suit = suit;
    }

    public Image getImage() { return image; }

    public void setImage(Image image)
    {
        this.image = image;
    }

    public int getIntRank()
    {
        return intRank;
    }

    public void setIntRank(int intRank)
    {
        this.intRank = intRank;
    }



    public String toString()
    {
        if (rank.ordinal() > Ranks.Ace.ordinal() & rank.ordinal() < Ranks.Jack.ordinal())
        {
            return String.format("%s of %s", rank.ordinal() + 1, suit);
        }
        return String.format("%s of %s", rank, suit);
    }
}
