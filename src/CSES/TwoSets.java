package CSES;

import java.nio.ByteBuffer;
import java.time.Instant;
import java.util.Base64;
import java.util.Scanner;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

public class TwoSets {
    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int n = scanner.nextInt();
        String streamKey = generateUniqueStreamKey2();
        System.out.println("streamkey " + streamKey);
        UUID uuid = UUID.randomUUID();
        System.out.println("original uuid : " + uuid);
//        String encodedKey = uuidToBase64(String.valueOf(uuid));
        String encodedKey = "FzyDcU0MQCq3mrVKt1v5Tg==";
        String decodedKey = uuidFromBase64(encodedKey);

        System.out.println("encoded key : " + encodedKey);
        System.out.println("decodedKey : " + decodedKey);
        Instant curr = Instant.now();
        System.out.println("current time :" + curr.toString());

    }

    private static String generateUniqueStreamKey() {
        // Generate a 5-digit random number
        int randomNumber = ThreadLocalRandom.current().nextInt(10000, 100000);

        // Convert the random number to a base64-encoded string
        byte[] bytes = ByteBuffer.allocate(Integer.BYTES).putInt(randomNumber).array();
        String streamKey = Base64.getEncoder().encodeToString(bytes).substring(0, 5);

        return streamKey;
    }

    private static String generateUniqueStreamKey2() {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789_/";
        System.out.println(characters.length());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            int index = ThreadLocalRandom.current().nextInt(characters.length());
            sb.append(characters.charAt(index));
        }
        return sb.toString();
    }


    private static String uuidToBase64(String str) {
        UUID uuid = UUID.fromString(str);
        ByteBuffer bb = ByteBuffer.wrap(new byte[16]);
        bb.putLong(uuid.getMostSignificantBits());
        bb.putLong(uuid.getLeastSignificantBits());
        return Base64.getEncoder().encodeToString(bb.array());
    }
    private static String uuidFromBase64(String str) {
        byte[] decodedKey = Base64.getDecoder().decode(str);
        ByteBuffer bb = ByteBuffer.wrap(decodedKey);
        UUID uuid = new UUID(bb.getLong(), bb.getLong());
        return uuid.toString();
    }
}
