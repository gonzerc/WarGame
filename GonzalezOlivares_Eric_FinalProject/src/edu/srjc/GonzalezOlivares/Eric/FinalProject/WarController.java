/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.srjc.GonzalezOlivares.Eric.FinalProject;

import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

/**
 *
 * @author 
 */
public class WarController implements Initializable
{
    private ArrayList<Card> userDeck;
    private ArrayList<Card> aiDeck;
    private ArrayList<Card> userHand;
    private ArrayList<Card> aiHand;
    private Image background;
    private Image cardBack;
    private Image emptyCard;
    private int userWonPile;
    private int aiWonPile;
    private Card userDraw;
    private Card aiDraw;
    private Card userTieBreak;
    private Card aiTieBreak;
    private int userDeckPlaceHolder;
    private int aiDeckPlaceHolder;
    private boolean lastRounds;
    private int cardsLeft;

    @FXML
    private ImageView ivBackground;
    @FXML
    private ImageView ivUserDeck;
    @FXML
    private ImageView ivUserCardOne;
    @FXML
    private ImageView ivUserCardTwo;
    @FXML
    private ImageView ivUserCardThree;
    @FXML
    private ImageView ivUserCardFour;
    @FXML
    private ImageView ivUserCardFive;
    @FXML
    private ImageView ivUserWonPile;
    @FXML
    private ImageView ivUserDraw;
    @FXML
    private ImageView ivUserTieBreak;
    @FXML
    private ImageView ivAiDeck;
    @FXML
    private ImageView ivAiCardOne;
    @FXML
    private ImageView ivAiCardTwo;
    @FXML
    private ImageView ivAiCardThree;
    @FXML
    private ImageView ivAiCardFour;
    @FXML
    private ImageView ivAiCardFive;
    @FXML
    private ImageView ivAiWonPile;
    @FXML
    private ImageView ivAiDraw;
    @FXML
    private ImageView ivAiTieBreak;
    @FXML
    private Button btnWar;
    @FXML
    private Button btnNext;
    @FXML
    private Button btnSuddenDeath;
    @FXML
    private MenuItem mnuStartGame;
    @FXML
    private MenuItem mnuResetGame;
    @FXML
    private MenuItem mnuEndGame;
    @FXML
    private Label lblUserPile;
    @FXML
    private Label lblAiPile;
    @FXML
    private Label lblUserWon;
    @FXML
    private Label lblAiWon;
    @FXML
    private Label lblTie;
    @FXML
    private Label lblEndGameMsg;

//---------------------------------------------------------------------------------

    @FXML
    private void startGame_Clicked(ActionEvent e)
    {
        setupGame();
    }

    @FXML
    private void endGame_Clicked(ActionEvent e)
    {
        Platform.exit();
    }

    @FXML
    private void resetGame_Clicked(ActionEvent e)
    {
        resetGame();
    }

//    ------------------------------------------------------------------------------

    private void setupGame()
    {
        Deck fullDeck = new Deck();

        Collections.shuffle(fullDeck);

        fullDeck.splitDeck(userDeck, aiDeck);

        setupHands(userDeck, aiDeck);

        enableUserHand();
    }

    @FXML
    private void setupHands(ArrayList<Card> userDeck, ArrayList<Card> aiDeck)
    {
        int i = 0;

        while (i < 5)
        {
            userHand.add(userDeck.get(i));
            aiHand.add(aiDeck.get(i));

            i++;
            userDeckPlaceHolder++;
            aiDeckPlaceHolder++;
        }

        ivUserCardOne.setImage(userHand.get(0).getImage());
        ivUserCardTwo.setImage(userHand.get(1).getImage());
        ivUserCardThree.setImage(userHand.get(2).getImage());
        ivUserCardFour.setImage(userHand.get(3).getImage());
        ivUserCardFive.setImage(userHand.get(4).getImage());
        ivAiCardOne.setImage(cardBack);
        ivAiCardTwo.setImage(cardBack);
        ivAiCardThree.setImage(cardBack);
        ivAiCardFour.setImage(cardBack);
        ivAiCardFive.setImage(cardBack);
    }

    @FXML
    private void resetGame()
    {
        resetBattlefield();
        userDeck.clear();
        aiDeck.clear();
        userHand.clear();
        aiHand.clear();
        removeFieldImages();
        userWonPile = 0;
        aiWonPile = 0;
        userDeckPlaceHolder = 0;
        aiDeckPlaceHolder = 0;
        disableUserHand();
        btnWar.setDisable(true);
        btnNext.setDisable(true);
        btnSuddenDeath.setDisable(true);

    }

//    --------------------------------------------------------------------------


    @FXML
    private void userCardOne_Clicked(MouseEvent e)
    {
        userDraw = userHand.get(0);
        ivUserDraw.setImage(userHand.get(0).getImage());
        userHand.set(0, null);
        ivUserCardOne.setImage(emptyCard);
        getAiDraw();
        btnWar.setDisable(false);
        disableUserHand();
    }

    @FXML
    private void userCardTwo_Clicked(MouseEvent e)
    {
        userDraw = userHand.get(1);
        ivUserDraw.setImage(userHand.get(1).getImage());
        userHand.set(1, null);
        ivUserCardTwo.setImage(emptyCard);
        getAiDraw();
        btnWar.setDisable(false);
        disableUserHand();
    }

    @FXML
    private void userCardThree_Clicked(MouseEvent e)
    {
        userDraw = userHand.get(2);
        ivUserDraw.setImage(userHand.get(2).getImage());
        userHand.set(2, null);
        ivUserCardThree.setImage(emptyCard);
        getAiDraw();
        btnWar.setDisable(false);
        disableUserHand();
    }

    @FXML
    private void userCardFour_Clicked(MouseEvent e)
    {
        userDraw = userHand.get(3);
        ivUserDraw.setImage(userHand.get(3).getImage());
        userHand.set(3, null);
        ivUserCardFour.setImage(emptyCard);
        getAiDraw();
        btnWar.setDisable(false);
        disableUserHand();
    }

    @FXML
    private void userCardFive_Clicked(MouseEvent e)
    {
        userDraw = userHand.get(4);
        ivUserDraw.setImage(userHand.get(4).getImage());
        userHand.set(4, null);
        ivUserCardFive.setImage(emptyCard);
        getAiDraw();
        btnWar.setDisable(false);
        disableUserHand();
    }

    @FXML
    private void getAiDraw()
    {
        if (!lastRounds)
        {

            Random rand = new Random();
            int r = rand.nextInt(aiHand.size()) + 1;

            aiDraw = aiHand.get(r - 1);
            ivAiDraw.setImage(cardBack);
            aiHand.set(r - 1, null);
            setIvAiCard(r - 1);
        }
        else
        {
            //check if card is already empty
            if(aiHand.get(cardsLeft) == null)
            {
                cardsLeft--;
                getAiDraw();
            }
            else
            {
                aiDraw = aiHand.get(cardsLeft);
                ivAiDraw.setImage((cardBack));
                aiHand.set(cardsLeft, null);
                setIvAiCard(cardsLeft);
                cardsLeft--;
            }
        }

    }


//    ------------------------------------------------------------------------


    @FXML
    private void btnWar_Clicked(MouseEvent e)
    {
        ivAiDraw.setImage(aiDraw.getImage());

        //compare ranks
        goToWar(userDraw, aiDraw);

        btnWar.setDisable(true);
    }


    @FXML
    private void btnSuddenDeath_Clicked(MouseEvent e)
    {
        userTieBreak = userDeck.get(userDeckPlaceHolder);
        ivUserTieBreak.setImage(userTieBreak.getImage());
        aiTieBreak = aiDeck.get(aiDeckPlaceHolder);
        ivAiTieBreak.setImage(aiTieBreak.getImage());
        userDeckPlaceHolder++;
        aiDeckPlaceHolder++;
        btnSuddenDeath.setDisable(true);
        goToWar(userTieBreak, aiTieBreak);
    }


    @FXML
    private void btnNext_Clicked(MouseEvent e)
    {
        if (userDeckPlaceHolder == 26 && aiDeckPlaceHolder == 26)
        {
            ivUserDeck.setImage(emptyCard);
            ivAiDeck.setImage(emptyCard);
            lastRounds = true;
        }
        else
        {
            getNewCards();

            if (userWonPile > 0)
            {
                ivUserWonPile.setImage(cardBack);
            }
            else
            {
                ivUserWonPile.setImage(emptyCard);
            }
            if (aiWonPile > 0)
            {
                ivAiWonPile.setImage(cardBack);
            }
            else
            {
                ivAiWonPile.setImage(emptyCard);
            }
        }

        resetBattlefield();
        checkGameOver();
    }


//    ------------------------------------------------------------------------------------------


    @FXML
    private void goToWar(Card userCard, Card aiCard)
    {
        if (userCard.getIntRank() > aiCard.getIntRank())
        {
            lblUserWon.setVisible(true);
            if (userTieBreak.getRank() != null)
            {
                userWonPile += 4;
            }
            else
            {
                userWonPile += 2;
            }
            lblUserPile.setText(Integer.toString(userWonPile));
            btnNext.setDisable(false);
        }
        else if (userCard.getIntRank() < aiCard.getIntRank())
        {
            lblAiWon.setVisible(true);
            if (aiTieBreak.getRank() != null)
            {
                aiWonPile += 4;
            }
            else
            {
                aiWonPile += 2;
            }
            lblAiPile.setText(Integer.toString(aiWonPile));
            btnNext.setDisable(false);
        }
        else if (userCard.getIntRank() == aiCard.getIntRank())
        {
            btnNext.setDisable(true);
            lblTie.setVisible(true);
            btnSuddenDeath.setDisable(false);
        }
    }


    @FXML
    private void getNewCards()
    {
        int i = 0;
        for (Card c : userHand)
        {
            if (c == null)
            {
                //place next card from user deck in user hand
                userHand.set(i, userDeck.get(userDeckPlaceHolder));

                //set image for new card
                switch (i)
                {
                    case 0:
                        ivUserCardOne.setImage(userHand.get(i).getImage());
                        userDeckPlaceHolder++;
                        break;
                    case 1:
                        ivUserCardTwo.setImage(userHand.get(i).getImage());
                        userDeckPlaceHolder++;
                        break;
                    case 2:
                        ivUserCardThree.setImage(userHand.get(i).getImage());
                        userDeckPlaceHolder++;
                        break;
                    case 3:
                        ivUserCardFour.setImage(userHand.get(i).getImage());
                        userDeckPlaceHolder++;
                        break;
                    case 4:
                        ivUserCardFive.setImage(userHand.get(i).getImage());
                        userDeckPlaceHolder++;
                        break;
                }
            }

            i++;
        }

        int j = 0;
        for (Card c : aiHand)
        {
            if (c == null)
            {
                //place next card from ai deck in ai hand
                aiHand.set(j, aiDeck.get(aiDeckPlaceHolder));

                //set image for new card
                switch (j)
                {
                    case 0:
                        ivAiCardOne.setImage(cardBack);
                        aiDeckPlaceHolder++;
                        break;
                    case 1:
                        ivAiCardTwo.setImage(cardBack);
                        aiDeckPlaceHolder++;
                        break;
                    case 2:
                        ivAiCardThree.setImage(cardBack);
                        aiDeckPlaceHolder++;
                        break;
                    case 3:
                        ivAiCardFour.setImage(cardBack);
                        aiDeckPlaceHolder++;
                        break;
                    case 4:
                        ivAiCardFive.setImage(cardBack);
                        aiDeckPlaceHolder++;
                        break;
                }
            }
            j++;
        }
    }


    @FXML
    private void enableUserHand()
    {
        ivUserCardOne.setDisable(false);
        ivUserCardTwo.setDisable(false);
        ivUserCardThree.setDisable(false);
        ivUserCardFour.setDisable(false);
        ivUserCardFive.setDisable(false);
    }

    @FXML
    private void disableUserHand()
    {
        ivUserCardOne.setDisable(true);
        ivUserCardTwo.setDisable(true);
        ivUserCardThree.setDisable(true);
        ivUserCardFour.setDisable(true);
        ivUserCardFive.setDisable(true);
    }

    @FXML
    private void setIvAiCard(int cardHolder)
    {
        switch (cardHolder)
        {
            case 0:
                ivAiCardOne.setImage(emptyCard);
                break;
            case 1:
                ivAiCardTwo.setImage(emptyCard);
                break;
            case 2:
                ivAiCardThree.setImage(emptyCard);
                break;
            case 3:
                ivAiCardFour.setImage(emptyCard);
                break;
            case 4:
                ivAiCardFive.setImage(emptyCard);
                break;
        }
    }

    @FXML
    private void resetBattlefield()
    {
        btnNext.setDisable(true);
        lblUserWon.setVisible(false);
        lblAiWon.setVisible(false);
        lblTie.setVisible(false);
        lblEndGameMsg.setVisible(false);
        userDraw = new Card();
        ivUserDraw.setImage(emptyCard);
        aiDraw = new Card();
        ivAiDraw.setImage(emptyCard);
        userTieBreak = new Card();
        ivUserTieBreak.setImage(emptyCard);
        aiTieBreak = new Card();
        ivAiTieBreak.setImage(emptyCard);
        enableUserHand();
    }

    @FXML
    private void checkGameOver()
    {
        if(cardsLeft < 0)
        {
            lblEndGameMsg.setVisible(true);

            if(userWonPile > aiWonPile)
            {
                lblEndGameMsg.setText("YOU WON!");
            }
            else if(userWonPile < aiWonPile)
            {
                lblEndGameMsg.setText("You lost.");
            }
            else if(userWonPile == aiWonPile)
            {
                lblEndGameMsg.setText("It was a tie!");
            }
            disableUserHand();
        }
    }

    @FXML
    private void removeFieldImages()
    {
        ivUserCardOne.setImage(emptyCard);
        ivUserCardTwo.setImage(emptyCard);
        ivUserCardThree.setImage(emptyCard);
        ivUserCardFour.setImage(emptyCard);
        ivUserCardFive.setImage(emptyCard);
        ivAiCardOne.setImage(emptyCard);
        ivAiCardTwo.setImage(emptyCard);
        ivAiCardThree.setImage(emptyCard);
        ivAiCardFour.setImage(emptyCard);
        ivAiCardFive.setImage(emptyCard);

        ivUserWonPile.setImage(emptyCard);
        ivAiWonPile.setImage(emptyCard);

        lblUserPile.setText("0");
        lblAiPile.setText("0");
    }

//    -----------------------------------------------------------------------------


    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        background = new Image("/images/green.jpg");
//        ivBackground.setImage(background);
        userDeck = new ArrayList<>();
        aiDeck = new ArrayList<>();
        userHand = new ArrayList<>();
        aiHand = new ArrayList<>();
        cardBack = new Image("/images/card_back.png");
        emptyCard = new Image("/images/card_empty.png");
        userWonPile = 0;
        aiWonPile = 0;
        userDraw = new Card();
        aiDraw = new Card();
        userTieBreak = new Card();
        aiTieBreak = new Card();
        userDeckPlaceHolder = 0;
        aiDeckPlaceHolder = 0;
        lastRounds = false;
        cardsLeft = 4;
    }

    
}
