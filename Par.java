import java.io.*;
import java.util.*;
import java.lang.*;
public class Par{
	public int vec[]; 
	int go(int lo,int hi){
		if(lo==hi-1) return 1;
		int mid = vec[lo];
		if (hi==mid) return 2*go(lo+1,hi-1);
		return go(lo,mid)+go(mid+1,hi);
	}
	int score(String s){
		int n = s.length();
		n = Math.max(n,1);
		vec = new int[n];
		Stack<Integer> a = new Stack<Integer>();
		for(int i=0;i<n;i++){
			if(s.charAt(i)==')'){
				int t = a.peek();
				vec[t] = i;
				a.pop();
			}
			else
				a.push(i);
		}
		return go(0,n-1);
	}
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		try{
		Par p = new Par();
		int l = p.score(s);
		System.out.println(l);}
		catch(NullPointerException e){
			e.printStackTrace();
		}
	}
}