package controllers;

import java.util.ArrayList;
import java.util.List;

import models.Assessmentlist;
import models.Member;
import models.Assessment;

import play.Logger;
import play.mvc.Controller;

public class Dashboard extends Controller
{
  public static void index() {
    Logger.info("Rendering Dashboard");

    List<Assessmentlist> assessmentlists = Assessmentlist.findAll();
    render ("dashboard.html", assessmentlists);
  }


  public static void deleteAssessment (Long id)
  {
    Logger.info("Deleting an Assessment");
    Member member = Accounts.getLoggedInMember();
    Assessment assessment = Assessment.findById(id);
    member.assessmentlist.remove(assessment);
    member.save();
    assessment.delete();
    redirect ("/dashboard");
  }
}