package logic;

public class Message_Binary_Bridge {

    public String convertMessageToBinary(String msg) {
        String output = "";
        String msgArr[] = msg.split("\\s");
        char c;
        int j;
        for (String str : msgArr) {
            for (int i = 0; i <= str.length(); i++) {
                if (i == str.length()) {
                    c = ' ';
                } else {
                    c = str.charAt(i);
                }
                j = (int) c;
                output += String.format("%8s", Integer.toBinaryString(j)).replace(' ', '0');
            }
            output += " ";
        }
        return output;
    }

    public String convertBinaryToMessage(String binaryMsg) {
        String output = "";
        String msgArr[] = binaryMsg.split("\\s");
        for (String str : msgArr) {
            for (int i = 0; i < str.length(); i += 8) {
                String subStr = str.substring(i, i + 8);
                int number = Integer.parseInt(subStr, 2);
                char c = (char) number;
                output += c;
            }
            output += " ";
        }
        return output;
    }

}