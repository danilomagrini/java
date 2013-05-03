Biblioteca de integração PagSeguro para Java
============================================
---
Descrição
---------
---
A biblioteca PagSeguro em Java é um conjunto de classes de domínio que facilitam, para o desenvolvedor Java, a utilização das funcionalidades que o PagSeguro oferece na forma de APIs. Com a biblioteca instalada e configurada, você pode facilmente integrar funcionalidades como:

 - Criar [requisições de pagamentos]
 - Consultar [transações por código]
 - Consultar [transações por intervalo de datas]
 - Consultar [transações abandonadas]
 - Receber [notificações]


Requisitos
----------
---
 - [Java] 1.4+


Instalação
----------
---
 - Baixe o repositório como arquivo zip ou faça um clone;
 - Descompacte os arquivos em seu computador;
 - Dentro do diretório *source* existem dois diretórios, o *pagseguro-api* e o *pagseguro-api-example*. O diretório *pagseguro-api-example* contém exemplos de chamadas utilizando a API e o diretório *pagseguro-api* contém a biblioteca propriamente dita. Você pode adicionar a biblioteca como dependência do seu projeto de duas formas:
  - incluindo o jar pagseguro-api-x.x.x.jar como dependência de seu projeto atual;
  - importando o diretório *pagseguro-api* como um novo projeto em sua IDE, e incluí-lo como dependência do seu projeto atual.
 - Opcionalmente você também pode importar o diretório *pagseguro-api-example* como um novo projeto em sua IDE para visualizar a utilização das classes da biblioteca de acordo com cada funcionalidade disponível.

Configuração
------------
---
Para facilitar sua integração e permitir um maior controle sobre suas configurações, centralizamos todas as configurações da biblioteca em um único arquivo 'pagseguro-config.properties' localizado no diretório src do projeto 'pagseguro-api'. Nele você pode configurar:

 - Credenciais para as chamadas à API do PagSeguro;
 - Ativação e configuração de logs das chamadas ao PagSeguro.

Mais informações estão disponíveis na [documentação oficial].


Changelog
---------
---
2.0.0 - 2.0.2

 - Classes de domínios que representam pagamentos, notificações e transações.
 - Criação de checkouts via API.
 - Controller para processar notificações de pagamento enviadas pelo PagSeguro.
 - Módulo de consulta de transações.


Licença
-------
---
Copyright 2013 PagSeguro Internet LTDA.

Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with the License. You may obtain a copy of the License at

http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the specific language governing permissions and limitations under the License.


Notas
-----
---
 - O PagSeguro somente aceita pagamento utilizando a moeda Real brasileiro (BRL).
 - Certifique-se que o email e o token informados estejam relacionados a uma conta que possua o perfil de vendedor ou empresarial.
 - Certifique-se que tenha definido corretamente o charset de acordo com a codificação (ISO-8859-1 ou UTF-8) do seu sistema. Isso irá prevenir que as transações gerem possíveis erros ou quebras ou ainda que caracteres especiais possam ser apresentados de maneira diferente do habitual.
 - Para que ocorra normalmente a geração de logs, certifique-se que o diretório e o arquivo de log tenham permissões de leitura e escrita.


[Dúvidas?]
----------
---
Em caso de dúvidas mande um e-mail para desenvolvedores@pagseguro.com.br


Contribuições
-------------
---
Achou e corrigiu um bug ou tem alguma feature em mente e deseja contribuir?

* Faça um fork.
* Adicione sua feature ou correção de bug.
* Envie um pull request no [GitHub].


  [requisições de pagamentos]: https://pagseguro.uol.com.br/v2/guia-de-integracao/api-de-pagamentos.html
  [notificações]: https://pagseguro.uol.com.br/v2/guia-de-integracao/api-de-notificacoes.html
  [transações por código]: https://pagseguro.uol.com.br/v2/guia-de-integracao/consulta-de-transacoes-por-codigo.html
  [transações por intervalo de datas]: https://pagseguro.uol.com.br/v2/guia-de-integracao/consulta-de-transacoes-por-intervalo-de-datas.html
  [transações abandonadas]: https://pagseguro.uol.com.br/v2/guia-de-integracao/consulta-de-transacoes-abandonadas.html
  [Dúvidas?]: https://pagseguro.uol.com.br/desenvolvedor/comunidade.jhtml
  [Java]: http://www.oracle.com/technetwork/java/index.html
  [GitHub]: https://github.com/pagseguro/java/
  [documentação oficial]: https://pagseguro.uol.com.br/v2/guia-de-integracao/tutorial-da-biblioteca-pagseguro-em-java.html
