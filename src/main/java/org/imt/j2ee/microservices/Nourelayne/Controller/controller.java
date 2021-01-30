package org.imt.j2ee.microservices.Nourelayne.Controller;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import org.imt.j2ee.microservices.Nourelayne.DAO.IBANDAO;
import org.imt.j2ee.microservices.Nourelayne.Model.IBANCandidate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class controller {

	@Autowired
    private IBANDAO ibanDAO;

    @RequestMapping(value = "/IBANCandidates", method = RequestMethod.GET)

    public List<IBANCandidate> listeIBANCandidates() {
        return ibanDAO.findAll();
    }

    @GetMapping(value = "/IBANCandidates/{id}")
    public IBANCandidate afficherUnIBANCandidate(@PathVariable int id) {

        return ibanDAO.findById(id);
    }
    
    @GetMapping(value = "/checkIBAN/{IBANCandidateNumber}")
    public boolean checkIBANCandidate(@PathVariable String IBANCandidateNumber) {

        IBANCandidate IBANCandidateAdded =  ibanDAO.save(IBANCandidateNumber);
        
        return IBANCandidateAdded.getValide();
        
    }

    @PostMapping(value = "/IBANCandidates/{IBANCandidateNumber}")
    public ResponseEntity<Void> ajouterIBANCandidate(@PathVariable String IBANCandidateNumber) {

        IBANCandidate IBANCandidateAdded =  ibanDAO.save(IBANCandidateNumber);

        if (IBANCandidateAdded == null)
            return ResponseEntity.noContent().build();

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(IBANCandidateAdded.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }
    
    @GetMapping(value = "/IBANCandidates/ValideIBANs")
    public List<IBANCandidate> ValideIBANs() {
    	List<IBANCandidate> valideIbans = new ArrayList<IBANCandidate>();
    	for(IBANCandidate ibanCandidate : this.listeIBANCandidates()) {
    		if(ibanCandidate.getValide() == true) {
    		  valideIbans.add(ibanCandidate);
    		}
    	}
    	return valideIbans;
    }
    
    @GetMapping(value = "/IBANCandidates/UnvalideIBANs")
    public List<IBANCandidate> UnvalideIBANs() {
    	List<IBANCandidate> valideIbans = new ArrayList<IBANCandidate>();
    	for(IBANCandidate ibanCandidate : this.listeIBANCandidates()) {
    		if(ibanCandidate.getValide() == false) {
    		  valideIbans.add(ibanCandidate);
    		}
    	}
    	return valideIbans;
    }

}
