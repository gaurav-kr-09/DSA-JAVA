package Miscalleneous;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class RandomLibrary {
    public static void main(String[] args) {
        Random rand = new Random();

        // Random integer between 0 and 99
        int num = rand.nextInt(100);
        System.out.println(num);

        // Random integer between start and end (inclusive)
        int start = -5;
        int end = 20;
        num = rand.nextInt(end - start + 1) + start;
        System.out.println(num);

        // Another inclusive integer range example
        start = 12;
        end = 22;
        num = rand.nextInt(end - start + 1) + start;
        System.out.println(num);

        // Random double between 0.0 and 1.0
        double d = rand.nextDouble();
        System.out.println(d);

        // Random double between 0.0 and 20.0
        d = rand.nextDouble(20);
        System.out.println(d);

        // Random double between start and end
        // Formula: random * range + start
        start = 2;
        end = 20;
        d = rand.nextDouble(end - start) + start;
        System.out.println(d);

        System.out.println("================================");

        // Using Math.random()

        // Random double between 0.0 and 1.0
        double nums = Math.random();
        System.out.println(nums);

        // Random integer between 0 and 99
        int randomInt = (int) (Math.random() * 100);
        System.out.println(randomInt);

        // Random double between start and end
        start = 5;
        end = 17;

        // FIXED:
        // Earlier formula had (start - end + 1),
        // which produces incorrect values.
        nums = Math.random() * (end - start) + start;
        System.out.println(nums);

        // Random integer between 52 and 88 (inclusive)
        start = 52;
        end = 88;
        randomInt = (int) (Math.random() * (end - start + 1) + start);
        System.out.println(randomInt);

        System.out.println("================================");

        // Random booleans
        boolean b = rand.nextBoolean();
        System.out.println(b);

        // Print 5 random boolean values
        for (int i = 0; i < 5; i++) {
            System.out.println(rand.nextBoolean());
        }

        System.out.println("=================================");

        // MODERN WAY (Recommended)
        // Generates integer from 45 (inclusive) to 72 (exclusive)
        int number = ThreadLocalRandom.current().nextInt(45, 72);
        System.out.println(number);

        // If you want inclusive upper bound:
        // ThreadLocalRandom.current().nextInt(45, 73);
    }
}
