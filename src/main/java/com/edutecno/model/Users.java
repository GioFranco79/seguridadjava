package com.edutecno.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "user")
public class Users {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "user_id")
	private Long userId;
	@Column(nullable = false, unique = true)
	@Size(min = 3, message = "Username must be present")
	private String username;
	@Column(nullable = false, unique = true)
	@Size(min = 8, message = "Email must be present")
	private String email;
	@Column(nullable = false)
	private String password;
	@Column(nullable = false)
	@Transient
	private String passwordConfirmation;
	@Enumerated(EnumType.STRING )
	private Role role;
	@OneToMany(mappedBy = "creatorShow", fetch = FetchType.LAZY)
	private List<Show> userShows;
	@OneToMany(mappedBy = "user", fetch = FetchType.LAZY)	
	private List<Rating> ratings;	
}
