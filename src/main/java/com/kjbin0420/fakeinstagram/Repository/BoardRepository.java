package com.kjbin0420.fakeinstagram.Repository;

import com.kjbin0420.fakeinstagram.Entity.Board.BoardData;
import org.springframework.data.repository.CrudRepository;

public interface BoardRepository extends CrudRepository<BoardData, Integer> {

}
