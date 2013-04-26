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

import br.com.uol.pagseguro.domain.AccountCredentials;
import br.com.uol.pagseguro.domain.Transaction;
import br.com.uol.pagseguro.exception.PagSeguroServiceException;
import br.com.uol.pagseguro.service.TransactionSearchService;

public class SearchTransactionByCode {

    public static void main(String[] args) {

    	//Substitute the code below with a valid transaction code for your account
        String transactionCode = "41F4640C-4A84-435B-831C-8EAD876A3B93";

        Transaction transaction = null;
        try {
        	//Substitute the parameters below with your credentials (e-mail and token)
            transaction = TransactionSearchService.searchByCode(new AccountCredentials("suporte@lojamodelo.com.br",
            "95112EE828D94278BD394E91C4388F20"), transactionCode);
        } catch (PagSeguroServiceException e) {
            System.err.println(e.toString());
        }

        if (transaction != null) {
            printTransaction(transaction);
        }
    }

    private static void printTransaction(Transaction transaction) {

        System.out.println("code: " + transaction.getCode());
        System.out.println("date: " + transaction.getDate());
        System.out.println("discountAmount: " + transaction.getDiscountAmount());
        System.out.println("extraAmount: " + transaction.getExtraAmount());
        System.out.println("feeAmount: " + transaction.getFeeAmount());
        System.out.println("grossAmount: " + transaction.getGrossAmount());
        System.out.println("installmentCount: " + transaction.getInstallmentCount());
        System.out.println("itemCount: " + transaction.getItemCount());

        for (int i = 0; i < transaction.getItems().size(); i++) {
            System.out.println("item[" + (i + 1) + "]: " + transaction.getItems().get(i));
        }

        System.out.println("lastEventDate: " + transaction.getLastEventDate());
        System.out.println("netAmount: " + transaction.getNetAmount());
        System.out.println("paymentMethodType: " + transaction.getPaymentMethod().getCode().getValue());
        System.out.println("paymentMethodcode: " + transaction.getPaymentMethod().getType().getValue());
        System.out.println("reference: " + transaction.getReference());
        System.out.println("senderEmail: " + transaction.getSender().getEmail());

        if(transaction.getSender() != null){
        	System.out.println("senderPhone: " + transaction.getSender().getPhone());
        }

        if(transaction.getShipping() != null){
	        System.out.println("shippingType: " + transaction.getShipping().getType().getValue());
	        System.out.println("shippingCost: " + transaction.getShipping().getCost());
	        if(transaction.getShipping().getAddress() != null){
		        System.out.println("shippingAddressCountry: " + transaction.getShipping().getAddress().getCountry());
		        System.out.println("shippingAddressState: " + transaction.getShipping().getAddress().getState());
		        System.out.println("shippingAddressCity: " + transaction.getShipping().getAddress().getCity());
		        System.out.println("shippingAddressPostalCode: " + transaction.getShipping().getAddress().getPostalCode());
		        System.out.println("shippingAddressDistrict: " + transaction.getShipping().getAddress().getDistrict());
		        System.out.println("shippingAddressStreet: " + transaction.getShipping().getAddress().getStreet());
		        System.out.println("shippingAddressNumber: " + transaction.getShipping().getAddress().getNumber());
		        System.out.println("shippingAddressComplement: " + transaction.getShipping().getAddress().getComplement());
	        }
        }

        System.out.println("status: " + transaction.getStatus().getValue());
        System.out.println("type: " + transaction.getType().getValue());
    }

}
