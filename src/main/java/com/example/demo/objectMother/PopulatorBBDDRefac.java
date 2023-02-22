package com.example.demo.objectMother;

import com.example.demo.modelo.*;
import com.example.demo.repositorios.*;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


@Service
public class PopulatorBBDDRefac {
    private final ActividadRepository actividadRepository;
    private final CabanaRepository cabanaRepository;
    private final TiendaRepository tiendaRepository;
    private final MonitorRepository monitorRepository;
    private final GrupoRepository grupoRepository;
    private final EsoRepository esoRepository;
    private final PrimariaREpository primariaREpository;
    private final ActividadGrupoMonitorRepository actividadGrupoMonitorRepository;

    public PopulatorBBDDRefac(ActividadRepository actividadRepository, CabanaRepository cabanaRepository, TiendaRepository tiendaRepository, MonitorRepository monitorRepository, GrupoRepository grupoRepository, EsoRepository esoRepository, PrimariaREpository primariaREpository, ActividadGrupoMonitorRepository actividadGrupoMonitorRepository) {
        this.actividadRepository = actividadRepository;
        this.cabanaRepository = cabanaRepository;
        this.tiendaRepository = tiendaRepository;
        this.monitorRepository = monitorRepository;
        this.grupoRepository = grupoRepository;
        this.esoRepository = esoRepository;
        this.primariaREpository = primariaREpository;
        this.actividadGrupoMonitorRepository = actividadGrupoMonitorRepository;
        String actividadesNames[] = {"escalada", "rafting", "trekking", "canoa", "windsurfing", "drones"};
        int duracionMax = 10;
        List<Actividad> actividads = populate(actividadRepository, new ConcreteListActividadFactory(actividadesNames, duracionMax));

        String tiendasNames[] = {"Grulla", "Ardilla", "Zorro", "Conejo", "Rana"};
        int temperaturaMinima = 10;
        List<Tienda> tiendas = populate(tiendaRepository, new ConcreteListTiendaFactory(tiendasNames, temperaturaMinima));


        String cabanasNames[] = {"jara", "cantueso", "oregano", "hierbuena", "cilantro"};
        boolean[] cabanasClimatizadas={true,true,false,true,false};
        List<Cabana> cabanas = populate(cabanaRepository, new ConcreteListCabanaFactory(cabanasNames,cabanasClimatizadas));

        String gruposNames[] = {"Exploradores", "Aventureros", "Salvajes", "Valientes", "Aguerridos"};
        String gruposturnos[] = {"diurno", "nocturno", "vespertino"};
        List<Grupo> grupos = populate(grupoRepository, new ConcreteListGrupoFactory(gruposNames, gruposturnos));

        String esosNames[] = {"Ramonazo", "Lusiazo", "Enriquazo", "Manolazo", "Juanazo", "Juliazo", "Alfonsazo", "Teresiazo", "Anazo", "Estebancazo", "Pilarcazo", "Luciiazo", "Vicentazo"};
        int edadMaxima = 16;
        int edadMinima = 11;
        List<Eso> esos = populate(esoRepository, new ConcreteListESOFactory(
                esosNames, edadMaxima, edadMinima, tiendas, grupos));

        String monitorsNames[] = {"Lolo", "Aullador", "Choricete", "Tenedor", "Morretes"};
        List<Monitor> monitors = populate(monitorRepository, new ConcreteListMonitoresFactory(monitorsNames));

        String primariaNames[] = {"Ramoncito", "Lusito", "Enriquito", "Manolito", "Juanito", "Julita", "Alfonsito", "Teresita", "Anita", "Estebancito", "Pilarcita", "Luciita", "Vicentita"};
        ArrayList<Primaria> arrayList = new ArrayList<>();
        edadMaxima = 11;
        edadMinima = 5;
        List<Primaria> primarias = populate(primariaREpository, new ConcreteListPrimariaFactory(primariaNames, edadMaxima, edadMinima, cabanas, grupos));

        List<ActividadGrupoMonitor> actividadGrupoMonitors = populate(actividadGrupoMonitorRepository,
                new ConcreteListCalendarioFactory(actividads, grupos, monitors));
    }

    private List populate(CrudRepository crudRepository, AbstractListFactory abstractListFactory) {
        List list = abstractListFactory.getList();
        for (int i = 0; i < list.size(); i++) {
            crudRepository.save(list.get(i));
        }
        return list;
    }


}
