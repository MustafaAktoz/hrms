package kodlama.io.hrms.dataAccess.abstracts;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import kodlama.io.hrms.dataAccess.constants.QueryStrings;
import kodlama.io.hrms.entities.concretes.JobAdvertisement;
import kodlama.io.hrms.entities.dtos.JobAdvertisementDetailDto;

public interface JobAdvertisementDao extends JpaRepository<JobAdvertisement, Integer>{

	@Query("From JobAdvertisement where id =:id")
	JobAdvertisement getById(int id);
	
	@Query(QueryStrings.JOB_ADVERTISEMENT_DETAIL_DTO_QUERY + "where ja.id =:id")
	JobAdvertisementDetailDto getDetailById(int id);
	
	@Query(QueryStrings.JOB_ADVERTISEMENT_DETAIL_DTO_QUERY)
	List<JobAdvertisementDetailDto> getDetails();

	@Query(QueryStrings.JOB_ADVERTISEMENT_DETAIL_DTO_QUERY + "where ja.status =:status")
	List<JobAdvertisementDetailDto> getDetailsByStatus(boolean status);
	
	@Query(QueryStrings.JOB_ADVERTISEMENT_DETAIL_DTO_QUERY + "where ja.confirmation =:confirmation")
	List<JobAdvertisementDetailDto> getDetailsByConfirmation(boolean confirmation);

	@Query(QueryStrings.JOB_ADVERTISEMENT_DETAIL_DTO_QUERY + "where ja.status = true and ja.confirmation = true")
	List<JobAdvertisementDetailDto> getActiveDetails();
	
	@Query(QueryStrings.JOB_ADVERTISEMENT_DETAIL_DTO_QUERY + "where ja.status = false or ja.confirmation = false")
	List<JobAdvertisementDetailDto> getPassiveDetails();
	
	@Query(QueryStrings.JOB_ADVERTISEMENT_DETAIL_DTO_QUERY + "where ja.status = true and ja.confirmation = true and ja.date =:date")
	List<JobAdvertisementDetailDto> getActiveDetailsByDate(LocalDate date);
	
	@Query(QueryStrings.JOB_ADVERTISEMENT_DETAIL_DTO_QUERY + "where ja.status = true and ja.confirmation = true and ja.employer.id =:employerUserId")
	List<JobAdvertisementDetailDto> getActiveDetailsByEmployerUserId(int employerUserId);
}