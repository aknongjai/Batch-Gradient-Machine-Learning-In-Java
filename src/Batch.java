import java.util.Scanner;

import static java.lang.Math.pow;
class data{
    public Scanner s=new Scanner(System.in);
    public double livArea,noBed,price;
    public void getVal(){
        System.out.println("Enter the Living area in square feet, no. of bedrooms and price in lacs respectively");
        livArea=s.nextDouble();
        noBed=s.nextDouble();
        price=s.nextDouble();
    }
}
public class Batch {
    private static double weight[]=new double[10];//The weights "theta or w"
    private static double hypothesis[]=new double[100];//The hypothesis values
    private static double cost=1;//The cost function values
    private static int m=5;//number of training examples
    private static int n=2;//number of features
    private static final double learnRate=0.000000001;
    private static boolean flag=true;
    private static double ddd=0.5;
    private static final double desiredError=0.01;
    private static void initialiseDataArray(data ex[]){
        for (int i=0;i<=m;i++){
            ex[i]=new data();
        }
    }
    public static void getData(data ex[]){
        for(int i=1;i<=m;i++){
            ex[i].getVal();
        }
    }
    public static void show(data ex[]){
        for (int i=1;i<=m;i++){
            System.out.println("Living Area "+ex[i].livArea+" number of bed "+ex[i].noBed+" price "+ex[i].price);
        }
    }
    static void getWt(){
        weight[0]=0.01;weight[1]=0.009;weight[2]=0.03;
    }
    static void calHypothesis(data ex[]){
        for (int i=1;i<=m;i++){
            hypothesis[i]=(weight[0]+(weight[1]*ex[i].livArea)+(weight[2]*ex[i].noBed));
        }//End calculation of hypothesis
        for (int i=1;i<=m;i++){
            System.out.println("hypothesis["+i+"] is "+ hypothesis[i]);
        }//printing the hypothesis values
        double sum=0;//variable to hold the cost for a while
        for (int i=1;i<=m;i++){
            sum+=(pow(((ex[i].price)-hypothesis[i]),2));
        }
        cost=(ddd*sum);
    }
    public static void update(data ex[]){
        double temp0=0,temp1=0,temp2=0;
        for (int i=1;i<=m;i++){
            temp0+=(ex[i].price-hypothesis[i]);
            temp1+=((ex[i].price-hypothesis[i])*(ex[i].livArea));
            temp2+=((ex[i].price-hypothesis[i])*(ex[i].noBed));
        }
        weight[0]=(weight[0]+(learnRate*temp0));
        weight[1]=(weight[1]+(learnRate*temp1));
        weight[2]=(weight[2]+(learnRate*temp2));
    }
    private static void checking(data ex[]){
        calHypothesis(ex);
        System.out.println("coinsst isss "+cost);
double varia=0;
        while (cost>=desiredError ){
            varia=cost;
            calHypothesis(ex);
            System.out.println("\n cost is "+cost);
            update(ex);
            System.out.println("Weight[0] is "+weight[0]+" weight[1] is "+weight[1]+" weight[2] is "+weight[2]);
            double sick=(weight[0]+(weight[1]*517)+(weight[2]*9.5));
            System.out.println("Value of 517 "+sick);
            //if(cost==varia)
              //  break;
        }
        System.out.println("Weight[0] is "+weight[0]+" weight[1] is "+weight[1]+" weight[2] is "+weight[2]);
        double sick=(weight[0]+(weight[1]*517)+(weight[2]*9.5));
        System.out.println("Value of 517 "+sick);
    }
    public static void main(String []args){
        data d[]=new data[10];
        initialiseDataArray(d);
        getData(d);
        getWt();
        checking(d);
    }
}
/*All Rights Reserved
Nongjaimayum Annas khan
Husband of Ph Tabasum Sahani
*/
