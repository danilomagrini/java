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

import java.lang.reflect.InvocationTargetException;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;

import br.com.uol.pagseguro.domain.AccountCredentials;
import br.com.uol.pagseguro.domain.TransactionSearchResult;
import br.com.uol.pagseguro.domain.TransactionSummary;
import br.com.uol.pagseguro.exception.PagSeguroServiceException;
import br.com.uol.pagseguro.service.TransactionSearchService;

public class SearchTransactionByDate {

    public static void main(String[] args) throws SecurityException, NoSuchFieldException, IllegalArgumentException,
            IllegalAccessException, NoSuchMethodException, InvocationTargetException {

        TransactionSearchResult result = null;
        try {
            Calendar initialCalendar = Calendar.getInstance();
            initialCalendar.set(2011, Calendar.JULY, 1, 0, 00);
            Calendar finalCalendar = Calendar.getInstance();
            finalCalendar.set(2011, Calendar.JULY, 26, 00, 00);

            //Substitute the parameters below with your credentials (e-mail and token)
            AccountCredentials credentials = new AccountCredentials("suporte@lojamodelo.com.br",
                    "95112EE828D94278BD394E91C4388F20");

            result = TransactionSearchService.searchByDate(credentials, initialCalendar.getTime(),
                    finalCalendar.getTime(), new Integer(1), new Integer(10));
        } catch (PagSeguroServiceException e) {
            System.err.println(e.toString());
            return;
        }

        if (result != null) {
            System.out.println("Search date: " + result.getDate());
            System.out.println(result.getResultsInThisPage() + " results in the page "
                    + result.getPage() + " of " + result.getTotalPages() + " pages.");

            List listTransactionSummaries = result.getTransactionSummaries();
            Iterator transactionSummariesIterator = listTransactionSummaries.iterator();
            int counter = 0;
            while (transactionSummariesIterator.hasNext()) {
                TransactionSummary currentTransactionSummary = (TransactionSummary) transactionSummariesIterator.next();
                System.out.println();
                System.out.println("Transaction: " + ++counter);
                System.out.println("Code: " + currentTransactionSummary.getCode());
                System.out.println("Reference: " + currentTransactionSummary.getReference());
                System.out.println("Date: " + currentTransactionSummary.getDate());
                System.out.println("Disccount amount: " + currentTransactionSummary.getDiscountAmount());
                System.out.println("Extra amount: " + currentTransactionSummary.getExtraAmount());
                System.out.println("Fee amount: "  + currentTransactionSummary.getFeeAmount());
                System.out.println("Transaction amount: " + currentTransactionSummary.getGrossAmount());
                System.out.println("Last event date: " + currentTransactionSummary.getLastEvent());
                System.out.println("Net amount: " + currentTransactionSummary.getNetAmount());
                System.out.println("Payment method type: " + currentTransactionSummary.getPaymentMethodType());
                System.out.println("Status: " + currentTransactionSummary.getStatus());
                System.out.println("Type: " + currentTransactionSummary.getType());
            }
        }
    }
}
