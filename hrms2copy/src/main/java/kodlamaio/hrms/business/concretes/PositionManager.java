package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.PositionService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.PositionDao;
import kodlamaio.hrms.entities.concretes.Position;


@Service
public class PositionManager implements PositionService{

	private PositionDao positionDao;
	
	@Autowired
	public PositionManager(PositionDao positionDao) {
		super();
		this.positionDao = positionDao;
	}

	@Override
	public DataResult<List<Position>> getAllpositions() {
		
		return new SuccessDataResult<List<Position>>(this.positionDao.findAll(),"Pozisyonlarımız....");
	}

	@Override
	public Result addPositions(Position position) {
		this.positionDao.save(position); //Pozisyonu save ile kaydettim.
		return new SuccessResult("Pozisyon başarılı bir şekilde eklenmiştir...");
	}

}
