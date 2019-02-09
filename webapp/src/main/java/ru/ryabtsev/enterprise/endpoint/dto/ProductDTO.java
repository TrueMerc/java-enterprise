package ru.ryabtsev.enterprise.endpoint.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jdk.internal.jline.internal.Nullable;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.ryabtsev.enterprise.entity.Product;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
@Setter
public class ProductDTO {

    @Nullable
    private String id;

    @Nullable
    private String name;

    private float price;

    @Nullable
    private String description;

    @Nullable
    private String categoryId;

    public ProductDTO(@Nullable final Product product) {
        if(product == null) return;
        setId(product.getId());
        setName(product.getName());
        setPrice(product.getPrice());
        setDescription(product.getDescription());
        setCategoryId(product.getCategory().getId());
    }
}
