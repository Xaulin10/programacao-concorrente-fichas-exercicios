# Ficha 7 — Processamento e agendamento de relatórios (ThreadLocal + TimerTask)

## Objetivo
Automatizar o processamento de relatórios de forma concorrente:
- cada utilizador (thread) mantém o seu contexto com `ThreadLocal`
- geração periódica via `TimerTask`
- tratamento global de exceções com `UncaughtExceptionHandler`

## O que foi implementado
- `Relatorio`: estrutura do relatório (userId, timestamp e conteúdo).
- `ProcessadorDeRelatorios` (Runnable): processa relatório e usa `ThreadLocal` para manter o userId no thread atual.
- `RelatorioTimer` (TimerTask): dispara periodicamente a geração de relatórios para utilizadores diferentes.
- `HandlerExcecoes`: handler global para exceções não tratadas.
- `Main`: agenda a tarefa e encerra o sistema após um tempo definido.

## Conceitos usados
- `ThreadLocal` para contexto por thread
- `Timer` + `TimerTask` para agendamento periódico
- `Thread.setDefaultUncaughtExceptionHandler(...)`

## Executar
```bash
javac *.java
java Main
