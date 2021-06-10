package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Position;

public interface PositionService {
	
	
	DataResult<List<Position>> getAllpositions();
	
	Result addPositions(Position position);//Sistem genel iş pozisyonlarını eklemek istiyor.

}
