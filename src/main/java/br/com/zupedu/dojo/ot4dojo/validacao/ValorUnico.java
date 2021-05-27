package br.com.zupedu.dojo.ot4dojo.validacao;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Constraint(validatedBy = ValorUnicoValidator.class)
@Documented
public @interface ValorUnico {

	    String mensagem ()default"O campo está duplicado";
	    Class<?>[] groups() default {};
	    Class<? extends Payload>[] payload() default {};

	    String campo();
	    Class<?> classe();
}
