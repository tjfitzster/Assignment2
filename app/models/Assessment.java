package models;

import javax.persistence.Entity;

import play.db.jpa.Model;

@Entity
public class Assessment extends Model
{
    public String Weight;
    public String Chest;
    public int Thigh;
    public String UpperArm;
    public String Waist;
    public int Hips;

    public Assessment(String Weight, String Chest, int Thigh, String UpperArm, String Waist, int Hips)
    {
        this.Weight = Weight;
        this.Chest = Chest;
        this.Thigh = Thigh;
        this.UpperArm = UpperArm;
        this.Waist = Waist;
        this.Hips = Hips;
    }
}
