package guevara.paulina.ResourceHub.controller;

import guevara.paulina.ResourceHub.model.Recurso;
import guevara.paulina.ResourceHub.service.RecursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/recursos")
public class RecursoController {

    @Autowired
    private RecursoService recursoService;

    @GetMapping
    public List<Recurso> listar() {
        return recursoService.listar();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Recurso> buscar(@PathVariable Long id) {
        return recursoService.buscar(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Recurso> crear(@RequestBody Recurso recurso) {
        return ResponseEntity.status(HttpStatus.CREATED).body(recursoService.crear(recurso));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        return recursoService.eliminar(id)
                ? ResponseEntity.noContent().build()
                : ResponseEntity.notFound().build();
    }

    // Reemplaza todo, si hay un campo vacío queda null
    @PutMapping("/{id}")
    public ResponseEntity<Recurso> actualizar(@PathVariable Long id, @RequestBody Recurso recurso) {
        return recursoService.actualizar(id, recurso)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Cambia solo una parte
    @PatchMapping("/{id}")
    public ResponseEntity<Recurso> actualizarParcial(@PathVariable Long id, @RequestBody Recurso recurso) {
        return recursoService.actualizarParcial(id, recurso)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
