package com.example.travel_agency.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

    @Controller
    public class WebController {

        // Obsługuje żądanie wyświetlenia strony głównej
        @GetMapping("/")
        public String showHomePage() {
            return "index"; // Zwraca nazwę widoku (bez rozszerzenia .html)
        }

        // Obsługuje żądanie konfiguracji oferty wycieczek
        @PostMapping("/configure-offer")
        public String configureOffer() {
            // Logika obsługi formularza konfiguracji oferty
            return "redirect:/"; // Przekierowanie na stronę główną po zapisaniu konfiguracji
        }

        // Obsługuje żądanie wyszukiwania wycieczek
        @GetMapping("/search-tours")
        public String searchTours() {
            // Logika obsługi formularza wyszukiwania wycieczek
            return "redirect:/"; // Przekierowanie na stronę główną z wynikami wyszukiwania
        }

        // Obsługuje żądanie zakupu wycieczki
        @PostMapping("/purchase-tour")
        public String purchaseTour() {
            // Logika obsługi formularza zakupu wycieczki
            return "redirect:/"; // Przekierowanie na stronę główną po dokonaniu zakupu
        }

        // Obsługuje żądanie dodatkowych usług
        @PostMapping("/additional-services")
        public String additionalServices() {
            // Logika obsługi formularza dodatkowych usług
            return "redirect:/"; // Przekierowanie na stronę główną po zapisaniu usług
        }

        // Obsługuje żądanie konfiguracji obostrzeń
        @PostMapping("/configure-restrictions")
        public String configureRestrictions() {
            // Logika obsługi formularza konfiguracji obostrzeń
            return "redirect:/"; // Przekierowanie na stronę główną po zapisaniu obostrzeń
        }

        // Tutaj możesz dodać obsługę innych żądań związanych z podstawowymi bytami (Kontynenty, Kraje, Miasta, Hotele, Lotniska)

        // Obsługuje żądanie dodawania wycieczki
        @PostMapping("/add-tour")
        public String addTour() {
            // Logika obsługi formularza dodawania wycieczki
            return "redirect:/"; // Przekierowanie na stronę główną po dodaniu wycieczki
        }

        @GetMapping("/login")
        public String showLoginForm() {
            return "login"; // Zwraca nazwę widoku logowania (login.html)
        }

        @PostMapping("/login")
        public String processLogin() {
            // Tutaj można dodać logikę weryfikacji danych logowania
            // Jeśli dane są poprawne, przekieruj na odpowiednią stronę
            // W przeciwnym razie można wyświetlić błąd lub przekierować z powrotem do formularza logowania
            return "redirect:/dashboard"; // Przykładowe przekierowanie po poprawnym zalogowaniu
        }

        @GetMapping("/dashboard")
        public String showDashboard() {
            // Logika wyświetlania panelu administracyjnego
            return "dashboard"; // Zwraca nazwę widoku panelu administracyjnego (dashboard.html)
        }
        @GetMapping("/custom-login") // Zmieniona ścieżka URL
        public String showLoginPage() {
            return "login"; // Nazwa pliku HTML dla strony logowania
        }
    }

