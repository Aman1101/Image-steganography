package words.library;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class WordLib {

    static ArrayList<String> coord0 = new ArrayList<>();
    static ArrayList<String> coord1 = new ArrayList<>();
    static ArrayList<String> coord2 = new ArrayList<>();
    static ArrayList<String> coord3 = new ArrayList<>();
    static ArrayList<String> coord4 = new ArrayList<>();
    static ArrayList<String> coord5 = new ArrayList<>();
    static ArrayList<String> coord6 = new ArrayList<>();
    static ArrayList<String> coord7 = new ArrayList<>();
    static ArrayList<String> coord8 = new ArrayList<>();
    static ArrayList<String> coord9 = new ArrayList<>();
    static ArrayList<ArrayList<String>> wordCoordList = new ArrayList<ArrayList<String>>();

    public WordLib() {
        loadWords();
        coord0.add(" ");
    }

    private void loadWords() {
        try {
            URL url = getClass().getResource("/words/library/words_lib.txt");
            File wordsFile = new File(url.toURI());
            FileInputStream fis = new FileInputStream(wordsFile);

            BufferedReader br = new BufferedReader(new InputStreamReader(fis));
            String s;
            String words = "";
            int counter = 0;
            while ((s = br.readLine()) != null) {
                switch (counter) {
                    case 0:
                        coord0.add(s);
                        break;
                    case 1:
                        coord1.add(s);
                        break;
                    case 2:
                        coord2.add(s);
                        break;
                    case 3:
                        coord3.add(s);
                        break;
                    case 4:
                        coord4.add(s);
                        break;
                    case 5:
                        coord5.add(s);
                        break;
                    case 6:
                        coord6.add(s);
                        break;
                    case 7:
                        coord7.add(s);
                        break;
                    case 8:
                        coord8.add(s);
                        break;
                    case 9:
                        coord9.add(s);
                        break;
                    default:
                        coord0.add(s);
                        counter = 0;
                }
                counter++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

//    public static ArrayList<ArrayList<String>> getLib() {
//        wordCoordList.add(coord0);
//        wordCoordList.add(coord1);
//        wordCoordList.add(coord2);
//        wordCoordList.add(coord3);
//        wordCoordList.add(coord4);
//        wordCoordList.add(coord5);
//        wordCoordList.add(coord6);
//        wordCoordList.add(coord7);
//        wordCoordList.add(coord8);
//        wordCoordList.add(coord9);
//        return wordCoordList;
//    }
    public String generateCoverMessage(ArrayList<Integer> xCoord, ArrayList<Integer> yCoord) {
        String output = "";
        char arr[];
        String digits;
        int x;
        for (int i = 0; i < xCoord.size(); i++) {
            x = xCoord.get(i);
            digits = convertToFourDigitVal(x);
            arr = digits.toCharArray();
            for (char c : arr) {
                output += fetchWordForDigit(c);
            }
            x = yCoord.get(i);
            digits = convertToFourDigitVal(x);
            arr = digits.toCharArray();
            for (char c : arr) {
                output += fetchWordForDigit(c);
            }
        }
        return output;
    }

    private String fetchWordForDigit(char c) {
        int size;
        int randomBit;
        String output;

        switch (c) {
            case '0':
                size = coord0.size();
                randomBit = (int) (Math.random() * size);
                output = coord0.get(randomBit);
                break;
            case '1':
                size = coord1.size();
                randomBit = (int) (Math.random() * size);
                output = coord1.get(randomBit);
                break;
            case '2':
                size = coord2.size();
                randomBit = (int) (Math.random() * size);
                output = coord2.get(randomBit);
                break;
            case '3':
                size = coord3.size();
                randomBit = (int) (Math.random() * size);
                output = coord3.get(randomBit);
                break;
            case '4':
                size = coord4.size();
                randomBit = (int) (Math.random() * size);
                output = coord4.get(randomBit);
                break;
            case '5':
                size = coord5.size();
                randomBit = (int) (Math.random() * size);
                output = coord5.get(randomBit);
                break;
            case '6':
                size = coord6.size();
                randomBit = (int) (Math.random() * size);
                output = coord6.get(randomBit);
                break;
            case '7':
                size = coord7.size();
                randomBit = (int) (Math.random() * size);
                output = coord7.get(randomBit);
                break;
            case '8':
                size = coord8.size();
                randomBit = (int) (Math.random() * size);
                output = coord8.get(randomBit);
                break;
            case '9':
                size = coord9.size();
                randomBit = (int) (Math.random() * size);
                output = coord9.get(randomBit);
                break;
            default:
                output = "-";
        }
        output += " ";
        return output;
    }

    private String convertToFourDigitVal(int i) {
        String output = String.format("%4s", i).replace(' ', '0');
        return output;
    }

    private int searchCoordOfWord(String word) {
        int coord;
        if (coord0.contains(word)) {
            coord = 0;
        } else if (coord1.contains(word)) {
            coord = 1;
        } else if (coord2.contains(word)) {
            coord = 2;
        } else if (coord3.contains(word)) {
            coord = 3;
        } else if (coord4.contains(word)) {
            coord = 4;
        } else if (coord5.contains(word)) {
            coord = 5;
        } else if (coord6.contains(word)) {
            coord = 6;
        } else if (coord7.contains(word)) {
            coord = 7;
        } else if (coord8.contains(word)) {
            coord = 8;
        } else if (coord9.contains(word)) {
            coord = 9;
        } else {
            coord = -1;
        }
        return coord;
    }

    public ArrayList<ArrayList<Integer>> decodeCoverMessage(String coverMessage) {
        ArrayList<ArrayList<Integer>> output = new ArrayList<>();
        ArrayList<Integer> x = new ArrayList<>();
        ArrayList<Integer> y = new ArrayList<>();
        StringTokenizer stringTokenizer = new StringTokenizer(coverMessage);
        int counter = 0;
        int coord, tempCoord;
        String tempCoordX = "";
        String tempCoordY = "";

        while (stringTokenizer.hasMoreTokens()) {
            String fragment = stringTokenizer.nextToken();
            coord = searchCoordOfWord(fragment);
            if (coord == -1) {
                return null;
            } else {
                if (counter < 4) {
                    tempCoordX += "" + coord;
                } else {
                    tempCoordY += "" + coord;
                }
            }
            if (counter == 3) {
                tempCoord = Integer.parseInt(tempCoordX);
                x.add(tempCoord);
                tempCoordX = "";
            }
            if (counter == 7) {
                tempCoord = Integer.parseInt(tempCoordY);
                y.add(tempCoord);
                tempCoordY = "";
            }
            counter++;
            if (counter == 8) {
                counter = 0;
            }
        }
        output.add(x);
        output.add(y);
        return output;
    }
}