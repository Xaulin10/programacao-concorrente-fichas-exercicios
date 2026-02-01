# Ficha 3 — Processamento concorrente de notas (ficheiros)

## Objetivo
Processar ficheiros de notas em paralelo e atualizar estruturas com médias/resultados, acelerando a leitura e processamento.

## O que foi implementado
- `ProcessadorDeNotas` (Runnable): lê linhas de um ficheiro e envia dados para registo.
- `RegistroDeNotas`: armazena resultados e atualiza médias.
- `Main`: cria leitores para vários ficheiros (`notas1.txt`, `notas2.txt`, `notas3.txt`), inicia threads, e interrompe após um tempo definido.

## Conceitos usados
- Threads paralelas por fonte de dados (um ficheiro por thread)
- Interrupção (`interrupt()`) para parar processamento
- Estruturas `Map` para armazenar resultados

## Executar
```bash
javac *.java
java Main
