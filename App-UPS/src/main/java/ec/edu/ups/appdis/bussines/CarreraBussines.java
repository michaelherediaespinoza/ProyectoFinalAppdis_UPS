package ec.edu.ups.appdis.bussines;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import ec.edu.ups.appdis.dao.CarreraDao;
import ec.edu.ups.appdis.model.Carrera;

@Stateless
public class CarreraBussines {
	@Inject
	private CarreraDao cdao;
	
	
	public void save(Carrera carrera) throws Exception {
		//Carrera aux = cdao.read(carrera.getCodigo());
		//if(aux!=null)
			//throw new Exception("Carrera ya registrada");
		//else
			cdao.insertar(carrera);
	}
	
	public List<Carrera> getCarreras(){
		return cdao.getCarreras();
	}
	
	public void deleteid(int id) throws Exception {
		Carrera aux = cdao.read(id);
		if(aux==null)
			throw new Exception("Registro no existe");
		else
			cdao.deleteid(id);
	}
	
	public void update(Carrera carrera) throws Exception {
	Carrera aux = cdao.read(carrera.getCodigo());
		if(aux==null)
			throw new Exception("Registro no existe");
		else
			cdao.update(carrera);
	}
	

}
