/**
 * @author Muhammad Fadhlan Harits
 * @version 8 Mei 2021
 */
public class OngoingInvoiceAlreadyExistsException extends Exception
{
    private Invoice invoice_error;
    /**
     * Konstruktur kelas ongoinginvoicealreadyexistsexception
     * @param invoice_input
     */
    public OngoingInvoiceAlreadyExistsException(Invoice invoice_input)
    {
        super("Ongoing Invoice: ");
        invoice_error = invoice_input;
    }
    /**
     * Method untuk menampilkan pesan sehingga returnnya getmessage
     */
    public String getMessage()
    {
        return super.getMessage() + invoice_error.getInvoiceStatus() + " already exists";
    }
}
