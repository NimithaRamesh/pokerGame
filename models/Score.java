package models;
import java.util.*;

class Score{

  private int[] score;
  private final static int MAX_SIZE = 5;
  private Hand myCards;
  private int[] cardValues;
  //private Dictionary myDictionary={ca = 100*1, c2= 100*2};

  public Score(){
    this.myCards=new Hand();
    int[] cardRanks= new int[5];
    for(int i=0; i<5; i++){
      cardRanks[i] = myCards.getCard(i).getRank();
    }
    score=new int[MAX_SIZE];
    score=numberOfCards(myCards);
  }

  public int[] numberOfCards(Hand myHand){
    cardValues=new int[13];
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

  public boolean royalFlush(){
    while(sameSuit(myCards)){
      int theSuit=myCards.getCard(0).getSuit();
      if(myCards.isPresent(10,theSuit)&&myCards.isPresent(11,theSuit)&&myCards.isPresent(12,theSuit)&&myCards.isPresent(13,theSuit)&&myCards.isPresent(1,theSuit)){
        return true;
      }
    }
    return false;
  }

  public boolean sameSuit(Hand myHand){
    int suit1=myHand.getCard(0).getSuit();
    int suit2=myHand.getCard(1).getSuit();
    int suit3=myHand.getCard(2).getSuit();
    int suit4=myHand.getCard(3).getSuit();
    int suit5=myHand.getCard(4).getSuit();
    if(suit1==100&&suit2==100&&suit3==100&&suit4==100&&suit5==100)
      return true;
    else if(suit1==101&&suit2==101&&suit3==101&&suit4==101&&suit5==101)
      return true;
    else if(suit1==102&&suit2==102&&suit3==102&&suit4==102&&suit5==102)
      return true;
    else if(suit1==103&&suit2==103&&suit3==103&&suit4==103&&suit5==103)
      return true;
    else
      return false;
  }

  public boolean inOrder(Hand myHand){
    int[] numbers=new int[MAX_SIZE];
    int[] order=new int[MAX_SIZE];
    for(int i=0;i<MAX_SIZE;i++){
      order[i]=i;
    }
    numbers=numberOfCards(myHand);
    Arrays.sort(numbers);
    for(int i=0;i<MAX_SIZE;i++){
      numbers[i]=numbers[i]-numbers[0];
    }
    if(numbers==order){
      return true;
    }
    return false;
  }

  public boolean straightFlush(){
    if(sameSuit(myCards)&&inOrder(myCards)){
      return true;
    }
    return false;
  }

  public boolean fourOfAKind(){
    int count=0;
    for(int i=0;i<13;i++){
      if(cardValues[i]==4){
        count++;
      }
    }
    if(count==1){
      return true;
    }
    else{
      return false;
    }
  }

  public boolean fullHouse(){
    return false;
  }
  public boolean flush(){
    return false;
  }
  public boolean straight(){
    return false;
  }
  public boolean threeOfAKind(){
    int count=0;
    for(int i=0;i<13;i++){
      if(cardValues[i]==3){
        count++;
      }
    }
    if(count==1){
      return true;
    }
    else{
      return false;
    }
  }

  public boolean twoPair(){
    int count=0;
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

  public boolean pair(){
    int count=0;
    for(int i=0;i<13;i++){
      if(cardValues[i]==2){
        count++;
      }
    }
    if(count==1){
      return true;
    }
    else{
      return false;
    }
  }

  /*public String winningCombination(){

  }*/

  public static void main(String[] args){
    System.out.println("The combination is : ");
  }
}
