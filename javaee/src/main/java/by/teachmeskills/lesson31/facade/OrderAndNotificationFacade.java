package by.teachmeskills.lesson31.facade;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class OrderAndNotificationFacade {

    private final OrderService orderService;

    private final NotificationService notificationService;

    public void makeOrder() {
        orderService.createOrder();
        notificationService.sendNotification();
    }
}
