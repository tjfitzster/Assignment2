package models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import play.db.jpa.Model;
import models.Assessment;

@Entity
public class Assessmentlist extends Model
{
    public  String client;
    @OneToMany(cascade = CascadeType.ALL)
    public List<Assessment> assessments = new ArrayList<Assessment>();
    public int age;
    public int BMI = 0;
    public Assessmentlist(String client, int age)
    {
        this.client = client;
        this.age = age;
    }

    public String CalculateBMI()
    {
        return "public/images/userIcon.png" ;
    }
    public int getBMI()
    {
        this.BMI = 33;
        return this.BMI;
    }

    public String getBMIImageString()
    {

        if (this.BMI < 16 )
        {
            //"SEVERELY UNDERWEIGHT"
            return "public/images/emergency_underweight.png" ;
        }
        else if ((this.BMI >= 16) && (BMI < 18.5)) {
            //"UNDERWEIGHT"
            return "public/images/doctor.png" ;
        }
        else if ((this.BMI >= 18.5) && (BMI < 25)) {
            // "NORMAL"
            return "public/images/healthy.png" ;
        }
        else if ((this.BMI >= 25) && (BMI < 30)) {
            // "OVERWEIGHT"
            return "public/images/doctor.png" ;
        }
        else if ((this.BMI >= 30) && (BMI < 35)) {
            //"MODERATELY OBESE"
            return "public/images/emergency_underweight.png" ;
        }
        else
            return "public/images/deathIcon.png" ;
        // "SEVERELY OBESE"

    }

    public String getBMIString()
    {
        if (BMI < 16 )
        {
            return "SEVERELY UNDERWEIGHT" ;
        }
        else if ((BMI >= 16) && (BMI < 18.5)) {

            return "UNDERWEIGHT" ;
        }
        else if ((BMI >= 18.5) && (BMI < 25)) {

            return "NORMAL" ;
        }
        else if ((BMI >= 25) && (BMI < 30)) {

            return "OVERWEIGHT" ;
        }
        else if ((BMI >= 30) && (BMI < 35)) {

            return "MODERATELY OBESE" ;
        }
        else
            return "SEVERELY OBESE" ;


    }

}