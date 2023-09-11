package com.example.travel_agency.controller;


import com.example.travel_agency.model.Airport;
import com.example.travel_agency.model.City;
import com.example.travel_agency.model.Country;
import com.example.travel_agency.model.Tour;
import com.example.travel_agency.respositories.TourRepository;
import com.example.travel_agency.service.AirportService;
import com.example.travel_agency.service.CityService;
import com.example.travel_agency.service.CountryService;
import com.example.travel_agency.service.TourService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@Controller
    public class WebController {

    //    @Autowired
//    private TourRepository tourRepository;
//    private final TourService tourService;
//    private final AirportService airportService;
//    private final CountryService countryService;
//    private final CityService cityService;
//    @Autowired
//    public WebController(TourService tourService, AirportService airportService, CountryService countryService, CityService cityService) {
//        this.tourService = tourService;
//        this.airportService = airportService;
//        this.countryService = countryService;
//        this.cityService = cityService;
//    }
//
//
//    // Obsługuje żądanie wyświetlenia strony głównej
//    @GetMapping("/")
//    public String showHomePage() {
//        System.out.println("/showHomePage()");
//        return "index"; // Zwraca nazwę widoku (bez rozszerzenia .html)
//    }
//
//    //NOWE!!
//    // Usuwanie wycieczki
//    @GetMapping("/delete-tour/{tourId}")
//    public String deleteTour(@PathVariable Long tourId, RedirectAttributes redirectAttributes) {
//        try {
//            Optional<Tour> tourOptional = tourRepository.findById(tourId);
//            if (tourOptional.isPresent()) {
//                tourRepository.delete(tourOptional.get());
//                redirectAttributes.addFlashAttribute("successMessage", "Wycieczka została pomyślnie usunięta.");
//            } else {
//                redirectAttributes.addFlashAttribute("errorMessage", "Nie znaleziono wycieczki o podanym ID.");
//            }
//        } catch (Exception e) {
//            redirectAttributes.addFlashAttribute("errorMessage", "Wystąpił błąd podczas usuwania wycieczki.");
//        }
//        return "redirect:/configure-offer";
//    }
//
//    @GetMapping("/configure-offer")
//    public String configureOfferForm(Model model) {
//        Iterable<Tour> tours = tourRepository.findAll();
//        model.addAttribute("tours", tours);
//        return "configure-offer"; // Zwraca nazwę widoku konfiguracji oferty (configure-offer.html)
//    }
//
//    // Obsługuje żądanie wyświetlenia formularza dodawania nowej wycieczki
//    @GetMapping("/add-tour")
//    public String addTourForm(Model model) {
//        return "add-tour"; // Zwraca widok formularza dodawania wycieczki (add-tour.html)
//    }
//    @PostMapping("/add-tour")
//    public String addTour(
//            @RequestParam("tourName") String tourName,
//            @RequestParam("tourDescription") String tourDescription,
//            @RequestParam("tourPrice") double tourPrice,
//            @RequestParam("tourDuration") int tourDuration,
//            @RequestParam("tourType") String tourType,
//            RedirectAttributes redirectAttributes
//    ) {
//        try {
//            Tour tour = new Tour(tourName, tourDescription, tourPrice, tourDuration, tourType);
//            tourRepository.save(tour);
//            redirectAttributes.addFlashAttribute("successMessage", "Wycieczka została pomyślnie dodana.");
//        } catch (Exception e) {
//            redirectAttributes.addFlashAttribute("errorMessage", "Wystąpił błąd podczas dodawania wycieczki.");
//        }
//        return "redirect:/configure-offer";
//    }
//
//    @GetMapping("/edit-tour/{tourId}")
//    public String editTourForm(@PathVariable Long tourId, Model model) {
//        Optional<Tour> tourOptional = tourRepository.findById(tourId);
//        if (tourOptional.isPresent()) {
//            Tour tour = tourOptional.get();
//            model.addAttribute("tour", tour);
//            return "edit-tour";
//        } else {
//            return "redirect:/configure-offer";
//        }
//    }
//
//    @PostMapping("/update-tour")
//    public String updateTour(
//            @RequestParam("tourId") Long tourId,
//            @RequestParam("tourName") String tourName,
//            @RequestParam("tourDescription") String tourDescription,
//            @RequestParam("tourPrice") double tourPrice,
//            @RequestParam("tourDuration") int tourDuration,
//            @RequestParam("tourType") String tourType,
//            RedirectAttributes redirectAttributes
//    ) {
//        try {
//            Optional<Tour> tourOptional = tourRepository.findById(tourId);
//            if (tourOptional.isPresent()) {
//                Tour tour = tourOptional.get();
//                tour.setTourName(tourName);
//                tour.setTourDescription(tourDescription);
//                tour.setTourPrice(tourPrice);
//                tour.setTourDuration(tourDuration);
//                tour.setTourType(tourType);
//                tourRepository.save(tour);
//
//                redirectAttributes.addFlashAttribute("successMessage", "Wycieczka została pomyślnie zaktualizowana.");
//            } else {
//                redirectAttributes.addFlashAttribute("errorMessage", "Nie znaleziono wycieczki o podanym ID.");
//            }
//        } catch (Exception e) {
//            redirectAttributes.addFlashAttribute("errorMessage", "Wystąpił błąd podczas aktualizacji wycieczki.");
//        }
//        return "redirect:/configure-offer";
//    }
//
//
//    // Obsługuje żądanie wyszukiwania wycieczek
//    @GetMapping("/search-tours")
//    public String searchTours() {
//        System.out.println("/searchTours()");
//        // Logika obsługi formularza wyszukiwania wycieczek
//        return "redirect:/"; // Przekierowanie na stronę główną z wynikami wyszukiwania
//    }
//
//    // Obsługuje żądanie zakupu wycieczki
//    @PostMapping("/purchase-tour")
//    public String purchaseTour() {
//        System.out.println("/purchaseTour()");
//        // Logika obsługi formularza zakupu wycieczki
//        return "redirect:/"; // Przekierowanie na stronę główną po dokonaniu zakupu
//    }
//
//    // Obsługuje żądanie dodatkowych usług
//    @PostMapping("/additional-services")
//    public String additionalServices() {
//        System.out.println("/additionalServices()");
//        // Logika obsługi formularza dodatkowych usług
//        return "redirect:/"; // Przekierowanie na stronę główną po zapisaniu usług
//    }
//
//    // Obsługuje żądanie konfiguracji obostrzeń
//    @PostMapping("/configure-restrictions")
//    public String configureRestrictions() {
//        System.out.println("/configureRestrictions()");
//        // Logika obsługi formularza konfiguracji obostrzeń
//        return "redirect:/"; // Przekierowanie na stronę główną po zapisaniu obostrzeń
//    }
//
//    // Tutaj możesz dodać obsługę innych żądań związanych z podstawowymi bytami (Kontynenty, Kraje, Miasta, Hotele, Lotniska)
//
//    @GetMapping("/login")
//    public String showLoginForm() {
//        System.out.println("/showLoginForm()");
//        return "login"; // Zwraca nazwę widoku logowania (login.html)
//    }
//
//
//    @GetMapping("/dashboard")
//    public String showDashboard() {
//        System.out.println("/showDashboard()");
//        // Logika wyświetlania panelu administracyjnego
//        return "dashboard"; // Zwraca nazwę widoku panelu administracyjnego (dashboard.html)
//    }
//
//
//    @GetMapping("/admin-login")
//    public String showAdminLoginForm() {
//        System.out.println("/showAdminLoginForm()");
//        return "admin-login"; // Zwraca nazwę widoku logowania administratora (admin-login.html)
//    }
//
//    @PostMapping("/admin-login")
//    public String processAdminLogin() {
//        System.out.println("/processAdminLogin()");
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//
//        boolean isAdmin = authentication.getAuthorities().stream()
//                .anyMatch(grantedAuthority -> grantedAuthority.getAuthority().equals("ROLE_ADMIN"));
//
//        if (isAdmin) {
//            return "redirect:/configure-offer"; // Przekierowanie do strony konfiguracji oferty
//        } else {
//            return "redirect:/index"; // Przekierowanie na dashboard
//        }
//
//    }
//    @GetMapping("/tour-details/{tourId}")
//    public String showTourDetails(@PathVariable Long tourId, Model model) {
//        Optional<Tour> tourOptional = tourRepository.findById(tourId);
//
//        if (tourOptional.isPresent()) {
//            Tour tour = tourOptional.get();
//            model.addAttribute("tour", tour);
//            return "tour-details";
//        } else {
//            return "error";
//        }
//    }
//
//    @GetMapping("/airports")
//    public String listAirports(Model model) {
//        List<Airport> airports = airportService.getAllAirports();
//        model.addAttribute("airports", airports);
//        return "airport/list";
//    }
//
//    @GetMapping("/airports/add")
//    public String showAddAirportForm(Model model) {
//        List<Country> countries = countryService.getAllCountries();
//        List<City> cities = cityService.getAllCities();
//
//        model.addAttribute("airport", new Airport());
//        model.addAttribute("countries", countries);
//        model.addAttribute("cities", cities);
//
//        return "airport/add";
//    }
//
//    @PostMapping("/airports/add")
//    public String addAirport(@ModelAttribute Airport airport, @RequestParam Long countryId, @RequestParam Long cityId) {
//        Country country = countryService.getCountryById(countryId);
//        City city = cityService.getCityById(cityId);
//
//        airport.setCountry(country);
//        airport.setCity(city);
//
//        airportService.addAirport(airport);
//
//        return "redirect:/airports";
//    }
//
//    @GetMapping("/airports/edit/{airportId}")
//    public String showEditAirportForm(@PathVariable Long airportId, Model model) {
//        Airport airport = airportService.getAirportById(airportId);
//        List<Country> countries = countryService.getAllCountries();
//        List<City> cities = cityService.getAllCities();
//
//        model.addAttribute("airport", airport);
//        model.addAttribute("countries", countries);
//        model.addAttribute("cities", cities);
//
//        return "airport/edit";
//    }
//
//    @PostMapping("/airports/edit")
//    public String editAirport(@ModelAttribute Airport airport) {
//        airportService.editAirport(airport);
//        return "redirect:/airports";
//    }
//
//    @GetMapping("/airports/delete/{airportId}")
//    public String deleteAirport(@PathVariable Long airportId) {
//        airportService.removeAirport(airportId);
//        return "redirect:/airports";
//    }
//}
    @Autowired
    private TourRepository tourRepository;
    private final TourService tourService;
    private final AirportService airportService;
    private final CountryService countryService;
    private final CityService cityService;

    @Autowired
    public WebController(TourService tourService, AirportService airportService, CountryService countryService, CityService cityService) {
        this.tourService = tourService;
        this.airportService = airportService;
        this.countryService = countryService;
        this.cityService = cityService;
    }

    // Obsługuje żądanie wyświetlenia strony głównej
    @GetMapping("/")
    public String showHomePage() {
        System.out.println("/showHomePage()");
        return "index"; // Zwraca nazwę widoku (bez rozszerzenia .html)
    }

    //NOWE!!
    // Usuwanie wycieczki
    @GetMapping("/delete-tour/{tourId}")
    public String deleteTour(@PathVariable Long tourId, RedirectAttributes redirectAttributes) {
        try {
            Optional<Tour> tourOptional = tourRepository.findById(tourId);
            if (tourOptional.isPresent()) {
                tourRepository.delete(tourOptional.get());
                redirectAttributes.addFlashAttribute("successMessage", "Wycieczka została pomyślnie usunięta.");
            } else {
                redirectAttributes.addFlashAttribute("errorMessage", "Nie znaleziono wycieczki o podanym ID.");
            }
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessage", "Wystąpił błąd podczas usuwania wycieczki.");
        }
        return "redirect:/configure-offer";
    }

    @GetMapping("/configure-offer")
    public String configureOfferForm(Model model) {
        Iterable<Tour> tours = tourRepository.findAll();
        model.addAttribute("tours", tours);
        return "configure-offer"; // Zwraca nazwę widoku konfiguracji oferty (configure-offer.html)
    }

    // Obsługuje żądanie wyświetlenia formularza dodawania nowej wycieczki
    @GetMapping("/add-tour")
    public String addTourForm(Model model) {
        return "add-tour"; // Zwraca widok formularza dodawania wycieczki (add-tour.html)
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
        try {
            Tour tour = new Tour(tourName, tourDescription, tourPrice, tourDuration, tourType);
            tourRepository.save(tour);
            redirectAttributes.addFlashAttribute("successMessage", "Wycieczka została pomyślnie dodana.");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessage", "Wystąpił błąd podczas dodawania wycieczki.");
        }
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
        try {
            Optional<Tour> tourOptional = tourRepository.findById(tourId);
            if (tourOptional.isPresent()) {
                Tour tour = tourOptional.get();
                tour.setTourName(tourName);
                tour.setTourDescription(tourDescription);
                tour.setTourPrice(tourPrice);
                tour.setTourDuration(tourDuration);
                tour.setTourType(tourType);
                tourRepository.save(tour);

                redirectAttributes.addFlashAttribute("successMessage", "Wycieczka została pomyślnie zaktualizowana.");
            } else {
                redirectAttributes.addFlashAttribute("errorMessage", "Nie znaleziono wycieczki o podanym ID.");
            }
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessage", "Wystąpił błąd podczas aktualizacji wycieczki.");
        }
        return "redirect:/configure-offer";
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

    @GetMapping("/login")
    public String showLoginForm() {
        System.out.println("/showLoginForm()");
        return "login"; // Zwraca nazwę widoku logowania (login.html)
    }

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

    @GetMapping("/tour-details/{tourId}")
    public String showTourDetails(@PathVariable Long tourId, Model model) {
        Optional<Tour> tourOptional = tourRepository.findById(tourId);

        if (tourOptional.isPresent()) {
            Tour tour = tourOptional.get();
            model.addAttribute("tour", tour);
            return "tour-details";
        } else {
            return "error";
        }
    }

//    @GetMapping("/airports")
//    public String listAirports(Model model) {
//        List<Airport> airports = airportService.getAllAirports();
//        model.addAttribute("airports", airports);
//        return "airport/list";
//    }
//
//    @GetMapping("/airports/add")
//    public String showAddAirportForm(Model model) {
//        List<Country> countries = countryService.getAllCountries();
//        List<City> cities = cityService.getAllCities();
//
//        model.addAttribute("airport", new Airport());
//        model.addAttribute("countries", countries);
//        model.addAttribute("cities", cities);
//
//        return "airport/add";
//    }
//
//    @PostMapping("/airports/add")
//    public String addAirport(
//            @ModelAttribute Airport airport,
//            @RequestParam("countryId") Long countryId,
//            @RequestParam("cityId") Long cityId
//    ) {
//        airportService.addAirport(airport, countryId, cityId);
//
//        return "redirect:/airports";
//    }
//
//    @GetMapping("/airports/edit/{airportId}")
//    public String showEditAirportForm(@PathVariable Long airportId, Model model) {
//        Airport airport = airportService.getAirportById(airportId);
//        List<Country> countries = countryService.getAllCountries();
//        List<City> cities = cityService.getAllCities();
//
//        model.addAttribute("airport", airport);
//        model.addAttribute("countries", countries);
//        model.addAttribute("cities", cities);
//
//        return "airport/edit";
//    }
//
//    @PostMapping("/airports/edit")
//    public String editAirport(@ModelAttribute Airport airport) {
//        airportService.editAirport(airport);
//        return "redirect:/airports";
//    }
//
//    @GetMapping("/airports/delete/{airportId}")
//    public String deleteAirport(@PathVariable Long airportId) {
//        airportService.removeAirport(airportId);
//        return "redirect:/airports";
//    }
//}

    @GetMapping("/airports")
    public String listAirports(Model model) {
        List<Airport> airports = airportService.getAllAirports();
        model.addAttribute("airports", airports);
        return "airport/list-airports";
    }

    @GetMapping("/airports/add")
    public String showAddAirportForm(Model model) {
        List<Country> countries = countryService.getAllCountries();
        List<City> cities = cityService.getAllCities();

        model.addAttribute("airport", new Airport());
        model.addAttribute("countries", countries);
        model.addAttribute("cities", cities);

        return "airport/add-airport";
    }

    @PostMapping("/airports/add")
    public String addAirport(
            @ModelAttribute Airport airport,
            @RequestParam("countryId") Long countryId,
            @RequestParam("cityId") Long cityId,
            RedirectAttributes redirectAttributes
    ) {
        try {
            airportService.addAirport(airport, countryId, cityId);
            redirectAttributes.addFlashAttribute("successMessage", "Lotnisko zostało dodane pomyślnie.");
        } catch (IllegalArgumentException ex) {
            redirectAttributes.addFlashAttribute("errorMessage", "Błąd podczas dodawania lotniska: " + ex.getMessage());
        }

        return "redirect:/airports";
    }

    @GetMapping("/airports/edit/{airportId}")
    public String showEditAirportForm(@PathVariable Long airportId, Model model) {
        Airport airport = airportService.getAirportById(airportId);
        List<Country> countries = countryService.getAllCountries();
        List<City> cities = cityService.getAllCities();

        model.addAttribute("airport", airport);
        model.addAttribute("countries", countries);
        model.addAttribute("cities", cities);

        return "airport/edit-airport";
    }

    @PostMapping("/airports/edit")
    public String editAirport(
            @ModelAttribute Airport airport,
            RedirectAttributes redirectAttributes
    ) {
        try {
            String countryName = airport.getCountryName();
            String cityName = airport.getCityName();

            Country country = countryService.getCountryByName(countryName);
            City city = cityService.getCityByName(cityName);

            if (country == null) {
                country = new Country();
                country.setCountryName(countryName);
                countryService.addCountry(country);
            }

            if (city == null) {
                city = new City();
                city.setCityName(cityName);
                city.setCountry(country);
                cityService.addCity(city);
            }

            airport.setCountry(country);
            airport.setCity(city);

            airportService.editAirport(airport);
            redirectAttributes.addFlashAttribute("successMessage", "Lotnisko zostało zaktualizowane pomyślnie.");
        } catch (IllegalArgumentException ex) {
            redirectAttributes.addFlashAttribute("errorMessage", "Błąd podczas aktualizacji lotniska: " + ex.getMessage());
        }

        return "redirect:/airports";
    }

    @GetMapping("/airports/delete/{airportId}")
    public String deleteAirport(@PathVariable Long airportId, RedirectAttributes redirectAttributes) {
        try {
            airportService.removeAirport(airportId);
            redirectAttributes.addFlashAttribute("successMessage", "Lotnisko zostało usunięte pomyślnie.");
        } catch (IllegalArgumentException ex) {
            redirectAttributes.addFlashAttribute("errorMessage", "Błąd podczas usuwania lotniska: " + ex.getMessage());
        }

        return "redirect:/airports";
    }
}
