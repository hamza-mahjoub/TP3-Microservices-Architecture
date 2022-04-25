package com.example.forecast.models;

public class Product {
    public String  Series_reference;
    public String  Period;
    public String   Data_value;
    public String  STATUS;
    public String  UNITS;
    public String  Subject;
    public String  Group;
    public String  Series_title;

    @Override
    public String toString() {
        return "product{" +
                "Series_reference='" + Series_reference + '\'' +
                ", Period='" + Period + '\'' +
                ", Data_value='" + Data_value + '\'' +
                ", STATUS='" + STATUS + '\'' +
                ", UNITS='" + UNITS + '\'' +
                ", Subject='" + Subject + '\'' +
                ", Group='" + Group + '\'' +
                ", Series_title='" + Series_title + '\'' +
                '}';
    }

    public Product() {

    }

    public Product(String series_reference, String period, String data_value, String STATUS, String UNITS, String subject, String group, String series_title) {
        Series_reference = series_reference;
        Period = period;
        Data_value = data_value;
        this.STATUS = STATUS;
        this.UNITS = UNITS;
        Subject = subject;
        Group = group;
        Series_title = series_title;
    }

    public String getSeries_reference() {
        return Series_reference;
    }

    public void setSeries_reference(String series_reference) {
        Series_reference = series_reference;
    }

    public String getPeriod() {
        return Period;
    }

    public void setPeriod(String period) {
        Period = period;
    }

    public String getData_value() {
        return Data_value;
    }

    public void setData_value(String data_value) {
        Data_value = data_value;
    }

    public String getSTATUS() {
        return STATUS;
    }

    public void setSTATUS(String STATUS) {
        this.STATUS = STATUS;
    }

    public String getUNITS() {
        return UNITS;
    }

    public void setUNITS(String UNITS) {
        this.UNITS = UNITS;
    }

    public String getSubject() {
        return Subject;
    }

    public void setSubject(String subject) {
        Subject = subject;
    }

    public String getGroup() {
        return Group;
    }

    public void setGroup(String group) {
        Group = group;
    }

    public String getSeries_title() {
        return Series_title;
    }

    public void setSeries_title_1(String series_title) {
        Series_title = series_title;
    }
}
