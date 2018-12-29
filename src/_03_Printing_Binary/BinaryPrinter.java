package _03_Printing_Binary;

public class BinaryPrinter {
	// Complete the methods below so they print the passed in parameter in binary.
	// Don't be afraid to use the methods that are already complete to finish the
	// others.
	// Create a main method to test your methods.

	public void printByteBinary(byte b) {

		System.out.println(Long.toBinaryString(Byte.toUnsignedLong(b)));

	}

	public void printShortBinary(short s) {

		System.out.println(Long.toBinaryString(Short.toUnsignedLong(s)));

	}

	public void printIntBinary(int i) {

		System.out.println(Integer.toBinaryString(i));
	}

	public void printLongBinary(long l) {
		System.out.println(Long.toBinaryString(l));
	}

	public static void main(String[] args) {
		int x = 22;
		long y = 22;
		byte z = 22;
		short w = 22;
		BinaryPrinter bp = new BinaryPrinter();
		bp.printIntBinary(x);
		bp.printLongBinary(y);
		bp.printShortBinary(w);
		bp.printByteBinary(z);
	}
}
