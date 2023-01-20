package es.cifpcm.vidicdaliborkamiali.dao;

import es.cifpcm.vidicdaliborkamiali.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<Users, Integer> {
}