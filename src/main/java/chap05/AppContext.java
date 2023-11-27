package chap05;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(basePackages = {"chap05"})
//@ComponentScan(basePackages = {"chap05"}, excludeFilters = @ComponentScan.Filter(type = FilterType.REGEX, pattern = "chap05\\..*ExcludedMemberDao"))
//@ComponentScan(basePackages = {"chap05"}, excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = { NoProduct.class }))
//@ComponentScan(basePackages = {"chap05"}, excludeFilters = @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, classes = ExcludedMemberDao.class))
//@ComponentScan(basePackages = {"chap05"}, excludeFilters = {
//	@ComponentScan.Filter(type = FilterType.ANNOTATION, classes = { NoProduct.class }),
//	@ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, classes = ExcludedMemberDao.class)
//})
public class AppContext
{
	@Bean
	public MemberPrinter memberPrinter()
	{
		return new MemberPrinter();
	}
	
	@Bean
	public MemberSummaryPrinter memberPrinterSeconds()
	{
		return new MemberSummaryPrinter();
	}
}
