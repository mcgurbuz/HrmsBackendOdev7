package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Company;

public interface CompanyService {
	
	
	DataResult<List<Company>> getAllCompany();
	
	Result addCompany(Company company);

}
