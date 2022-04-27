package mk.ukim.finki.wpproject.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Data
@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Double price;

    private Integer quantity;

    private String imageProduct;

    private String description;



    @ManyToOne
    private Category category;

    public Product() {

    }

    public Product(String name, Double price, Integer quantity, Category category, String imageProduct, String description) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.category = category;
        this.imageProduct = imageProduct;
        this.description = description;
    }

}
