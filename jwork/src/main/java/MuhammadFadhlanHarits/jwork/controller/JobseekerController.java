/**
 * @author Muhammad Fadhlan Harits
 * @version 20 Mei 2021
 */
package MuhammadFadhlanHarits.jwork.controller;

import MuhammadFadhlanHarits.jwork.*;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/jobseeker")
@RestController

public class JobseekerController
{

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Jobseeker getJobseekerById(@PathVariable int id) {
        Jobseeker jobseeker = null;
        try {
            jobseeker = DatabaseJobseeker.getJobseekerById(id);
        } catch (JobSeekerNotFoundException e) {
            e.getMessage();
            return null;
        }
        return jobseeker;
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public Jobseeker registerJobseeker(@RequestParam(value="name") String name,
                                  @RequestParam(value="email") String email,
                                  @RequestParam(value="password") String password)
    {
        Jobseeker jobseeker = new Jobseeker(DatabaseJobseeker.getLastId()+1, name, email, password);
        try {
            DatabaseJobseeker.addJobseeker(jobseeker);
        } catch (EmailAlreadyExistsException e) {
            e.getMessage();
            return null;
        }
        return jobseeker;
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public Jobseeker loginJobseeker(@RequestParam(value="email") String email,
                                       @RequestParam(value="password") String password)
    {
        Jobseeker jobseeker = DatabaseJobseeker.jobseekerLogin(email, password);
        return jobseeker;
    }
}
