package academy.lgs.selection_committee.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import academy.lgs.selection_committee.domain.Statment;

@Repository
public interface StatmentRepository extends JpaRepository<Statment, Integer>{

}
