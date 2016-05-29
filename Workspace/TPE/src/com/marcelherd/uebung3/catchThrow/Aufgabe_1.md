# catch-or-throw-Regel
Die catch-or-throw Regel besagt, dass man eine Ausnahme (Exception) wenn möglich erst in der innersten try Anweisung löst, und nur wenn keine passende catch Klausel vorhanden ist weiterwirft (throw).

Beispiel(In eigenen Worten):
Ein Restaurant. Der Leiter bestellt beim Lieferanten zutaten. Der Leiter übergibt die Zutaten dem Service. Dieser übergibt das fertige Essen dem Kunden. In diesem Falle Salat. Der Kunde beschwert sich beim Service, dass der Salat total braun ist (Exception!) Der Service gibt das an den Koch weiter. Dieser weis, dass der Salat heute geliefert wurde. Also gibt er das Problem an den Leiter des Restaurants weiter welcher das Problem mit dem Lieferanten klärt. 

In den in diesem Package enthaltenden Java Dateien wird das Beispiel nochmal in "Java Sprache" gezeigt

Wie man darin sehen kann, wird das Problem erst zum Service, dann zum Koch, und dann zum Manager geworfen. Dieser (würde sich) darum dann kümmern.