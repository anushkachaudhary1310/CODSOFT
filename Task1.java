import java.util.Random;
import java.util.Scanner;

public class Task1{
    static int c=1;
    public static int checkNumber(int userNum,int randomNum){
        @SuppressWarnings("resource")
        Scanner sc=new Scanner(System.in);
            if(c<=10){   //till all 10 tries are complete
                if(randomNum==userNum){
                    System.out.println("Your guess is correct");
                    return c;
                }
                else if(userNum-randomNum>20 && userNum-randomNum<=30){
                    System.out.println("Your guess is too high"); //too high :user num>random num and the difference in user and random number is between 20 to 30 
                    c++;
                    System.out.println("enter a new number: ");
                    int n=sc.nextInt();
                    checkNumber(n, randomNum);
                    //score=score-10;
                }
                else if(userNum-randomNum>10 && userNum-randomNum<=20){
                    System.out.println("Your guess is high");  //high: user num>random num and the difference in user and random number is bwt 10 and 20
                    c++;
                    System.out.println("enter a new number: ");
                    int n=sc.nextInt();
                    checkNumber(n, randomNum);
                    //score=score-10;
                }
                else if(userNum-randomNum>5 && userNum-randomNum<=10){
                    System.out.println("Your guess is near but high"); //near but high :user num>random num and the difference in user and random number is bwt 5 and 10
                    c++;
                    System.out.println("enter a new number: ");
                    int n=sc.nextInt();
                    checkNumber(n, randomNum);
                    //score=score-10;
                }
                else if(userNum-randomNum>0 && userNum-randomNum<=5){
                    System.out.println("Your guess is very near but high"); //very near but high: user num>random num and the difference in user and random number is bwt 1 and 5
                    c++;
                    System.out.println("enter a new number: ");
                    int n=sc.nextInt();
                    checkNumber(n, randomNum);
                    //score=score-10;
                }
                else if(userNum-randomNum<-20 && userNum-randomNum>=-30){
                    System.out.println("Your guess is too low");  //too low: user num<random num and the difference in user and random number is bwt 20 and 30
                    c++;
                    System.out.println("enter a new number: ");
                    int n=sc.nextInt();
                    checkNumber(n, randomNum);
                    //score=score-10;
                }
                else if(userNum-randomNum<-10 && userNum-randomNum>=-20){
                    System.out.println("Your number is low"); //low: user num<random num and the difference in user and random number is bwt 10 and 20
                    c++;
                    System.out.println("enter a new number: ");
                    int n=sc.nextInt();
                    checkNumber(n, randomNum);
                    //score=score-10;
                }
                else if(userNum-randomNum<-5 && userNum-randomNum>=-10){
                    System.out.println("Your guess is near but low"); //near but low: user num<random num and the difference in user and random number is bwt 5 and 10
                    c++;
                    System.out.println("enter a new number: ");
                    int n=sc.nextInt();
                    checkNumber(n, randomNum);
                    //score=score-10;
                }
                else if(userNum-randomNum<0 && userNum-randomNum>=-5){
                    System.out.println("Your guess is very near but low"); //very near but low: user num<random num and the difference in user and random number is bwt 1 and 5
                    c++;
                    System.out.println("enter a new number: ");
                    int n=sc.nextInt();
                    checkNumber(n, randomNum);
                    //score=score-10;
                }
                else if(userNum-randomNum>30 || userNum-randomNum<-30){ 
                    System.out.println("Your guess is no way near");  //no way near : either user or random number is bigger but their so much gap that the difference bwt them is more than 30
                    c++;
                    System.out.println("enter a new number: ");
                    int n=sc.nextInt();
                    checkNumber(n, randomNum);
                    //score=score-10;
                }
                else{
                    System.out.println("Invalid Choice"); 
                    return -1;
                }
            }
        return c;
    }
    public static void numberGame(){
        Random rand=new Random();
        @SuppressWarnings("resource")
        Scanner sc=new Scanner(System.in);
        int randomNumber=rand.nextInt(101);
        int TotalScore=100; //user gets 100 Total score and 10 tries for the correct guess and will give 10 less score for each try
        
        //System.out.println("your random number:"+randomNumber);

        System.out.println("Enter your guessed number: ");
        int userNumber=sc.nextInt();
        int s=checkNumber(userNumber,randomNumber);
        if(s<10 && s>0){
            System.out.println("Good Job!! You guessed the number in "+s+" tries and your score out of 100 is: "+(TotalScore-s*10));
        }
        else{
            System.out.println("Game Over - You Lost. ");
            
        }
    }
    public static void main(String[] args) {
        @SuppressWarnings("resource")
        Scanner sc=new Scanner(System.in);
        numberGame();
        int i=1;
        numberGame();
            while(true){
                numberGame();
                System.out.println("Press '1\' to retry the game and press '0\' for exiting");
                i=sc.nextInt();
                if(i==1){
                    numberGame();
                }
                else if(i==0){
                    System.out.println("GAME IS COMPLETED");
                    break;
                }
                else{
                    System.out.println("Invalid Choice. ");
                    break;
                }
            }
    }
 }