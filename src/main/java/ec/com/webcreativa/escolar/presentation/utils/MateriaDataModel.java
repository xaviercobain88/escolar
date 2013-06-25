package ec.com.webcreativa.escolar.presentation.utils;

import java.util.List;

import javax.faces.model.ListDataModel;

import org.primefaces.model.SelectableDataModel;

import ec.com.webcreativa.escolar.persistence.entity.Materia;

public class MateriaDataModel extends ListDataModel<Materia> implements
		SelectableDataModel<Materia> {

	public MateriaDataModel() {
	}

	public MateriaDataModel(List<Materia> data) {
		super(data);
	}

	@SuppressWarnings("unchecked")
	@Override
	public Materia getRowData(String rowKey) {
		// In a real app, a more efficient way like a query by rowKey should be
		// implemented to deal with huge data

		List<Materia> materias = (List<Materia>) getWrappedData();
		if (materias != null && !materias.isEmpty()) {
			for (Materia materia : materias) {
				if (materia.getIdMateria().equals(Integer.parseInt(rowKey))){
					
					return materia;
				}
			}
		}
		return null;
	}

	@Override
	public Object getRowKey(Materia materia) {
		return materia.getIdMateria();
	}
}
