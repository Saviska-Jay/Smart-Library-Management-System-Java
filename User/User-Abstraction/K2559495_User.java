import java.util.ArrayList;
import java.util.List;

public abstract class K2559495_User
{
    private final String userId;
    private String name;
    private String email;
    private String contactNumber;
    private List<String> borrowedBooksHistory = new ArrayList<>();
    private K2559495_FineStrategy fineStrategy;

    public K2559495_User(String userId, String name, String email, String contactNumber, K2559495_FineStrategy fineStrategy)
    {
        this.userId = userId;
        this.name = name;
        this.email = email;
        this.contactNumber = contactNumber;
        this.fineStrategy = fineStrategy;
    }
}