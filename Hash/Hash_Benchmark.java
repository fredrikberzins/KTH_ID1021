public class Hash_Benchmark {
    public static void main(String[] arg) {
	int[] sizesInt = {11115, 24494, 45732, 98499, 11115, 45732, 98499, 11115, 45732, 98499};
	String[] sizesStr = {"111 15", "244 94", "457 32", "984 99", "111 15", "457 32", "984 99", "111 15", "457 32", "984 99"};
		/*--*/System.out.printf("those: # searching through an array of length n, time in ns\n");
		/*--*/System.out.printf("#%7s%22s%30s%23s\n", "", "String", "Integer", "Index");
		/*--*/System.out.printf("#%7s%15s%15s%15s%15s%15s\n", "n", "linear", "binary", "linear", "binary", "lookup");
		for (int n  = 0; n < sizesInt.length; n++) {
			System.gc();
			int loop = 1000;

			Hash_String stringArr = new Hash_String("Hash/postnummer.csv");
            Hash_Integer integerArr = new Hash_Integer("Hash/postnummer.csv");
            Hash_Index indexArr = new Hash_Index("Hash/postnummer.csv");

			/*--*/System.out.printf("%8d", sizesInt[n]);

			Double min = Double.POSITIVE_INFINITY;
			long t0 = System.nanoTime();
			for (int i = 0; i < loop; i++) {
                stringArr.linear(sizesStr[n]);
			}
			long t1 = System.nanoTime();
			double t = (t1 - t0);
			if (t < min) min = t;
			/*--*/System.out.printf("%15.0f" , (min/(loop)));

			min = Double.POSITIVE_INFINITY;
			t0 = System.nanoTime();
			for (int i = 0; i < loop; i++) {
                stringArr.binary(sizesStr[n]);
			}
			t1 = System.nanoTime();
			t = (t1 - t0);
			if (t < min) min = t;
            /*--*/System.out.printf("%15.0f" , (min/(loop)));

			min = Double.POSITIVE_INFINITY;
			t0 = System.nanoTime();
			for (int i = 0; i < loop; i++) {
                integerArr.linear(sizesInt[n]);
			}
			t1 = System.nanoTime();
			t = (t1 - t0);
			if (t < min) min = t;
            /*--*/System.out.printf("%15.0f" , (min/(loop)));

			min = Double.POSITIVE_INFINITY;
			t0 = System.nanoTime();
			for (int i = 0; i < loop; i++) {
                integerArr.binary(sizesInt[n]);
			}
			t1 = System.nanoTime();
			t = (t1 - t0);
			if (t < min) min = t;
			/*--*/System.out.printf("%15.0f" , (min/(loop)));

			min = Double.POSITIVE_INFINITY;
			min = Double.POSITIVE_INFINITY;
			t0 = System.nanoTime();
			for (int i = 0; i < loop; i++) {
                indexArr.lookup(sizesInt[n]);
			}
			t1 = System.nanoTime();
			t = (t1 - t0);
			if (t < min) min = t;
			/*--*/System.out.printf("%15.0f\n" , (min/(loop)));
		}
    }
}