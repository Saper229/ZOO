Oto skrótowy opis projektu do pliku README.md, napisany w języku polskim:

ZOO Management System
Aplikacja konsolowa w języku Java służąca do zarządzania ogrodem zoologicznym, oferująca osobne ścieżki dostępu dla gości oraz personelu.

🚀 Główne Funkcje
1. Moduł Gościa (Guest)
Zakup Biletu: Wybór metody płatności (BLIK, Karta, Gotówka).

Weryfikacja: Symulacja autoryzacji transakcji (kod BLIK, PIN: 8520).

Edukacja: Po opłaceniu wstępu gość otrzymuje listę zwierząt w ZOO.

2. Moduł Pracownika (Employee)
Bezpieczeństwo: System generowania haseł na podstawie danych osobowych.

Zarządzanie Zwierzętami:

Przeglądanie list z podziałem na sekcje (Ssaki, Ptaki, Gady).

Dodawanie, usuwanie oraz edycja lokalizacji zwierząt (przenoszenie między klatką, wybiegiem itp.).

Raportowanie: Generowanie zbiorczych raportów o stanie ZOO.

🛠️ Architektura i Technologie
Programowanie Obiektowe: Wykorzystanie dziedziczenia (klasa Person), polimorfizmu oraz typów wyliczeniowych (enum).

Obsługa Błędów: Autorski system wyjątków w pakiecie exceptions. Każdy błąd (zły PIN, brak środków, błędne dane) kończy działanie programu z jasnym komunikatem.

Struktura Danych: Podział na logiczne pakiety i klasy odpowiedzialne za płatności, zwierzęta oraz infrastrukturę (obiekty).

📁 Struktura Projektu
Main.java – główny kontroler aplikacji.

Zoo.java – baza danych zwierząt i logistyka.

exceptions/ – pakiet z autorskimi wyjątkami (np. UnauthorizedException).

Animal.java – definicja zwierząt i logika zarządzania nimi.
