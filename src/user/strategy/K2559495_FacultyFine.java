package user.strategy;

public class K2559495_FacultyFine implements K2559495_FineStrategy
{
    @Override
    public double calculateFine(int overdueDays) {
        return overdueDays * 20; // 20.00 LKR per day for faculty members
    }
}