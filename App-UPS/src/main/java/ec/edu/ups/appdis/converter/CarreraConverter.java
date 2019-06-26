package ec.edu.ups.appdis.converter;

import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.faces.model.SelectItem;
import javax.inject.Named;

import ec.edu.ups.appdis.model.Carrera;
import ec.edu.ups.appdis.util.CarreraFacade;
import ec.edu.ups.appdis.util.JsfUtil;

@Named("carreraConverter")
@ManagedBean
public class CarreraConverter  implements Serializable {
    
    private static final long serialVersionUID = 1L;

    private Carrera newCarrera;
    
    @EJB
    private CarreraFacade ejbFacade;
    
    public Carrera getSelected() {
        if (newCarrera == null) {
        	newCarrera = new Carrera();
        }
        return newCarrera;
    }
    
    public CarreraConverter() {
        
    }


    public CarreraFacade getEjbFacade() {
        return ejbFacade;
    }

    public SelectItem[] getItemsAvailableSelectMany() {
        return JsfUtil.getSelectItems(ejbFacade.findAll(), false);
    }

    public SelectItem[] getItemsAvailableSelectOne() {
        return JsfUtil.getSelectItems(ejbFacade.findAll(), true);
    }

    public Carrera getCarreras(java.lang.Integer id) {
        return ejbFacade.find(id);
    }
    
    @FacesConverter(forClass = Carrera.class)
    public static class CategoriasBeanConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            CarreraConverter controller = (CarreraConverter) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "carreraConverter");
            return controller.getCarreras(getKey(value));
        }

        java.lang.Integer getKey(String value) {
            java.lang.Integer key;
            key = Integer.valueOf(value);
            return key;
        }

        String getStringKey(java.lang.Integer value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value);
            return sb.toString();
        }

     
        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null || (object instanceof String && ((String) object).length() == 0)){
                return null;
            }
            if (object instanceof Carrera) {
                Carrera o = (Carrera) object;
                return getStringKey(o.getCodigo());
            } else {
                throw new IllegalArgumentException("object " + object + " is of type " + object.getClass().getName() + "; expected type: " + Carrera.class.getName());
            }
        }
        }
    }

    