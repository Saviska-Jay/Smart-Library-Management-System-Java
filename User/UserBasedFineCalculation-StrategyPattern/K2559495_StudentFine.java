public class K2559495_StudentFine implements K2559495_FineStrategy
{
    @Override
    public double calculateFine(int overdueDays) {
        return overdueDays * 50; // 50.00 LKR per day for students
    }
}