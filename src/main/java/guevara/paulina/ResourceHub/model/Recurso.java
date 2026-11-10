package guevara.paulina.ResourceHub.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Recurso {
    private Long id;
    private String titulo;
    private String url;
    private String tipo;
    private String categoria;
}
