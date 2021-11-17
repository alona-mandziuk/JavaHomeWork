package com.pb.mandziuk.hw7;

public enum Size {
    XXS ("Kid size", "32"),
    XS ("Adult size", "34"),
    S ("Adult size", "36"),
    M ("Adult size", "38"),
    L("Adult size", "40");

    String Description;
    String Eurosize;



    Size(String Description, String Eurosize) {
        this.Description = Description;
    this.Eurosize = Eurosize;}

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getEurosize() {
        return Eurosize;
    }

    public void setEurosize(String eurosize) {
        Eurosize = eurosize;
    }
}





