/**
 * @author Muhammad Fadhlan Harits
 * @version 24 April 2021
 */

import java.util.ArrayList;

public class DatabaseInvoice {

    private static ArrayList<Invoice> INVOICE_DATABASE = new ArrayList<Invoice>();
    private static int lastId=0;
    /**
     * Akan mengembalikan database invoice sehingga returnnya INVOCIE_DATABASE
     * @return INVOICE DATABASE
     */
    public static ArrayList<Invoice> getInvoiceDatabase()
    {
        return INVOICE_DATABASE;
    }
    /**
     * Akan mengembalikan id terakhir sehingga returnnya lastId
     * @return last id
     */
    public static int getLastId()
    {
        return lastId;
    }
    /**
     * Akan mengembalikan invoice berdasarkan id sehingga returnnya objek i1
     * @param  id
     */
    public static Invoice getInvoiceById(int id)
    {
        Invoice i1 = null;
        for(Invoice i : INVOICE_DATABASE)
        {
            if(i.getId() == id)
            {
                i1 = i;
            }
        }
        if(i1==null)
        {
            return null;
        }
        return i1;
    }
    /**
     * Akan mengembalikan invoice berdasarkan id jobseeker sehingga returnnya arraylist
     * @param jobseekerId
     */
    public static ArrayList<Invoice> getInvoiceByJobseeker(int jobseekerId)
    {
        ArrayList<Invoice> gbjs = new ArrayList<Invoice>();
        for(Invoice i : INVOICE_DATABASE)
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
     * Akan menambah invoice sehingga parameternya invoice
     * @param invoice
     */
    public static boolean addInvoice(Invoice invoice)
    {
       for (int i=0;i<INVOICE_DATABASE.size();i++){
            if(INVOICE_DATABASE.get(i).getInvoiceStatus() == InvoiceStatus.OnGoing)
            {
                return false;
            }
        }

        INVOICE_DATABASE.add(invoice);
        lastId = invoice.getId();
        return true;
    }
    /**
     * Akan mengubah status invoice sehingga parameternya id dan invoiceStatus
     * @param id, invoiceStatus
     */
    public static boolean changeInvoiceStatus(int id, InvoiceStatus invoiceStatus)
    {
        boolean b = false;
       for (int i=0;i<INVOICE_DATABASE.size();i++)
       {
            if(INVOICE_DATABASE.get(i).getId() == id)
            {
                INVOICE_DATABASE.get(i).setInvoiceStatus(invoiceStatus);
                b = true;
            }
        }
        return b;
    }
    /**
     * Akan menghapus invoice sehingga parameternya id
     * @param id
     */
    public static boolean removeInvoice(int id)
    {
        boolean b = false;
        for(Invoice i : INVOICE_DATABASE)
        {
            if(i.getId() == id)
            {
                INVOICE_DATABASE.remove(i);
                b = true;
            }
        }
        return b;
    }
}
