import java.util.Random;

public class RandomGenerator {
	// -------------------------------------------------------
	// Returns a random number between a min and max value based on: 
	// http://stackoverflow.com/questions/363681/generating-random-numbers-in-a-range-with-java
	// -------------------------------------------------------
	public static void main(String[] args) {
		System.out.println(randomInt(2, 8));
		System.out.println(randomFloat(2, 8));
		System.out.println(randomDouble(-8, 8));
	}
	
	// -------------------------------------------------------
	// --- Random int ---
	// -------------------------------------------------------
	public static int randomInt(int min, int max){
		if (min < max){
			Random gen = new Random();
			return gen.nextInt((max - min) + 1) + min;
		} else {
			return max;
		}
	}
	
	// -------------------------------------------------------
	// --- Random float ---
	// -------------------------------------------------------
	public static float randomFloat(float min, float max){
		Random gen = new Random();
		return gen.nextFloat() * (max - min) + min;
	}
	
	// -------------------------------------------------------
	// --- Random double ---
	// -------------------------------------------------------
	public static double randomDouble(double min, double max){
		Random gen = new Random();
		return gen.nextDouble() * (max - min) + min;
	}
	
}
