import java.util.*;
public class Grade_Calculator {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the number of subjects");
        int n= sc.nextInt();
        int sum=0;
        for(int i=1;i<=n;i++){
            System.out.println("Enter marks of subject "+ i);
            int marks= sc.nextInt();
            sum+= marks;
        }
        int avg_percentage=sum/n;
        char grade;
        if(avg_percentage<=100 && avg_percentage>=90)
           grade='A';
        else if(avg_percentage<90 && avg_percentage>=80)
           grade='B';
        else if(avg_percentage<80 && avg_percentage>=60)
           grade='C';
        else if(avg_percentage<60 && avg_percentage>=40)
           grade='D';
        else
           grade='F';
           System.out.println("Total Marks\tAverage Percentage\tGrade");
           System.out.println(sum+"\t\t"+avg_percentage+"%\t\t\t"+grade);
    }
}
