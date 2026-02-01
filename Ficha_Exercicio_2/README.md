# Ficha 2 — Controle de acesso concorrente a um estoque

## Objetivo
Simular múltiplos clientes a tentar comprar um produto a partir de um estoque partilhado, evitando condições de corrida.

## O que foi implementado
- `Estoque`: mantém a quantidade disponível e controla a compra com método `synchronized` (`comprarProduto()`).
- `Cliente` (Runnable): cada thread representa um cliente a tentar comprar.
- `Main`: cria várias threads de clientes, inicia e aguarda conclusão (`join`), mostrando o estoque final.

## Conceitos usados
- `Runnable`, `Thread`
- Exclusão mútua com `synchronized`
- `join()` para sincronizar fim das threads

## Executar
```bash
javac *.java
java Main
