package com.services.epam.ivanov.mentoring.service;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import java.util.Date;

/**
 * Created by Андрей on 01.07.2014.
 */
@WebService(name = "ConvertationPortType",
        targetNamespace = "http://com.services.epam.ivanov.mentoring.service/")
public interface ConvertationWS {

    @WebMethod(operationName = "currencyConvertation")
    public Double convert(@WebParam(name = "fromCurrency") String fromCurrency,
                          @WebParam(name = "toCurrency") String toCurrency,
                          @WebParam(name = "currencyAmount") Double fromCurrencyAmount,
                          @WebParam(name = "date") Date date);

    @WebMethod(operationName = "getCurrencyExchangeRate")
    public Double getExchangeRate(@WebParam(name = "fromCurrency") String fromCurrency,
                                  @WebParam(name = "toCurrency") String toCurrency);

}
