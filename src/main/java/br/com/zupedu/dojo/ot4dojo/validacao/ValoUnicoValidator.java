package br.com.zupedu.dojo.ot4dojo.validacao;

import org.springframework.util.Assert;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ValoUnicoValidator implements ConstraintValidator<ValorUnico, Object> {

	@PersistenceContext
	private EntityManager manager;

	private String domainAttribute;
	private Class<?> klass;

	@Override
	public void initialize(ValorUnico params) {
		domainAttribute = params.fieldName();
		klass = params.domainClass();
	}

	@Override
	public boolean isValid(Object value, ConstraintValidatorContext context) {
		final Query query = manager.createQuery("select 1 from " + klass.getName() + " where " + domainAttribute + " =:value");
		query.setParameter("value", value);
		final List<?> resultList = query.getResultList();
		Assert.state(resultList.size() <= 1,
				"Foi encontrado mais de um " + klass.getSimpleName() + " com o atributo " + domainAttribute);
		return resultList.isEmpty();
	}
}
