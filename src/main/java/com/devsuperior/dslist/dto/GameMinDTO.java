package com.devsuperior.dslist.dto;

import com.devsuperior.dslist.entities.Game;
import com.devsuperior.dslist.projections.GameMinProjection;


/*Para mostrar um listagem dos games com uma projeção somente dos dados que queremos, criamos a classe
 * DTO, onde antes de mostrar os dados detalhados do objeto game, mostramos uma lista de pre-visualização
 * com os dados que queremos. O que faz com que economize tráfego na API, pois não mostra logo de cara
 * todos os dados.*/
public class GameMinDTO {
/*DTO (Data Transfer Object) é um padrão de software voltado para a transferência de dados entre as camadas
 * de uma aplicação. Ele consiste basicamente no entendimento de como as informações trafegam dentro de um
 * sistema.
 */
	
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
	
	public GameMinDTO(GameMinProjection projection) {
		id = projection.getId();
		title = projection.getTitle();
		year = projection.getYear();
		imgUrl = projection.getImgUrl();
		shortDescription = projection.getShortDescription();
	}
	
	//Só precisamos de Getters no DTO
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
