package de.opm.dataset.events;

import de.opm.dataset.output.LogEntry;
import de.opm.template.activities.Activity;

/**
 * Event which specifies a Payment Ammount
 */
public class PaymentEvent extends Event{
    private double payment_ammount;

    protected PaymentEvent(Activity activity, Long timestamp, double payment_ammount){
        super(activity, timestamp);
        this.payment_ammount = payment_ammount;
    }

    @Override
    public LogEntry toLogEntry(int case_id){
        LogEntry entry = super.toLogEntry(case_id)
        .addPaymentAmmount(payment_ammount);

        return entry;
    }
}