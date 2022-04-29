package de.opm.template.activities;

/**
 * Used to determine if extra data is to be generated for each Event.
 * normal: no extra data
 * order: Order Ammount
 * shipment: Shipment Carrier and Shipment Ammount
 * payment: Payment Ammount
 */
public enum ActivityType {   
    normal,
    order,
    shipment,
    payment
}
