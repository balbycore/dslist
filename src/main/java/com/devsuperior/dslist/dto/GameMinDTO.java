package com.devsuperior.dslist.dto;

import com.devsuperior.dslist.entities.Game;


/*Para mostrar um listagem dos games com uma projeção somente dos dados que queremos criamos a classe
 * DTO, onde antes de mostrar os dados detalhados do objeto game, mostramos uma lista de pre-visualização
 * com os dados que queremos. O que faz com que economize tráfego na API, pois não mostra logo de cara
 * todos os dados.*/
public class GameMinDTO {
	
	private Long id;
	private String title;
	private Integer year;
	private String imgUrl;
	private String shortDescription;
	
	public GameMinDTO() {
	}
	
	public GameMinDTO(Game entity) {
		id = entity.getId();
		title = entity.getTitle();
		year = entity.getYear();
		imgUrl = entity.getImgUrl();
		shortDescription = entity.getShortDescription();
	}
	
	//Só precisamos de Geters no DTO
	public Long getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public Integer getYear() {
		return year;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public String getShortDescription() {
		return shortDescription;
	}
	
	
}
