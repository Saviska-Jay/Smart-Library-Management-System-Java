package user.strategy;

public class K2559495_GuestFine implements K2559495_FineStrategy
{
    @Override
    public double calculateFine(int overdueDays) {
        return overdueDays * 100; // 100.00 LKR per day for guest users
    }
}