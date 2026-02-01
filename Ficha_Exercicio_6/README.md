# Ficha 6 — Monitoramento do ciclo de vida de threads (Centro de Estágio)

## Objetivo
Simular computadores como threads, monitorando o ciclo de vida:
- execução de ciclos (RUNNABLE/TIMED_WAITING)
- espera por manutenção (WAITING via `wait()`)
- encerramento seguro (TERMINATED)

## O que foi implementado
- `Computador` (Runnable): simula ciclos de operação com `sleep`, e depois entra em espera com `wait()` até ser liberado.
- `GestorCentroEstagio`: coordena o sistema (libera computadores para novo ciclo e encerra o centro de estágio).
- `Main`: cria os computadores (threads), inicia a simulação, imprime estados das threads e finaliza com segurança.

## Conceitos usados
- `wait()`/`notify()` para simular WAITING
- `sleep()` para simular tempo de operação
- Encerramento controlado com flag e notificação

## Executar
```bash
javac *.java
java Main
