# Aufgabe 1: Pakete

```
Wählen Sie ein Paket-Benennungs-Schema fur Ihre Übungsaufgaben zur Vorlesung TPE. Erklären Sie Ihr
Schema und begründen Sie, warum es durch das von Ihnen gewählte Schema nicht zu Kollisionen mit
anderen Gruppen und Entwicklern kommen kann.
```

Unser gewähltes Schema ist:

```java
com.marcelherd.tpe.uebung%d
```

Unser Schema beginnt mit der "Organisation", die für das Projekt verantwortlich ist. Da ich (Marcel Herd) die Domain marcelherd.com tatsächlich besitze und dort auch das Projekt samt Quellcode zur Verfügung stelle, bietet es sich an, die Pakete mit com.marcelherd beginnen zu lassen.

Durch diesen Präfix ist außerdem gewährleistet, dass es nicht zu Kollisionen kommen kann - schließlich ist jede Domain im Internet eindeutig (danke ICANN).

Da unsere "Organisation" nicht weiter strukturell unterteilt ist, folgt direkt darauf das Projekt (tpe).

Die Übungen werden voneinander unabhängig bearbeitet, daher erhält jede Übung ein separates Unterpaket (uebung1, uebung2, ...). 

Bei Bedarf können dann weitere Unterpakete angelegt werden:
* .uebung%d.test
* .uebung%d.controller
* .uebung%d.view
* etc