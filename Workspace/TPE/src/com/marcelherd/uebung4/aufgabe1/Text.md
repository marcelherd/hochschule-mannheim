# Beschreiben und benennen sie die Probleme, die durch die Anwesenheit von mehreren Threads entstehen können

## Safety Hazards

Wenn ein Programm sich bei Anwesenheit mehrerer Threads nicht mehr korrekt verhält

### Race Condition

Wenn sich mehrere Threads eine geteilte Resource teilen _und_ gleichzeitig darauf zugreifen können.

## Liveness Hazards

Wenn ein Programm mit mehreren Threads in einen Zustand gerät, bei dem es "nicht mehr weiter geht"

### Deadlock

Ein Thread blockiert den Monitor.  
Weil der Thread auf die Erfüllung einer Bedingung wartet, geht es nicht weiter.  
Wenn die Erfüllung der Bedingung an einen anderen Thread gebunden ist, der darauf wartet dass der blockierende Thread den Monitor freigibt, kann es nicht mehr weiter gehen --> Deadlock (keiner der Threads kann mehr weiterlaufen)

--> Ein Thread, der den Monitor blockiert, kann diesen (temporär) mittels wait freigeben (während er auf das Erfüllen der Bedingung wartet)

### Livelock

Wenn es zu einem Zustand Z1 kommen kann, der immer nur zu einem Zustand Z2 führen kann, der immer nur zu einem Zustand Z1 führen kann --> Zyklus

--> Im Gegesatz zum Deadlock sind die Threads nicht blockiert, sie machen aber dennoch keinen Fortschritt

### Starvation

Wenn immer andere Threads bevorzugt werden --> der Thread kommt niemals zum Zug

## Performance Hazards

Wenn ein Programm trotz mehrerer Threads eine schlechte Performanz aufweist