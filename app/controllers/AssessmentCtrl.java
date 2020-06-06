package controllers;

import java.util.List;

import models.Assessmentlist;
import models.Assessment;
import play.Logger;
import play.mvc.Controller;

public class AssessmentCtrl extends Controller
{
    public static void index(Long id)
    {

        List<Assessmentlist> assessmentlists = Assessmentlist.findAll();
        Logger.info ("Assessment id = " + id);
        render("dashboard.html", assessmentlists);

    }

        public static void addAssessment(Long id, String Weight, String Chest, int Thigh, String UpperArm, String Waist, int Hips)
        {
            Assessment assessment = new Assessment(Weight, Chest, Thigh,UpperArm, Waist, Hips);
            Assessmentlist assessmentlist = Assessmentlist.findById(id);
            assessmentlist.assessments.add(assessment);
            assessmentlist.save();
            redirect ("/dashboard ");
        }

    public static void deleteAssessment (Long id, Long AssessmentId)
    {
        Assessmentlist assessmentlist = Assessmentlist.findById(id);
        Assessment assessment = Assessment.findById(AssessmentId);
        assessmentlist.assessments.remove(assessment);
        assessmentlist.save();
        assessment.delete();
        redirect ("/dashboard ");
    }
}
