/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.testingteam.bookingsystem;

/**
 *
 * @author DELL
 */
public class BookingManager {

    private IPaymentGateway payment;
    private INotificationService notification;
    private IEventRepository repo;

    public BookingManager(IPaymentGateway payment,
                          INotificationService notification,
                          IEventRepository repo) {
        this.payment = payment;
        this.notification = notification;
        this.repo = repo;
    }

    public void book(String eventId, String userId, double amount) {
        if (repo.isSoldOut(eventId)) return;

        payment.processPayment(amount);
        repo.saveBooking(eventId, userId);
        notification.sendConfirmation("Booking successful");
    }
}
