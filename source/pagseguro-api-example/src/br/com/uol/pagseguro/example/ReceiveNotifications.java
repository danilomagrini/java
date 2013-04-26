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
import br.com.uol.pagseguro.service.NotificationService;

public class ReceiveNotifications {

    public static void main(String[] args) {

    	// Substitute the code below with a notification code for your transaction. 
        // You receive this notification code through a post on the URL that you specify in 
        // this page: 
    	/** @link https://pagseguro.uol.com.br/integracao/notificacao-de-transacoes.jhtml*/
        String notificationCode = "512AF8-49E2FBE2FB71-799426FFAC58-90F5C1";

        Transaction transaction = null;
        try {
            // Check transaction
            transaction = NotificationService.checkTransaction(new AccountCredentials("suporte@lojamodelo.com.br",
                    "95112EE828D94278BD394E91C4388F20"), notificationCode);
        } catch (PagSeguroServiceException e) {
            System.err.println(e.toString());
        }

        if (transaction != null) {
            System.out.println("transaction code: " + transaction.getCode());
            System.out.println("transaction status: " + transaction.getStatus());
        }
    }
}
