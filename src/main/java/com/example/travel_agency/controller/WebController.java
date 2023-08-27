package com.example.travel_agency.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

    @Controller
    public class WebController {

        // Obsługuje żądanie wyświetlenia strony głównej
        @GetMapping("/")
        public String showHomePage() {
            System.out.println("/showHomePage()");
            return "index"; // Zwraca nazwę widoku (bez rozszerzenia .html)
        }

        // Obsługuje żądanie konfiguracji oferty wycieczek
        @PostMapping("/configure-offer")
        public String configureOffer() {
            System.out.println("/configureOffer()");
            // Logika obsługi formularza konfiguracji oferty
            return "redirect:/"; // Przekierowanie na stronę główną po zapisaniu konfiguracji
        }

        // Obsługuje żądanie wyszukiwania wycieczek
        @GetMapping("/search-tours")
        public String searchTours() {
            System.out.println("/searchTours()");
            // Logika obsługi formularza wyszukiwania wycieczek
            return "redirect:/"; // Przekierowanie na stronę główną z wynikami wyszukiwania
        }

        // Obsługuje żądanie zakupu wycieczki
        @PostMapping("/purchase-tour")
        public String purchaseTour() {
            System.out.println("/purchaseTour()");
            // Logika obsługi formularza zakupu wycieczki
            return "redirect:/"; // Przekierowanie na stronę główną po dokonaniu zakupu
        }

        // Obsługuje żądanie dodatkowych usług
        @PostMapping("/additional-services")
        public String additionalServices() {
            System.out.println("/additionalServices()");
            // Logika obsługi formularza dodatkowych usług
            return "redirect:/"; // Przekierowanie na stronę główną po zapisaniu usług
        }

        // Obsługuje żądanie konfiguracji obostrzeń
        @PostMapping("/configure-restrictions")
        public String configureRestrictions() {
            System.out.println("/configureRestrictions()");
            // Logika obsługi formularza konfiguracji obostrzeń
            return "redirect:/"; // Przekierowanie na stronę główną po zapisaniu obostrzeń
        }

        // Tutaj możesz dodać obsługę innych żądań związanych z podstawowymi bytami (Kontynenty, Kraje, Miasta, Hotele, Lotniska)

        // Obsługuje żądanie dodawania wycieczki
        @PostMapping("/add-tour")
        public String addTour() {
            System.out.println("/addTour()");
            // Logika obsługi formularza dodawania wycieczki
            return "redirect:/"; // Przekierowanie na stronę główną po dodaniu wycieczki
        }

        @GetMapping("/login")
        public String showLoginForm() {
            System.out.println("/showLoginForm()");
            return "login"; // Zwraca nazwę widoku logowania (login.html)
        }

//        @PostMapping("/login")
//        public String processLogin() {
//            // Tutaj można dodać logikę weryfikacji danych logowania
//            // Jeśli dane są poprawne, przekieruj na odpowiednią stronę
//            // W przeciwnym razie można wyświetlić błąd lub przekierować z powrotem do formularza logowania
//            return "redirect:/dashboard"; // Przykładowe przekierowanie po poprawnym zalogowaniu
//        }

        @GetMapping("/dashboard")
        public String showDashboard() {
            System.out.println("/showDashboard()");
            // Logika wyświetlania panelu administracyjnego
            return "dashboard"; // Zwraca nazwę widoku panelu administracyjnego (dashboard.html)
        }

        @GetMapping("/configure-offer")
        public String configureOfferForm() {
            System.out.println("/configureOfferForm()");
            return "configure-offer"; // Zwraca nazwę widoku konfiguracji oferty (configure-offer.html)
        }

        @GetMapping("/admin-login")
        public String showAdminLoginForm() {
            System.out.println("/showAdminLoginForm()");
            return "admin-login"; // Zwraca nazwę widoku logowania administratora (admin-login.html)
        }

        @PostMapping("/admin-login")
        public String processAdminLogin() {
            System.out.println("/processAdminLogin()");
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

            boolean isAdmin = authentication.getAuthorities().stream()
                    .anyMatch(grantedAuthority -> grantedAuthority.getAuthority().equals("ROLE_ADMIN"));

            if (isAdmin) {
                return "redirect:/configure-offer"; // Przekierowanie do strony konfiguracji oferty
            } else {
                return "redirect:/index"; // Przekierowanie na dashboard
            }
        }
    }



