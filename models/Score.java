package models;
import java.util.Dictionary;

class Score{

  private int score;
  private Hand myCards;
  private int[] cardValues;
  //private Dictionary myDictionary={ca = 100*1, c2= 100*2};

  public Score(){
    myCards = new Hand();
    Card [] currentCards = myCards.getCards();
    int[] cardRanks= new int[5];
    for(int i=0; i<5; i++){
      cardRanks[i] = currentCards[i].getRank();
    }
    score=numberOfCards(currentCards);
  }

  public int[] numberOfCards(Card[] currentCards){
    cardValues=new int[13];
    int ace=0,two=0,three=0,four=0,five=0,six=0,seven=0,eight=0,nine=0,ten=0,jack=0,queen=0,king=0;
    for(int i=0;i<5;i++){
      switch(currentCards[i].getRank()){
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
      return cardValues;
      //String nothing = currentCards[i].toString();
    }
  }

  public boolean royalFlush(){
    int suit1=currentCards[0].getSuit;
    return false;
  }

  public boolean straightFlush(Card[] currentCards){
    if(currentCards[0].getSuit()=currentCards[1].getSuit()=currentCards[2].getSuit()=currentCards[3].getSuit()=currentCards[4].getSuit()){
      if(currentCards[0].getRank()+currentCards[1].getRank()+currentCards[2].getRank()+currentCards[3].getRank()+currentCards[4].getRank()==(10+11+12+13+1)){
      }
      return false;
    }
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

  public String winningCombination(){

  }

  public static void main(String[] args){
    System.out.println("The combination is : ");
  }
}
