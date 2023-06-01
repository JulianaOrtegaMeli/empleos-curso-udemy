package udemy.mercadolibre.service;

import org.springframework.stereotype.*;
import udemy.mercadolibre.model.*;

import java.text.*;
import java.util.*;

@Service
public class VacantesServiceImpl implements IVacantesService{

    private List<Vacante> lista = null;

    public VacantesServiceImpl() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        lista = new LinkedList<Vacante>();

        try{
            Vacante v1 = new Vacante();
            v1.setId(1);
            v1.setNombre("Ingeniero Civil");
            v1.setDescripcion("Solicitamos ingeniero civil para diseñar puente peatonal");
            v1.setFecha(sdf.parse("08-02-2023"));
            v1.setSalario(1600000.0);
            v1.setDestacado(1);
            v1.setImage("empresa1.png");

            Vacante v2 = new Vacante();
            v2.setId(2);
            v2.setNombre("Ingeniero ambiental");
            v2.setDescripcion("Solicitamos ingeniero ambiental para dirigir la hornamentacion de un condominio residencial");
            v2.setFecha(sdf.parse("10-03-2023"));
            v2.setSalario(800000.0);
            v2.setDestacado(0);
            v2.setImage("empresa2.png");

            Vacante v3 = new Vacante();
            v3.setId(3);
            v3.setNombre("Abogado");
            v3.setDescripcion("Solicitamos abogado para tramitar herencia");
            v3.setFecha(sdf.parse("31-03-2023"));
            v3.setSalario(2500000.0);
            v3.setDestacado(1);

            lista.add(v1);
            lista.add(v2);
            lista.add(v3);

        }catch(ParseException e){
            System.out.println("ERROR: " + e.getMessage());
        }
    }

    @Override
    public List<Vacante> buscarTodas() {
        return lista;
    }

    @Override
    public Vacante buscarPorId(Integer idVacante) {

        for (Vacante vacante : lista) {
            if (vacante.getId().equals(idVacante)) {
                return vacante;
            }
        }
        return null;
    }


}
