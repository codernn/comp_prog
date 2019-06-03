import java.io.*;
import java.util.*;
import java.lang.*;
public class Step{
	//recursion 
	static int num_ways(int n){
		if(n==0) return 1;
		if(n==1) return 1;
		return num_ways(n-1)+num_ways(n-2);
		//return num_ways(n-1)+num_ways(n-3)+num_ways(n-5);
	}
	static int num_waysX(int n,int[] x){
		if(n==0) return 1;
		int tot = 0;
		int l = x.length;
		for(int i=0;i<l;i++){
			if(n-x[i]>0)
				tot += num_ways(n-x[i]);
		}
		return tot;
	}
	//Dynamic programming
	static int botup(int n){
		if(n==0) return 1;
		if(n==1) return 1;
		//int[] a = new int[n+1];
		//a[0] = 1;
		//a[1] = 1;
		//for(int i=2;i<n+1;i++){
		//	a[i] = a[i-1]+a[i-2];
		//}
		//return a[n];
		int x = 1;
		int y = 1;
		int k = 0;
		for(int i=0;i<n-1;i++){
			k = x+y;
			y = x;
			x = k;
		}
		return k;
	}


	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] x = {1,3,5};
		int k = num_waysX(n,x);
		System.out.println(k);
	}
}