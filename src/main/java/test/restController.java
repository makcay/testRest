package test;

import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.xml.Jaxb2RootElementHttpMessageConverter;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class restController{

    private final String url="https://jl-nonprod-syst.apigee.net/v1/categories/600001506/products?key=2ALHCAAs6ikGRBoy6eTHA58RaG097Fma";

    @RequestMapping("/testRest")
    public List<product> index(@RequestParam(value="labelType", defaultValue="ShowWasNow") String labelType){
        RestTemplate restTemplate=new RestTemplate();
        restTemplate.getMessageConverters().add(new Jaxb2RootElementHttpMessageConverter());
        restTemplate.getMessageConverters().add(new StringHttpMessageConverter());

        List<originalProduct> products = restTemplate.getForObject(url,originalProductsResponse.class).getProducts();

        List<product> result=null;

        if (products!=null) {
            System.out.println(products.toString());
            result=convertProducts(products, labelType);
        }

        return result;
    }

    private List<product> convertProducts(List<originalProduct> input, String labelType){
        List<product> output=new ArrayList<product>();

        //filter the products that have discount only and sort according to the discount
        input=input.stream()
                .filter(orgP -> orgP.getPrice().getdiscount()>0 )
                .sorted((l, r) -> l.getPrice().getdiscount().compareTo(r.getPrice().getdiscount()))
                .collect(Collectors.toList());

        for (originalProduct tmp:input) {
            product newProduct=new product();
            newProduct.setProductid(tmp.getProductId());
            newProduct.setTitle(tmp.getTitle());
            List<ColorSwatch> colorSwatches=new ArrayList<ColorSwatch>();
            for(originalColorSwatch cs:tmp.getColorSwatches()){
                ColorSwatch newCs=new ColorSwatch();
                newCs.setColor(cs.getHexColor());
                newCs.setSkuid(cs.getSkuId());
                colorSwatches.add(newCs);
            }
            newProduct.setColorSwatches(colorSwatches.stream().toArray(ColorSwatch[]::new));
            newProduct.setPriceLabel(tmp.getPrice().getPriceText(labelType));

            output.add(newProduct);
        }

        return output;
    }

}
