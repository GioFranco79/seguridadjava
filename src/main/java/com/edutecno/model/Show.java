package com.edutecno.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "shows")
public class Show {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "show_id")
	private Long showId;
	@Size(min = 1, message = "Title must be present")
	private String showTitle;
	@Size(min = 1, message = "Network must be present")
	private String showNetwork;
	private Long aux;
	@ManyToOne (fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	private Users creatorShow;	
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)	
	private Rating rating;
}
