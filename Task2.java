import java.util.Scanner;

public class Task2 {
    public static int[] input(){
        @SuppressWarnings("resource")
        Scanner sc=new Scanner(System.in);
        System.out.println("enter the number of subjects");
        int n=sc.nextInt();
        int marks[]=new int[n];
        for(int i=0;i<n;i++){
            System.out.println("Enter the marks in "+(i+1)+" th subject: ");
            marks[i]=sc.nextInt();
        }
        return marks;
    }
    public static int CalTotalMarks(int marks[]){
        int sum=0;
        for(int i=0;i<marks.length;i++){
            sum=sum+marks[i];
        }
        return sum;
    }

    public static double CalAvgPercentage(int sum,int n){
        double avgPer=(sum/n);
        return avgPer;
    }
    public static char GradeAllotment(double avgPer){
        char grade;
        if(avgPer>=90)
            grade='S';
        else if(avgPer>=80 && avgPer<90)
            grade='A';
        else if(avgPer>=70 && avgPer<80)
            grade='B';
        else if(avgPer>=60 && avgPer<70)
            grade='C';
        else if(avgPer>=50 && avgPer<60)
            grade='D';
        else if(avgPer>=40 && avgPer<50)
            grade='E';
        else 
            grade='F';
            
        return grade;
    
        }

        public static void display(int totalMarks,double avgPer,char grade){
            System.out.println("Your Total Marks are: "+totalMarks);
            System.out.println("Your Average Percentage is: "+avgPer);
            System.out.println("Your grades for these subject is: "+grade);

        }
    public static void main(String[] args) {
        int[] marks=input();
        int TotalMarks=CalTotalMarks(marks);
        double avgPer=CalAvgPercentage(TotalMarks,marks.length);
        char Grade=GradeAllotment(avgPer);
        display(TotalMarks,avgPer,Grade);
    }
}
