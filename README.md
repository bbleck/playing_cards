# playing_cards
Initial commit

A java program that simulates a card trick that will possibly amaze your friends and family.

The card trick goes like this:

A standard 52 card deck is shuffled and placed face down.

There will be three piles made: a discard pile, a "red" pile, and a "black" pile.

The user proceeds to draw the top card and lay it face up in the discard pile.  If the card is red, the user draws a second card and places it face down in the red pile.  If the first card is black, the second card goes face down in the black pile.

The user then draws a third card, and places it face up in the discard pile. The same rules are followed for the fourth card as for the second.

The user continues this process until all cards have been drawn. (Sanity check:  number of cards in the red pile plus number of cards in the black pile will equal 26).

The user can get rid of the discard pile, and then chooses a number between 0 and the size of the smaller pile between the red pile and the black pile.

Make sure to remember which pile is the red pile and which is the black.  Then take the chosen number of cards off the top of the red pile and also take the chosen number of cards off the top of the black pile.  Put the cards taken off the black pile onto the top of the red pile, and put the cards taken off the red pile onto the top of the black pile.

Now count the number of red cards in the red pile.  This number will be the same as the number of black cards in the black pile!
