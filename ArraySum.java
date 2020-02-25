package JUnit_Lab;
import java.util.Arrays;
public class ArraySum {

	public int sumOfArray(Integer[] myArray, int size) {

		if(size <= 0) {
			return 0;
		}
		else
		return sumOfArray(myArray, size - 1) + myArray[size - 1];
}}
