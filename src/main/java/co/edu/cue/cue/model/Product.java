package co.edu.cue.cue.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class Product {
    private long id;
    private String name;
    private String tipo;
    private Double price;
}
