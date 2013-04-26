/**
 * Copyright [2011] [PagSeguro Internet Ltda.]

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
 */
package br.com.uol.pagseguro.example;

import java.math.BigDecimal;
import java.net.URL;

import br.com.uol.pagseguro.domain.AccountCredentials;
import br.com.uol.pagseguro.domain.Currency;
import br.com.uol.pagseguro.domain.PaymentRequest;
import br.com.uol.pagseguro.domain.ShippingType;
import br.com.uol.pagseguro.exception.PagSeguroServiceException;

public class CreatePayment {

    /**
     * Class with a main method to illustrate the usage of the domain class PaymentRequest
     */
    public static void main(String[] args) {

        // Instantiate a new payment request
        PaymentRequest paymentRequest = new PaymentRequest();

        // Sets the currency
        paymentRequest.setCurrency(Currency.BRL);

        // Add an item for this payment request
        paymentRequest.addItem("0001", "Notebook Prata", new Integer(1), new BigDecimal("2430.00"),
                new Long(1000), null);

        // Add another item for this payment request
        paymentRequest.addItem("0002", "Notebook Rosa", new Integer(2), new BigDecimal("2560.00"),
                new Long(750), null);
       
        // Sets a reference code for this payment request, it's useful to identify this payment in future notifications.
        paymentRequest.setReference("REF1234");

        // Sets shipping information for this payment request
        paymentRequest.setShippingType(ShippingType.SEDEX);
        paymentRequest.setShippingAddress("BRA", "SP", "São Paulo", "Jardim Paulistano", "01452002",
                "Av. Brig. Faria Lima", "1384", "5o andar");

        // Sets your customer information.
        paymentRequest.setSender("João Comprador", "comprador@uol.com.br", "11", "56273440");

        try {
            // Register this payment request in PagSeguro, to obtain the payment URL for redirect your customer.
            URL paymentURL = paymentRequest.register(new AccountCredentials("suporte@lojamodelo.com.br",
                    "95112EE828D94278BD394E91C4388F20"));
            System.out.println(paymentURL);
        } catch (PagSeguroServiceException e) {
            System.err.println(e.toString());
        }

    }

}
