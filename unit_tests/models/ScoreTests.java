package unit_tests.models;

import unit_tests.*;
import models.*;

public class ScoreTests extends UnitTests {
  public static void run() {
    Card[] royalFlush = {
      new Card(10,Card.SPADE),
      new Card(11,Card.SPADE),
      new Card(12,Card.SPADE),
      new Card(13,Card.SPADE),
      new Card(1,Card.SPADE)
    };

    Card[] straightFlush = {
      new Card(8,Card.SPADE),
      new Card(9,Card.SPADE),
      new Card(10,Card.SPADE),
      new Card(11,Card.SPADE),
      new Card(12,Card.SPADE)
    };

    Card[] fourOfAKind = {
      new Card(10,Card.HEART),
      new Card(10,Card.DIAMOND),
      new Card(10,Card.CLUB),
      new Card(10,Card.SPADE),
      new Card(1,Card.SPADE)
    };

    Card[] fullHouse = {
      new Card(10,Card.HEART),
      new Card(10,Card.DIAMOND),
      new Card(1,Card.CLUB),
      new Card(1,Card.SPADE),
      new Card(1,Card.HEART)
    };

    Card[] flush = {
      new Card(5,Card.HEART),
      new Card(7,Card.HEART),
      new Card(9,Card.HEART),
      new Card(11,Card.HEART),
      new Card(12,Card.HEART)
    };

    Card[] straight = {
      new Card(8,Card.SPADE),
      new Card(9,Card.HEART),
      new Card(10,Card.CLUB),
      new Card(11,Card.CLUB),
      new Card(12,Card.DIAMOND)
    };

    Card[] threeOfAKind = {
      new Card(11,Card.HEART),
      new Card(10,Card.DIAMOND),
      new Card(1,Card.CLUB),
      new Card(1,Card.SPADE),
      new Card(1,Card.HEART)
    };

    Card[] twoPair = {
      new Card(10,Card.HEART),
      new Card(10,Card.DIAMOND),
      new Card(1,Card.CLUB),
      new Card(1,Card.SPADE),
      new Card(4,Card.HEART)
    };

    Card[] pair = {
      new Card(11,Card.HEART),
      new Card(11,Card.DIAMOND),
      new Card(3,Card.CLUB),
      new Card(1,Card.SPADE),
      new Card(4,Card.HEART)
    };

    Card[] badHand = {
      new Card(11,Card.HEART),
      new Card(2,Card.DIAMOND),
      new Card(7,Card.CLUB),
      new Card(1,Card.SPADE),
      new Card(4,Card.HEART)
    };

    Score testScore = new Score(new Hand(royalFlush));
    test((testScore.scoreMultiplier() == 25), "Score.scoreMultiplier() for Royal Flush");

    testScore = new Score(new Hand(straightFlush));
    test((testScore.scoreMultiplier() == 20), "Score.scoreMultiplier() for Straight Flush");

    testScore = new Score(new Hand(fourOfAKind));
    test((testScore.scoreMultiplier() == 15), "Score.scoreMultiplier() for Four of a kind");

    testScore = new Score(new Hand(fullHouse));
    test((testScore.scoreMultiplier() == 10), "Score.scoreMultiplier() for Full house");

    testScore = new Score(new Hand(flush));
    test((testScore.scoreMultiplier() == 5), "Score.scoreMultiplier() for Flush");

    testScore = new Score(new Hand(straight));
    test((testScore.scoreMultiplier() == 4), "Score.scoreMultiplier() for Straight");

    testScore = new Score(new Hand(threeOfAKind));
    test((testScore.scoreMultiplier() == 3), "Score.scoreMultiplier() for Three of a kind");

    testScore = new Score(new Hand(twoPair));
    test((testScore.scoreMultiplier() == 2), "Score.scoreMultiplier() for Two pair");

    testScore = new Score(new Hand(pair));
    test((testScore.scoreMultiplier() == 1), "Score.scoreMultiplier() for Pair");

    testScore = new Score(new Hand(badHand));
    test((testScore.scoreMultiplier() == 0), "Score.scoreMultiplier() for No combinations");
  }
}
