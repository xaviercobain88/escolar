package ec.com.webcreativa.escolar.util;

import java.util.List;

public class BaseUtils {

	@SuppressWarnings("rawtypes")
	protected Boolean listaLLena(List list) {
		return list != null && !list.isEmpty();
	}
}
