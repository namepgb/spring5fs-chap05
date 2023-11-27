package chap05;

import java.time.LocalDateTime;

public class Member
{
	private Long id;
	private String email;
	private String password;
	private String name;
	private LocalDateTime registerDateTime;
	
	public Member(String email,
	              String password,
	              String name,
	              LocalDateTime registerDateTime)
	{
		this.email = email;
		this.password = password;
		this.name = name;
		this.registerDateTime = registerDateTime;
	}
	
	public void changePassword(String oldPassword,
	                           String newPassword)
	{
		if (!this.password.equals(oldPassword))
			throw new RuntimeException();
		this.password = newPassword;
	}
	
	protected void setId(Long id)
	{
		this.id = id;
	}
	
	public Long getId()
	{
		return id;
	}
	
	public String getEmail()
	{
		return email;
	}
	
	public String getPassword()
	{
		return password;
	}
	
	public String getName()
	{
		return name;
	}
	
	public LocalDateTime getRegisterDateTime()
	{
		return registerDateTime;
	}
}
