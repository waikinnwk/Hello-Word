import java.math.BigInteger;


public class FNumber {
	public static void main(String[] args){
		System.out.println(FNumber(2996));
	}
	
	public static BigInteger FNumber(int n){
		if(n<0)
			return BigInteger.valueOf(-1);
		else if(n == 0)
			return BigInteger.valueOf(0);
		else if(n ==1)
			return BigInteger.valueOf(1);
		BigInteger f0 = BigInteger.valueOf(0);
		BigInteger f1 = BigInteger.valueOf(1);
		BigInteger f = BigInteger.valueOf(0);
		for(int i =2; i <=n; i++){
			f  = f0.add(f1);
			f0 = f1;
			f1 =f;
		}
		return f;
		
		
	}
}
