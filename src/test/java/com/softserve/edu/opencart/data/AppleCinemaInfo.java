package com.softserve.edu.opencart.data;

public class AppleCinemaInfo {

    private String textField;
    private String textAreaField;
    private String uploadFileValue;
    private String dateField;
    private String timeField;
    private String dateTimeField;
    private String quantityField;

    public AppleCinemaInfo(String textField, String textAreaField, String uploadFileValue, String dateField,
                           String timeField, String dateTimeField, String quantityField){
        this.textField = textField;
        this.textAreaField = textAreaField;
        this.uploadFileValue = uploadFileValue;
        this.dateField = dateField;
        this.timeField = timeField;
        this.dateTimeField = dateTimeField;
        this.quantityField = quantityField;
}

//setters

    public void setTextField(){
        this.textField = textField;
    }

    public void setTextAreaField(){
        this.textAreaField = textAreaField;
    }

    public void setUploadFileValue(){
        this.uploadFileValue = uploadFileValue;
    }

    public void setDateField(){
        this.dateField = dateField;
    }

    public void setTimeField(){
        this.timeField = timeField;
    }

    public void setDateTimeField(){
        this.dateTimeField = dateTimeField;
    }

    public void setQuantityField(){
        this.quantityField = quantityField;
    }


//getters

    public String getTextField(){
        return textField;
    }

    public String getTextAreaField(){
        return textAreaField;
    }

    public String getUploadFileValue(){
        return uploadFileValue;
    }

    public String getDateField(){
        return dateField;
    }

    public String getTimeField(){
        return timeField;
    }

    public String getDateTimeField(){
        return dateTimeField;
    }

    public String getQuantityField(){
        return quantityField;
    }

}


