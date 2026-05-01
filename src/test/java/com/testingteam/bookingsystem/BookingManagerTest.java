/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.testingteam.bookingsystem;


import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

/**
 *
 * @author DELL
 */
public class BookingManagerTest {
    

    @Test
    public void testHappyPath() {

    IPaymentGateway payment = mock(IPaymentGateway.class);
    INotificationService notification = mock(INotificationService.class);
    IEventRepository repo = mock(IEventRepository.class);

    when(repo.isSoldOut("E1")).thenReturn(false);
    when(payment.processPayment(100)).thenReturn("TX123");

    BookingManager manager = new BookingManager(payment, notification, repo);

    manager.book("E1", "U1", 100);

    verify(repo, times(1)).saveBooking("E1", "U1");
    verify(notification, times(1)).sendConfirmation(anyString());
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
