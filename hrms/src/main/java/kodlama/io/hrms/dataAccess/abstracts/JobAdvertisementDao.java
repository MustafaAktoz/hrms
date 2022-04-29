package kodlama.io.hrms.dataAccess.abstracts;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import kodlama.io.hrms.dataAccess.constants.QueryStrings;
import kodlama.io.hrms.entities.concretes.JobAdvertisement;
import kodlama.io.hrms.entities.dtos.JobAdvertisementDetailDto;

public interface JobAdvertisementDao extends JpaRepository<JobAdvertisement, Integer>{
	@Query(QueryStrings.JOB_ADVERTISEMENT_DETAIL_DTO_QUERY + "where ja.status =:status")
	List<JobAdvertisementDetailDto> getDetailsByStatus(boolean status);
	
	@Query(QueryStrings.JOB_ADVERTISEMENT_DETAIL_DTO_QUERY + "where ja.status = true and ja.date =:date")
	List<JobAdvertisementDetailDto> getActiveDetailsByDate(LocalDate date);
	
	@Query(QueryStrings.JOB_ADVERTISEMENT_DETAIL_DTO_QUERY + "where ja.status = true and ja.employer.id =:employerUserId")
	List<JobAdvertisementDetailDto> getActiveDetailsByEmployerUserId(int employerUserId);
}
