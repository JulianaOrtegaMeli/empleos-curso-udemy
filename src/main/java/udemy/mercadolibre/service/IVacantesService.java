package udemy.mercadolibre.service;

import udemy.mercadolibre.model.*;

import java.util.*;

public interface IVacantesService {

    List<Vacante> buscarTodas();

    Vacante buscarPorId(Integer idVacante);
}
