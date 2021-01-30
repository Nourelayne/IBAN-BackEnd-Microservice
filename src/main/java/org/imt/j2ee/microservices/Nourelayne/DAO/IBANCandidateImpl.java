package org.imt.j2ee.microservices.Nourelayne.DAO;


import java.util.ArrayList;
import java.util.List;

import org.imt.j2ee.microservices.Nourelayne.Model.IBANCandidate;
import org.springframework.stereotype.Repository;
import org.imt.j2ee.microservices.Nourelayne.Model.IBAN;



@Repository
public class IBANCandidateImpl implements IBANDAO {

    public static List<IBANCandidate> IbanCandidates = new ArrayList<>();
    public static int lastId = 3;
    
    static {
    	IbanCandidates.add(new IBANCandidate(1, new String("FR3714508000704126318124Y36")));
    	IbanCandidates.add(new IBANCandidate(2, new String("GB94BARC10201530093459")));
    	IbanCandidates.add(new IBANCandidate(3, new String("US64SVBKUS6S3300958879")));
    	
    	for (IBANCandidate IbanCandidate : IbanCandidates) {
    		IbanCandidate.setValide(IBAN.isCheckDigitValid(IbanCandidate.getIbanNumber()));
        }
    }
    
	@Override
	public IBANCandidate findById(int id) {
		for (IBANCandidate IbanCandidate : IbanCandidates) {
            if(IbanCandidate.getId() == id){
                return IbanCandidate;
            }
        }
        return null;
	}

	@Override
	public IBANCandidate save(String ibanCandidateNumber) {
		IBANCandidate ibanCandidate= new IBANCandidate(ibanCandidateNumber);
		ibanCandidate.setId(++lastId);
		ibanCandidate.setValide(IBAN.isCheckDigitValid(ibanCandidate.getIbanNumber()));
		IbanCandidates.add(ibanCandidate);
        return ibanCandidate;
	}

	@Override
	public List<IBANCandidate> findAll() {
		return IbanCandidates;
	}
}