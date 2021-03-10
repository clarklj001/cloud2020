package de.killbuqs.springcloud.model;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class User implements Serializable{
	
	private Long id;
	
	private String name;
	
	private int age;

}
