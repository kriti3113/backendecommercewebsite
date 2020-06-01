
package com.example.demo.model;
        import javax.persistence.*;

@Entity
public class items {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long ProductId;
    private String name ;
    private String description;
    private double price;
    private String img;
    private String category;
    @Column( nullable = false , columnDefinition = " int default '1' ")
    private int active;



    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }

    public String getImg()
    {return img; }

    public String getCategory() {
        return category;
    }
    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) { this.description = description;    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public void setCategory(String category) {
        this.category = category;
    }


    public int getActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
        this.active=1;
    }

    public Long getProductId() {
        return ProductId;
    }

    public void setProductId(Long productId) {
        ProductId = productId;
    }
}

