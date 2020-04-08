package AccntInterface;

import java.util.List;

public interface AccountInterface {
	public int CreateAccount(String name, double balance);
	public double Deposit(double amount,String id);
	public double Withdraw(double amount,String id);
	public List<Transactions>trasaction(String userId);
}
