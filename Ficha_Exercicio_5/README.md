# Ficha 5 — Pesquisa concorrente de docentes em ficheiros (Produtor-Consumidor)

## Contexto / Objetivo
Acelerar a pesquisa do nome de docentes em vários ficheiros, evitando pesquisa totalmente sequencial.  
Foi aplicado o padrão **Produtor-Consumidor** usando `wait`, `notify` e `notifyAll`.

## O que foi implementado
- `SharedBuffer`: fila partilhada (`Queue`) com sincronização e controlo de término:
  - `put()` insere trabalho no buffer
  - `take()` retira trabalho, aguardando quando estiver vazio
  - flags para encerrar e para “nome encontrado”
- `Produtor` (Runnable): lê ficheiros e coloca linhas/entradas no buffer.
- `Consumidor` (Runnable): consome entradas e verifica ocorrências do nome procurado.
- `Main`: inicializa produtores/consumidores, inicia threads e apresenta o resultado (ficheiro/linha quando encontrado).

## Conceitos usados
- `wait()` / `notifyAll()` para coordenação
- Padrão Produtor-Consumidor
- Paragem antecipada quando o nome é encontrado (reduz trabalho)

## Executar
```bash
javac *.java
java Main
