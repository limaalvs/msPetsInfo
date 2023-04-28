package br.com.fit.petsInfo.adapter.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "USER_INFO")
public class UserInfoEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private Long id;
	
	@Column(name = "USERNAME")
	private String username;
	
	@Column(name = "CPF")
	private String cpf;
	
	@Column(name = "ADDRESS")
	private String address;
	
	@Column(name = "REGISTRATION_DATE")
	private String registrationDate;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="fk_user_id", referencedColumnName = "id")
	private List<PetsListEntity> petsList;
}
