package chap05;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ChangePasswordService
{
	@Autowired
	private MemberDao memberDao;
	
	public void changePassword(String email,
	                           String oldPassword,
	                           String newPassword)
	{
		Member member = memberDao.selectByEmail(email);
		if (null == member)
			throw new RuntimeException();
		member.changePassword(oldPassword, newPassword);
		memberDao.update(member);
	}
	
	@Deprecated
	public void setMemberDao(MemberDao memberDao)
	{
		this.memberDao = memberDao;
	}
}
