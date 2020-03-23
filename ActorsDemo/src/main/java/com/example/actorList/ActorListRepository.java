package com.example.actorList;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActorListRepository extends JpaRepository<Actor, Long>{
	
	// 18 methods are inherited from JpaRepository interface
	
	public List<Actor> findActorsByWatcher(String watcher);

}
