import java.util.HashSet;
import java.util.Random;


public class HashTableLinearProbing {
    public static void main(String[] args) {
        int[] hashTable = new int[20]; 
        boolean[] occupied = new boolean[20]; 
        HashSet<Integer> uniqueValues = new HashSet<>();
        Random random = new Random();

        while (uniqueValues.size() < 15) {
            int value = 100000 + random.nextInt(900000); // Random value in the range
            uniqueValues.add(value);
        }

        for (int value : uniqueValues) {
            int key = hashFunction(value);
            int index = key;

            while (occupied[index]) {
                index = (index + 1) % 20;
            }

            hashTable[index] = value;
            occupied[index] = true; 
        }

        System.out.println("Final values in the hash table:");
        for (int i = 0; i < hashTable.length; i++) {
            if (occupied[i]) {
                System.out.println("Index " + i + ": " + hashTable[i]);
            } else {
                System.out.println("Index " + i + ": Empty");
            }
        }
    }

    private static int hashFunction(int x) {
        return (x % 18) + 2;
    }
}
