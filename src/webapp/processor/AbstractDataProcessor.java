package webapp.processor;

import java.util.List;

import webapp.domain.parameter.AbstractExportParam;
import webapp.domain.request.AbstractRequestParam;


public abstract class AbstractDataProcessor<T extends AbstractRequestParam> {
	protected List<? extends AbstractExportParam> processDatamakerInput(Class<T>  inputParams) {
		return null;
	}
}
