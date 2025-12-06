package observer;

import user.abstraction.K2559495_User;

public class K2559495_UserObserver implements K2559495_Observer {
    private K2559495_User user;

    public K2559495_UserObserver(K2559495_User user) {
        this.user = user;
    }

    @Override
    public void update(String message) {
        System.out.println("Notification for " + user.getName() + ": " + message);
    }
}