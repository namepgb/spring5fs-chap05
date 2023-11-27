package chap05;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class MemberRegisterService
{
	@Autowired
	private MemberDao memberDao;
	
	public MemberRegisterService()
	{
	
	}
	
	public MemberRegisterService(MemberDao memberDao)
	{
		this.memberDao = memberDao;
	}
	
	public Long regist(RegisterRequest req)
	{
		Member member = memberDao.selectByEmail(req.getEmail());
		if (null != member)
			throw new RuntimeException(req.getEmail());
		member = new Member(req.getEmail(), req.getPassword(), req.getName(), LocalDateTime.now());
		memberDao.insert(member);
		return member.getId();
		
	}
}
