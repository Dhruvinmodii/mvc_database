package mvccrud.model;

import org.springframework.jdbc.core.JdbcTemplate;

public class Userdao {
	
	private JdbcTemplate jdbc;
	
	public JdbcTemplate getJdbc() {
		return jdbc;
	}

	public void setJdbc(JdbcTemplate jdbc) {
		this.jdbc = jdbc;
	}

	public int save(User u)
	{
		String insert = "insert into master values ('"+u.getEmail()+"','"+u.getUsername()+"','"+u.getUserpass()+"')";
		return jdbc.update(insert);
	}

	
	
}


	
