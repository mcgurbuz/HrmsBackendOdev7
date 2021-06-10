package kodlamaio.hrms.api.controllers;

import java.util.HashMap;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.UserService;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.User;
import kodlamaio.hrms.core.utilities.results.ErrorDataResult;

@RestController
@RequestMapping("/api/usercontroller")
public class UserController {
	
	private UserService Userservice;

	
	@Autowired
	public UserController(UserService userservice) {
		super();
		Userservice = userservice;
	}
	
	@PostMapping("/addUser")
	public Result addUser(@Valid @RequestBody User user) {
		
		return this.Userservice.addUser(user);
		
	}
	
	//Global exeption handler denen bir şey var. Metodun önüne koyarız.Bütün operasyonların önünde çalışan bir yapıdır.
	//Bütün fonksiyonlara Try catch yazmak yerine bir tane try catch yazarım bütün operasyonları oraya yönlendiririm.
				
	//Bütün classların temeli objecttir.Base olarak objecttir.Ne döneceğini bilmiyorum ben object dönecek diyorum
	//ErrorDataResult<Object>
	//Hangi alanda hata oldu ve hata ne ? Email alanında hata oldu email null örneğin.
	//Map yapısıyla bunu yapacağım
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
