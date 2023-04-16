package co.edu.cue.cue.service.impl;

import co.edu.cue.cue.model.Product;
import co.edu.cue.cue.service.ProductService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ProductServiceImp implements ProductService {
    @Override
    public List<Product> listar() {
        return Arrays.asList(
                 new Product(1L,"notebook","computacion",17500.0)
                ,new Product(2L,"mesa escritorio","oficina",1.0)
                ,new Product(3L,"teclado mecanico","computacion",1.0));
    }
}
