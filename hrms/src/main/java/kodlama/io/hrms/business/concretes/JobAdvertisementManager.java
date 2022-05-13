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
import kodlama.io.hrms.entities.dtos.JobAdvertisementDto;
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
	public DataResult<List<JobAdvertisementDto>> getDetailsByStatus(boolean status) {
		var result = jobAdvertisementDao.getDetailsByStatus(status);
		return new SuccessDataResult<List<JobAdvertisementDto>>(result,Messages.LISTED);
	}

	@Override
	public DataResult<List<JobAdvertisementDto>> getActiveDetailsByDate(LocalDate date) {
		var result = jobAdvertisementDao.getActiveDetailsByDate(date);
		return new SuccessDataResult<List<JobAdvertisementDto>>(result,Messages.LISTED);
	}

	@Override
	public DataResult<List<JobAdvertisementDto>> getActiveDetailsByEmployerUserId(int employerUserId) {
		var result = jobAdvertisementDao.getActiveDetailsByEmployerUserId(employerUserId);
		return new SuccessDataResult<List<JobAdvertisementDto>>(result,Messages.LISTED);
	}

	@Override
	public DataResult<List<JobAdvertisementDto>> getDetails() {
		var result = jobAdvertisementDao.getDetails();
		return new SuccessDataResult<List<JobAdvertisementDto>>(result,Messages.LISTED);
	}

	@Override
	public DataResult<List<JobAdvertisement>> getAll() {
		var result = jobAdvertisementDao.findAll();
		return new SuccessDataResult<List<JobAdvertisement>>(result,Messages.LISTED);
	}

	@Override
	public DataResult<JobAdvertisement> getById(int id) {
		var result = jobAdvertisementDao.getById(id);
		return new SuccessDataResult<JobAdvertisement>(result,Messages.GETED);
	}
}