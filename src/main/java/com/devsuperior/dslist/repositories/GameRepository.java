package com.devsuperior.dslist.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.devsuperior.dslist.entities.Game;
import com.devsuperior.dslist.projections.GameMinProjection;

//fazer uma consulta no banco de dados para buscar os games que estão lá e devolver numa API

/*instancia um GameMinDTO a partir de um objeto Game, copiando os dados do game para o DTO.
* Vou criar um repository, que é um objeto de acesso a dados, que faz a consluta no banco,
* traz os games, devolve para uma classe de service e esse sevice devole o DTO equivalente
* para o controlador*/
/*Repository --> objeto responsável por fazer consultas ao banco de dados,
* utilizando um componente do Spring, que é o JpaRepository*/
													 //ID e o tipo
public interface GameRepository extends JpaRepository<Game, Long>{
	//Consulta SQL customizada no Spring Data JPA
	/*Anotation para usar o SQL puro.  Só que quando usamos nativeQuery e o resultado tem que ser uma interface
	 * que no Spring chamamos de projection
	 */
	@Query(nativeQuery = true, value = """
			SELECT tb_game.id, tb_game.title, tb_game.game_year AS gameYear, tb_game.img_url AS imgUrl,
			tb_game.short_description AS shortDescription, tb_belonging.position
			FROM tb_game
			INNER JOIN tb_belonging ON tb_game.id = tb_belonging.game_id
			WHERE tb_belonging.list_id = :listId
			ORDER BY tb_belonging.position
				""")
	List<GameMinProjection> searchByList(Long listId);

}
