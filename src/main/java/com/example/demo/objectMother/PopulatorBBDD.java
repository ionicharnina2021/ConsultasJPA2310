package com.example.demo.objectMother;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.example.demo.modelo.*;
import com.example.demo.repositorios.*;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;


@Service
public class PopulatorBBDD {
    private final ActividadRepository actividadRepository;
    private final CabanaRepository cabanaRepository;
    private final TiendaRepository tiendaRepository;
    private final MonitorRepository monitorRepository;
    private final GrupoRepository grupoRepository;
    private final EsoRepository esoRepository;
    private final PrimariaREpository primariaREpository;
    private final ActividadGrupoMonitorRepository actividadGrupoMonitorRepository;

    public PopulatorBBDD(ActividadRepository actividadRepository, CabanaRepository cabanaRepository, TiendaRepository tiendaRepository, MonitorRepository monitorRepository, GrupoRepository grupoRepository, EsoRepository esoRepository, PrimariaREpository primariaREpository, ActividadGrupoMonitorRepository actividadGrupoMonitorRepository) {
        this.actividadRepository = actividadRepository;
        this.cabanaRepository = cabanaRepository;
        this.tiendaRepository = tiendaRepository;
        this.monitorRepository = monitorRepository;
        this.grupoRepository = grupoRepository;
        this.esoRepository = esoRepository;
        this.primariaREpository = primariaREpository;
        this.actividadGrupoMonitorRepository = actividadGrupoMonitorRepository;
        List<Tienda> tiendas = populateTienda(tiendaRepository);
        List<Grupo> grupos = populateGrupo(grupoRepository);
        List<Eso> esos = populateEso(esoRepository, tiendas, grupos);
        List<Cabana> cabanas = populateCabana(cabanaRepository);
        List<Primaria> primarias = populatePrimara(primariaREpository, cabanas, grupos);
        List<Actividad> actividads = populateActividad(actividadRepository);
        List<Monitor> monitors = populateMonitores(monitorRepository);
        List<ActividadGrupoMonitor> actividadGrupoMonitors = populateCalendario(actividads, grupos, monitors);
    }

    private List<ActividadGrupoMonitor> populateCalendario( List<Actividad> actividads,  List<Grupo> grupos,  List<Monitor> monitors) {
        ArrayList<ActividadGrupoMonitor> lista = new ArrayList<>();
        for (int i = 0; i <actividads.size(); i++) {
            for (int j = 0; j <grupos.size(); j++) {
                    ActividadGrupoMonitor actividadGrupoMonitor = new ActividadGrupoMonitor(actividads.get(i), grupos.get(j), monitors.get(j));
                    lista.add(actividadGrupoMonitor);
                    actividadGrupoMonitorRepository.save(actividadGrupoMonitor);
            }
        }
        return lista;
    }

    private List<Actividad> populateActividad(CrudRepository repository) {
        String elements[] = {"escalada", "rafting", "trekking", "canoa", "windsurfing", "drones"};
        int duracionMax = 10;
        ArrayList<Actividad> arrayList = new ArrayList<>();
        for (int i = 0; i < elements.length; i++) {
            Actividad elemento = new Actividad(elements[i], new Random().nextInt(duracionMax) + 1);
            arrayList.add(elemento);
            repository.save(elemento);
        }
        return arrayList;
    }

    private List<Cabana> populateCabana(CrudRepository repository) {
        String elements[] = {"jara", "cantueso", "oregano", "hierbuena", "cilantro"};
        ArrayList<Cabana> arrayList = new ArrayList<>();
        for (int i = 0; i < elements.length; i++) {
            Cabana cabana = new Cabana(elements[i], new Random().nextBoolean());
            arrayList.add(cabana);
            repository.save(cabana);
        }
        return arrayList;
    }

    private List<Tienda> populateTienda(CrudRepository repository) {
        String elements[] = {"Grulla", "Ardilla", "Zorro", "Conejo", "Rana"};
        ArrayList<Tienda> arrayList = new ArrayList<>();
        int temperaturaMinima = 10;
        for (int i = 0; i < elements.length; i++) {
            Tienda elemento = new Tienda(elements[i], new Random().nextInt(temperaturaMinima) + 1);
            arrayList.add(elemento);
            repository.save(elemento);
        }
        return arrayList;
    }

    private List<Grupo> populateGrupo(CrudRepository repository) {
        ArrayList<Grupo> arrayList = new ArrayList<>();
        String elements[] = {"Exploradores", "Aventureros", "Salvajes", "Valientes", "Aguerridos"};
        String turnos[] = {"diurno", "nocturno", "vespertino"};
        for (int i = 0; i < elements.length; i++) {
            Grupo elemento = new Grupo(elements[i], turnos[new Random().nextInt(turnos.length)]);
            arrayList.add(elemento);
            repository.save(elemento);
        }
        return arrayList;
    }

    private List<Monitor> populateMonitores(CrudRepository repository) {
        String elements[] = {"Lolo", "Aullador", "Choricete", "Tenedor", "Morretes"};
        ArrayList<Monitor> arrayList = new ArrayList<>();
        for (int i = 0; i < elements.length; i++) {
            Monitor elemento = new Monitor(elements[i]);
            arrayList.add(elemento);
            repository.save(elemento);
        }
        return arrayList;
    }

    private List<Primaria> populatePrimara(CrudRepository repository, List<Cabana> alojamiento, List<Grupo> grupos) {
        String elements[] = {"Ramoncito", "Lusito", "Enriquito", "Manolito", "Juanito", "Julita", "Alfonsito", "Teresita", "Anita", "Estebancito", "Pilarcita", "Luciita", "Vicentita"};
        ArrayList<Primaria> arrayList = new ArrayList<>();
        int edadMaxima = 11;
        int edadMinima = 5;
        for (int i = 0; i < elements.length; i++) {
            Primaria elemento = new Primaria(elements[i], new Random().nextInt(edadMaxima - edadMinima) + edadMinima, grupos.get(i % grupos.size()), alojamiento.get(i % alojamiento.size()));
            arrayList.add(elemento);
            repository.save(elemento);
        }
        return arrayList;
    }

    private List<Eso> populateEso(CrudRepository repository, List<Tienda> alojamiento, List<Grupo> grupos) {
        String elements[] = {"Ramonazo", "Lusiazo", "Enriquazo", "Manolazo", "Juanazo", "Juliazo", "Alfonsazo", "Teresiazo", "Anazo", "Estebancazo", "Pilarcazo", "Luciiazo", "Vicentazo"};
        ArrayList<Eso> arrayList = new ArrayList<>();
        int edadMaxima = 16;
        int edadMinima = 11;
        for (int i = 0; i < elements.length; i++) {
            Eso elemento = new Eso(elements[i], new Random().nextInt(edadMaxima - edadMinima) + edadMinima, grupos.get(i % grupos.size()), alojamiento.get(i % alojamiento.size()));
            arrayList.add(elemento);
            repository.save(elemento);
        }
        return arrayList;
    }

}
