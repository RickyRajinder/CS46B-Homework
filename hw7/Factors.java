package mergesort;

public class Factors {
	
	private static boolean isPrime(int num) {
        if (num < 2) return false;
        if (num == 2) return true;
        if (num % 2 == 0) return false;
        for (int i = 3; i * i <= num; i += 2)
            if (num % i == 0) return false;
        return true;
}

	public static void primeFactors(int n){
		if (isPrime(n))
			System.out.println(n);
		while (n%2==0){
			System.out.print("2 ");
			n = n/2;
		for (int i = 3; i < Math.sqrt(n); i = i+2){
			while (n%i == 0){
				System.out.print(i + " ");
				n = n/i;
			}
		}
		if (n>2 && isPrime(n))
			System.out.println(n + " ");
		}
	}


	public static void main (String args[]){
		System.out.println(Factors.isPrime(136));
		Factors.primeFactors(136);
		Factors.primeFactors(12);

	}
	
}
