/**
 * @author Muhammad Fadhlan Harits
 * @version 20 Mei 2021
 */
package MuhammadFadhlanHarits.jwork.controller;

import MuhammadFadhlanHarits.jwork.*;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RequestMapping("/job")
@RestController

public class JobController
{
    /**
     * Akan mengembalikan database job sehingga returnnya getJobDatabase
     * @return getJobDatabase
     */
    @RequestMapping(value = "", method = RequestMethod.GET)
    public ArrayList<Job> getAllJob() {
        return DatabaseJob.getJobDatabase();
    }
    /**
     * Akan mengembalikan profesi berdasarkan id sehingga returnnya job
     * @param  id
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Job getJobById(@PathVariable int id)
    {
        Job job = null;
        try {
            job = DatabaseJob.getJobById(id);
        } catch (JobNotFoundException e) {
            e.getMessage();
            return null;
        }
        return job;
    }
    /**
     * Akan mengembalikan profesi berdasarkan id recruitersehingga returnnya arraylist job
     * @param recruiterId
     */
    @RequestMapping(value = "/recruiter/{recruiterId}", method = RequestMethod.GET)
    public ArrayList<Job> getJobByRecruiter(@PathVariable int recruiterId)
    {
        ArrayList<Job> gbr = new ArrayList<Job>();
        for(Job jj : DatabaseJob.getJobDatabase()){
            if(jj.getRecruiter().getID() == recruiterId){
                gbr.add(jj);
            }
        }
        if(gbr.isEmpty())
        {
            return null;
        }
        return gbr;
    }
    /**
     * Akan mengembalikan profesi berdasarkan kategori sehingga paramnya kategori
     * @param category
     */
    @RequestMapping(value = "/category/{category}", method = RequestMethod.GET)
    public ArrayList<Job> getByCategory(@PathVariable JobCategory category)
    {
        ArrayList<Job> gbc = new ArrayList<Job>();
        for(Job jj : DatabaseJob.getJobDatabase()){
            if(jj.getCategory().equals(category)){
                gbc.add(jj);
            }
        }
        if(gbc.isEmpty())
        {
            return null;
        }
        return gbc;
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public Job addJob(@RequestParam(value="name") String name,
                      @RequestParam(value="recruiterId") int recruiterId,
                      @RequestParam(value="fee") int fee,
                      @RequestParam(value = "category") JobCategory category) throws RecruiterNotFoundException
    {
        Job job = null;
        try {
            job = new Job(DatabaseJobseeker.getLastId()+1, name, DatabaseRecruiter.getRecruiterById(recruiterId), fee, category);
            DatabaseJob.addJob(job);
        } catch (RecruiterNotFoundException e) {
            e.getMessage();
        }
        return job;
    }
}
