package br.com.zupedu.dojo.ot4dojo.validacao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.ConstraintValidator;

public class ValorUnicoValidator implements ConstraintValidator<ValorUnico, Object>{
	
	    private String campo;
	    private Class<?> classe;
	    
	    @PersistenceContext
	    private EntityManager entityManager;
	    
	    @Override
	    public void initialize(ValorUnico constraintAnnotation) {
	        this.campo = constraintAnnotation.campo();
	        this.classe = constraintAnnotation.classe();
	    }
	    
	    Query query = entityManager.createQuery("SELECT 1 FROM " + classe.getName() + 
        		"WHERE " + campo + " = :value").setParameter("value", o);
        
        List<?> list = query.getResultList();
        
        return list.isEmpty();
    }

}
