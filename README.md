# Proporcjonalny podział rabatu 
## Cel 
Celem zadania jest zaprojektowanie i oprogramowanie małej aplikacji, której głównym zadaniem będzie naliczenie 
rabatu do produktów w wysokości proporcjonalnej do ich ceny. 
## Przyjęte założenia 
W przedmiotowej aplikacja przyjęto następujące założenia: 
* za prawidłową cenę uznaje się każdą wartość dopuszczalną w klasie `BigDecimal`, która jest liczbą dodatnią, 
posiadającą dokładnie dwa miejsca po przecinku, 
* za prawidłową nazwę produktu uznaje się każdy `String`, który nie jest pusty i nie składa się z samych białych znaków, 
* za prawidłowy produkt uznaje się każdy obiekt klasy `Product`, który posiada poprawną nazwę oraz prawidłową cenę, 
* aplikacja dopuszcza do utworzenia od <1; 5> produktów, które należy umieścić w liście oraz całkowitej kwoty rabatu 
(wymagania takie same jak przy cenie), obie wartości muszą zostać określone w metodzie `main` klasy `Main`, 
* walidacja następuje na etapie tworzenia serwisu `DiscountService`, 
* do wykonania programu niezbędne jest pozytywne przejście procesu walidacji danych wejściowych, 
* jeżeli rabatu nie da się rozdzielić między produktami w idealnych proporcjach, to różnica (możliwe wartości 
ujemne jak i dodatnie) zostaje dodana do ostatniego produktu na liście, 
* naliczony rabat może przekraczać wartością kwotę produktu (przedmiotowa kwestia nie została opisana w wymaganiach), 
## Wykonanie 
Aplikacja została opracowana z wykorzystaniem: 
* Apache Maven, 
* Java 11, 
* JUnit 5.4.0 
## Sposób użycia 
Do poprawnego uruchomienia aplikacji wymagane jest wprowadzenie poprawnych (zgodnych z przyjętymi wymogami) 
danych wejściowych, które należy wprowadzić w metodzie `main` klasy `Main`. Po wprowadzeniu poprawnych danych 
aplikacja jest gotowa do uruchomienia.
