public class Hash_Benchmark {
    public static void main(String[] arg) {
	long tS = System.nanoTime();
	int[] sizes = {100, 200, 100, 200, 400, 800, 1600, 3200, 6400, 12800, 25600};
		System.out.printf("those: # searching through an array of length n, time in ns\n");
		System.out.printf("#%4s%22s%30s\n", "", "String", "Integer");
		System.out.printf("#%4s%15s%15s%15s%15s\n", "n", "linear", "binary", "linear", "binary");
		for ( int n : sizes) {
			System.gc();
			int loop = 1000;
			int k = 1000;

            String[][] Str2d = Hash_inital.Unsorted2d(k, loop, "postnummer.csv");
            Integer[][] Int2d = Hash_inital.Convert(Str2d);
			Hash_String stringArr = new Hash_String("postnummer.csv");
            Hash_Integer integerArr = new Hash_Integer("postnummer.csv");

			System.out.printf("%5d", n);

			Double min = Double.POSITIVE_INFINITY;
			for (int i = 0; i < k; i++) {
				long t0 = System.nanoTime();
				for (int m = 0; m < loop; m++) {
                    stringArr.linear(Str2d[i][m]);
				}
				long t1 = System.nanoTime();
				double t = (t1 - t0);
				if (t < min) min = t;
			}
			System.out.printf("%10.0f(%3.1f)" , (min/(loop)),((min/(loop))/(10*n*Math.log(n))));

			min = Double.POSITIVE_INFINITY;
			for (int i = 0; i < k; i++) {
				long t0 = System.nanoTime();
				for (int m = 0; m < loop; m++) {
                    stringArr.binary(Str2d[i][m]);
				}
				long t1 = System.nanoTime();
				double t = (t1 - t0);
				if (t < min) min = t;
				
			}
            System.out.printf("%10.0f(%3.1f)" , (min/(loop)),((min/(loop))/(10*n*Math.log(n))));

			min = Double.POSITIVE_INFINITY;
			for (int i = 0; i < k; i++) {
				long t0 = System.nanoTime();
				for (int m = 0; m < loop; m++) {
                    integerArr.linear(Int2d[i][m]);
				}
				long t1 = System.nanoTime();
				double t = (t1 - t0);
				if (t < min) min = t;
				
			}
            System.out.printf("%10.0f(%3.1f)" , (min/(loop)),((min/(loop))/(10*n*Math.log(n))));

			min = Double.POSITIVE_INFINITY;
			for (int i = 0; i < k; i++) {
				long t0 = System.nanoTime();
				for (int m = 0; m < loop; m++) {
                    integerArr.binary(Int2d[i][m]);
				}
				long t1 = System.nanoTime();
				double t = (t1 - t0);
				if (t < min) min = t;
				
			}
			System.out.printf("%10.0f(%3.1f)\n" , (min/(loop)),((min/(loop))/(10*n*Math.log(n))));
		}
		long tE = System.nanoTime();
		double tot = (tE - tS);
		System.out.println(tot);
    }
}