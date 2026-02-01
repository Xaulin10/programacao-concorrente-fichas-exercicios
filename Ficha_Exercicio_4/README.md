# Ficha 4 — Fila de pedidos (Garçom/Cozinheiro) com wait/notify

## Objetivo
Simular um cenário produtor-consumidor, onde pedidos são adicionados a uma fila e processados por outra thread, controlando estados de fila cheia/vazia.

## O que foi implementado
- `FilaDePedidos`: estrutura partilhada com operações sincronizadas:
  - adicionar pedido (aguarda se estiver cheia)
  - retirar pedido (aguarda se estiver vazia)
- `garcom` (Runnable): produz pedidos e coloca na fila.
- `Cozinheiro` (Runnable): consome pedidos retirando da fila.
- `Main`: inicializa fila e inicia as threads.

## Conceitos usados
- Região crítica com `synchronized`
- Coordenação com `wait()` e `notify()`
- Padrão Produtor-Consumidor

## Executar
```bash
javac *.java
java Main
