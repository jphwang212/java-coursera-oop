import edu.duke.*;
import java.io.*;

public class TestCaesarCipher {
    public void simpleTests(){
        FileResource fr = new FileResource();
        String fileString = fr.asString();
        CaesarCipher cc = new CaesarCipher(18);
        String encrypted = cc.encrypt(fileString);
        System.out.println("Encrypted message = " + encrypted);
        String decrypted = cc.decrypt(encrypted);
        System.out.println("Decrypted = " + decrypted);
        String decryptBreak = breakCaesarCipher(encrypted);
        System.out.println("Break Caesar Cipher = " + decryptBreak);
    }
    public String breakCaesarCipher(String input){
        int[] freqs = countLetters(input);
        int maxIdx = maxIndex(freqs);
        int diffKey = maxIdx - 4;
        if(maxIdx < 4){
            diffKey = 26 - (4 - maxIdx);
        }
        CaesarCipher cc = new CaesarCipher(diffKey);
        String broken = cc.decrypt(input);
        return broken;
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
        TestCaesarCipher inst = new TestCaesarCipher();
        inst.simpleTests();
    }
}
