package academy.lgs.selection_committee.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import academy.lgs.selection_committee.domain.Statment;


public interface StatmentRepository extends JpaRepository<Statment, Integer>{

}
