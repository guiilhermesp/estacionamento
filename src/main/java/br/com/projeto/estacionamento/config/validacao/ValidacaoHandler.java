package br.com.projeto.estacionamento.config.validacao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import br.com.projeto.estacionamento.Dto.VeiculoDto;

@RestControllerAdvice
public class ValidacaoHandler {
	
	@Autowired
	private MessageSource messageSource;

	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public List<VeiculoErroDto> handle(MethodArgumentNotValidException exception) {
		List<VeiculoErroDto> dto = new ArrayList<>();
		List<FieldError> fieldErrors = exception.getBindingResult().getFieldErrors();
		fieldErrors.forEach( e -> {
			
			//talvez a ordem dos parametros esteja ao contrario. linha: 30
			String mensagem = messageSource.getMessage(e, LocaleContextHolder.getLocale());
			VeiculoErroDto erro = new VeiculoErroDto(e.getField(), mensagem);
			dto.add(erro);
		});
		
		return dto;
	}
}
