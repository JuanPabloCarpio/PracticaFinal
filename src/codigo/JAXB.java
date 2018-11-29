/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codigo;

import generated.Objetos;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

/**
 *
 * @author xp
 */
public class JAXB {
    
    Objetos misLibros;
    
    public int  abrir_XML_JAXB(File fichero){
        JAXBContext contexto;
        try {
            contexto = JAXBContext.newInstance(Objetos.class);
            
            Unmarshaller u = contexto.createUnmarshaller();
            
            misLibros = (Objetos)u.unmarshal(fichero);
            return 0;
        } catch (Exception e) {
            return 1;
        }
    }
    public String recorrerJAXByMostrar(){
        String Datos_nodo[] = null;
        String cadena_resultado = "";
        
        List<Objetos.Objeto> lLibros = misLibros.getObjeto();
        for(int i=0; i<lLibros.size();i++){
            
            cadena_resultado = cadena_resultado + "\n" + "El nombre es: " + lLibros.get(i).getNombre();
            cadena_resultado = cadena_resultado + "\n" + "Las partes son: " + lLibros.get(i).getPartes();
            cadena_resultado = cadena_resultado + "\n" + "El precio es: " + lLibros.get(i).getPrecio();
            cadena_resultado = cadena_resultado + "\n" + "Las activas son: " + lLibros.get(i).getActivas();
            cadena_resultado = cadena_resultado + "\n" + "Las pasivas son: " + lLibros.get(i).getPasivas();
            cadena_resultado = cadena_resultado + "\n" + "El daño es: " + lLibros.get(i).getDaño();
            cadena_resultado = cadena_resultado + "\n" + "La vida es: " + lLibros.get(i).getVida();
            cadena_resultado = cadena_resultado + "\n" + "Las resistencias son: " + lLibros.get(i).getResistencias();
            cadena_resultado = cadena_resultado + "\n" + "El CDR es: " + lLibros.get(i).getCooldownReduction();
            cadena_resultado = cadena_resultado + "\n" + "El mana es: " + lLibros.get(i).getMana();
            cadena_resultado = cadena_resultado + "\n" + "----------------------" + "\n";
        }
        return cadena_resultado;
        
    }
     public void generateXML (String nameFile) {
 
        try {
            File file = new File (nameFile);
            JAXBContext jc = JAXBContext.newInstance(this.getClass());
            Marshaller jaxbMarshaller = jc.createMarshaller();
 
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
 
            jaxbMarshaller.marshal(this, new FileWriter(nameFile, true));
 
        } catch (JAXBException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    
}
