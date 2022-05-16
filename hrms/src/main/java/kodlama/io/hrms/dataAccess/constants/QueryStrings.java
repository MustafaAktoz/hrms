package kodlama.io.hrms.dataAccess.constants;

public class QueryStrings {
	public static final String JOB_ADVERTISEMENT_DETAIL_DTO_QUERY = "select new kodlama.io.hrms.entities.dtos.JobAdvertisementDetailDto(ja.id, e.companyName, jp.name, c.name, wty.name, wt.name,ja.description, ja.minSalary, ja.maxSalary, ja.numberOfPositions, ja.date, ja.applicationDeadline) from JobAdvertisement ja inner join ja.employer e inner join ja.jobPosition jp inner join ja.city c inner join ja.workingTime wt inner join ja.workingType wty ";
}