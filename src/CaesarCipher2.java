public class CaesarCipher2 {
    private String alphabet;
    private String shiftedAlphabet1;
    private String shiftedAlphabet2;
    private int key1, key2;
    public CaesarCipher2(int key1, int key2){
        this.alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        this.key1 = key1;
        this.key2 = key2;
        this.shiftedAlphabet1 = this.alphabet.substring(key1) + this.alphabet.substring(0, key1);
        this.shiftedAlphabet2 = this.alphabet.substring(key2) + this.alphabet.substring(0, key2);
    }
    public String encrypt(String input){
        StringBuilder encrypted = new StringBuilder(input);
        char originalChar, newChar;
        int alphabetIdx;
        for(int i = 0; i < input.length(); i++){
            originalChar = Character.toUpperCase(input.charAt(i));
            if(this.alphabet.indexOf(originalChar) == -1){
                continue;
            }
            if(i % 2 == 0){
                alphabetIdx = this.shiftedAlphabet1.indexOf(originalChar);
            } else {
                alphabetIdx = this.shiftedAlphabet2.indexOf(originalChar);
            }
            newChar = this.alphabet.charAt(alphabetIdx);
            encrypted.setCharAt(i, newChar);
        }
        return encrypted.toString();
    }
    public String decrypt(String input){
        StringBuilder decrypted = new StringBuilder(input);
        char currentChar;
        int alphabetIdx;
        for(int i = 0; i < input.length(); i++){
            currentChar = Character.toUpperCase(input.charAt(i));
            if(i % 2 == 0){
                alphabetIdx = this.shiftedAlphabet1.indexOf(currentChar);
            } else {
                alphabetIdx = this.shiftedAlphabet2.indexOf(currentChar);
            }
            if(alphabetIdx == -1){
                continue;
            }
            decrypted.setCharAt(i, this.alphabet.charAt(alphabetIdx));
        }
        return decrypted.toString();
    }
}
