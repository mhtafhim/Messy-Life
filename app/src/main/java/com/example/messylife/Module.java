package com.example.messylife;
import android.app.Application;
import android.widget.ArrayAdapter;
import java.util.ArrayList;
public class Module extends Application {
    private ArrayList<String> garrList = new ArrayList<>();
    private ArrayAdapter<String> garrAdp;
    public String gvalue_usename;
    public String gvalue_email;

    public String getGvalue_usename() {
        return gvalue_usename;
    }

    public void setGvalue_usename(String gvalue_usename) {
        this.gvalue_usename = gvalue_usename;
    }

    public String getGvalue_email() {
        return gvalue_email;
    }

    public void setGvalue_email(String gvalue_email) {
        this.gvalue_email = gvalue_email;
    }


}
