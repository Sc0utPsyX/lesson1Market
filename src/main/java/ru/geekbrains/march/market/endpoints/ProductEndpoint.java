package ru.geekbrains.march.market.endpoints;

import lombok.RequiredArgsConstructor;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import ru.geekbrains.march.market.services.ProductSoapService;
import ru.geekbrains.march.market.soap.GetAllProductResponse;
import ru.geekbrains.march.market.soap.GetAllProductsRequest;
import ru.geekbrains.march.market.soap.GetProductByTitleRequest;
import ru.geekbrains.march.market.soap.GetProductByTitleResponse;

@Endpoint
@RequiredArgsConstructor
public class ProductEndpoint {
    private static final String NAMESPACE_URI = "http://www.geekbrains.com/march/market/soap/ProductSoap";
    private final ProductSoapService productService;

//    Пример запроса
//    <soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/"
//    xmlns:f="http://www.geekbrains.com/march/market/soap/ProductSoap">
//            <soapenv:Header/>
//            <soapenv:Body>
//                <f:getProductByTitleRequest>
//                <f:title>Bread</f:title>
//                </f:getProductByTitleRequest>
//            </soapenv:Body>
//        </soapenv:Envelope>

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getProductByTitleRequest")
    @ResponsePayload
    public GetProductByTitleResponse getProductByTitle(@RequestPayload GetProductByTitleRequest request){
        GetProductByTitleResponse response = new GetProductByTitleResponse();
        response.setProductSoap(productService.getByTitle(request.getTitle()));
        return response;
    }

//    Пример запроса
//    <soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/"
//    xmlns:f="http://www.geekbrains.com/march/market/soap/ProductSoap">
//            <soapenv:Header/>
//            <soapenv:Body>
//                <f:getAllProductsRequest/>
//            </soapenv:Body>
//        </soapenv:Envelope>


    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getAllProductsRequest")
    @ResponsePayload
    public GetAllProductResponse getAllProduct(@RequestPayload GetAllProductsRequest request){
        GetAllProductResponse response = new GetAllProductResponse();
        productService.getAllProducts().forEach(response.getProductSoap()::add);
        return response;
    }

}
