import java.util.Scanner;

public class Main{
    public static void main(String[] args){
    	Scanner sc=new Scanner(System.in);
    	while(true) {
            int M=sc.nextInt();
    		if(M==0) {
    			break;
    		}
            int N=2*M;
            boolean arr[] =new boolean[N+1];
            arr[0]=true;
            arr[1]=true;
            int count =0;
            
            for(int i=2; i<Math.sqrt(N+1); i++) {
            	for(int j=i*i; j<N+1; j += i) {
            		arr[j]=true;
            	}
            }
            for(int i=M+1; i<N+1; i++) {
            	if(arr[i] == false)
            		count++;
            }
            System.out.println(count);
    	}
    }
}
    