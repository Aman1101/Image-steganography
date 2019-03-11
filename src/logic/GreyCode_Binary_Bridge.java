package logic;

public class GreyCode_Binary_Bridge {

    public String binaryToGrey(String binary) {
        String output = "";
        output += binary.charAt(0);
        for (int i = 1; i < 8; i++) {
            char a = binary.charAt(i - 1);
            char b = binary.charAt(i);

            output += xor(a, b);
        }
        return output;
    }

    public String binaryStringToGreyString(String binary) {
        String tempMsg[] = binary.split("\\s");
        String grey = "";
        for (String string : tempMsg) {
            for (int i = 0; i < string.length(); i += 8) {
                String subStr = string.substring(i, i + 8);
                grey += binaryToGrey(subStr);
            }
            grey += " ";
        }
        return grey;
    }
    
    public String greyStringToBinaryString(String grey) {
        String tempMsg[] = grey.split("\\s");
        String binary = "";
        for (String string : tempMsg) {
            for (int i = 0; i < string.length(); i += 8) {
                String subStr = string.substring(i, i + 8);
                binary += greyToBinary(subStr);
            }
            binary += " ";
        }
        return binary;
    }

    public String greyToBinary(String grey) {
        String output = "";
        output += grey.charAt(0);
        char a = grey.charAt(0);
        for (int i = 1; i < 8; i++) {
            char b = grey.charAt(i);
            a = xor(a, b);
            output += a;
        }
        return output;
    }

    public char xor(char a, char b) {
        char output;
        if ((a == '1' && b == '1') || (a == '0' && b == '0')) {
            output = '0';
        } else {
            output = '1';
        }
        return output;
    }
}
