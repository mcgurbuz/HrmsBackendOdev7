package kodlamaio.hrms.entities.concretes;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="companys")
@AllArgsConstructor
@NoArgsConstructor
public class Company {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="company_id")
	private int id;
	
	@Column(name="company_name")
	@NotNull
	@NotBlank
	private String companyName;
	
	@Column(name="phone_number")
	@NotNull
	@NotBlank
	private String phoneNumber;
	
	@NotNull
	@Column(name="position_id_fk")
	private int positionId;
	
	@Column(name="user_id")
	private int userId;
	
	@Column(name="website")
	@NotNull
	@NotBlank
	private String webSite;

	//Adam önden girer user'ını pozisyonu da bir tane coklu butondan alır. Frontend tarafında
	//User otomatik atanır. Ama illaki bir tane pozisyon lazım. User Onceki sayfada girdigi bilgiler 
	//Otomatik eklenecek adama. companys ile users left join. companys'deki bilgiler tutulacak hepsi
	//karsiligi yoksa users'da users'da o taraf tutulmasın. Yine members ile users yine left join. Sıfırdan
	//kodla olusacak bu tablolar. Ama join islemi nerenin uzerinden olacak ??? user'ın id'si ile company ve
	//member id leri üzerinden olacak zaten primarykey foreign key bu yuzden var.
	//SIFRE TEKRARI ???
	//TELEFON NUMARASI TC VALİSDASYONLARI NEREDE MESELA USERS'DA EMAIL ICIN VAR.

}
