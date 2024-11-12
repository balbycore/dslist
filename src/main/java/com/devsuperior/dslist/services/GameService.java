package com.devsuperior.dslist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.dslist.dto.GameDTO;
import com.devsuperior.dslist.dto.GameMinDTO;
import com.devsuperior.dslist.entities.Game;
import com.devsuperior.dslist.projections.GameMinProjection;
import com.devsuperior.dslist.repositories.GameRepository;


/*Service --> componente responsável por implementar lógica de negócio.
 * Orquestra todas as operações da lógica de negócio. Nesta lógica de negócio o service tem que
 * devolver um DTO, que vai ser o retorno de uma lista.*/

/*Necessário registrar essa classe como sendo um componente do sistema,
 * isso é um conceito importante no conceito de desenvolvimento de sistemas com frameworks.
 * Esses componentes tem que ser registrados, porque o framework vai gerenciar esse componentes,
 * pois ele que sabe registrar um componente, reaproveitar.
 * Para registrar um componente no Spring, é só colocar a anotation @Component,
 * ou o apelido da classe, no caso, @Service*/

@Service
public class GameService {
	
	/*Estou criando um componente service, que está a uma camada acima do repository,
	 * o GameService vai chamar o GameRepository que está na outra camada, e para chamar
	 * eu tenho que puxar uma instancia do GameReposutory*/
	//Vai injetar uma instancia do GameRepository dentro do GameService usando a anotation @Autowired
	@Autowired
	private GameRepository gameRepository;
	
	/*@Transactionl --> é uma boa prática para colocar em todo o método do seu service para que fique transacional
	 *  para que ele garanta que a opração com o banco de dados ela vai acontecer obedecendo ao princípio das
	 *  transações (atômica, consistente, isolada e durável). 
	 */
	@Transactional(readOnly = true) //readOnly = true --> não vai fazer nenhuma operação de escrita, fica mais rápido
	public GameDTO findById(Long id) {//Método para buscar por ID
		Game result = gameRepository.findById(id).get();
		return new GameDTO(result); //Converte para DTO
	}
	
	@Transactional(readOnly = true)
	public List<GameMinDTO> findAll() {
		//Consulta no banco de dados que consulta os games
		List<Game> result = gameRepository.findAll();
		/*gameRepository.findAll() --> é o método que já vem pronto, que por padrão já vai gerar
		 * uma consulta no banco de dados, para buscar todos os games. O resultado dessa consulta,
		 * que vai ser uma tabela de games, vai ser automaticamente convertida para uma lista de game
		   e o resultado cai na variável result*/
		
		//Cria uma lista equivalente, transformando todo mundo que for Game para GameMinDTO.
		/*Stream --> lib do Java que permite fazer operações com sequência de dados, por exemplo
		 * o .map -> transforma objetos de uma coisa para outra. Todo objeto x original que era Game
		 * vou transformar para num new GameMinDTO passando o x como argumento. E para volta esse stream
		 * para uma lista normal colocar o .toList.*/
		return result.stream().map(x -> new GameMinDTO(x)).toList();
	}
	
	@Transactional(readOnly = true)
	public List<GameMinDTO> findByList(Long listId) {
		List<GameMinProjection> result = gameRepository.searchByList(listId);
		return result.stream().map(x -> new GameMinDTO(x)).toList();
	}
}
