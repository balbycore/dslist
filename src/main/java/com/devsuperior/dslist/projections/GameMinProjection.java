package com.devsuperior.dslist.projections;

public interface GameMinProjection {

	//Colocar métodos get, correspondentes a minha consulta
	
	Long getId();
	String getTitle();
	Integer getYear();
	String getImgUrl();
	String getShortDescription();
	Integer getPosition();
}
