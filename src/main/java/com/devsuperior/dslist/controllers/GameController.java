package com.devsuperior.dslist.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.dslist.dto.GameDTO;
import com.devsuperior.dslist.dto.GameMinDTO;
import com.devsuperior.dslist.services.GameService;

/*Este controlador vai ser a porta de entrada do nosso back-end, ele que vai disponibilizar a nossa
 * API (O frontend chamar coisas por meio da API e o controlador que implementa essa API)*/

//Para configurar essa classe como sendo um controlador, usar a anotation @RestController

@RestController
//Configurar o caminho que vai ser respondido na API
@RequestMapping(value = "/games")
public class GameController {
	
	/*@Autowirde --> Injeta um service do controller, indica um ponto aonde a injeção
	 * automática deve ser aplicada. Esta pode ser usada em métodos, atributos e construtores.
	 */
	@Autowired
	private GameService gameService;
	
	@GetMapping(value = "/{id}")//Configura um parâmetro id nessa posição do path
	public GameDTO findById(@PathVariable Long id) {
		GameDTO result = gameService.findById(id);
		return result;
	}
	
	//End-point para buscar objetos, então o método é get
	@GetMapping
	public List<GameMinDTO> findAll() {
		List<GameMinDTO> result = gameService.findAll();
		return result;
	}
}
