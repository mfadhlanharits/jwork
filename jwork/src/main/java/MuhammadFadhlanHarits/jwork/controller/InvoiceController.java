/**
 * @author Muhammad Fadhlan Harits
 * @version 22 Mei 2021
 */
package MuhammadFadhlanHarits.jwork.controller;

import MuhammadFadhlanHarits.jwork.*;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RequestMapping("/invoice")
@RestController

public class InvoiceController
{
    /**
     * Akan mengembalikan database invoice sehingga returnnya getInvoiceDatabase
     * @return getInvoiceDatabase
     */
    @RequestMapping(value = "", method = RequestMethod.GET)
    public ArrayList<Invoice> getAllInvoice()
    {
        return DatabaseInvoice.getInvoiceDatabase();
    }

    /**
     * akan mengembalikan invoice berdasarkan id
     * @param id
     * @return null
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Invoice getInvoiceById(@PathVariable int id) throws InvoiceNotFoundException
    {
        Invoice i1 = null;
        for(Invoice i : DatabaseInvoice.getInvoiceDatabase())
        {

            if(i.getId() == id)
            {
                i1 = i;
            }
        }
        if(i1==null)
        {
            InvoiceNotFoundException e = new InvoiceNotFoundException(id);
            System.out.println(e.getMessage());
        }
        return i1;
    }

    /**
     * Akan mengembalikan invoice berdasarkan id jobseeker sehingga returnnya arraylist
     * @param jobseekerId
     */
    @RequestMapping(value = "/jobseeker/{jobseekerId}", method = RequestMethod.GET)
    public ArrayList<Invoice> getInvoiceByJobseeker(@PathVariable int jobseekerId)
    {
        ArrayList<Invoice> gbjs = new ArrayList<Invoice>();
        for(Invoice i : DatabaseInvoice.getInvoiceDatabase())
        {
            if(i.getJobseeker().getID() == jobseekerId)
            {
                gbjs.add(i);
            }
        }
        if(gbjs.isEmpty())
        {
            return null;
        }
        return gbjs;
    }

    /**
     * Akan mengubah status invoice sehingga parameternya id dan invoiceStatus
     * @param id, invoiceStatus
     */
    @RequestMapping(value = "/invoiceStatus/{id}", method = RequestMethod.PUT)
    public Invoice changeInvoiceStatus(int id, InvoiceStatus invoiceStatus)
    {
        Invoice i1 = null;
        for(Invoice i : DatabaseInvoice.getInvoiceDatabase())
        {
            if(i.getId()==id)
            {
                i1.setInvoiceStatus(invoiceStatus);
            }
        }
        return i1;
    }

    /**
     * Akan menghapus invoice sehingga parameternya id
     * @param id
     */
    @RequestMapping(value = "/invoice/{id}", method = RequestMethod.DELETE)
    public boolean removeInvoice(int id) throws InvoiceNotFoundException
    {
        boolean b = false;
        for(Invoice i : DatabaseInvoice.getInvoiceDatabase())
        {
            if(i.getId() == id)
            {
                DatabaseInvoice.getInvoiceDatabase().remove(i);
                b = true;
            }
        }
        if(b==false)
        {
            InvoiceNotFoundException e = new InvoiceNotFoundException(id);
            System.out.println(e.getMessage());
        }
        return b;
    }

    /**
     * Akan menambah invoice sehingga parameter dan return invoice
     * @return bp1
     */
    @RequestMapping(value = "/createBankPayment", method = RequestMethod.POST)
    public Invoice addBankPayment(@RequestParam(value="jobIdList") ArrayList<Integer> jobIdList,
                                  @RequestParam(value="jobseekerId") int jobseekerId,
                                  @RequestParam(value="adminFee") int adminFee)
    {
        BankPayment bp1 = null;
        try {
            ArrayList<Job> jobs = new ArrayList<>();
            for(int id : jobIdList){
                Job job = DatabaseJob.getJobById(id);
                jobs.add(job);
            }
            bp1 = new BankPayment(DatabaseInvoice.getLastId()+1, jobs, DatabaseJobseekerPostgre.getJobseekerFromId(jobseekerId), adminFee);
            bp1.setTotalFee();
            DatabaseInvoice.addInvoice(bp1);
        } catch (OngoingInvoiceAlreadyExistsException e){
            System.out.println(e.getMessage());
        } catch (JobSeekerNotFoundException e){
            System.out.println(e.getMessage());
        } catch (JobNotFoundException e){
            System.out.println(e.getMessage());
        }

        return bp1;
    }

    /**
     * Akan menambah invoice sehingga parameter dan return invoice
     * @return ep1
     */
    @RequestMapping(value = "/createEWalletPaymentCode", method = RequestMethod.POST)
    public Invoice addEWalletPayment(@RequestParam(value="jobIdList") ArrayList<Integer> jobIdList,
                                  @RequestParam(value="jobseekerId") int jobseekerId,
                                  @RequestParam(value="referralCode") String referralCode)
    {
        EwalletPayment ep1 = null;

        try {
            ArrayList<Job> jobs = new ArrayList<>();
            for(int id : jobIdList){
                Job job = DatabaseJob.getJobById(id);
                jobs.add(job);
            }
            ep1 = new EwalletPayment(DatabaseInvoice.getLastId()+1, jobs, DatabaseJobseekerPostgre.getJobseekerFromId(jobseekerId), DatabaseBonusPostgre.getBonusByReferralCode(referralCode));
            ep1.setTotalFee();
            DatabaseInvoice.addInvoice(ep1);
        } catch (OngoingInvoiceAlreadyExistsException e){
            System.out.println(e.getMessage());
        } catch (JobSeekerNotFoundException e){
            System.out.println(e.getMessage());
        } catch (JobNotFoundException e){
            System.out.println(e.getMessage());
        }

        return ep1;
    }

    /**
     * Akan menambah invoice sehingga parameter dan return invoice
     * @return ep1
     */
    @RequestMapping(value = "/createEWalletPayment", method = RequestMethod.POST)
    public Invoice addEWalletPayment(@RequestParam(value="jobIdList") ArrayList<Integer> jobIdList,
                                     @RequestParam(value="jobseekerId") int jobseekerId)
    {
        EwalletPayment ep1 = null;

        try {
            ArrayList<Job> jobs = new ArrayList<>();
            for(int id : jobIdList){
                Job job = DatabaseJob.getJobById(id);
                jobs.add(job);
            }
            ep1 = new EwalletPayment(DatabaseInvoice.getLastId()+1, jobs, DatabaseJobseekerPostgre.getJobseekerFromId(jobseekerId));
            ep1.setTotalFee();
            DatabaseInvoice.addInvoice(ep1);
        } catch (OngoingInvoiceAlreadyExistsException e){
            System.out.println(e.getMessage());
        } catch (JobSeekerNotFoundException e){
            System.out.println(e.getMessage());
        } catch (JobNotFoundException e){
            System.out.println(e.getMessage());
        }

        return ep1;
    }
}