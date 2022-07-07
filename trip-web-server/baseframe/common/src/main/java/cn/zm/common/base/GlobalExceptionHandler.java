package cn.zm.common.base;

import cn.zm.common.enums.ResEnum;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.multipart.MultipartException;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.List;

/**
 * @author Mr_W
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(value = Exception.class)
	public ResResult internalErrorHandler(Exception e) {
		log.error("\nhappened serviceException, Caused by " +
				"\n ------------------------------------" +
				"--------------ERROR INFO------------" +
				"--------------------------------------"
				+ getMessage(e), e);
		ResResult r;
		if (e instanceof ServiceException) {
			r = ResResult.fail(StringUtils.isBlank(((ServiceException) e).getAlertMessage()) ? e.getMessage() : ((ServiceException) e).getAlertMessage());
		} else if (e instanceof IllegalArgumentException){
			r = ResResult.fail(e.getMessage());
		} else {
			r = ResResult.fail(e.getMessage());
		}
		return r;
	}
	
	@ExceptionHandler(value = MethodArgumentNotValidException.class)
	public ResResult paramErrorHandler(MethodArgumentNotValidException e) {
		BindingResult exceptions = e.getBindingResult();
        // 判断异常中是否有错误信息，如果存在就使用异常中的消息，否则使用默认消息
        if (exceptions.hasErrors()) {
            List<ObjectError> errors = exceptions.getAllErrors();
            if (!errors.isEmpty()) {
                // 这里列出了全部错误参数，按正常逻辑，只需要第一条错误即可
                FieldError fieldError = (FieldError) errors.get(0);
                log.error("invalid parameter, Caused by " + fieldError.getDefaultMessage(), e);
                return ResResult.fail(fieldError.getDefaultMessage());
            }
        }
		return ResResult.fail(ResEnum.INVALID_PARAMS.getMsg());
	}
	
	public String getMessage(Exception e) {
		StringWriter sw = new StringWriter();
		try (PrintWriter pw = new PrintWriter(sw)) {
			pw.flush();
			sw.flush();
		}
		return sw.toString();
	}

	@ExceptionHandler(MissingServletRequestParameterException.class)
	public ResResult handlerMissingServletRequestParameterException(MissingServletRequestParameterException e) {
		log.debug(e.getParameterName() + "不能为空", e);
		return ResResult.fail(e.getParameterName() + "不能为空");
	}

	@ExceptionHandler(BindException.class)
	public ResResult handlerBindException(BindException e) {
		log.debug(e.getAllErrors().get(0).getDefaultMessage(), e);
		return ResResult.fail(e.getAllErrors().get(0).getDefaultMessage());
	}

	@ExceptionHandler(MultipartException.class)
	public ResResult handleError1(MultipartException e) {
		log.error("文件解析失败", e);
		return ResResult.fail("文件解析失败");
	}

}
