package models;
import java.util.*;

public class Score{

  private int score;
  private final static int MAX_SIZE = 5;
  private Hand myCards;
  private int[] cardRanks;
  private int[] cardValues;

  //Note to self: Call numberOfMethods() wherever you use cardValues!@!!!!@!!!!!

  public Score(Hand hand){
    myCards=hand;
    cardRanks= new int[5];
    cardValues=new int[13];
    for(int i=0; i<5; i++){
      cardRanks[i] = myCards.getCard(i).getRank();
    }
    //score=new int[MAX_SIZE];
    //score=numberOfCards(myCards);
  }

  public int scoreMultiplier(){
    if(royalFlush()){
      score=250;
    }
    else if(straightFlush()){
      score=50;
    }
    else if(fourOfAKind()){
      score=25;
    }
    else if(fullHouse()){
      score=9;
    }
    else if(flush()){
      score=6;
    }
    else if(straight()){
      score=5;
    }
    else if(threeOfAKind()){
      score=3;
    }
    else if(twoPair()){
      score=2;
    }
    else if(pair()){
      score=1;
    }
    else{
      score=0;
    }
    return score;
  }

  public String toString(){
    String combo;
    int score=scoreMultiplier();
    switch(score){
      case 250: combo="Royal Flush";break;
      case 50: combo="Straight Flush";break;
      case 25: combo="Four of a Kind";break;
      case 9: combo="Full House";break;
      case 6: combo="Flush";break;
      case 5: combo="Straight";break;
      case 3: combo="Three of a Kind";break;
      case 2: combo="Two Pair";break;
      case 1: combo="Pair";break;
      default:combo="No combination";
    }
    return combo;
  }

  //*Royal Flush: five consecutive denomination cards of the same suit,
  //*starting from 10 and ending with an ace
  public boolean royalFlush(){
    if(sameSuit(myCards)){
      int theSuit=myCards.getCard(0).getSuit();
      if(myCards.isPresent(10,theSuit)&&myCards.isPresent(11,theSuit)&&myCards.isPresent(12,theSuit)&&myCards.isPresent(13,theSuit)&&myCards.isPresent(1,theSuit)){
        return true;
      }
    }
    return false;
  }

  //*Straight Flush: five consecutive denomination cards of the same suit.
  public boolean straightFlush(){
    int straightSuit=myCards.getCard(0).getSuit();
    if(sameSuit(myCards)&&inOrder(myCards)){
      return true;
    }
    else if(myCards.isPresent(10,straightSuit)&&myCards.isPresent(11,straightSuit)&&myCards.isPresent(12,straightSuit)&&myCards.isPresent(13,straightSuit)&&myCards.isPresent(1,straightSuit)){
      return true;
    }
    else{
      return false;
    }
  }

  //*Four of a kind: four cards of the same denomination.
  public boolean fourOfAKind(){
    int count=0;
    cardValues=numberOfCards(myCards);
    for(int i=0;i<13;i++){
      if(cardValues[i]==4){
        count=1;
      }
    }
    if(count==1){
      return true;
    }
    else{
      return false;
    }
  }

  //Full House: a set of three cards of the same denomination plus
  //*a set of two cards of the same denomination.
  public boolean fullHouse(){
    if(this.fullHousePair()&&this.threeOfAKind()){
      return true;
    }
    return false;
  }

  //*Flush: five non-consecutive denomination cards of the same suit.
  public boolean flush(){
    if(sameSuit(myCards)){
      return true;
    }
    else{
      return false;
    }
  }

  //*Straight: five consecutive denomination cards of different suit.
  public boolean straight(){
    if(inOrder(myCards)){
      return true;
    }
    else{
      return false;
    }
  }

  //*Three of a Kind: three cards of the same denomination.
  public boolean threeOfAKind(){
    int count=0;
    cardValues=numberOfCards(myCards);
    for(int i=0;i<13;i++){
      if(cardValues[i]==3){
        count=1;
      }
    }
    if(count==1){
      return true;
    }
    else{
      return false;
    }
  }

  //*Two Pair: two sets of pairs of the same card denomination.
  public boolean twoPair(){
    int count=0;
    cardValues=numberOfCards(myCards);
    for(int i=0;i<13;i++){
      if(cardValues[i]==2){
        count++;
      }
    }
    if(count==2){
      return true;
    }
    else{
      return false;
    }
  }

  //*Jacks or Better: a pair pays out only if the cards in the pair are Jacks,
  //*Queens, Kings, or Aces. Lower pairs do not pay out.
  public boolean pair(){
    int count=0;
    cardValues=numberOfCards(myCards);
    for(int i=10;i<13;i++){ //Loops through Jack or better
      if(cardValues[i]==2){
        count++;
      }
    }
    if(cardValues[0]==2){ //Checks for an Ace pair
      count++;
    }
    if(count==1){
      return true;
    }
    else{
      return false;
    }
  }

  public boolean fullHousePair(){
    int count=0;
    cardValues=numberOfCards(myCards);
    for(int i=0;i<13;i++){
      if(cardValues[i]==2){
        count=1;
      }
    }
    if(count==1){
      return true;
    }
    else{
      return false;
    }
  }


  //*Helper methods

  //*Checks if all cards in Hand are of the same suit
  public boolean sameSuit(Hand myHand){
    int suit1=myHand.getCard(0).getSuit();
    int suit2=myHand.getCard(1).getSuit();
    int suit3=myHand.getCard(2).getSuit();
    int suit4=myHand.getCard(3).getSuit();
    int suit5=myHand.getCard(4).getSuit();
    if(suit1==100&&suit2==100&&suit3==100&&suit4==100&&suit5==100){
      return true;
    }
    else if(suit1==101&&suit2==101&&suit3==101&&suit4==101&&suit5==101){
      return true;
    }
    else if(suit1==102&&suit2==102&&suit3==102&&suit4==102&&suit5==102){
      return true;
    }
    else if(suit1==103&&suit2==103&&suit3==103&&suit4==103&&suit5==103){
      return true;
    }
    else{
      return false;
    }
  }

  //*Checks if all cards in Hand are in ascending order
  public boolean inOrder(Hand myHand){
    int[] numbers=new int[MAX_SIZE];
    int[] order=new int[MAX_SIZE];
    for(int i=0;i<MAX_SIZE;i++){
      order[i]=i;
    }
    for(int i=0;i<MAX_SIZE;i++){
      numbers[i]=myHand.getCard(i).getRank();
    }
    Arrays.sort(numbers);
    for(int i=0;i<MAX_SIZE;i++){
      if (!(order[i] == numbers[i]-numbers[0])) {
        return false;
      }
    }
    return true;
  }

  //*Returns an integer array
  public int[] numberOfCards(Hand myHand){
    int ace=0,two=0,three=0,four=0,five=0,six=0,seven=0,eight=0,nine=0,ten=0,jack=0,queen=0,king=0;
    for(int i=0;i<5;i++){
      switch(myHand.getCard(i).getRank()){
        case 1: ace=ace+1;
                cardValues[0]=ace;
                break;
        case 2: two=two+1;
                cardValues[1]=two;
                break;
        case 3: three=three+1;
                cardValues[2]=three;
                break;
        case 4: four=four+1;
                cardValues[3]=four;
                break;
        case 5: five=five+1;
                cardValues[4]=five;
                break;
        case 6: six=six+1;
                cardValues[5]=six;
                break;
        case 7: seven=seven+1;
                cardValues[6]=seven;
                break;
        case 8: eight=eight+1;
                cardValues[7]=eight;
                break;
        case 9: nine=nine+1;
                cardValues[8]=nine;
                break;
        case 10:ten=ten+1;
                cardValues[9]=ten;
                break;
        case 11:jack=jack+1;
                cardValues[10]=jack;
                break;
        case 12:queen=queen+1;
                cardValues[11]=queen;
                break;
        case 13:king=king+1;
                cardValues[12]=king;
                break;
        default:break;
      }
      //String nothing = currentCards[i].toString();
    }
    return cardValues;
  }

  /*public static void main(String[] args){
    Hand testHand = new Hand();

  }*/
}
