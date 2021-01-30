package org.imt.j2ee.microservices.Nourelayne.DAO;

import java.util.List;

import org.imt.j2ee.microservices.Nourelayne.Model.IBANCandidate;

public interface IBANDAO {

	public List<IBANCandidate> findAll();
    public IBANCandidate findById(int id);
    public IBANCandidate save(String IBANCandidateNumber);
}
