import java.util.*;
public class numberGuess {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int random=(int)(Math.random()*100)+1;
        int guess=-1, count;
        for( count=1;count<=10;){
        System.out.println("Guess a number from range 1 to 100");
        guess=sc.nextInt();
        if(guess==random){
            System.out.println("Hurray! You guessed right");
            count=11;
        }
        else if(guess>random){
            System.out.println("Your guess is higher.");
            count++;
            System.out.println("You have "+(11-count)+" attempts remaining...");
        }
        else{
             System.out.println("Your guess is lower.");
            count++;
            System.out.println("You have "+(11-count)+" attempts remaining...");
        }
        
         if (count==11){
            System.out.println("Do you want to play again? Y/N");
            char ch=sc.next().charAt(0);
            if(ch=='Y'|| ch=='y'){
            count=0;
            random=(int)(Math.random()*100)+1;
            }
            else 
            break;
         }
        }
        
    }
}
