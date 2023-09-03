package com.example.travel_agency.controller;


import com.example.travel_agency.model.Tour;
import com.example.travel_agency.respositories.TourRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.math.BigDecimal;
import java.util.Optional;

@Controller
    public class WebController {
    @Autowired
    private TourRepository tourRepository;

        // Obsługuje żądanie wyświetlenia strony głównej
        @GetMapping("/")
        public String showHomePage() {
            System.out.println("/showHomePage()");
            return "index"; // Zwraca nazwę widoku (bez rozszerzenia .html)
        }

    @GetMapping("/delete-tour/{tourId}")
    public String deleteTour(@PathVariable Long tourId, RedirectAttributes redirectAttributes) {
        tourRepository.deleteById(tourId);

        // Przekierowanie z dodatkowym atrybutem informacji
        redirectAttributes.addFlashAttribute("message", "Wycieczka została pomyślnie usunięta.");

        return "redirect:/configure-offer";
    }

    @GetMapping("/configure-offer")
    public String configureOfferForm(Model model) {
        Iterable<Tour> tours = tourRepository.findAll();
        model.addAttribute("tours", tours);
        return "configure-offer"; // Zwraca nazwę widoku konfiguracji oferty (configure-offer.html)
    }

    @PostMapping("/add-tour")
    public String addTour(
            @RequestParam("tourName") String tourName,
            @RequestParam("tourDescription") String tourDescription,
            @RequestParam("tourPrice") double tourPrice,
            @RequestParam("tourDuration") int tourDuration,
            @RequestParam("tourType") String tourType,
            RedirectAttributes redirectAttributes
    ) {
        Tour tour = new Tour(tourName, tourDescription, tourPrice, tourDuration, tourType);
        tourRepository.save(tour);

        // Przekierowanie z dodatkowym atrybutem informacji
        redirectAttributes.addFlashAttribute("message", "Wycieczka została pomyślnie dodana.");

        return "redirect:/configure-offer";
    }
    @GetMapping("/edit-tour/{tourId}")
    public String editTourForm(@PathVariable Long tourId, Model model) {
        Optional<Tour> tourOptional = tourRepository.findById(tourId);
        if (tourOptional.isPresent()) {
            Tour tour = tourOptional.get();
            model.addAttribute("tour", tour);
            return "edit-tour";
        } else {
            // Obsłuż błąd - nie znaleziono wycieczki o podanym ID
            return "redirect:/configure-offer";
        }
    }

    @PostMapping("/update-tour")
    public String updateTour(
            @RequestParam("tourId") Long tourId,
            @RequestParam("tourName") String tourName,
            @RequestParam("tourDescription") String tourDescription,
            @RequestParam("tourPrice") double tourPrice,
            @RequestParam("tourDuration") int tourDuration,
            @RequestParam("tourType") String tourType,
            RedirectAttributes redirectAttributes
    ) {
        Optional<Tour> tourOptional = tourRepository.findById(tourId);
        if (tourOptional.isPresent()) {
            Tour tour = tourOptional.get();
            tour.setTourName(tourName);
            tour.setTourDescription(tourDescription);
            tour.setTourPrice(tourPrice);
            tour.setTourDuration(tourDuration);
            tour.setTourType(tourType);
            tourRepository.save(tour);

            // Przekierowanie z dodatkowym atrybutem informacji
            redirectAttributes.addFlashAttribute("message", "Wycieczka została pomyślnie zaktualizowana.");

            return "redirect:/configure-offer";
        } else {
            // Obsłuż błąd - nie znaleziono wycieczki o podanym ID
            return "redirect:/configure-offer";
        }
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
//        @PostMapping("/add-tour")
//        public String addTour() {
//            System.out.println("/addTour()");
//            // Logika obsługi formularza dodawania wycieczki
//            return "redirect:/"; // Przekierowanie na stronę główną po dodaniu wycieczki
//        }

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



