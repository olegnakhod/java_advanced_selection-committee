package academy.lgs.selection_committee.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import academy.lgs.selection_committee.domain.Certificate;

public interface CertificateRepository  extends JpaRepository<Certificate, Integer>{
}
