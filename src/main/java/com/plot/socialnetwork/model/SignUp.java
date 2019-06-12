package com.plot.socialnetwork.model;

import java.io.Serializable;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SignUp implements Serializable {

	@Size(min = 2, max = 50)
	private String firstName;

	@Size(min = 2, max = 50)
	private String lastName;

	@Size(min = 5, max = 50)
	private String userName;

	@NotNull
	@Size(min = 5, max = 50)
	private String password;

}
