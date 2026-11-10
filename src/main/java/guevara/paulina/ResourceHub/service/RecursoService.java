package guevara.paulina.ResourceHub.service;

import guevara.paulina.ResourceHub.model.Recurso;
import guevara.paulina.ResourceHub.repository.RecursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class RecursoService {

    @Autowired
    private RecursoRepository recursoRepository;

    public Recurso crear(Recurso recurso) {
        recurso.setId(null); // el id lo asigna el repositorio
        return recursoRepository.save(recurso);
    }

    public List<Recurso> listar() {
        return recursoRepository.findAll();
    }

    public Optional<Recurso> buscar(Long id) {
        return recursoRepository.findById(id);
    }

    public boolean eliminar(Long id) {
        return recursoRepository.deleteById(id);
    }

    // PUT: reemplaza el recurso completo
    public Optional<Recurso> actualizar(Long id, Recurso datos) {
        return recursoRepository.findById(id).map(existente -> {
            datos.setId(id);
            return recursoRepository.save(datos);
        });
    }

    // PATCH: solo cambia los campos que vienen en el JSON
    public Optional<Recurso> actualizarParcial(Long id, Recurso datos) {
        return recursoRepository.findById(id).map(existente -> {
            if (datos.getTitulo() != null) existente.setTitulo(datos.getTitulo());
            if (datos.getUrl() != null) existente.setUrl(datos.getUrl());
            if (datos.getTipo() != null) existente.setTipo(datos.getTipo());
            if (datos.getCategoria() != null) existente.setCategoria(datos.getCategoria());
            return recursoRepository.save(existente);
        });
    }
}
