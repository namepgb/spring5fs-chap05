package chap05;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("infoPrinter")
public class MemberInfoPrinter
{
	private MemberDao memberDao;
	private MemberPrinter memberPrinter;
	
	public void printMemberInfo(String email)
	{
		Member member = memberDao.selectByEmail(email);
		if (null == member)
			throw new NullPointerException();
		memberPrinter.print(member);
		System.out.println();
	}
	
	@Autowired
	public void setMemberDao(MemberDao memberDao)
	{
		this.memberDao = memberDao;
	}
	
	@Autowired
	@Qualifier("memberPrinter")
	public void setPrinter(MemberPrinter printer)
	{
		this.memberPrinter = printer;
	}
}
