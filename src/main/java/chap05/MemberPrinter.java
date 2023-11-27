package chap05;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;

import java.time.format.DateTimeFormatter;

public class MemberPrinter
{
	private DateTimeFormatter dateTimeFormatter;
	
	public MemberPrinter()
	{
		dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy년 MM월 dd일");
	}
	
	public void print(Member member)
	{
		if (null == dateTimeFormatter)
		{
			System.out.printf("회원 정보: 아이디=%d, 이메일=%s, 이름=%s, 등록일=%tF\n",
			                  member.getId(),
			                  member.getEmail(),
			                  member.getName(),
			                  member.getRegisterDateTime());
		}
		else
		{
			System.out.printf("회원 정보: 아이디=%d, 이메일=%s, 이름=%s, 등록일=%s\n",
			                  member.getId(),
			                  member.getEmail(),
			                  member.getName(),
			                  dateTimeFormatter.format(member.getRegisterDateTime()));
		}
	}
	
//	@Autowired(required = false)
//	public void setDateTimeFormatter(DateTimeFormatter dateTimeFormatter)
//	{
//		System.out.println("@Autowired(required = false) invoked");
//		this.dateTimeFormatter = dateTimeFormatter;
//	}

//	@Autowired
//	public void setDateTimeFormatter(Optional<DateTimeFormatter> dateTimeFormatter)
//	{
//		if (dateTimeFormatter.isPresent())
//			this.dateTimeFormatter = dateTimeFormatter.get();
//		else
//			this.dateTimeFormatter = null;
//	}
	
	@Autowired
	public void setDateTimeFormatter(@Nullable DateTimeFormatter dateTimeFormatter)
	{
		this.dateTimeFormatter = dateTimeFormatter;
	}
}
