package kodlamaio.hrms.api.controllers;

import java.util.HashMap;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import kodlamaio.hrms.business.abstracts.MemberService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorDataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Member;
import kodlamaio.hrms.entities.concretes.Position;

@RestController
@RequestMapping("api/members")
public class MemberController {
	
	private MemberService memberService;
	

	@Autowired
	public MemberController(MemberService memberService) {
		super();
		this.memberService = memberService;
	}


	@GetMapping("/getAllJobSeekers")
	public DataResult<List<Member>> getAllJobSeekers(){
		return this.memberService.getAllJobSeekers();
		
	}
	
	@PostMapping("/addMember")
	public Result addMember(@Valid @RequestBody Member Member) {
		
		return this.memberService.addMember(Member);
	}
	
	//Global exeption handler denen bir şey var. Metodun önüne koyarız.Bütün operasyonların önünde çalışan bir yapıdır.
		//Bütün fonksiyonlara Try catch yazmak yerine bir tane try catch yazarım bütün operasyonları oraya yönlendiririm.
			
		//Bütün classların temeli objecttir.Base olarak objecttir.Ne döneceğini bilmiyorum ben object dönecek diyorum
		//ErrorDataResult<Object>
		//Hangi alanda hata oldu ve hata ne ? Email alanında hata oldu email null örneğin.//Map yapısıyla bunu yapacağım
		//Sistemde bir hata oluşursa handleValidationExceptionu çağır demek hataları oraya parametre olarak geç dedim.
		
		@ExceptionHandler(MethodArgumentNotValidException.class)//Spring doğrulama hatalarını böyle geçiyor.
		@ResponseStatus(HttpStatus.BAD_REQUEST)
		public ErrorDataResult<Object> handleValidatonException(MethodArgumentNotValidException exceptions){
			Map<String,String> validationErrors = new HashMap<String,String>();
			for(FieldError fieldError:exceptions.getBindingResult().getFieldErrors()) {
				validationErrors.put(fieldError.getField(),fieldError.getDefaultMessage());
			}
			ErrorDataResult<Object> errors = new ErrorDataResult(validationErrors,"Doğrulama Hataları");
			return errors;
		}

}
