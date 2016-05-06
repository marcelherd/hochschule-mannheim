Machen Sie die Klassen Eis und Eisdiele abstrakt.
Die jetzt abstrakte Klasse Eisdiele erhält hierfur eine weitere Methode:
```
public abstract Eis erstellen(String typ)
```
1. Was muss hier geschehen? 

In dieser Methode werden konkrete Eis Objekte erzeugt - eine Eisdiele ist also eine Factory für Eis. Wie das passiert, ist abhängig von der konkreten Implementierung der Eisdiele. Zum Beispiel kann es eine MannheimerEisdiele geben, die in dieser Methode das Eis auf Mannheimer Art zubereitet. Somit ist es möglich regionale Unterschiede in der Zubereitung des Eises zu realisieren. Anhand des Parameters "typ" wird entschieden welches Eis erzeugt werden soll - oder null, falls dieser Typ nicht angeboten wird.

2. Müssen Sie bestehende Methoden ändern oder verlagern?

Zuerst müssen die Methoden begruessen(), kassieren(), verabschieden() und entschuldigen() als abstract gekennzeichnet werden. Dadurch verlagert sich die Implementierung dieser Methoden in die konkreten Eisdielen (MannheimerEisdiele, KoelnerEisdiele etc.). Damit ist es möglich auf regionale Unterschiede im Dialog mit dem Kunden einzugehen. 

Außerdem werden die Methoden vorbereiten(), fuellen() und dekorieren() als abstract gekennzeichnet, da es auch in der Zubereitung des Eises die Möglichkeit geben soll, regionale Unterschiede wiederzuspiegeln.

3. Brauchen Sie zusätzliche Klassen und Methoden? Wenn Ja - welche?

Da die Klasse Eisdiele nun abstrakt ist, können keine Objekte von ihr mehr erzeugt werden. Für jede regionale Eisdiele muss also eine weitere Klasse erstellt werden, die die Eisdiele vollständig implementiert (bspw. MannheimerEisdiele, KoelnerEisdiele etc.). Es müssen hier keine weiteren Methoden erstellt werden, nur die vorhandenen müssen in jeder konkreten Eisdiele implementiert werden.

Wir haben die Klasse Eisdiele außerdem um die Methode String[] getEiskarte() erweitert - das wäre nicht nötig gewesen, hilft uns aber bei der Umsetzung der main()-Funktion.

Außerdem muss für jedes Eisgericht eine Klasse erzeugt werden, die die abstrakte Klasse Eis implementiert.

Ergebnis:
- Eisdiele
  - MannheimerEisdiele <EisFactory, produces>
      - MannheimerBananaSplit <Eis>
      - MannheimerNussBecher <Eis>
      - MannheimerSpaghettiEis <Eis>
  - KoelnerEisdiele <EisFactory, produces>
      - KoelnerBananaSplit <Eis>
      - KoelnerErdbeerTraum <Eis>
      - KoelnerSpaghettiEis <Eis>
  - BerlinerEisdiele <EisFactory, produces>
      - BerlinerKaramelBecher <Eis>
      - BerlinerPfirsichSchale <Eis>
      - BerlinerSpaghettiEis <Eis>
- Eis
  - BerlinerSpaghettiEis <Eis>
  - KoelnerSpaghettiEis <Eis>
  - MannheimerSpaghettiEis <Eis>
  - alle drei sind SpaghettiEis, werden aber jeweils anders zubereitet und serviert.

4. Was muss in Ihrer main() passieren um die jeweiligen lokalen Eisdielen anzusprechen?

Es muss für jede lokale Eisdiele, die angesprochen werden soll, eine eigene Instanz erzeugt werden.

5. Notieren Sie die Vorteile dieser Lösung in Aufgabe 2 gegenuber der Lösung von aufgabe 1

- Offensichtlich können nun regionale Unterschiede in der Zubereitung des Eises und im Dialog mit dem Kunden realisiert werden, da die Implementierung nun von den Subklassen vorgegeben werden muss
- Wenn weitere Eisgerichte oder Eisdielen hinzugefügt werden sollen, dann müssen für diese nur weitere Subklassen erstellt werden. Das Programm ist sehr einfach erweiterbar und flexibler
- Durch die Factory als "Middleman" hätten wir die Möglichkeit, nicht jedes mal ein neues Objekt zu erzeugen. In diesem Fall wollen wir aber wohl jedem Kunden sein eigenes Eis produzieren.. :)
- Die Factory kann beliebige Subklassen von Eis erzeugen
- Falls das erzeugen von Eis-Objekten jemals komplizierter werden sollte, ist dieses Initialisierungslogik in der Factory ausgelager - die nutzende Klasse muss sich darum nicht kümmern. Außerdem
wird sichergestellt, dass die Objekte "richtig" erzeugt werden. Falls nämlich zusätzliche Initialisierungslogik erfoderlich ist, die nicht im Konstruktor der Klasse stattfindet, kann sich die Factory
darum kümmern. Indem wir die Konstruktoren als package-private deklarieren, stellen wir sicher, dass nur die jew. Eisdiele Objekte der Eisgerichte erzeugen kann.

