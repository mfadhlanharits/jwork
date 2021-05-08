/**
 * @author Muhammad Fadhlan Harits
 * @version 8 Mei 2021
 */
public class InvoiceNotFoundException extends Exception
{
    private int invoice_error;
    /**
     * Konstruktur kelas invoicenotfoundexception
     * @param invoice_input
     */
    public InvoiceNotFoundException(int invoice_input)
    {
        super("Invoice ID: ");
        invoice_error = invoice_input;
    }
    /**
     * Method untuk menampilkan pesan sehingga returnnya getmessage
     */
    public String getMessage()
    {
        return super.getMessage() + invoice_error + " not found";
    }
}
