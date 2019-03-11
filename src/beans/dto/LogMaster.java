package beans.dto;

import java.util.ArrayList;
import java.util.Date;

public class LogMaster {
    private int sno;
    private byte[] inputImage;
    private byte[] encodedImage;
    private String secretMessage_Orignal;
    private String secretMessage_Rendered;
    private String paraphrase;
    private ArrayList<String> coordinates_xy;
    private Date dateCreated;

    public int getSno() {
        return sno;
    }

    public void setSno(int sno) {
        this.sno = sno;
    }

    public byte[] getInputImage() {
        return inputImage;
    }

    public void setInputImage(byte[] inputImage) {
        this.inputImage = inputImage;
    }

    public byte[] getEncodedImage() {
        return encodedImage;
    }

    public void setEncodedImage(byte[] encodedImage) {
        this.encodedImage = encodedImage;
    }

    public String getSecretMessage_Orignal() {
        return secretMessage_Orignal;
    }

    public void setSecretMessage_Orignal(String secretMessage_Orignal) {
        this.secretMessage_Orignal = secretMessage_Orignal;
    }

    public String getSecretMessage_Rendered() {
        return secretMessage_Rendered;
    }

    public void setSecretMessage_Rendered(String secretMessage_Rendered) {
        this.secretMessage_Rendered = secretMessage_Rendered;
    }

    public String getParaphrase() {
        return paraphrase;
    }

    public void setParaphrase(String paraphrase) {
        this.paraphrase = paraphrase;
    }

    public void setCoordinates_xy(ArrayList<String> coordinates_xy) {
        this.coordinates_xy = coordinates_xy;
    }

    public ArrayList<String> getCoordinates_xy() {
        return coordinates_xy;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }
    
}