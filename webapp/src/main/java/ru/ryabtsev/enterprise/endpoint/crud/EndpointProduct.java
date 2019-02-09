package ru.ryabtsev.enterprise.endpoint.crud;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.ryabtsev.enterprise.api.ProductRepository;
import ru.ryabtsev.enterprise.endpoint.dto.ProductDTO;
import ru.ryabtsev.enterprise.endpoint.dto.ResultDTO;
import ru.ryabtsev.enterprise.endpoint.dto.SuccessDTO;
import ru.ryabtsev.enterprise.entity.Product;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import java.util.List;
import java.util.stream.Collectors;

@WebService
@Path("/products")
@ApplicationScoped
public class EndpointProduct {

    @Inject
    private ProductRepository productRepository;

    @GET
    @WebMethod
    @Path("/ping")
    @Produces(MediaType.APPLICATION_JSON)
    public ResultDTO ping() { return new SuccessDTO(); }

    @GET
    @NotNull
    @WebMethod
    @Path("/getList")
    @Produces(MediaType.APPLICATION_JSON)
    public List<ProductDTO> getList() {
        return productRepository.getAll().stream().map(ProductDTO::new).collect(Collectors.toList());
    }

    @GET
    @WebMethod
    @Path("/create")
    @Produces(MediaType.APPLICATION_JSON)
    public ProductDTO create() {
        final Product product = productRepository.create();
        return new ProductDTO(product);
    }

    @GET
    @WebMethod
    @Path("/getById")
    @Produces(MediaType.APPLICATION_JSON)
    public ProductDTO getById(
            @QueryParam("id")
            @WebParam(name="id", partName="id")
            @Nullable final String id
            )
    {
        @Nullable final Product product = productRepository.get(id);
        if(product == null) return null;
        return new ProductDTO(product);
    }

    @GET
    @WebMethod
    @Path("/removeById")
    @Produces(MediaType.APPLICATION_JSON)
    public ResultDTO removeById(
            @QueryParam("id")
            @WebParam(name="id", partName="id")
            @Nullable final String id
    )
    {
        productRepository.remove(id);
        return new SuccessDTO();
    }

}
