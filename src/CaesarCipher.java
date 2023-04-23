public class CaesarCipher {
    private String alphabet;
    private String shiftedAlphabet;
    private int mainKey;
    public CaesarCipher(int key){
        this.alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        this.shiftedAlphabet = this.alphabet.substring(key) + this.alphabet.substring(0, key);
    }
    public String encrypt(String input){
        StringBuilder encrypted = new StringBuilder(input);
        for(int i = 0; i < encrypted.length(); i++){
            int alphabetIdx = this.shiftedAlphabet.indexOf(Character.toUpperCase(input.charAt(i)));
            if(alphabetIdx == -1){
                continue;
            }
            char changed = this.alphabet.charAt(alphabetIdx);
            if(Character.isLowerCase(input.charAt(i))){
                encrypted.setCharAt(i, Character.toLowerCase(changed));
            } else {
                encrypted.setCharAt(i, changed);
            }
        }
        return encrypted.toString();
    }
    public String decrypt(String input){
        int key = 0;
        this.mainKey = key;
        CaesarCipher cc = new CaesarCipher(26 - this.mainKey);
        String decrypted = cc.encrypt(input);
        return decrypted;
    }
}
