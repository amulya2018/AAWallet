package AccntImplementation;
import AccntInterface.AccountInterface;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;

import AccntBean.Transactions;
import AccntBean.Account;

public class AccountImpl implements AccountInterface{
	private org.springframework.jdbc.core.JdbcTemplate jdbcTemplate;
	

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public int CreateAccount(String userName, double balance) {
		
		String sql1="select max(userId) from accounts";
		List<String> list;
		list=jdbcTemplate.query(sql1,new ResultSetExtractor<List<String>>(){  
		    public List<String> extractData(ResultSet result)
		    		List<String> list=new ArrayList<String>();  
		    		while(rs.next()){  
		    			String maxAccountId=rs.getString(1);
		        return list;  
		        } } 
		    });  
		String userId=list.get(0);
		String sql="insert into accounts values('"+userName+"','"+userId+"',"+balance+")";
		return jdbcTemplate.update(sql);
	}

	public double Withdraw(double amount,String userId) {
		double current=0;
		String sql="select	* from accounts where userId=?";
		if(result.getAccount_Balance()>amount)
		{
		 current=result.getAccount_Balance()-amount;
		}
		return current;
	}

	public double Deposit(double amount,String userId) {
		double current=0;
		String sql="select	* from accounts where userId=?";
		current=result.getAccount_Balance()+amount;
		String transtype="dp";
		return current;
	}

	public List<Transactions> trasaction(String userId) {
		String sql="Select * from transaction where userId='"+userId+"'";
		List<Transactions> transactions=jdbcTemplate.query(sql,new BeanPropertyRowMapper(Transactions.class));
		return transactions;
	}
		
}