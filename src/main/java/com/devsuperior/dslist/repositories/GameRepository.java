package com.devsuperior.dslist.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devsuperior.dslist.entities.Game;

//fazer uma consulta no banco de dados para buscar os games que estão lá e devolver numa API

/*instancia um GameMinDTO a partir de um objeto Game, copiando os dados do game para o DTO.
 * Vou criar um repository, que é um objeto de acesso a dados, que faz a consluta no banco,
 * traz os games, devolve para uma classe de service e esse sevice devole o DTO equivalente
 * para o controlador*/
/*Repository --> objeto responsável por fazer consultas ao banco de dados,
 * utilizando um componente do Spring, que é o JpaRepository*/
/*JpaRepository --> é um componente do Spring, que já tem todas as operações básicas prontas,
 * inclusive a busca por ID*/
													//ID e o tipo
public interface GameRepository extends JpaRepository<Game, Long>{

}
