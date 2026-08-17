import java.util.Random;
import java.util.concurrent.atomic.AtomicLong;
import java.util.function.BiFunction;
import java.util.stream.IntStream;

public class MatrixMultiplicationBenchmark {
	private static AtomicLong start = new AtomicLong();
    private static AtomicLong stop = new AtomicLong();
    private static Random random = new Random();

    /**
     * Main method that warms-up each implementation and then runs the benchmark.
     *
     * @param args main class args
     */
    public static void main(String[] args) {
        // Warming up with more iterations and smaller data set
        System.out.println("Warming up...");
        IntStream.range(0, 10000000).forEach(i -> run(10, MatrixMultiplicationBenchmark::multiplyWithStreams));
        IntStream.range(0, 10000000).forEach(i -> run(10, MatrixMultiplicationBenchmark::multiplyWithForLoops));

        // Running with less iterations and larger data set
        startWatch("Running MatrixMultiplicationBenchmark::multiplyWithForLoops...");
        IntStream.range(0, 10).forEach(i -> run(10000000, MatrixMultiplicationBenchmark::multiplyWithForLoops));
        endWatch("MatrixMultiplicationBenchmark::multiplyWithForLoops");

        startWatch("Running MatrixMultiplicationBenchmark::multiplyWithStreams...");
        IntStream.range(0, 10).forEach(i -> run(10000000, MatrixMultiplicationBenchmark::multiplyWithStreams));
        endWatch("MatrixMultiplicationBenchmark::multiplyWithStreams");
    }

    /**
     * Creates the random matrix and vector and applies them in the given implementation as BiFunction object.
     *
     * @param multiplyImpl implementation to use.
     */
    public static void run(int size, BiFunction<double[][], double[], double[]> multiplyImpl) {
        // creating random matrix and vector
        double[][] matrix = new double[size][10];
        double[] vector = random.doubles(10, 0.0, 10.0).toArray();
        IntStream.range(0, size).forEach(i -> matrix[i] = random.doubles(10, 0.0, 10.0).toArray());

        // applying matrix and vector to the given implementation. Returned value should not be ignored in test cases.
        double[] result = multiplyImpl.apply(matrix, vector);
    }

    /**
     * Multiplies the given vector and matrix using Java 8 streams.
     *
     * @param matrix the matrix
     * @param vector the vector to multiply
     *
     * @return result after multiplication.
     */
    public static double[] multiplyWithStreams(final double[][] matrix, final double[] vector) {
        final int rows = matrix.length;
        final int columns = matrix[0].length;

        return IntStream.range(0, rows)
                .mapToDouble(row -> IntStream.range(0, columns)
                        .mapToDouble(col -> matrix[row][col] * vector[col])
                        .sum()).toArray();
    }

    /**
     * Multiplies the given vector and matrix using vanilla for loops.
     *
     * @param matrix the matrix
     * @param vector the vector to multiply
     *
     * @return result after multiplication.
     */
    public static double[] multiplyWithForLoops(double[][] matrix, double[] vector) {
        int rows = matrix.length;
        int columns = matrix[0].length;

        double[] result = new double[rows];

        for (int row = 0; row < rows; row++) {
            double sum = 0;
            for (int column = 0; column < columns; column++) {
                sum += matrix[row][column] * vector[column];
            }
            result[row] = sum;
        }
        return result;
    }

    private static void startWatch(String label) {
        System.out.println(label);
        start.set(System.currentTimeMillis());
    }

    private static void endWatch(String label) {
        stop.set(System.currentTimeMillis());
        System.out.println(label + " took " + ((stop.longValue() - start.longValue()) / 1000) + "s");
    }

}
