package academy.lgs.selection_committee.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import academy.lgs.selection_committee.domain.Certificate;

@Repository
public interface CertificateRepository extends JpaRepository<Certificate, Integer>{

}
