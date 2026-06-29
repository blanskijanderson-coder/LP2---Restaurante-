# Restaurante Cleberlícia 🍽️

Trabalho semestral desenvolvido para a disciplina de Linguagem de Programação II da Universidade do Estado da Bahia (UNEB), sob orientação da Profa. Ana Patrícia Magalhães.

---

## Sobre o sistema

Sistema de atendimento para um restaurante, desenvolvido em **Java** com interface gráfica **Java Swing**, seguindo os princípios da **Orientação a Objetos**.

O sistema simula o fluxo completo de atendimento: desde a chegada do cliente ao restaurante, passando pela escolha da mesa, realização de pedidos pelo tablet, até o pagamento da conta com acúmulo de bônus para visitas futuras. A cozinha também possui uma interface própria para gerenciar os pedidos em aberto.

---

## Funcionalidades

### Cliente
- Cadastro e login de clientes
- Escolha de mesa disponível
- Visualização do cardápio (comidas e bebidas)
- Realização de pedidos com seleção de itens e quantidades
- Visualização e gerenciamento da conta atual
- Pagamento com Crédito, Débito, Pix ou Dinheiro
- Abatimento automático de bônus acumulado no pagamento
- Acúmulo de 10% do valor consumido em bônus para a próxima visita
- Histórico de contas

### Administrador
- Login com perfil de administrador
- Gerenciamento do cardápio (adicionar comidas e bebidas)
- Gerenciamento da cozinha (visualizar e entregar pedidos)
- Atualização da quantidade de mesas disponíveis

### Cozinha
- Visualização dos pedidos em aberto com status, cliente e mesa
- Entrega de pedidos aos clientes

---

## Tecnologias utilizadas

- **Java** — linguagem principal
- **Java Swing** — interface gráfica
- **NetBeans** — ambiente de desenvolvimento

---

## Conceitos de OO aplicados

- **Herança** — `Cliente` e `Administrador` herdam de `Cadastrado`; `Comida` e `Bebida` herdam de `Cardapio`
- **Polimorfismo** — método `getDetalhes()` implementado diferente em `Comida` (ingredientes) e `Bebida` (fornecedor)
- **Classe abstrata** — `Cardapio` é abstrata, impedindo instanciação direta
- **Encapsulamento** — atributos privados com getters e setters em todas as classes

---

## Estrutura das classes principais

```
Cadastrado (abstrata)
├── Cliente
└── Administrador

Cardapio (abstrata)
├── Comida
└── Bebida

Cozinha        — repositório central (listas estáticas de produtos, pedidos e contas)
Pedido         — agrupa itens solicitados com status de preparo
Conta          — agrupa pedidos de uma visita e calcula o total
Mesa           — controla ocupação e liberação de mesas
```

---

## Como executar

1. Abra o projeto no **NetBeans**
2. Execute a classe `Inicio.java` (tela de login)
3. Cadastre um usuário ou use um administrador para popular o cardápio
4. Realize o fluxo completo: login → mesa → pedido → pagamento

---

## Equipe

Trabalho desenvolvido em grupo para o semestre 2026.1.

CODERS: Marcelo Livros, Janderson Blanski e João Cleber.

"O vencedor comemora, o perdedor justifica"
