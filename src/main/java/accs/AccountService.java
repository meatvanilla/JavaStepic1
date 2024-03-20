package accs;

import java.util.HashMap;
import java.util.Map;

public class AccountService {
    private final Map<String, String> accounts = new HashMap<>();

    public void addAccount(String login, String password) {
        accounts.put(login, password);
    }

    public boolean containsAccount(String login, String password) {
        return accounts.containsKey(login) && accounts.get(login).equals(password);
    }
}