package kodlama.io.hrms.business.concretes;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.hrms.business.abstracts.JobAdvertisementService;
import kodlama.io.hrms.business.constants.Messages;
import kodlama.io.hrms.core.utilities.business.BusinessRules;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.ErrorResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.core.utilities.results.SuccessDataResult;
import kodlama.io.hrms.core.utilities.results.SuccessResult;
import kodlama.io.hrms.dataAccess.abstracts.JobAdvertisementDao;
import kodlama.io.hrms.entities.concretes.JobAdvertisement;
import kodlama.io.hrms.entities.dtos.JobAdvertisementDetailDto;
import kodlama.io.hrms.entities.dtos.UpdateStatusDto;

@Service
public class JobAdvertisementManager implements JobAdvertisementService {

	private JobAdvertisementDao jobAdvertisementDao;
	@Autowired
	public JobAdvertisementManager(JobAdvertisementDao jobAdvertisementDao) {
		this.jobAdvertisementDao = jobAdvertisementDao;
	}
	
	@Override
	public Result add(JobAdvertisement jobAdvertisement) {
		jobAdvertisement.setDate(LocalDate.now());
		
		var result = BusinessRules.Run(tempValidationRules(jobAdvertisement));
		if(!result.isSuccess()) return result;
		
		jobAdvertisementDao.save(jobAdvertisement);
		return new SuccessResult(Messages.ADDED);
	}
	
	@Override
	public Result updateStatus(UpdateStatusDto updateStatusDto) {
		var result = jobAdvertisementDao.getById(updateStatusDto.getId());
		result.setStatus(updateStatusDto.isStatus());
		jobAdvertisementDao.save(result);
		return new SuccessResult(Messages.UPDATED);
	}

	@Override
	public DataResult<List<JobAdvertisementDetailDto>> getDetailsByStatus(boolean status) {
		var result = jobAdvertisementDao.getDetailsByStatus(status);
		return new SuccessDataResult<List<JobAdvertisementDetailDto>>(result,Messages.LISTED);
	}

	@Override
	public DataResult<List<JobAdvertisementDetailDto>> getActiveDetailsByDate(LocalDate date) {
		var result = jobAdvertisementDao.getActiveDetailsByDate(date);
		return new SuccessDataResult<List<JobAdvertisementDetailDto>>(result,Messages.LISTED);
	}

	@Override
	public DataResult<List<JobAdvertisementDetailDto>> getActiveDetailsByEmployerUserId(int employerUserId) {
		var result = jobAdvertisementDao.getActiveDetailsByEmployerUserId(employerUserId);
		return new SuccessDataResult<List<JobAdvertisementDetailDto>>(result,Messages.LISTED);
	}
	
	private Result tempValidationRules(JobAdvertisement jobAdvertisement) {
		if(jobAdvertisement.getCity().getId()==0) return new ErrorResult("Şehir boş olamaz");
		if(jobAdvertisement.getDate()==null) return new ErrorResult("Tarih boş olamaz");
		if(jobAdvertisement.getDescription()==null) return new ErrorResult("Açıklama boş olamaz");
		if(jobAdvertisement.getEmployer().getId()==0) return new ErrorResult("İşveren boş olamaz");
		if(jobAdvertisement.getJobPosition().getId()==0) return new ErrorResult("İş pozisyonu boş olamaz");
		if(jobAdvertisement.getNumberOfPositions()==0) return new ErrorResult("Açık pozisyonu adedi boş olamaz");

		return new SuccessResult();
	}
}