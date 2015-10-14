package com.services.epam.ivanov.mentoring.service;

import com.services.epam.ivanov.mentoring.utils.ExchangeRates;

import javax.jws.WebService;
import java.util.Date;

/**
 * Created by Ð�Ð½Ð´Ñ€ÐµÐ¹ on 01.07.2014.
 */

@WebService(portName = "ConvertationPort",
        serviceName = "Convertation",
        targetNamespace = "http://com.services.epam.ivanov.mentoring.service/",
        endpointInterface = "com.services.epam.ivanov.mentoring.service.ConvertationWS",
        wsdlLocation = "WEB-INF/wsdl/Convertation.wsdl")
public class ConvertationImpl implements ConvertationWS {

    public Double convert(String fromCurrency, String toCurrency, Double fromCurrencyAmount, Date date) {
        Date currentDate = new Date();
        Double currentRate;
        if (currentDate.before(date)) {
            currentRate = ExchangeRates.valueOf(fromCurrency + toCurrency).getRate() * 1.5;
        } else if (currentDate.after(date)) {
            currentRate = ExchangeRates.valueOf(fromCurrency + toCurrency).getRate() * 0.75;
        } else {
            currentRate = ExchangeRates.valueOf(fromCurrency + toCurrency).getRate();
        }
        fromCurrencyAmount *= currentRate;
        return fromCurrencyAmount;
    }

    public Double getExchangeRate(String fromCurrency, String toCurrency) {
        return ExchangeRates.valueOf(fromCurrency + toCurrency).getRate();
    }
}
