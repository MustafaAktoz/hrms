package kodlama.io.hrms.business.concretes;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.hrms.business.abstracts.JobAdvertisementService;
import kodlama.io.hrms.business.constants.Messages;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.core.utilities.results.SuccessDataResult;
import kodlama.io.hrms.core.utilities.results.SuccessResult;
import kodlama.io.hrms.dataAccess.abstracts.JobAdvertisementDao;
import kodlama.io.hrms.entities.concretes.JobAdvertisement;
import kodlama.io.hrms.entities.dtos.JobAdvertisementDetailDto;
import kodlama.io.hrms.entities.dtos.UpdateConfirmationDto;
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
		jobAdvertisement.setConfirmation(false);
		
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
	public Result updateConfirmation(UpdateConfirmationDto updateConfirmationDto) {
		var result = jobAdvertisementDao.getById(updateConfirmationDto.getId());
		result.setConfirmation(updateConfirmationDto.isConfirmation());
		jobAdvertisementDao.save(result);
		return new SuccessResult(Messages.UPDATED);
	}

	@Override
	public DataResult<JobAdvertisement> getById(int id) {
		var result = jobAdvertisementDao.getById(id);
		return new SuccessDataResult<JobAdvertisement>(result,Messages.GETED);
	}


	@Override
	public DataResult<JobAdvertisementDetailDto> getDetailById(int id) {
		var result = jobAdvertisementDao.getDetailById(id);
		return new SuccessDataResult<JobAdvertisementDetailDto>(result,Messages.GETED);
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

	@Override
	public DataResult<List<JobAdvertisementDetailDto>> getDetails() {
		var result = jobAdvertisementDao.getDetails();
		return new SuccessDataResult<List<JobAdvertisementDetailDto>>(result,Messages.LISTED);
	}

	@Override
	public DataResult<List<JobAdvertisement>> getAll() {
		var result = jobAdvertisementDao.findAll();
		return new SuccessDataResult<List<JobAdvertisement>>(result,Messages.LISTED);
	}

	@Override
	public DataResult<List<JobAdvertisementDetailDto>> getActiveDetails() {
		var result = jobAdvertisementDao.getActiveDetails();
		return new SuccessDataResult<List<JobAdvertisementDetailDto>>(result,Messages.LISTED);
	}

	@Override
	public DataResult<List<JobAdvertisementDetailDto>> getPassiveDetails() {
		var result = jobAdvertisementDao.getPassiveDetails();
		return new SuccessDataResult<List<JobAdvertisementDetailDto>>(result,Messages.LISTED);
	}

	@Override
	public DataResult<List<JobAdvertisementDetailDto>> getUnconfirmedDetails() {
		var result = jobAdvertisementDao.getDetailsByConfirmation(false);
		return new SuccessDataResult<List<JobAdvertisementDetailDto>>(result,Messages.LISTED);
	}
}