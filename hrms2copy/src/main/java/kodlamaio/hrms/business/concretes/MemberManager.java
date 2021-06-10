package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.MemberService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.MemberDao;
import kodlamaio.hrms.entities.concretes.Member;


@Service
public class MemberManager implements MemberService {

	
	private MemberDao memberDao;
	
	@Autowired
	public MemberManager(MemberDao memberDao) {
		super();
		this.memberDao = memberDao;
	}


	@Override
	public DataResult<List<Member>> getAllJobSeekers() {
		
		return new SuccessDataResult<List<Member>>(this.memberDao.getAllJobSeekers(), "İş arayanlar listelendi.");
	}


	@Override
	public Result addMember(Member Member) {
		
		this.memberDao.save(Member);
		return new SuccessResult("İş arayan eklendi...");
	}
	
	

}
