package com.example.demo.ListFactory;

import com.example.demo.modelo.Actividad;
import com.example.demo.modelo.ActividadGrupoMonitor;
import com.example.demo.modelo.Grupo;
import com.example.demo.modelo.Monitor;

import java.util.ArrayList;
import java.util.List;

public class ConcreteListCalendarioFactory extends AbstractListFactory<ActividadGrupoMonitor,Actividad> {
    ArrayList<ActividadGrupoMonitor> lista = new ArrayList<>();

    List<Actividad> actividads; List<Grupo> grupos; List<Monitor> monitors;
    int j=0;

    public ConcreteListCalendarioFactory(List<Actividad> actividads, List<Grupo> grupos, List<Monitor> monitors) {
        super(new ArrayList<ActividadGrupoMonitor>());
        this.actividads = actividads;
        this.grupos = grupos;
        this.monitors = monitors;
    }

    @Override
    public List<ActividadGrupoMonitor> getList() {
        for (int i = 0; i <actividads.size(); i++) {
            for (int j = 0; j <grupos.size(); j++) {
                ActividadGrupoMonitor actividadGrupoMonitor = new ActividadGrupoMonitor(actividads.get(i), grupos.get(j), monitors.get(j));
                lista.add(actividadGrupoMonitor);
            }
        }
        return lista;
    }
}
