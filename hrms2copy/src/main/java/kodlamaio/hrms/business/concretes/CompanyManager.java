package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.CompanyService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.CompanyDao;
import kodlamaio.hrms.entities.concretes.Company;


@Service
public class CompanyManager  implements CompanyService{

	private CompanyDao campanyDao;
	

	@Autowired
	public CompanyManager(CompanyDao campanyDao) {
		super();
		this.campanyDao = campanyDao;
	}

	@Override
	public DataResult<List<Company>> getAllCompany() {
		
		return new SuccessDataResult<List<Company>>(this.campanyDao.findAll(),"Sistemimizdeki tüm şirketler listelendi...");
	}

	@Override
	public Result addCompany(Company company) {
		
		this.campanyDao.save(company);
		return new SuccessResult("Şirketler başarılı bir şekilde eklendi...");
	}

}
