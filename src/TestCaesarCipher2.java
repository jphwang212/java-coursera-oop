import edu.duke.FileResource;

import java.io.File;

public class TestCaesarCipher2 {
    public void simpleTests(){
//        FileResource fr = new FileResource();
//        String fileString = fr.asString();
        String fileString = "Top ncmy qkff vi vguv vbg ycpx";
        CaesarCipher2 cc = new CaesarCipher2(17, 3);
        String encrypted = cc.encrypt(fileString);
        System.out.println("Encrypted = " + encrypted);
        String decrypted = cc.decrypt(encrypted);
        System.out.println("Decrypted = " + decrypted);
        String brokenCaesar = breakCaesarCipher(encrypted);
        System.out.println("Broken = " + brokenCaesar);
    }
    public String breakCaesarCipher(String input){
        String firstHalf = halfOfString(input, 0);
        String secondHalf = halfOfString(input, 1);
        int[] freqsFirst = countLetters(firstHalf);
        int[] freqsSecond = countLetters(secondHalf);
        int maxIdx1 = maxIndex(freqsFirst);
        int maxIdx2 = maxIndex(freqsSecond);
        int diffKey1 = 0;
        int diffKey2 = 0;
        if(maxIdx1 < 4){
            diffKey1 = 26 - (4 - maxIdx1);
        }
        if(maxIdx2 < 4){
            diffKey2 = 26 - (4 - maxIdx2);
        }
        CaesarCipher2 cc = new CaesarCipher2(26 - diffKey1, 26 - diffKey2);
        return cc.decrypt(input);
    }
    public String halfOfString(String message, int start){
        StringBuilder half = new StringBuilder();
        for(int i = start; i < message.length(); i += 2){
            half.append(message.charAt(i));
        }
        return half.toString();
    }
    public int[] countLetters(String s){
        String inputUpper = s.toUpperCase();
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        int[] freqs = new int[26];
        for(int i = 0; i < s.length(); i++){
            char ch = inputUpper.charAt(i);
            int dex = alphabet.indexOf(ch);
            if(dex != -1){
                freqs[dex] += 1;
            }
        }
        return freqs;

    }
    public int maxIndex(int[] freqs){
        int maxIdx = 0;
        for(int i = 0; i < freqs.length; i++){
            if(freqs[i] > freqs[maxIdx]){
                maxIdx = i;
            }
        }
        return maxIdx;
    }

    public static void main(String[] args) {
        TestCaesarCipher2 testInst = new TestCaesarCipher2();
        testInst.simpleTests();
    }
}
