package br.com.sigcar.conversor;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

import br.com.sigcar.dominio.Usuario;
import br.com.sigcar.repositorios.UsuarioRepositorio;


@FacesConverter("usuarioConversor")
public class UsuarioConversor implements Converter<Object>, Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    @Inject
    private UsuarioRepositorio usuarioRepositorio;
    
    public UsuarioConversor() {
        usuarioRepositorio = new UsuarioRepositorio();
    }

    public Object getAsObject(FacesContext fc, UIComponent uic, String value) {
        if (value != null && value.trim().length() > 0) {
            	Usuario usuario=usuarioRepositorio.getUsuario(Integer.valueOf(value));
				return usuario;
        } else {
            return null;
        }
    }

    public String getAsString(FacesContext fc, UIComponent uic, Object object) {
        if(object instanceof Usuario && object != null){ 
        	Integer id =  (Integer)((Usuario) object).getId();
            return id.toString();
        } else {
            return null;
        }
    }

}